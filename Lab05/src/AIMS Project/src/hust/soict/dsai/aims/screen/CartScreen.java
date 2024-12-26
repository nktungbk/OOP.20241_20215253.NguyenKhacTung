package hust.soict.dsai.aims.screen;

import java.io.IOException;
import java.util.ArrayList;

import javax.naming.LimitExceededException;
import javax.swing.*;

import javafx.application.Platform;
import javafx.embed.swing.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super();

        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        
        this.setTitle("Cart");
        this.setSize(1024, 768);
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) throws LimitExceededException {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Movie 1", "Category 1",15, 9.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Movie 2", "Category 2",12, 7.99f);

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        int bookId = 3;
        String bookTitle = "Book 1";
        String bookCategory = "Category 3";
        float bookCost = 12.99f;
        ArrayList<String> bookAuthors = new ArrayList<>();
        bookAuthors.add("Author 1");
        bookAuthors.add("Author 2");
        Book book = new Book(bookTitle, bookCost);
        
        cart.addMedia(book);

        new CartScreen(cart);
    }
}
