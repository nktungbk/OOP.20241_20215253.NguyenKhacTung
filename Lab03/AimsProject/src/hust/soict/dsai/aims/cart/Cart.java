package hust.soict.dsai.aims.cart;


import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public final int MAX_NUMBER_ORDERED=100;
	private DigitalVideoDisc itemsOrdered[]=new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	private int qtyOrdered=0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered==MAX_NUMBER_ORDERED) {
			System.out.println("Cart full.");
			System.out.println("Cart quantity: ");
			System.out.print(qtyOrdered);
			}
		if(MAX_NUMBER_ORDERED-5<qtyOrdered&&qtyOrdered<MAX_NUMBER_ORDERED) {
			System.out.println("Cart almost full.");
			System.out.println("Cart quantity: ");
			System.out.print(qtyOrdered);
			itemsOrdered[qtyOrdered]=disc;
			System.out.println("Disk added.");
			qtyOrdered++;
		}
		else {
			itemsOrdered[qtyOrdered]=disc;
			System.out.println("Disk added.");
			qtyOrdered++;
		}
		
	}
	public void addDigitalVideoDisc(DigitalVideoDisc disc1,DigitalVideoDisc disc2) {
		if (qtyOrdered==MAX_NUMBER_ORDERED-1) {
			System.out.println("Cart full.");
			System.out.println("Cart quantity: ");
			System.out.print(qtyOrdered);
			}
		if(MAX_NUMBER_ORDERED-6<qtyOrdered&&qtyOrdered<MAX_NUMBER_ORDERED-1) {
			System.out.println("Cart almost full.");
			System.out.println("Cart quantity: ");
			System.out.print(qtyOrdered);
			itemsOrdered[qtyOrdered]=disc1;
			itemsOrdered[qtyOrdered+1]=disc2;
			System.out.println("2 disk added.");
			qtyOrdered++;
			qtyOrdered++;
		}
		else {
			itemsOrdered[qtyOrdered]=disc1;
			itemsOrdered[qtyOrdered+1]=disc2;
			System.out.println("2 disk added.");
			qtyOrdered++;
			qtyOrdered++;
		}
		
	}
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		int listSize = dvdList.length;
		if (qtyOrdered+listSize>MAX_NUMBER_ORDERED) {
			System.out.println("Cart full.");
			System.out.println("Cart quantity: ");
			System.out.print(qtyOrdered);
			}
		if(MAX_NUMBER_ORDERED-5+listSize<qtyOrdered&&qtyOrdered+listSize<MAX_NUMBER_ORDERED) {
			System.out.println("Cart almost full.");
			System.out.println("Cart quantity: ");
			System.out.print(qtyOrdered);
			
			for(int i=0;i<listSize;i++) {
			itemsOrdered[qtyOrdered+i]=dvdList[i];

			qtyOrdered++;
			}
			

			System.out.print(listSize);
			System.out.println(" disk added.");
			System.out.print("Cart quantity: ");
			System.out.println(qtyOrdered);
		}
		else {
			for(int i=0;i<listSize;i++) {
				itemsOrdered[qtyOrdered]=dvdList[i];
				qtyOrdered++;
			}
			System.out.print(listSize);
			System.out.println(" disk added.");
			System.out.print("Cart quantity: ");
			System.out.println(qtyOrdered);
		}
		
	}
	//Using an array as argument is better than overloading many times for many number of argument
	public float totalCost() {
		float cost=0;
		for(int i=0; i<qtyOrdered;i++) {
			cost+=itemsOrdered[i].getCost();
		}
		return cost;
	}
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		float tempcost;
		String formattedString;
		for(int i=0; i<qtyOrdered;i++) {
			int id=i+1;
			System.out.print(id);
			tempcost = itemsOrdered[i].getCost();
			formattedString = String.format("%.02f", tempcost);
			System.out.println(". DVD - "+itemsOrdered[i].getTitle()+" - "+itemsOrdered[i].getCategory()+" - "+itemsOrdered[i].getDirectory()+" - "+itemsOrdered[i].getLength()+" : "+itemsOrdered[i].getCost()+"$");
		}
		tempcost = totalCost();
		formattedString = String.format("%.02f", tempcost);
		System.out.println("Total cost: "+ formattedString);
		System.out.println("***************************************************");
		
	}
	
}
