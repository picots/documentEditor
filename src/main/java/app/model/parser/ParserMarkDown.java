package app.model.parser;

import app.model.elements.Link;
import app.model.elements.Paragraph;
import app.model.factory.FactoryMarkDown;

public class ParserMarkDown implements Parser {
	/**
	 * the factory to create the elements in MarkDown
	 */
	FactoryMarkDown factory;
	
	/**
	 * Initialize the factory
	 */
	public ParserMarkDown() {
		factory = new FactoryMarkDown();
	}
	
	@Override
	public Paragraph parseParagraph(String str) {
		return (Paragraph) factory.createParagraph(str);
	}

	@Override
	public Link parseLink(String str) {
		if(!str.matches("(?s)[(.*?)]((.*?))"))
			throw new IllegalArgumentException("The specified string is not an MarkDown link");
		String text = str.substring(str.indexOf("["), str.lastIndexOf("]"));
		String url = str.substring(str.lastIndexOf("("), str.lastIndexOf(")"));
		return (Link) factory.createLink(text, url);
	}

}
