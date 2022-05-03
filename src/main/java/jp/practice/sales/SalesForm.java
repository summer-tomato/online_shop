package jp.practice.sales;

import java.util.ArrayList;

/**
 * Form情報を管理するクラス。
 *
 * @author 鈴木友邦
 * @version 1.0
 */
public class SalesForm {

	/** プルダウンメニューで購入する商品名を表す変数です。 */
	private String goodsName;
	/** 購入する商品の点数を表す変数です。 */
	private String point;
	/** 明細から削除する商品番号を表す変数です。 */
	private int delNumber;
	/** 購入する商品のリストを表す変数です。 */
	private ArrayList<Item> allList = new ArrayList<>();

	/**
	 * コンストラクタ
	 */
	public SalesForm() {
	}

	/**
	 * @return goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 * @param goodsName セットする goodsName
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/**
	 * @return point
	 */
	public String getPoint() {
		return point;
	}

	/**
	 * @param point セットする point
	 */
	public void setPoint(String point) {
		this.point = point;
	}

	/**
	 * @return delNumber
	 */
	public int getDelNumber() {
		return delNumber;
	}

	/**
	 * @param delNumber セットする delNumber
	 */
	public void setDelNumber(int delNumber) {
		this.delNumber = delNumber;
	}

	/**
	 * Itemをリストに追加する。
	 * @param myItem
	 */
	public void addToAllList(Item myItem) {
		allList.add(myItem);
	}

	/**
	 *Itemを追加したリストを取得する。
	 * @return allList
	 */
	public ArrayList<Item> getAllList() {
		return allList;
	}
}
