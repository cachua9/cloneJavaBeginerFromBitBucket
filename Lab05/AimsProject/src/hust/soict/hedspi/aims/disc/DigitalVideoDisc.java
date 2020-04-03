package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {
	
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	public DigitalVideoDisc() {
		
	}	
	public DigitalVideoDisc(DigitalVideoDisc dvd) {
		this.category=dvd.category;
		this.cost=dvd.cost;
		this.director=dvd.director;
		this.length=dvd.length;
		this.title=dvd.title;
	}	
	public DigitalVideoDisc(String title) {
		if (title!="") {
			this.title = title;
		}
		else {
			System.out.print("Empty title");
		}
	}		
	public DigitalVideoDisc(String title, String category) {
		this(title);
		this.category=category;
	}
	public DigitalVideoDisc(String title, String category, String dirertor) {
		this(title,category);
		this.director=dirertor;
	}
	public DigitalVideoDisc(String title, String category, String dirertor, int length, float cost) {
		this(title,category,dirertor);
		this.length=length;
		this.cost=cost;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}		
	
	public void swap(DigitalVideoDisc dvd) {
		DigitalVideoDisc tmp = new DigitalVideoDisc(this);
		this.title = dvd.title;
		this.category = dvd.category;
		this.director = dvd.director;
		this.length = dvd.length;
		this.cost = dvd.cost;
		dvd.setTitle(tmp.title);
		dvd.setCategory(tmp.category);
		dvd.setDirector(tmp.director);
		dvd.setLength(tmp.length);
		dvd.setCost(tmp.cost);
	}
	
	public boolean search(String title) {
		boolean flag = true;
		String[] outputStrings = title.toLowerCase().split(" ");
		for(int i=0; i<outputStrings.length; i++) {
			if(this.title.toLowerCase().indexOf(outputStrings[i])==-1) {
				flag=false;
				break;
			}
		}
		return flag;
	}
}
