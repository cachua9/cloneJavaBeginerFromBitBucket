
public class Aims {
	public static void main(String[] args) {
		
		Order anOrder = new Order();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Iron Man");
		dvd1.setCategory("category dvd1");
		dvd1.setCost(20.1f);
		dvd1.setDirector("director dvd1");
		dvd1.setLength(90);
		anOrder.addDVD(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Caption America","category dvd2","director dvd2");
		dvd2.setCost(18.25f);
		dvd2.setLength(89);
		anOrder.addDVD(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Widow Black","category dvd3","director dvd3",94,23.35f);
		anOrder.addDVD(dvd3);
		
		DigitalVideoDisc[] dvdList = {dvd2,dvd3};
		anOrder.addDVD(dvdList);
		
		System.out.print("Total cost is: ");
		System.out.println(anOrder.totalCost());
		
		anOrder.removeDVD(dvd2);
		
		System.out.print("Total cost is: ");
		System.out.println(anOrder.totalCost());
		
	}

}
