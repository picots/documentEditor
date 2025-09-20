package app.model.elements;

/**
 * An abstract paragraph modeling
 * @author Picot Solal
 * @version 0.1
 * @since 2025
 */ 

public abstract class Paragraph implements Element {
	/**
	 * the paragraph content
	 */
	protected String text;
	
	/**
	 * Create a paragraph with the specified text
	 * @param text the paragraph content
	 */
	public Paragraph(String text) {
		this.text = text;
	}
}
