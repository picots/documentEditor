package app.model;

import app.model.factory.FactoryMarkDown;
import app.model.parser.ParserMarkDown;

/**
 * A MarkDown document modeling
 * @author Picot Solal
 * @version 0.1
 * @since 2025
 */

public class DocumentMarkDown extends Document {
	
	/**
	 * Initialize the specific factory to build the document in MarkDown and the specific parser
	 */
	public DocumentMarkDown() {
		super();
		factory = new FactoryMarkDown();
		parser = new ParserMarkDown();
	}
}
