package jp.practice.sales;

/**
 * 明細情報となるクラス。
 *
 * @author 鈴木友邦
 * @version 1.0
 */
public class Item {

	/** 商品データのIDを表す変数です。 */
	private String id;
	/** 商品データの名前を表す変数です。 */
	private String name;
	/** 商品データの価格を表す変数です。 */
	private int price;
	/** 購入する商品の点数を表す変数です。 */
	private int quantity;
	/** 価格x点数の計算結果を表す変数です。  */
	private int subtotal;

	/**
	 * コンストラクタ
	 * @param id
	 * @param name
	 * @param price
	 * @param quantity
	 * @param subtotal
	 */
	public Item(String id, String name, int price, int quantity, int subtotal) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.subtotal = subtotal;
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
	 * @return price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price セットする price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity セットする quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return subtotal
	 */
	public int getSubtotal() {
		return subtotal;
	}
	/**
	 * @param subtotal セットする subtotal
	 */
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	/* (非 Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (非 Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Item)) {
			return false;
		}
		Item other = (Item) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}
}
