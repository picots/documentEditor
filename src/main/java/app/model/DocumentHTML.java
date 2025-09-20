package app.model;

/**
 * An HTML document modeling
 @author Picot Solal
 * @version 0.1 
 * @since 2025
 */

public class DocumentHTML extends Document {
	
	/**
	 * Initialize the specific factory to build the document in HTML
	 */
	public DocumentHTML() {
		super();
		factory = new FactoryHTML();
	}
}
