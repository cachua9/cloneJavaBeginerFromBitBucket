package hust.soict.hedspi.aims.media;

public class Media {
	
	protected static int nID = 0;
	protected String title;
	protected String category;
	protected float cost;
	protected int id;
	
	public Media() {
		this.id = nID;
		nID++;
	}
	public Media(String title) {
		this();
		this.title = title;
	}
	public Media(String title, String category) {
		this(title);
		this.category = category;
	}
	public Media(Media media) {
		this();
		this.title = media.title;
		this.category = media.category;
		this.cost = media.cost;
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
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getID() {
		return this.id;
	}
	
	

}
