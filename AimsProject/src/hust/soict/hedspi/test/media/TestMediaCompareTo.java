package hust.soict.hedspi.test.media;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;

public class TestMediaCompareTo {
	public static void main(String[] args) {
		Collection collection = new ArrayList();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Iron Man", "Action", "Marval", 90, 20.4f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Captain America", "Action", "Marval", 87, 18.45f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Hulk", "Action", "Marval", 98, 16.8f);
		
		collection.add(dvd2);
		collection.add(dvd1);
		collection.add(dvd3);
		
		Iterator iterator = collection.iterator();
		
		System.out.println("-------------------------------------");
		System.out.println("The DVDs currently in the order are: ");
		
		while(iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
		
		Collections.sort((List)collection);
		
		iterator = collection.iterator();
		
		System.out.println("-------------------------------------");
		System.out.println("The DVDs in sorted order are: ");
			
		while(iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
		
		System.out.println("-------------------------------------");
		
		Collection collection2 = new ArrayList();
		Track track1 = new Track("Baby Shark", 4);
		Track track2 = new Track("300 bai hat thieu nhi", 3);
		Track track3 = new Track("Bella chaos", 5);
		Track track4 = new Track("Ai khoc noi dau nay", 2);
		Track track5 = new Track("Ta lang", 5);
		Track track6 = new Track("Di Du Dua Di", 3);
		Track track7 = new Track("Astronomia", 6);
		Track track8 = new Track("999 doa hong", 7);
		Track track9 = new Track("Chua len 3", 10);
		Track track10 = new Track("Co gai mo duong", 3);
		CompactDisc cd1 = new CompactDisc("Summer Hot");
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		cd1.addTrack(track3);
		cd1.addTrack(track4);
		cd1.addTrack(track5);
		CompactDisc cd2 = new CompactDisc("Winter but not cold");
		cd2.addTrack(track2);
		cd2.addTrack(track4);
		cd2.addTrack(track6);
		cd2.addTrack(track8);
		cd2.addTrack(track10);
		CompactDisc cd3 = new CompactDisc("People from Mars");
		cd3.addTrack(track5);
		cd3.addTrack(track7);
		cd3.addTrack(track9);
		
		collection2.add(cd2);
		collection2.add(cd1);
		collection2.add(cd3);
		
		iterator = collection2.iterator();
		
		System.out.println("-------------------------------------");
		System.out.println("The CDs currently in the order are: ");
		
		while(iterator.hasNext()) {
			System.out.println(((CompactDisc)iterator.next()).getTitle());
		}
		
		Collections.sort((List)collection2);
		
		iterator = collection2.iterator();
		
		System.out.println("-------------------------------------");
		System.out.println("The CDs in sorted order are: ");
			
		while(iterator.hasNext()) {
			CompactDisc cd = (CompactDisc)iterator.next();
			System.out.println(cd.getTitle() + " - Lenth: " + cd.getLength());
		}
		
		System.out.println("-------------------------------------");
	}
}
