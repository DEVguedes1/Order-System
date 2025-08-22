package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.enums.OrderStatus;


public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		String name,email;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		name = sc.nextLine();
		
		System.out.print("Email: ");
		email = sc.nextLine();
		
		System.out.println("Birth date (DD/MM/YYYY): ");
		Date date = sdf.parse(sc.next());
		
		Client c1 = new Client(name,email,date);
		
		System.out.println("Enter order data: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(),status,c1);
		
		System.out.println();
		System.out.println("How many items to this order? ");
		int n = sc.nextInt();
		for (int i=1;i<=n;i++){
			//Product name: 
			System.out.println("Enter #"+i+" item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String nameProduct = sc.nextLine();
			System.out.print("Product price: ");
			double priceProduct = sc.nextDouble();

			Product product = new Product(nameProduct,priceProduct);

			System.out.print("Quantity: ");
			int quantity = sc.nextInt();

			OrderItem orderItem = new OrderItem(quantity, priceProduct, product);
			order.addItem(orderItem);
		}
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		sc.close();
	}

}
