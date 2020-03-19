
public class DigitalVideoDisc {
	
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	public DigitalVideoDisc() {
		
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
	
}
