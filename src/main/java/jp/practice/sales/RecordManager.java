package jp.practice.address;

import java.util.ArrayList;
import java.util.List;

public class RecordManager {
	/** Initial value data **/
	private static List<Employee> list = new ArrayList<>();
	static {
		list.add(new Employee("200101", "佐藤一郎", "0569-000-1111", "尾張県愛知市舟船町５９６"));
		list.add(new Employee("200102", "鈴木次男", "0242-000-2222", "三河県三河市海池２７２７"));
		list.add(new Employee("200103", "田中信三郎", "0722-000-3333", "和泉県泉市浜川５５"));
		list.add(new Employee("200104", "高橋四郎", "0729-000-4444", "摂津府兵庫市沼地１１"));
		list.add(new Employee("200105", "渡辺五郎", "0982-000-5555", "筑紫県筑後市泉町２"));
		list.add(new Employee("200106", "伊藤六次", "0562-000-6666", "信濃県信州市泊町３３３"));
		list.add(new Employee("200107", "山本七三", "086-000-7777", "土佐県四国市港町４"));
		list.add(new Employee("200108", "中村八吉", "0489-000-8888", "薩摩県種島市潮見５５"));
		list.add(new Employee("200109", "小林九兵", "0827-000-9999", "周防県周防市川原６６"));
		list.add(new Employee("200110", "加藤十重", "048-000-1010", "武蔵県北むさし市河岸７７７"));
		list.add(new Employee("200111", "ジャック", "0273-000-1111", "相模県相模市堤５"));
		list.add(new Employee("200112", "山田十二", "075-000-1212", "駿河県南駿河市河口３５"));
	}

	private RecordManager() {
	}

	/**
	 * 指定したIDのレコードを取得
	 *
	 * @param id 従業員番号
	 * @return Employee
	 */
	public static Employee selectEmployee(String id) {
		int index = list.indexOf(new Employee(id, "", "", ""));
		if(index < 0) {
			return null;
		}
		return list.get(index);
	}

	/**
	 * 指定した従業員情報を反映
	 *
	 * @param emp 従業員情報
	 */
	public static void updateEmployee(Employee emp) {
		int index = list.indexOf(emp);
		list.set(index, emp);
	}

	public static List<Employee> getEmployeeList() {
		return list;
	}

	/**
	 * 新たに従業員情報を追加
	 *
	 * @param emp 従業員情報
	 * @return boolean
	 */
	public static boolean addEmployee(Employee emp) {
		boolean exists = list.contains(emp);
		if(exists) {
			return false;
		} else {
			list.add(emp);
			return true;
		}
	}
}


