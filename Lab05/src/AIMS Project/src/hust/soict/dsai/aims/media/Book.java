package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors=new ArrayList<String>();
	
	public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } else {
            System.out.println("This author is already in the list!");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println("This author is already not in the list!");
        }
    }
    public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	// Constructor 
	public Book(String title, float cost) {
		this.setTitle(title);
		this.setCost(cost);
	}
	public Book(String title, String category, int id, float cost) {
		super(title,category,id,cost);
	}
	public Book(int id, String title, String category, float cost, List<String> authors2) {
		// TODO Auto-generated constructor stub
		super(title,category,id,cost);
		this.setAuthors(authors);
	}

	@Override
	public int compareTo(Media o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
