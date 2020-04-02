
public class Order {
	
	private int qtyOrdered;
	public static final int  MAX_NUMBERS_ORDERED = 10;
	private DigitalVideoDisc orderList[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public Order() {
		this.qtyOrdered = 0;
	}

	public int getQtyOrdered() {
		return this.qtyOrdered;
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
	

}
