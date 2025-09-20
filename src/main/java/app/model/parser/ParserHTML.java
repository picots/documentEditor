package app.model.parser;

import app.model.elements.Link;
import app.model.elements.Paragraph;
import app.model.factory.FactoryHTML;

public class ParserHTML implements Parser {
	/**
	 * the factory to create the elements in HTML
	 */
	FactoryHTML factory;
	
	/**
	 * Initialize the factory
	 */
	public ParserHTML() {
		factory = new FactoryHTML();
	}
	
	@Override
	public Paragraph parseParagraph(String str) {
		if(!(str.matches("(?s)<p\\b[^>]*>(.*?)</p>")))
			throw new IllegalArgumentException("The specified string is not an HTML paragraph");
		String text = str.substring(str.indexOf(">"), str.lastIndexOf("<"));
		return (Paragraph) factory.createParagraph(text);
	}

	@Override
	public Link parseLink(String str) {
		if(!(str.matches("(?s)<a\b[^>]*>(.*?)</a>")))
			throw new IllegalArgumentException("The specified string is not an HTML link");
		String text = str.substring(str.indexOf(">"), str.lastIndexOf("<"));
		String url = str.substring(str.indexOf("href"), str.lastIndexOf("'"));
		return (Link) factory.createLink(text, url);
	}

}
