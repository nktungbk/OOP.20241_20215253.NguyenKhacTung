package hust.soict.dsai.aims.media;

public class Disc extends Media {
	protected int length;
	protected String director;
	
	public Disc() {
		
	}
	public Disc(String title, String category, float cost,int length, String director) {
		// TODO Auto-generated constructor stub
		super(title,category,cost);
		this.length = length;
		this.director = director;
	}

	public Disc(String title, String category, float cost) {
		// TODO Auto-generated constructor stub
		super(title,category,cost);
	}
	public Disc(String title, String category, float cost, String director) {
		// TODO Auto-generated constructor stub
		super(title,category,cost);
		this.director = director;
	}
	

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	@Override
	public int compareTo(Media o) {
		// TODO Auto-generated method stub
		return 0;
	}

}