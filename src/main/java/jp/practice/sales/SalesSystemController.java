package jp.practice.sales;

import java.util.ArrayList;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


/**
 * 売上システムのコントローラーを提供します。
 *
 * @author 鈴木友邦
 * @version 1.0
 */
@Controller
@SessionAttributes(types = {SalesForm.class})
@RequestMapping(value = "/system")
public class SalesSystemController {

	/** 初期画面のjsp名を表す定数です。 */
	private static final String INIT = "init";
	/** 明細追加画面のjsp名を表す定数です。 */
	private static final String ADD = "add";
	/** 登録画面のjsp名を表す定数です。 */
	private static final String FIX = "fix";
	/** 明細追加に成功時のメッセージを表す定数です。 */
	private static final String ADD_DONEMSG = "明細に追加しました。";
	/** 明細追加に失敗時のメッセージを表す定数です。 */
	private static final String ADD_ERRORMSG = "点数には1以上100以下の整数を入力してください。";
	/** 売上登録に成功時のメッセージを表す定数です。 */
	private static final String FIX_DONEMSG = "以下のように売上登録しました。";
	/** 明細削除に成功時のメッセージを表す定数です。 */
	private static final String REMOVE_DONEMSG = "選択された明細行を削除しました。";
	/** 明細削除に失敗時のメッセージを表す定数です。 */
	private static final String REMOVE_ERRORMSG = "明細行を選択してください。";

	/** 点数の最小値 */
	private static final int MIN_QUANTITY = 1;
	/** 点数の最大値 */
	private static final int MAX_QUANTITY = 100;

	/** 売上ID算出用 開始年 */
	private static final int FROM_YEAR = 1970;

	/**
	 * 売上システムの初期画面を表示します。
	 * @param form viewsのformと連携するための引数です。
	 * @param model viewsに値を送るための引数です。
	 * @return "init"
	 */
	@RequestMapping(value = "/start")
	public String init(SalesForm form, Model model) {
		model.addAttribute("nameList", RecordManager.makeNameList());
		form.setGoodsName(RecordManager.getFirstItemName());
		form.setPoint("1");
		return INIT;
	}


	/**
	 * 売上システムの明細追加画面を表示します。
	 * @param form viewsのformと連携するための引数です。
	 * @param model viewsに値を送るための引数です。
	 * @param session formをsession管理するための引数です。
	 * @return "add" | "init"
	 */
	@RequestMapping(params = "add")
	public String add(SalesForm form, Model model, HttpSession session) {
		try {
			// formのinput情報からItemインスタンスを生成する
			Item item = RecordManager.findItem(form.getGoodsName());
			String myId = item.getId();
			String myName = item.getName();
			int myPrice = item.getPrice();
			int myQuantity = Integer.parseInt(form.getPoint());
			if (MIN_QUANTITY <= myQuantity && myQuantity <= MAX_QUANTITY) {
				// 点数が1以上100以下の場合の処理
				int mySubtotal = myPrice * myQuantity;
				Item myItem = new Item(myId, myName, myPrice, myQuantity, mySubtotal);

				// salesFormをsessionで管理する
				SalesForm salesForm = (SalesForm) session.getAttribute("salesForm");
				if (salesForm == null) {
					// sessionで管理されていない場合の処理
					form.addToAllList(myItem);
					session.setAttribute("salesForm", form);
				} else {
					// 既にsessionで管理している場合の処理
					salesForm.addToAllList(myItem);
				}
				model.addAttribute("doneMessage", ADD_DONEMSG);
				form.setGoodsName(RecordManager.getFirstItemName());
				form.setPoint("1");
				form.setDelNumber(0);

			// 点数が1以上100以下ではなかった場合の処理
			} else {
				model.addAttribute("errorMessage", ADD_ERRORMSG);
				form.setGoodsName(form.getGoodsName());
				form.setPoint(form.getPoint());
				form.setDelNumber(0);
			}

		// 点数に整数以外が入力された場合の例外処理
		} catch (NumberFormatException e) {
			model.addAttribute("errorMessage", ADD_ERRORMSG);
			form.setGoodsName(form.getGoodsName());
			form.setPoint(form.getPoint());
			form.setDelNumber(0);
        }

		// 小計を合計する
		int total = 0;
		for (Item list : form.getAllList()) {
			total += list.getSubtotal();
		}
		model.addAttribute("total", String.format("%,d", total));

		// selectに表示するリストをセットする
		model.addAttribute("nameList", RecordManager.makeNameList());

		// allListの要素数が0の場合は初期画面に遷移させる
		if (form.getAllList().size() == 0) {
			return INIT;
		} else {
			return ADD;
		}
	}

	/**
	 * 売上システムの明細追加画面の売上明細1行を削除します。
	 * @param form viewsのformと連携するための引数です。
	 * @param model viewsに値を送るための引数です。
	 * @return "add" | "init"
	 */
	@RequestMapping(params = "remove")
	public String remove(SalesForm form, Model model) {
		int delNumber = form.getDelNumber();
		// delNumberが0の場合はadd.jspに戻す
		if (delNumber == 0) {
			model.addAttribute("errorMessage", REMOVE_ERRORMSG);
			form.setGoodsName(form.getGoodsName());
			form.setPoint(form.getPoint());
			form.setDelNumber(0);

			// 小計を合計する
			int total = 0;
			for (Item list : form.getAllList()) {
				total += list.getSubtotal();
			}
			model.addAttribute("total", String.format("%,d", total));

			// selectに表示するリストをセットする
			model.addAttribute("nameList", RecordManager.makeNameList());

			return ADD;
		}

		form.setGoodsName(RecordManager.getFirstItemName());
		form.setPoint("1");
		form.setDelNumber(0);
		// selectに表示するリストをセットする
		model.addAttribute("nameList", RecordManager.makeNameList());

		model.addAttribute("doneMessage", REMOVE_DONEMSG);

		ArrayList<Item> allList = form.getAllList();
		allList.remove(delNumber - 1);
		if (allList.size() == 0) {
			return INIT;
		} else {
			// 小計を合計する
			int total = 0;
			for (Item list : form.getAllList()) {
				total += list.getSubtotal();
			}
			model.addAttribute("total", String.format("%,d", total));
			return ADD;
		}
	}

	/**
	 * 売上システムの売上登録画面を表示します。
	 * @param form viewsのformと連携するための引数です。
	 * @param model viewsに値を送るための引数です。
	 * @return "fix"
	 */
	@RequestMapping(params = "firm")
	public String firm(SalesForm form, Model model) {

		// 売上IDをセットする
		Duration duration = Duration.between(LocalDateTime.of(FROM_YEAR, 1, 1, 0, 0), LocalDateTime.now());
		model.addAttribute("salesId", duration.toMillis());

		// 小計を合計する
		int total = 0;
		for (Item list : form.getAllList()) {
			total += list.getSubtotal();
		}
		model.addAttribute("total", String.format("%,d", total));

		model.addAttribute("doneMessage", FIX_DONEMSG);
		return FIX;
	}

	/**
	 * 売上登録後、売上システムの初期画面を表示します。
	 * @param form viewsのformと連携するための引数です。
	 * @param model  viewsに値を送るための引数です。
	 * @param sessionStatus session管理しているformを破棄するための引数です。
	 * @return "init"
	 */
	@RequestMapping(params = "end")
	public String end(SalesForm form, Model model, SessionStatus sessionStatus) {

		// session attributesの"salesForm"を解放する
		sessionStatus.setComplete();

		model.addAttribute("nameList", RecordManager.makeNameList());
		form.setGoodsName(RecordManager.getFirstItemName());
		form.setPoint("1");
		return INIT;
	}
}
