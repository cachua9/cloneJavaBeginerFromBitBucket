package hust.soict.hedspi.aims.media;

import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import hust.soict.hedspi.aims.PlayerException;

public class CompactDisc extends Disc implements Playable {

	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(CompactDisc disc) {
		super(disc);
	}
	public CompactDisc(String title) {
		super(title);
	}
	public CompactDisc(String title, String category) {
		super(title, category);
	}
	public CompactDisc(String title, String category, String director) {
		super(title, category, director);
	}
	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public CompactDisc(String title, String category, String dirertor, float cost) {
		super(title, category, dirertor, cost);
	}
	public CompactDisc(String title, String category, String dirertor, int length, float cost) {
		super(title, category, dirertor, length, cost);
	}
	public CompactDisc(String title, String category, String dirertor, int length, float cost, String artist) {
		this(title, category, dirertor, length, cost);
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}	
	
	public void addTrack(Track track) {
		if(tracks.size() !=	0) {		
			for (Track trk : tracks) {
				if(trk.equals(track)) {
					System.out.println("Track is exist!");
					JOptionPane.showMessageDialog(null, "Track is exist!");
					return;
				}
			}
		}
		tracks.add(track);
		System.out.println("Input track success!");
		JOptionPane.showMessageDialog(null, "Input track success!");
	}
	public void removeTrack(Track track) {
		if(tracks.size()==0) {
			System.out.println("Tracks is empty!");
			return;
		}
		for (Track trk : tracks) {
			if(trk.equals(track)) {
				tracks.remove(track);
				System.out.println("Remove track success!");
				return;
			}
		}
	}
	public int getLength() {
		int length = 0;
		for (Track track : tracks) {
			length += track.getLength();
		}
		return length;
	}
	@Override
	public void play() throws PlayerException{
		if(tracks.size()==0) {
			System.out.println("Tracks is empty!");
			JOptionPane.showMessageDialog(null, "Tracks is empty!");
			return;
		}
		if(this.getLength() > 0) {
			for (Track track : tracks) {
				try {
					track.play();
				} catch (PlayerException e) {
					throw e;
				}
			}
		}
		else {
			throw new PlayerException("CD length is non-positive");
		}
		
		
	}
	@Override
	public int compareTo(Media o) {
		//return this.getTitle().compareTo(((CompactDisc)o).getTitle());
		if(o instanceof CompactDisc) {
			if(this.tracks.size() > ((CompactDisc)o).tracks.size()) {
				return 1;
			}
			else if(this.tracks.size() < ((CompactDisc)o).tracks.size()) {
				return -1;
			}
			else {
				if(this.getLength() > ((CompactDisc)o).getLength()) {
					return 1;
				}
				else if(this.getLength() < ((CompactDisc)o).getLength()) {
					return -1;
				}
				else {
					return 0;
				}
			}		
		}
		return super.compareTo(o);	
	}

}
