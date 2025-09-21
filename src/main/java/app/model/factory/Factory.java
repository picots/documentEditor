package app.model.factory;

import app.model.elements.Element;

/**
 * the abstract factory to build any {@link app.model.Document Document}
 * @author Picot Solal
 * @version 0.1
 * @since 2025
 */

public interface Factory {
	
	/**
	 * Create a new paragraph in the document
	 * @param text the paragraph content
	 * @return the created element, that means the new paragraph
	 */
	public Element createParagraph(String text);
	
	/**
	 * Create a new link in the document
	 * @param text the link content 
	 * @param url the link address
	 * @return the created element, that means the new link
	 */
	public Element createLink(String text, String url);
}
