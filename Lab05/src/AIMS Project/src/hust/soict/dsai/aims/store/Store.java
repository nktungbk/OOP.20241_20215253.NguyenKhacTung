package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;
import java.util.NoSuchElementException;
public class Store {
	public static final int MAX_NUMBERS_DVD = 100;
	ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		itemsInStore.add(media);
	}
	
	public void removeMedia(Media media) throws NoSuchElementException {
        if (itemsInStore.remove(media)) {
            System.out.println("Removed " + media.getTitle() + " from the store.");
        } else {
            throw new NoSuchElementException(media.getTitle() + " is not in the store.");
        }
    }
	
	public void listItems() {
		System.out.println("List of item: ");
		for (Media m: itemsInStore) {
			System.out.println(m.toString());
		}
		System.out.println("-----------------------");
	}
	
	public Media searchMedia(String title) {
		for (Media m : itemsInStore) {
			if (m.getTitle().equals(title)) {
				return m;
			}
		}
		return null;
	}

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
}