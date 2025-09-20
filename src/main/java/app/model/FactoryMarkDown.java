package app.model;

/**
 * the factory to build MarkDown document 
 * @author Picot Solal
 * @version 0.1
 * @since 2025
 */

public class FactoryMarkDown implements Factory {

	@Override
	public Element createParagraph(String text) {
		return new ParagraphMarkDown(text);
	}

	@Override
	public Element createLink(String text, String url) {
		return new LinkMarkDown(text, url);
	}

}
