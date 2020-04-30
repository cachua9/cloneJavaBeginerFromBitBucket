package hust.soict.hedspi.aims.order;
import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order {
	
	public static int nbOrder = 0;
	public static final int  MAX_NUMBERS_ORDERED = 10;
	public static int MAX_LIMITTED_ORDER = 5;
	private int qtyOrdered;
	private MyDate dateOrder;
	private ArrayList<Media> itemOrdered = new ArrayList<Media>();
	private int id;
	
	
	public Order() {
		this.id = nbOrder;
		this.qtyOrdered = 0;
		nbOrder++;
	}
	public Order(MyDate date) {
		this();
		this.dateOrder = date;
	}
	
	public static Order createOrder() {
		if(Order.nbOrder<MAX_LIMITTED_ORDER) {
			System.out.println("Create new order success!");
			return new Order();
		}
		else {
			System.out.println("nOrders full!");
			return null;
		}
	}
	public static Order createOrder(MyDate date) {
		if(Order.nbOrder<MAX_LIMITTED_ORDER) {
			System.out.println("Create new order success!");
			return new Order(date);
		}
		else {
			System.out.println("nOrders full!");
			return null;
		}
	}

	public int getQtyOrdered() {
		return this.qtyOrdered;
	}	
	public MyDate getDateOrder() {
		return this.dateOrder;
	}
	public void setDateOrder(MyDate date) {
		this.dateOrder=date;
	}
	public int getID() {
		return this.id;
	}
	
	public void addMedia(Media media) {
		if(itemOrdered.size()<MAX_NUMBERS_ORDERED) {
			for (Media tmp : itemOrdered) {
				if(tmp.equals(media)) {
					System.out.println("Media "+media.getTitle()+" is exist!");
					return;
				}
			}
			itemOrdered.add(media);
			System.out.println("Add media "+media.getTitle()+": Success!");		
		}
		else {
			System.out.println("Order full");
		}
	}
	public void removeMedia(Media media) {
		if(itemOrdered.size() == 0) {
			System.out.println("Empty order");
			return;
		}
		for (Media tmp : itemOrdered) {
			if(tmp.equals(media)) {
				itemOrdered.remove(tmp);
				System.out.println("Remove Media "+media.getTitle()+": Success!");
				return;
			}
		}
		System.out.println("Media "+media.getTitle()+" not found!");		
	}
	public void removeMediaByID(int id) {
		if(itemOrdered.size() == 0) {
			System.out.println("Empty order");
			return;
		}
		for (Media media : itemOrdered) {
			if(media.getID() == id) {
				itemOrdered.remove(media);
				System.out.println("Remove Media id "+id+": Success!");
				return;
			}
		}
		System.out.println("Media id "+id+" not found!");		
	}
	
	/*public void addDVD(DigitalVideoDisc... dvdList) {
		if (this.qtyOrdered+dvdList.length <=MAX_NUMBERS_ORDERED) {
			for(int i=0; i<dvdList.length; i++) {
				orderList[++this.qtyOrdered] = dvdList[i];
			}
		}
		else {
			System.out.println("Add DVDList False! - Order full");
		}
	}*/
	
	public float totalCost() {
		float result=0;
		for (Media media : itemOrdered) {
			result += media.getCost();
		}
		return result;
	}
	public void getALuckyItem() {
		int rand = 1 + (int)(Math.random()*this.qtyOrdered);
		itemOrdered.get(rand).setCost(0);		
		System.out.println("Lucky item is "+itemOrdered.get(rand).getTitle());
	}
	public void print() {
		if(itemOrdered.size()==0) {
			System.out.println("Order empty!");
			return;
		}
		for (Media media : itemOrdered) {
			if(media instanceof DigitalVideoDisc) {
				System.out.println("ID: "+media.getID()+" | DVD - Title: "+media.getTitle()+", Cost: "+media.getCost());
			}
			else if(media instanceof Book) {
				System.out.println("ID: "+media.getID()+" | Book - Title: "+media.getTitle()+", Cost: "+media.getCost());
			}
			else if(media instanceof CompactDisc) {
				System.out.println("ID: "+media.getID()+" | CD - Title: "+media.getTitle()+", Cost: "+media.getCost());
			}
			
		}
	}

}
