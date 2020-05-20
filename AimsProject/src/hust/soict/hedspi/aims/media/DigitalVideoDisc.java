package hust.soict.hedspi.aims.media;

import javax.swing.JOptionPane;

import hust.soict.hedspi.aims.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	
	public DigitalVideoDisc(DigitalVideoDisc dvd) {
		super(dvd);		
	}	
	public DigitalVideoDisc(String title) {
		super(title);
	}		
	public DigitalVideoDisc(String title, String category) {
		super(title, category);
	}
	public DigitalVideoDisc(String title, String category, String director) {
		super(title, category, director);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public DigitalVideoDisc(String title, String category, String dirertor, float cost) {
		super(title, category, dirertor, cost);
	}
	public DigitalVideoDisc(String title, String category, String dirertor, int length, float cost) {
		super(title, category, dirertor, length, cost);
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
	@Override
	public void play() throws PlayerException{
		if(this.length > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
			JOptionPane.showMessageDialog(null, "Playing DVD: " + this.getTitle() + "\nDVD length: " + this.getLength());
		}
		else {
			throw new PlayerException("DVD length is non-positive");
		}
	}
	@Override	
	public int compareTo(Media o) {
		//return this.getTitle().compareTo(((DigitalVideoDisc)o).getTitle());
		if (o instanceof DigitalVideoDisc) {
			if(this.getCost() > ((DigitalVideoDisc)o).getCost())
				return 1;
			if(this.getCost() < ((DigitalVideoDisc)o).getCost())
				return -1;
			return 0;			
		}
		return super.compareTo(o);
	}
}
