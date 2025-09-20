package app.model.parser;

import app.model.elements.Link;
import app.model.elements.Paragraph;

public interface Parser {
	/**
	 * Parse the specified string to a {@link Paragraph}
	 * @param str the string to parse
	 * @return the {@link Paragraph} created with the string
	 */
	public Paragraph parseParagraph(String str);
	/**
	 * Parse the specified string to a {@link Link}
	 * @param str the string to parse
	 * @return the {@link Link} created with the string
	 */
	public Link parseLink(String str);
}
