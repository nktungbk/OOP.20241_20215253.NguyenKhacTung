package hust.soict.dsai.test.store;


import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.store.Store;

public class StoreTest {
	public static void main(String args[]) {
		Store store = new Store();
		DigitalVideoDisc dvd1=new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addDVD(dvd1);
		DigitalVideoDisc dvd2=new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addDVD(dvd2);
		DigitalVideoDisc dvd3=new DigitalVideoDisc("Aladin", "Animation", 19.95f);
		store.addDVD(dvd3);
		DigitalVideoDisc [] dvdList= {dvd1,dvd2,dvd3};
		store.addDVD(dvdList);
//		System.out.println("Total Cost is: ");
//		float myFloat = cart.totalCost();
//		String formattedString = String.format("%.02f", myFloat);
//		System.out.println(formattedString );
//		
		store.removeDVD(dvd2);
	}
}
