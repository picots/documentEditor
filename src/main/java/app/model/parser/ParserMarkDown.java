package app.model.parser;

import app.model.elements.Link;
import app.model.elements.Paragraph;
import app.model.factory.FactoryMarkDown;

/**
 * Parse a {@link app.model.DocumentMarkDown DocumentMarkDown}
 * @author Picot Solal
 * @version 0.1
 * @since 2025
 */
public class ParserMarkDown extends Parser {
	/**
	 * Initialize the {@link app.factory.FactoryMarkDown FactoryMarkDown}
	 */
	public ParserMarkDown() {
		super();
		factory = new FactoryMarkDown();
	}
	
	@Override
	public Paragraph parseParagraph(String str) {
		return (Paragraph) factory.createParagraph(str);
	}

	@Override
	public Link parseLink(String str) {
		if(!str.matches("(?s)[(.*?)]((.*?))"))
			throw new IllegalArgumentException("The specified string isn't an MarkDown link");
		String text = str.substring(str.indexOf("["), str.lastIndexOf("]"));
		String url = str.substring(str.lastIndexOf("("), str.lastIndexOf(")"));
		return (Link) factory.createLink(text, url);
	}
}
