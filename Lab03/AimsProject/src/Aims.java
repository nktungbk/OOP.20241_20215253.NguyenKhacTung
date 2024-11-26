

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {
	public static void main(String args[]) {
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1=new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		//anOrder.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2=new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		//anOrder.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3=new DigitalVideoDisc("Aladin", "Animation", 19.95f);
		//anOrder.addDigitalVideoDisc(dvd3);
		DigitalVideoDisc [] dvdList= {dvd1,dvd2,dvd3};
		anOrder.addDigitalVideoDisc(dvdList);
		System.out.println("Total Cost is: ");
		float myFloat = anOrder.totalCost();
		String formattedString = String.format("%.02f", myFloat);
		System.out.println(formattedString );
		
		anOrder.print();
	}
}
