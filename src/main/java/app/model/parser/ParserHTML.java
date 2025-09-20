package app.model.parser;

import app.model.elements.Link;
import app.model.elements.Paragraph;
import app.model.factory.FactoryHTML;

/**
 * Parse a {@link app.model.DocumentHTML DocumentHTML}
 * 
 * @author Picot Solal
 * @version 0.1
 * @since 2025
 */
public class ParserHTML extends Parser {
	/**
	 * Initialize the {@link app.factory.FactoryHTML FactoryHTML}
	 */
	public ParserHTML() {
		super();
		factory = new FactoryHTML();
	}

	@Override
	public Paragraph parseParagraph(String str) {
		String text;
		if (!(str.matches("(?s)<p\\b[^>]*>(.*?)</p>")))
			throw new IllegalArgumentException("The specified string isn't an HTML paragraph");
		if(str.matches("<p\\b[^>]*>.*?<a\\b[^>]*>.*?</a>.*?</p>")) // The paragraph contains a link
			text = str.substring(str.indexOf(">") + 1, str.indexOf("<a") - 1) + str.substring(str.indexOf("a>") + 2);
		else
			text = str.substring(str.indexOf(">") + 1, str.lastIndexOf("<") - 1);
		return (Paragraph) factory.createParagraph(text);
	}

	@Override
	public Link parseLink(String str) {
		if (!(str.matches("(?s)<a\b[^>]*>(.*?)</a>")))
			throw new IllegalArgumentException("The specified string isn't an HTML link");
		String text = str.substring(str.indexOf(">") + 1, str.lastIndexOf("<") - 1);
		String url = str.substring(str.indexOf("=") + 1, str.lastIndexOf("'") - 1);
		return (Link) factory.createLink(text, url);
	}
}
