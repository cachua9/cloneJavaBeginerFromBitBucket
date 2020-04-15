package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media{
	
	private String director;
	private int length;	
	public DigitalVideoDisc(DigitalVideoDisc dvd) {
		super(dvd);
		this.director = dvd.director;
		this.length = dvd.length;		
	}	
	public DigitalVideoDisc(String title) {
		super(title);
	}		
	public DigitalVideoDisc(String title, String category) {
		super(title, category);
	}
	public DigitalVideoDisc(String title, String category, String dirertor) {
		super(title, category);
		this.director=dirertor;
	}
	public DigitalVideoDisc(String title, String category, String dirertor, int length, float cost) {
		this(title,category,dirertor);
		this.length=length;
		this.cost=cost;
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
