package app.controller;

import app.model.DocumentHTML;
import app.model.DocumentMarkDown;

/**
 * Controls the app menu
 * @author Picot Solal
 * @version 0.1
 * @since 2025
 */

public class MenuController {
	
	/**
	 * The parent controller
	 */
	public Controller controller;
	
	/**
	 * Set the parent controller
	 * @param c the parent controller
	 */
	public void setController(Controller c) {
		controller = c;
	}
	
	public void onNewHTML() {
		controller.document.set(new DocumentHTML());
		controller.pane.setVisible(true);
	}
	
	public void onNewMarkDown() {
		controller.document.set(new DocumentMarkDown());
		controller.pane.setVisible(true);
	}
}
