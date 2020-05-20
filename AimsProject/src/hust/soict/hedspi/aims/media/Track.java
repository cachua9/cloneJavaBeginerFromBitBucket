package hust.soict.hedspi.aims.media;

import javax.swing.JOptionPane;

import hust.soict.hedspi.aims.PlayerException;

public class Track implements Playable, Comparable<Track>{

		private String title;
		private int length;		
		
		public Track(String title) {
			this.title = title;
		}
		public Track(String title, int length) {
			this.title = title;
			this.length = length;
		}

		public String getTitle() {
			return title;
		}
		public int getLength() {
			return length;
		}
		@Override
		public void play() throws PlayerException {
			if(this.length > 0) {
				System.out.println("Playing track: " + this.getTitle());
				System.out.println("Track length: " + this.getLength());
				JOptionPane.showMessageDialog(null, "Playing Track: " + this.getTitle() + "\nTrack length: " + this.getLength());
			}
			else {
				throw new PlayerException("Track length is non-positive");
			}
			
		}
		public boolean equals(Object obj) {
			if(obj == null)
				return false;
			if(this.title.equals(((Track)obj).getTitle()) && this.length == ((Track)obj).getLength())
				return true;
			return false;
		}
		@Override
		public int compareTo(Track o) {
			return this.getTitle().compareTo(o.getTitle());
		}
		
}
