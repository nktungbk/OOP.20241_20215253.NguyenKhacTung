package hust.soict.dsai.aims.screen;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	private Cart cart;
	@FXML
	private TableView<Media> tblMedia;
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	@FXML
	private TableColumn<Media, String> colMediaCategory;

	@FXML
	private TableColumn<Media, String> colMediaCost;
	@FXML
	private Button btnPlay;
	
	@FXML
	private Button btnRemove;

    @FXML
    private Label lblTotalCost;
	public CartScreenController(Cart cart) {
		super();
		this.cart=cart;
	}
	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media,String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media,String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media,String>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
						if(newValue!=null) {
							updateButtonBar(newValue);
							
						}	
					}
				});
		
		
	}
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
		}
	}
	@FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }
	 @FXML
	 void btnPlayPressed(ActionEvent event) {
		 Media media = tblMedia.getSelectionModel().getSelectedItem();
		 try {
			 ((Playable)media).play();
		 } catch (PlayerException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Media Player");
				alert.setHeaderText("ERROR: Media length is non-positive.");
				alert.setContentText("Media cannot be played.");
				alert.showAndWait();
			}
	}
}
