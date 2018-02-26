package pos.receipt.bean;

public class ReceiptBean {   

	
	public ReceiptBean(String item, int quantity, String itemDescription, double itemPrice, double totalPrice) {
		this.item = item;
		this.quantity = quantity;
		this.itemDescription = itemDescription;  
		this.itemPrice = itemPrice;
		this.totalPrice = totalPrice;
	}
	private String item;
	private int    quantity;
	private String itemDescription;
	private double itemPrice;
	private double totalPrice;
	
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quuantity) {
		this.quantity = quuantity;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	
}
