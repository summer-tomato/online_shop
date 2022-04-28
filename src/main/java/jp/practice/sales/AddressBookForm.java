package jp.practice.address;

public class AddressBookForm {

	private String id;
	private String name;
	private String phone;
	private String address;

	public AddressBookForm() {
	}

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone セットする phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return addrsss
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param addrsss セットする addrsss
	 */
	public void setAddress(String addrss) {
		this.address = addrss;
	}

}
