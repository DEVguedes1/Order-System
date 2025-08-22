package entities;

public class OrderItem {

	private Integer quantity;
	private Double price;
	
	public OrderItem(){
	}
	
	public OrderItem(int quantity,double price){
		this.quantity=quantity;
		this.price=price;
	}

}
