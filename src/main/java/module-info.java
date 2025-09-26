/**
 * This module permits to create or create several types of files
*/
module documentEditor{
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens app to javafx.fxml;
    opens app.controller to javafx.fxml;
    exports app;
}