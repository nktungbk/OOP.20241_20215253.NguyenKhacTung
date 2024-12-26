package hust.soict.dsai.aims.media;

import java.util.*;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
	private String Artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	// Add and remove track
    public void addTrack(Track track) {
    	if (tracks.isEmpty()) {
    		tracks.add(track);
            System.out.println("Track: " + track.getTitle() + " has been added to CD: " + this.getTitle());
    	}
    	else if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track: " + track.getTitle() + " has been added to CD: " + this.getTitle());
        } else {
            System.out.println("Track is already in the CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track: " +track.getTitle() + " has been removed from CD: " + this.getTitle());
        } else {
            System.out.println("Track is already not in the CD.");
        }
    }
 // Constructor 
    public CompactDisc(String title, float cost) {
		this.setTitle(title);
		this.setCost(cost);
	}

	public CompactDisc(String title,String director, int length, String category, String artist, float cost) {
		// TODO Auto-generated constructor stub
		super(title,category,cost,length, director);
		this.Artist = artist;
		
	}

	public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist2,
			List<Track> tracks2) {
		super(title,category,cost,length,director);
		this.setId(id);
		this.setArtist(artist2);
		this.setTracks(tracks);
		
		// TODO Auto-generated constructor stub
	}
	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getArtist() {
		return Artist;
	}
	public void setArtist(String artist) {
		this.Artist = artist;
	}
	@Override
    public String toString() {
        return this.getId() + " - CD: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Artist" + this.getArtist() +
                " - Length: " + this.getLength() + " seconds" + 
                " - Cost: " + this.getCost() + "$";
    }	
	 public void addtrack(Track track) throws IllegalArgumentException {
	        if (!tracks.contains(track)) {
	            tracks.add(track);
	            System.out.println("Added track: " + track.getTitle());
	        } else {
	            throw new IllegalArgumentException(track.getTitle() + " is already in the list of tracks.");
	        }
	    }
	 public void removetrack(Track track) throws NoSuchElementException {
	        if (tracks.contains(track)) {
	            tracks.remove(track);
	            System.out.println("Removed track: " + track.getTitle());
	        } else {
	            throw new NoSuchElementException(track.getTitle() + " is not in the list of tracks.");
	        }
	 }
	@Override
	public void play() throws PlayerException {
        if (getLength() > 0) {
            Iterator<Track> iter = tracks.iterator();
            Track nextTrack;
            while (iter.hasNext()) {
                nextTrack = (Track) iter.next();
                try {
                    nextTrack.play();
                } catch (PlayerException e) {
                    throw new PlayerException("Error playing track: " + nextTrack.getTitle(),e);
                }
            }
        } else {
            throw new PlayerException("CD length is non-positive");
        }
    }

}
