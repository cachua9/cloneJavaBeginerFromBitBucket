package hust.soict.hedspi.aims.order;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order {
	
	private int qtyOrdered;
	public static final int  MAX_NUMBERS_ORDERED = 10;
	public DigitalVideoDisc orderList[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED+1];
	private MyDate dateOrder;
	public static int nbOrder;
	public static int MAX_LIMITTED_ORDER = 5;
	
	public Order() {
		this.qtyOrdered = 0;
		nbOrder++;
	}
	public Order(MyDate date) {
		this.qtyOrdered = 0;
		nbOrder++;
		this.dateOrder = date;
	}
	
	public static Order createOrder() {
		if(Order.nbOrder<MAX_LIMITTED_ORDER) {
			return new Order();
		}
		else {
			System.out.println("nOrders full!");
			return null;
		}
	}
	public static Order createOrder(MyDate date) {
		if(Order.nbOrder<MAX_LIMITTED_ORDER) {
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
	
	public void addDVD(DigitalVideoDisc DVD) {
		if (this.qtyOrdered <MAX_NUMBERS_ORDERED) {
			orderList[++this.qtyOrdered] = DVD;
			System.out.println("Add DVD "+DVD.getTitle()+": Success!");		
		}
		else {
			System.out.println("Add DVD "+DVD.getTitle()+": False! - Order full");
		}
	}
	
	public void addDVD(DigitalVideoDisc[] dvdList) {
		if (this.qtyOrdered+dvdList.length <=MAX_NUMBERS_ORDERED) {
			for(int i=0; i<dvdList.length; i++) {
				orderList[++this.qtyOrdered] = dvdList[i];
			}
		}
		else {
			System.out.println("Add DVDList False! - Order full");
		}
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
	
	public void addDVD(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (this.qtyOrdered+2 <=MAX_NUMBERS_ORDERED) {
			orderList[++this.qtyOrdered] = dvd1;
			orderList[++this.qtyOrdered] = dvd2;
		}
		else {
			System.out.println("Add DVDList False! - Order full");
		}
	}
	
	public void removeDVD(DigitalVideoDisc DVD) {
		
		if (this.qtyOrdered==0) {
			System.out.println("Empty order");	
		}
		else {
			int qtyOrder=0;
			for (int i = 1; i <= this.qtyOrdered; i++) {
				if(DVD==orderList[i]) qtyOrder=i;
			}
			if (qtyOrder==0) {
				System.out.println("DVD "+DVD.getTitle()+" not found!");		
			}
			else {
				for(int i=qtyOrder; i<this.qtyOrdered; i++) {
					orderList[i]=orderList[i+1];
				}
				this.qtyOrdered--;
				System.out.println("Remove DVD "+DVD.getTitle()+": Success!");
			}
		}
		
	}
	public float totalCost() {
		float result=0;
		for(int i=1; i<= this.qtyOrdered; i++) {
			result+=orderList[i].getCost();
		}
		return result;
	}
	public void printOrder() {
		System.out.println(this.dateOrder.getStringDate());
		for(int i=1; i<=qtyOrdered; i++) {
			System.out.println(i + ". DVD - " + orderList[i].getTitle() + " - " + orderList[i].getCategory() + " - " + orderList[i].getDirector() + " - " + orderList[i].getLength() + " - " + orderList[i].getCost() + "$");
		}
		System.out.println(this.totalCost());
	}
	public void getALuckyItem() {
		int rand = 1 + (int)(Math.random()*this.qtyOrdered);
		orderList[rand].setCost(0);		
		System.out.println("Lucky item is "+orderList[rand].getTitle());
	}

}
