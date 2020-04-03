package hust.soict.hedspi.aims.disc;

public class TestPassingParameter {
	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("dvd1");
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("dvd2");
		
		swap(dvd1, dvd2);
		System.out.println("dvd1 title: " + dvd1.getTitle());
		System.out.println("dvd2 title: " + dvd2.getTitle() + "\n");
		
		changeTitle(dvd1, "newTitle");
		System.out.println("dvd1 title: " + dvd1.getTitle() + "\n");
		
		dvd1.swap(dvd2);
		System.out.println("dvd1 title: " + dvd1.getTitle());
		System.out.println("dvd2 title: " + dvd2.getTitle() + "\n");
	}
	
	public static void swap(Object x, Object y) {
		Object tmp = x;
		x = y;
		y = tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
	
}
