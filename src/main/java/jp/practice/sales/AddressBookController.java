package jp.practice.address;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// The following lines were added to submit the files.
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/book")
public class AddressBookController {

	private static final Logger logger = LoggerFactory.getLogger(AddressBookController.class);

	private static final String INIT = "init";
	private static final String REFER = "refer";
	private static final String UPDATE = "update";
	private static final String LIST = "list";
	private static final String INIMSG = "従業員番号を入力してください";
	private static final String REFMSG = "データを取得できました";
	private static final String UPDMSG = "データを更新してください";
	private static final String ERRMSG = "該当するデータはありません";


	@RequestMapping(value="/start")
	public String init(AddressBookForm form, Model model) {
		model.addAttribute("message", INIMSG);
		return INIT;
	}


	@RequestMapping(params = "refer")
	public String refer(AddressBookForm form, Model model) {
		Employee employee = RecordManager.selectEmployee(form.getId());
		if(employee != null) {
			form.setName(employee.getName());
			form.setPhone(employee.getPhone());
			form.setAddress(employee.getAddress());
			model.addAttribute("message", REFMSG);
			return REFER;
		} else {
			model.addAttribute("message", ERRMSG);
			return INIT;
		}
	}

	@RequestMapping(params = "update")
	public String update(AddressBookForm form, Model model) {
		Employee employee = RecordManager.selectEmployee(form.getId());
		if(employee != null) {
			form.setName(employee.getName());
			form.setPhone(employee.getPhone());
			form.setAddress(employee.getAddress());
			model.addAttribute("message", UPDMSG);
			return UPDATE;
		} else {
			model.addAttribute("message", ERRMSG);
			return INIT;
		}
	}

	@RequestMapping(params = "doUpdate")
	public String doUpdate(AddressBookForm form, Model model) {
		Employee employee = new Employee(form.getId(), form.getName(), form.getPhone(), form.getAddress());
		RecordManager.updateEmployee(employee);
		model.addAttribute("message", INIMSG);
		return INIT;
	}

	@RequestMapping(params = "toInit")
	public String toInit(AddressBookForm form, Model model) {
		model.addAttribute("message", INIMSG);
		return INIT;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "home";
	}

	@RequestMapping(params = "list")
	public String list(Model model) {
		List<Employee> employeeList = RecordManager.getEmployeeList();
		model.addAttribute("employeeList", employeeList);
		model.addAttribute("employeeCount",employeeList.size());
		return LIST;
	}


	private static final String ADD = "add";
	private static final String ADDMSG = "データを追加してください";
	private static final String ADDERRMSG = "既にそのIDは存在するため追加できませんでした";
	@RequestMapping(params = "add")
	public String add(AddressBookForm form, Model model) {
		model.addAttribute("message", ADDMSG);
		return ADD;
	}

	@RequestMapping(params = "doAdd")
	public String doAdd(AddressBookForm form, Model model) {
		Employee employee = new Employee(form.getId(), form.getName(), form.getPhone(), form.getAddress());
		boolean b = RecordManager.addEmployee(employee);
		if(b) {
			model.addAttribute("message", INIMSG);
			return INIT;
		} else {
			model.addAttribute("message", ADDERRMSG);
			return INIT;
		}
	}
}
