package app.model.elements;

/**
 * An HTML link modeling
 * @author Picot Solal
 * @version 0.1
 * @since 2025
 */ 

public class LinkHTML extends Link {
	
	/**
	 * Create an HTML link with the specified text and url
	 * @param text the link content
	 * @param url the link address
	 */
	public LinkHTML(String text, String url) {
		super(text, url);
	}

	@Override
	public String render() {
		return String.format("<a href='%s'>%s</a>", url, text);
	}

}
