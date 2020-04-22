package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.order.Order;

public class Aims {
	
	private static Scanner keyboard = new Scanner(System.in);	
	private static ArrayList<Order> orderList = new ArrayList<Order>();
	
	public static void main(String[] args) {
		
		/*MyDate today = new MyDate(18,3,2020);
		
		Order anOrder = new Order();
		anOrder.setDateOrder(today);
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Iron Man");
		dvd1.setCategory("category dvd1");
		dvd1.setCost(20.1f);
		dvd1.setDirector("director dvd1");
		dvd1.setLength(90);
		anOrder.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Caption America","category dvd2","director dvd2");
		dvd2.setCost(18.25f);
		dvd2.setLength(89);
		anOrder.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Widow Black","category dvd3","director dvd3",94,23.35f);
		anOrder.addMedia(dvd3);
		
		anOrder.removeMedia(dvd1);
		anOrder.removeMedia(dvd1);
		Book book1 = new Book("Book 1");
		anOrder.addMedia(book1);
		
		anOrder.print();
		System.out.print("Total cost is: ");
		System.out.println(anOrder.totalCost());
		
		anOrder.removeMedia(dvd2);
		
		anOrder.print();
		System.out.print("Total cost is: ");
		System.out.println(anOrder.totalCost());
		
		
		Order od2 = Order.createOrder();
		od2.setDateOrder(today);
		od2.addMedia(dvd1);
		od2.addMedia(dvd2);
		Order od3 = Order.createOrder(today);
		od2.addMedia(dvd1);
		od2.addMedia(dvd2);
		Order od4 = Order.createOrder(today);
		od2.addMedia(dvd1);
		od2.addMedia(dvd2);
		Order od5 = Order.createOrder(today);
		od2.addMedia(dvd1);
		od2.addMedia(dvd2);
		System.out.println("nbOrder: " + Order.nbOrder);
		
		Order od6 = Order.createOrder(today);*/
		
		MemoryDaemon memoryDaemon = new MemoryDaemon();
		Thread thread = new Thread(memoryDaemon);
		thread.setDaemon(true);
		thread.start();
		
		while(true) {
			showMenu();
		}		
		
	}
	
	public static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1.Create new order");
		System.out.println("2.Add item to the Order");
		System.out.println("3.Delete item by id");
		System.out.println("4.Display the items list of order");
		System.out.println("0.Exit");
		System.out.print("Please choose a number: 0-1-2-3-4: ");		
		String index = keyboard.nextLine();
		switch (index) {
		case "0":
			System.exit(0);
			break;
		case "1":
			createNewOrder();
			break;
		case "2":
			addItem();
			break;
		case "3":
			delItem();
			break;
		case "4":
			displayItem();
			break;
		default:
			System.out.println("Please only choose a number: 0-1-2-3-4");
			break;
		}		
		System.out.println("================================");
		System.out.println("Press any key to continue");
		keyboard.nextLine();
	}
	private static void showOrderList() {
		for (Order order : orderList) {
			System.out.println("Order ID: "+order.getID());
		}
	}
	private static void createNewOrder() {
		System.out.println("--------------------------------");
		Order newOrder = Order.createOrder();
		if(newOrder!=null) orderList.add(newOrder);
	}
	private static void addItem() {
		if(Order.nbOrder==0) {
			System.out.println("Please create order!");
			return;
		}
		String ynInput;
		showOrderList();
		System.out.print("Add item to order(id): ");
		try {
			int idOrder = Integer.valueOf(keyboard.nextLine());
			System.out.print("Dvd or cd or book ? 1/2/3: ");
			int typeItem = Integer.valueOf(keyboard.nextLine());
			System.out.println("--------------------------------");
			if(typeItem == 1) {
				DigitalVideoDisc dvd = inputDVD();
				orderList.get(idOrder).addMedia(dvd);
				System.out.print("Do you want play it ? y/n: ");
				ynInput = keyboard.nextLine();
				if(ynInput.equalsIgnoreCase("y")) {
					dvd.play();
				}
			}
			else if(typeItem == 2){
				CompactDisc cd = inputCD();
				orderList.get(idOrder).addMedia(cd);
				System.out.print("Do you want play it ? y/n: ");
				ynInput = keyboard.nextLine();
				if(ynInput.equalsIgnoreCase("y")) {
					cd.play();
				}
			}
			else if(typeItem == 3){
				orderList.get(idOrder).addMedia(inputBook());
			}
		}
		catch (Exception e) {
			System.out.println("Something wrong!");
			return;
		}
	}
	private static void delItem() {
		if(Order.nbOrder==0) {
			System.out.println("Please create order!");
			return;
		}
		showOrderList();
		System.out.print("Del item from order(id): ");
		try {
			int idOrder = Integer.valueOf(keyboard.nextLine());
			System.out.print("Media ID?: ");
			int idMedia = Integer.valueOf(keyboard.nextLine());
			System.out.println("--------------------------------");
			orderList.get(idOrder).removeMediaByID(idMedia);
		}
		catch (Exception e) {
			System.out.println("Something wrong!");
			return;
		}
	}
	private static void displayItem() {
		if(Order.nbOrder==0) {
			System.out.println("Please create order!");
			return;
		}
		showOrderList();
		System.out.print("Show item from order(id): ");
		try {
			int idOrder = Integer.valueOf(keyboard.nextLine());
			System.out.println("--------------------------------");
			orderList.get(idOrder).print();
		}
		catch (Exception e) {
			System.out.println("Something wrong!");
			return;
		}
	}
	private static Book inputBook() {
		System.out.print("Book title?: ");
		String title = keyboard.nextLine();
		System.out.print("Book category?: ");
		String category = keyboard.nextLine();
		System.out.print("Book cost?: ");
		Float cost = Float.valueOf(keyboard.nextLine());
		Book newBook =  new Book(title,category,cost);
		return newBook;
	}
	private static DigitalVideoDisc inputDVD() {
		System.out.print("DVD title?: ");
		String title = keyboard.nextLine();
		System.out.print("DVD category?: ");
		String category = keyboard.nextLine();
		System.out.print("DVD dirertor?: ");
		String dirertor = keyboard.nextLine();
		System.out.print("DVD Length?: ");
		int length = Integer.valueOf(keyboard.nextLine());
		System.out.print("DVD cost?: ");
		Float cost = Float.valueOf(keyboard.nextLine());
		DigitalVideoDisc newDVD =  new DigitalVideoDisc(title,category,dirertor,length,cost);
		return newDVD;
	}
	private static CompactDisc inputCD() {
		System.out.print("CD title?: ");
		String title = keyboard.nextLine();
		System.out.print("CD category?: ");
		String category = keyboard.nextLine();
		System.out.print("CD dirertor?: ");
		String dirertor = keyboard.nextLine();
		System.out.print("CD Cost?: ");
		Float cost = Float.valueOf(keyboard.nextLine());
		CompactDisc newCD = new CompactDisc(title, category, dirertor, cost);
		String ynInput;
		int length;
		while(true) {
			System.out.print("Add a track? y/n:");
			ynInput = keyboard.nextLine();
			if(ynInput.equalsIgnoreCase("n")) break; 
			System.out.print("Track title?: ");
			title = keyboard.nextLine();
			System.out.print("Track Length?: ");
			length = Integer.valueOf(keyboard.nextLine());
			Track newTrack = new Track(title, length);
			newCD.addTrack(newTrack);
		}
		return newCD;
	}
}
