package hust.soict.dsai.aims.media;
public class DigitalVideoDisc extends Disc implements Playable {
	
	private static int nbDigitalVideoDiscs=0;
	private String director;
	private int length;
	public String getDirectory() {
		return director;
	}
	public int getLength() {
		return length;
	}
	// Constructor 
    public DigitalVideoDisc(String title) {
        super(title);
    }    
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
