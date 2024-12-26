package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.*;
import java.util.*;

import javax.naming.LimitExceededException;

public class Aims {
	private static Cart cart = new Cart();
	private static Store store = new Store();
	
	public static void main(String[] args) throws LimitExceededException, PlayerException {
		// Create a new Cart and Store:
		
		// Create new dvd object and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
						"Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
								"Science Fiction", "George Lucas", 87, 24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
							"Animation", 18.99f);
		
		// Create CD:
		CompactDisc cd1 = new CompactDisc("Allstarts", "Yes", 15, "Sport", "Smash Mouth", 69.420f);
		Track track1 = new Track("NBA1", 12);
		Track track2 = new Track("NBA2", 15);
		cd1.addtrack(track1);
		cd1.addtrack(track2);
		
		// Book:
		Book book1 = new Book("Sherlock Holmes", "Detective", 420, 5f);
		book1.addAuthor("Nguyen Nhat Anh");
		book1.addAuthor("JK Rolling");
		
		// ADD:
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.addMedia(cd1);
		store.addMedia(book1);
		
		Scanner scanner = new Scanner(System.in);
		int choice;
		
		do {
			showMenu();
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
				case 1:
					viewStore(scanner);
					break;
					
				case 2:
					updateStore(scanner);
					break;
				
				case 3:
					seeCurrentCart(scanner);
					break;
				case 0 :
					System.out.println("Exiting.......");
					
				default:
					System.out.println("Invalid choice. Please try again");
					break;
			}
		} while (choice != 0);
		
		scanner.close();
		
	}
	
	// ------------------------------------- Show Menu --------------------------------------------------//
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("----------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("-----------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void viewStore(Scanner scanner) throws LimitExceededException, PlayerException {
		store.listItems();
		storeMenu(scanner);
	}
	
	public static void updateStore(Scanner scanner) {
		System.out.println("-------------------------------");
		System.out.println("1. Add a media to the store");
		System.out.println("2. Remove a media to the store");
		System.out.println("0. Exit");
		System.out.println("-------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		
		int choice  = scanner.nextInt();
		scanner.nextLine();
		switch(choice) {
			case 1:
				addMedia(scanner);
				break;
			case 2: 
				removeMedia(scanner);
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice. Please try again");
				updateStore(scanner);
				break;
		}
	}
	public static void addMedia(Scanner scanner) {
		System.out.println("Choose type of media to add:");
		System.out.println("-----------------------------");
		System.out.println("1. DVD");
		System.out.println("2. CD");
		System.out.println("3. Book");
		System.out.println("0. Exit");
		System.out.println("-----------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch(choice) {
			case 1:
				System.out.println("Enter the information of DVD: ");
				System.out.println("Title: ");
				String title = scanner.nextLine();
				System.out.println("Category: ");
				String category = scanner.nextLine();
				System.out.println("Director: ");
				String director = scanner.nextLine();
				System.out.println("Length: ");
				int length = scanner.nextInt();
				System.out.println("Cost: ");
				float cost = scanner.nextFloat();
				Media check = store.searchMedia(title);
				if (check == null) {
					Media dvd = new DigitalVideoDisc(title, category, director, length, cost);
					store.addMedia(dvd);
					System.out.println("Add Successfully");
				} else {
					System.out.println("Already in the store");
				}
				break;
			case 2: 
				System.out.println("Enter the information of CD: ");
				System.out.println("Title: ");
				String title1 = scanner.nextLine();
				System.out.println("Category: ");
				String category1 = scanner.nextLine();
				System.out.println("Director: ");
				String director1 = scanner.nextLine();
				System.out.println("Length: ");
				int length1 = scanner.nextInt();
				System.out.println("Cost: ");
				float cost1 = scanner.nextFloat();
				System.out.println("Artist: ");
				String artist = scanner.nextLine();
				Media check1 = store.searchMedia(title1);
				if (check1 == null) {
					Media cd = new CompactDisc(title1,director1,length1,category1, artist, cost1);
					store.addMedia(cd);
					System.out.println("Add Successfully");
				}
				break;
				
			case 3:
				System.out.println("Enter the information of book: ");
				System.out.println("Id: ");
				int id = scanner.nextInt();
				System.out.println("Title: ");
				String title2 = scanner.nextLine();
				System.out.println("Category: ");
				String category2 = scanner.nextLine();
				System.out.println("Cost: ");
				float cost2 = scanner.nextFloat();
				Media check2 = store.searchMedia(title2);
				if (check2 == null) {
					Media book = new Book(title2, category2, id, cost2);
					store.addMedia(book);
					System.out.println("Add successfully");
				}
				break;
			
			case 0:
				break;
			default:
				System.out.println("Invalid choice. Please try again");
				addMedia(scanner);
				break;
					
		}
		
	}
	
	public static void removeMedia(Scanner scanner) {
		System.out.println("Please enter the title of media you want to remove: ");
		String title = scanner.nextLine();
		Media media = store.searchMedia(title);
		store.removeMedia(media);
	}
	
	public static void seeCurrentCart(Scanner scanner) throws PlayerException {
		System.out.println(cart.getQuantity());
		System.out.println(cart.toString());
		cartMenu(scanner);
	}
	
	// ------------------------------------------------------------------------------------------------------------------//
	
	
	// ----------------------------------------- Store Menu ------------------------------------------------------------//
	
	public static void storeMenu(Scanner scanner) throws LimitExceededException, PlayerException {
		System.out.println("Options: ");
		System.out.println("----------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("-----------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		
		int choice = scanner.nextInt();
		scanner.nextLine();
		
		switch(choice) {
			case 1:
				seeMediaDetails(scanner);
				storeMenu(scanner);
				break;
			case 2: 
				addMediaToCart(scanner);
				storeMenu(scanner);
				break;
			
			case 3:
				playAMedia(scanner);
				storeMenu(scanner);
				break;
			
			case 4: 
				seeCurrentCart(scanner);
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				storeMenu(scanner);
				break;
	}
	}
	public static void seeMediaDetails(Scanner scanner) throws LimitExceededException, PlayerException {
		System.out.println("Please enter the title of the Media: ");
		String title = scanner.nextLine();
		
		Media media = store.searchMedia(title);
		if (media != null) {
			System.out.println(media.toString());
			mediaDetailsMenu(scanner,media);
		} else {
			System.out.println("Media not found");
			storeMenu(scanner);
		}
	}
	
	public static void addMediaToCart(Scanner scanner) throws LimitExceededException {
		System.out.println("Please enter the title of the Media: ");
		String title = scanner.nextLine();
		
		Media media = cart.searchTitle(title);
		if (media != null) {
			System.out.println("Media is alrealdy in Cart");
		} else {
			cart.addMedia(store.searchMedia(title));
			System.out.println("Add media to cart successfully");
			System.out.println("Number of Medias in the current cart: " + cart.getQuantity());
		}
	}
	
	public static void playAMedia(Scanner scanner) throws PlayerException {
		System.out.println("Please enter the title of the Media: ");
		String title = scanner.nextLine();
		
		Media media = store.searchMedia(title);
		playMedia(media);
	}
	
	
	// ----------------------------------------------------------------------------------------------------------//
	
	//------------------------------------------------------- Media Menu ----------------------------------------//
	
	
	
	public static void mediaDetailsMenu(Scanner scanner, Media media) throws LimitExceededException, PlayerException {
		System.out.println("Options: ");
		System.out.println("--------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. back");
		System.out.println("---------------------------");
		System.out.println("Please choose a number 0-1-2");
		
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch(choice) {
			case 1:
				cart.addMedia(media);
				System.out.println("Add media to cart successfully");
				System.out.println("Number of Medias in the current cart: " + cart.getQuantity());
				mediaDetailsMenu(scanner,media);
				break;
			case 2:
				playMedia(media);
				mediaDetailsMenu(scanner,media);
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice. Please try again");
				mediaDetailsMenu(scanner,media);
				break;	
		}
	}
	
	public static void playMedia(Media media) throws PlayerException {
		if (media == null) {
			System.out.println("Not found that media");
		} else if (media instanceof CompactDisc) {
			CompactDisc cd = (CompactDisc) media;
			cd.play();
		} else if (media instanceof DigitalVideoDisc) {
			DigitalVideoDisc dvd = (DigitalVideoDisc) media;
			dvd.play();
		} else {
			System.out.println("Book can't be played");
		}
	}
	// ------------------------------- Cart Menu -----------------------------------------------------//
	
	public static void cartMenu(Scanner scanner ) throws PlayerException {
		System.out.println("Options: ");
		System.out.println("-----------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play media");
		System.out.println("5. Play order");
		System.out.println("0. Back");
		System.out.println("------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch(choice) {
			case 1:
				filterMedia(scanner);
				cartMenu(scanner);
				break;
			case 2:
				sortMedia(scanner);
				cartMenu(scanner);
				break;
			case 3:
				removeMediafromCart(scanner);
				cartMenu(scanner);
				break;
			case 4:
				playMediaFromCart(scanner);
				cartMenu(scanner);
				break;
			case 5:
				placeOrder();
				cartMenu(scanner);
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice. Please try again");
				cartMenu(scanner);
				break;	
 		}
	}
	
	public static void filterMedia(Scanner scanner) {
		System.out.println("Options: ");
		System.out.println("------------------------");
		System.out.println("1. Filter by id");
		System.out.println("2. Filter by title");
		System.out.println("0. Back");
		System.out.println("-------------------------");
		System.out.println("Please choose a number: 0-1-2");
		
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch(choice) {
			case 1:
				System.out.println("Enter the id: ");
				int id = scanner.nextInt();
				Media m = cart.searchID(id);
				if (m != null) {
					System.out.println(m.toString());
				} else {
					System.out.println("No found");
				}
				filterMedia(scanner);
				break;
			
			case 2:
				System.out.println("Enter the title");
				String title = scanner.nextLine();
				Media m1 = cart.searchTitle(title);
				if (m1 != null) {
					System.out.println(m1.toString());
				} else {
					System.out.println("No found");
				}
				filterMedia(scanner);
				break;
			
			case 0:
				break;
			default:
				System.out.println("Invalid choice. Please try again");
				filterMedia(scanner);
				break;
				
		}
	}
	
	public static void sortMedia(Scanner scanner) {
		System.out.println("Options: ");
		System.out.println("------------------------");
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by cost");
		System.out.println("0. Back");
		System.out.println("-------------------------");
		System.out.println("Please choose a number: 0-1-2");
		
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch(choice) {
			case 1:
				Collections.sort(cart.getItemsOrdered(),Media.COMPARE_BY_TITLE_COST);
				sortMedia(scanner);
				break;
			
			case 2:
				Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
				sortMedia(scanner);
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice. Please try again");
				filterMedia(scanner);
				break;
				
		}
	}
	
	public static void removeMediafromCart(Scanner scanner) {
		System.out.println("Please enter the title of media: ");
		String title = scanner.nextLine();
		Media m = cart.searchTitle(title);
		if (m != null) {
			cart.removeMedia(m);
			System.out.println("Remove successfully");
		} else {
			System.out.println("Not found media");
		}
	}
	
	public static void playMediaFromCart(Scanner scanner) throws PlayerException {
		System.out.println("Please enter the title of Medie you want to play: ");
		String title = scanner.nextLine();
		Media m = cart.searchTitle(title);
		if (m == null) {
			System.out.println("Not found that media");
		} else if (m instanceof CompactDisc) {
			CompactDisc cd = (CompactDisc) m;
			cd.play();
		} else if (m instanceof DigitalVideoDisc) {
			DigitalVideoDisc dvd = (DigitalVideoDisc) m;
			dvd.play();
		} else {
			System.out.println("Book can't be playable");
		}
	}
	
	public static void placeOrder() {
		System.out.println("Order is successlly created");
		cart.getItemsOrdered().clear();
	}
	//---------------------------------------------------------------------------------------------------------------//
	
	
}