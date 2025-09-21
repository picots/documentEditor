package app.model;

import app.model.factory.FactoryHTML;
import app.model.parser.ParserHTML;

/**
 * An HTML document modeling
 @author Picot Solal
 * @version 0.1 
 * @since 2025
 */

public class DocumentHTML extends Document {
	
	/**
	 * Initialize the specific factory to build the document in HTML and the specific parser
	 */
	public DocumentHTML() {
		super();
		factory = new FactoryHTML();
		parser = new ParserHTML();
	}
}
