public class Cart {
	public final int MAX_NUMBER_ORDERED=20;
	private DigitalVideoDisc itemsOrdered[]=new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	private int qtyOrdered=0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered==19) {
			System.out.println("Cart full.");
			}
		if(16<qtyOrdered&&qtyOrdered<19) {
			System.out.println("Cart almost full.");
			System.out.println("Cart quantity: ");
			System.out.print(qtyOrdered);
		}
		else {
			itemsOrdered[qtyOrdered]=disc;
			System.out.println("Disk added.");
			qtyOrdered++;
		}
		
	}
	public float totalCost() {
		float cost=0;
		for(int i=0; i<qtyOrdered;i++) {
			cost+=itemsOrdered[i].getCost();
		}
		return cost;
	}
}
