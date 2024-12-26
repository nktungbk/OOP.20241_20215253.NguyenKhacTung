package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;
	
	public Track(int length) {
		super();
		this.length = length;
	}
	public Track(String title) {
		super();
		this.title = title;
	}
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	@Override
	public void play() throws PlayerException{
        if (getLength() > 0) {
            System.out.println("Playing Track: " + getTitle());
        System.out.println("Track length: " + getLength());
        } else {
            throw new PlayerException("Track length is non-postive");
       }
	}
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {  
            return true;
        }
        if (!(obj instanceof Track)) {
            return false;
        }
        return ((Track)obj).getTitle() == this.getTitle() && ((Track)obj).getLength() == this.getLength();
    }	

}
