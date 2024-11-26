package hust.soict.dsai.store;


import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	private final int MAX_DVD_ID=10000;
	private int idDVD=0;
	private int nbDVD=0;
	public DigitalVideoDisc itemsInStore[]=new DigitalVideoDisc[MAX_DVD_ID];
	public void addDVD(DigitalVideoDisc disc) {
		itemsInStore[idDVD]=disc;
		System.out.println("Disk "+disc.getTitle()+" added to store.");
		nbDVD++;
		idDVD++;
	}
	public void addDVD(DigitalVideoDisc [] dvdList) {
		int listSize = dvdList.length;
		nbDVD+=listSize;
			for(int i=0;i<listSize;i++) {
				itemsInStore[idDVD]=dvdList[i];
				idDVD++;
				System.out.print(dvdList[i].getTitle());
				System.out.println(": disk added.");
			}
			System.out.print("Store quantity: ");
			System.out.println(nbDVD);
	}
	public void removeDVD(DigitalVideoDisc disc) {



        // Copy the elements except the index
        for (int i = 0, k = 0; i < itemsInStore.length; i++) {
            if (itemsInStore[i] ==disc )
                continue;
            
              itemsInStore[k++] = itemsInStore[i];
        }
        System.out.println("Disk "+disc.getTitle()+" removed from store.");

    }
	
}
