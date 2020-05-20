package hust.soict.hedspi.aims.order;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import hust.soict.hedspi.aims.PlayerException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order {

	public static int nbOrder = 0;
	public static final int MAX_NUMBERS_ORDERED = 10;
	public static int MAX_LIMITTED_ORDER = 5;
	private int qtyOrdered;
	private MyDate dateOrder;
	private ArrayList<Media> itemOrdered = new ArrayList<Media>();
	private int id;
	private float saleoff;

	public Order() {
		this.id = nbOrder;
		this.qtyOrdered = 0;
		this.saleoff = 0;
		nbOrder++;
	}

	public Order(MyDate date) {
		this();
		this.dateOrder = date;
	}

	public static Order createOrder() {
		if (Order.nbOrder < MAX_LIMITTED_ORDER) {
			System.out.println("Create new order success!");
			JOptionPane.showMessageDialog(null, "Create new order success!");
			return new Order();
		} else {
			System.out.println("nOrders full!");
			JOptionPane.showMessageDialog(null, "nOrders full!");
			return null;
		}
	}

	public static Order createOrder(MyDate date) {
		if (Order.nbOrder < MAX_LIMITTED_ORDER) {
			System.out.println("Create new order success!");
			return new Order(date);
		} else {
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
		this.dateOrder = date;
	}

	public int getID() {
		return this.id;
	}

	public void addMedia(Media media) {
		if (itemOrdered.size() < MAX_NUMBERS_ORDERED) {
			for (Media tmp : itemOrdered) {
				if (tmp.equals(media)) {
					System.out.println("Media " + media.getTitle() + " is exist!");
					JOptionPane.showMessageDialog(null, "Media " + media.getTitle() + " is exist!");
					return;
				}
			}
			itemOrdered.add(media);
			saleoff = 0;
			System.out.println("Add media " + media.getTitle() + ": Success!");
			JOptionPane.showMessageDialog(null, "Add media " + media.getTitle() + ": Success!");
		} else {
			System.out.println("Order full");
			JOptionPane.showMessageDialog(null, "Order full");
		}
	}

	public void removeMedia(Media media) {
		if (itemOrdered.size() == 0) {
			System.out.println("Empty order");
			return;
		}
		for (Media tmp : itemOrdered) {
			if (tmp.equals(media)) {
				itemOrdered.remove(tmp);
				System.out.println("Remove Media " + media.getTitle() + ": Success!");
				return;
			}
		}
		System.out.println("Media " + media.getTitle() + " not found!");
	}

	public void removeMediaByID(int id) {
		if (itemOrdered.size() == 0) {
			System.out.println("Empty order");
			JOptionPane.showMessageDialog(null, "Empty order");
			return;
		}
		for (Media media : itemOrdered) {
			if (media.getID() == id) {
				itemOrdered.remove(media);
				System.out.println("Remove Media id " + id + ": Success!");
				JOptionPane.showMessageDialog(null, "Remove Media id " + id + ": Success!");
				return;
			}
		}
		System.out.println("Media id " + id + " not found!");
		JOptionPane.showMessageDialog(null, "Media id " + id + " not found!");
	}

	/*
	 * public void addDVD(DigitalVideoDisc... dvdList) { if
	 * (this.qtyOrdered+dvdList.length <=MAX_NUMBERS_ORDERED) { for(int i=0;
	 * i<dvdList.length; i++) { orderList[++this.qtyOrdered] = dvdList[i]; } } else
	 * { System.out.println("Add DVDList False! - Order full"); } }
	 */

	public float totalCost() {
		float result = 0;
		for (Media media : itemOrdered) {
			result += media.getCost();
		}
		return result - (saleoff >= 0 ? saleoff : 0);
	}

	public void getALuckyItem() throws PlayerException {
		if (saleoff == 0) {
			saleoff = -1;
			if (this.totalCost() >= 300) {
				if (this.itemOrdered.size() >= 5) {
					int rand = 1 + (int) (Math.random() * 2);
					if (rand == 1) {
						saleoff = this.totalCost() * 0.2f;
						if (saleoff > 100) {
							saleoff = 100;
						}
						System.out.println("Lucky item cost: " + saleoff);
						JOptionPane.showMessageDialog(null, "Lucky item cost: " + saleoff);
					} else {
						throw new PlayerException("Wish you luck next time");
					}
				} else {
					throw new PlayerException("The number of items must be >= 5");
				}
			} else {
				throw new PlayerException("The total cost of the item must be >= 300");
			}
		} else {
			throw new PlayerException("You have been get lucky");
		}

	}

	public void print() {
		if (itemOrdered.size() == 0) {
			System.out.println("Order empty!");
			return;
		}
		for (Media media : itemOrdered) {
			if (media instanceof DigitalVideoDisc) {
				System.out.println(
						"ID: " + media.getID() + " | DVD - Title: " + media.getTitle() + ", Cost: " + media.getCost());
			} else if (media instanceof Book) {
				System.out.println(
						"ID: " + media.getID() + " | Book - Title: " + media.getTitle() + ", Cost: " + media.getCost());
			} else if (media instanceof CompactDisc) {
				System.out.println(
						"ID: " + media.getID() + " | CD - Title: " + media.getTitle() + ", Cost: " + media.getCost());
			}

		}
	}

	public ArrayList<Media> getItemOrdered() {
		return itemOrdered;
	}

}
