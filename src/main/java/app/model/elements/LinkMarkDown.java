package app.model.elements;

/**
 * A MarkDown link modeling
 * @author Picot Solal
 * @version 0.1
 * @since 2025
 */ 

public class LinkMarkDown extends Link {
	
	/**
	 * Create an MarkDown link with the specified text and url
	 * @param text the link content
	 * @param url the link address
	 */
	public LinkMarkDown(String text, String url) {
		super(text, url);
	}

	@Override
	public String render() {
		
		return null;
	}

}
