package hust.soict.dsai.aims.disc;
public class DigitalVideoDisc {
	private static int nbDigitalVideoDiscs=0;
	private int id; 	
	private String title;
	private String category;
	private String directory;
	private int length;
	private float cost;
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirectory() {
		return directory;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.directory = directory;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id=nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String directory, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.directory = directory;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id=nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id=nbDigitalVideoDiscs;

	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDiscs++;
		this.id=nbDigitalVideoDiscs;

	}
	public void setTitle(String title2) {
		// TODO Auto-generated method stub
		this.title=title2;
	}
	public int getId(){
	       return id;
	   }
}
