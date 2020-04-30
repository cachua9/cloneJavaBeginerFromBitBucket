package hust.soict.hedspi.aims.media;

public abstract class Media {
	
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
	public Media(String title, String category, float cost) {
		this(title,category);
		this.cost = cost;
	}
	public Media(Media media) {
		this();
		this.title = media.title;
		this.category = media.category;
		this.cost = media.cost;
	}
	public static int getnID() {
		return nID;
	}
	public static void setnID(int nID) {
		Media.nID = nID;
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
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this.id == ((Media)obj).getID())
			return true;
		return false;
	}

}
