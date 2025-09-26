package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.model.Document;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * The GUI main controller 
 * @author Picot Solal
 * @version 0.1
 * @since 2025
 */

public class Controller implements Initializable{

    @FXML
    public Button addL;

    @FXML
    public Button addP;

    @FXML
    public TextField lAdress;

    @FXML
    public TextField lContent;

    @FXML
    public TextField pContent;
    
    @FXML
    public GridPane pane;
    
    /**
     * Delegate the menu methods to this specific controller
     */
    public MenuController menuController;
    
    /**
     * The working {@link app.model.Document Document}
     */
    public SimpleObjectProperty<Document> document;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		menuController.setController(this);
		
		document = new SimpleObjectProperty<Document>();
	}
    
    

}

