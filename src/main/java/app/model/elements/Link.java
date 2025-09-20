package app.model.elements;

/**
 * An abstract link modeling
 * @author Picot Solal
 * @version 0.1
 * @since 2025
 */ 

public abstract class Link implements Element {
	/**
	 * the link content
	 */
	protected String text;
	/**
	 * the link address
	 */
	protected String url;
	
	/**
	 * Create a link with the specified text and url
	 * @param text the link content
	 * @param url the link address
	 */
	public Link(String text, String url) {
		this.text = text;
		this.url = url;
	}
}
