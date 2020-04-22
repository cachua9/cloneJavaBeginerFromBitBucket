package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	
	protected int length;
	protected String director;
	
	public Disc(String title) {
		super(title);
	}		
	public Disc(String title, String category) {
		super(title, category);
	}
	public Disc(String title, String category, String director) {
		super(title, category);
		this.director = director;
	}
	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public Disc(String title, String category, String dirertor, float cost) {
		super(title, category,cost);
		this.director=dirertor;
	}
	public Disc(String title, String category, String dirertor, int length, float cost) {
		this(title,category,dirertor,cost);
		this.length=length;
	}
	public Disc(Disc disc) {
		super(disc);
		this.director = disc.director;
		this.length = disc.length;		
	}	
	
	public void setLength(int length) {
		this.length = length;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	
	
}
