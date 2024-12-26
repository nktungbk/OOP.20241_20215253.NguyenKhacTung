package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class PainterController {
	@FXML
    private RadioButton choosePenOption;

    @FXML
    private RadioButton chooseEraseOption;
    
	@FXML
	private Pane drawingAreaPane;
    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if (choosePenOption.isSelected()) {
    		Circle newCircle = new Circle(event.getX(),event.getY(),4,Color.BLACK);
        	drawingAreaPane.getChildren().add(newCircle);
    	} else {
    		Circle newCircle = new Circle(event.getX(),event.getY(),4,Color.WHITE);
        	drawingAreaPane.getChildren().add(newCircle);
    	}
  
    }

}
