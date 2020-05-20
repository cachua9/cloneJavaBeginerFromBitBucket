package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;
import hust.soict.hedspi.aims.utils.MyDate;

public class DiskTest {
	public static void main(String[] args) {
		MyDate today = new MyDate(18,3,2020);
		
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
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Iron Man 4","category dvd4","director dvd4",100,25.32f);
		anOrder.addMedia(dvd4);
		
		
		System.out.print("Total cost is: ");
		System.out.println(anOrder.totalCost());
		//anOrder.getALuckyItem();
		System.out.print("Total cost is: ");
		System.out.println(anOrder.totalCost());
		
	}
}
