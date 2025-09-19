package app;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Launch the GUI 
 * @author Picot Solal
 * @version 0.1
 * @since 2025
 */
public class App extends Application {
	
	public static Scene scene;
	
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("app"), 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("fxml/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
