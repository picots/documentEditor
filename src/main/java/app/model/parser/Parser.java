package app.model.parser;

import java.util.List;

import app.model.elements.Element;
import app.model.elements.Link;
import app.model.elements.Paragraph;
import app.model.factory.Factory;
/**
 * Parse any kind of {@link app.model.Document Document}
 * @author Picot Solal
 * @version 0.1
 * @since 2025
 */
public abstract class Parser {
	/**
	 * the factory to create the elements
	 */
	Factory factory;
	
	/**
	 * In case we have a paragraph of several lines, we store the current paragraph
	 */
	Paragraph p = null;
	
	/**
	 * Create an abstract parser for any type of {@link app.model.Document Document}
	 */
	public Parser() {
		p = null; //there's no paragraph for the moment
	}
	
	/**
	 * Parse the specified line with the specific document format
	 * @param line the line to parse
	 * @return a list of elements we have parsed in the line 
	 * @throws {@link IllegalArgumentException} when the line isn't written in the correct language
	 */
	public abstract List<Element> parseLine(String line);
	
	/**
	 * Parse the specified string to a {@link Paragraph}
	 * @param str the string to parse
	 * @return the {@link Paragraph} created with the string
	 */
	public abstract Paragraph parseParagraph(String str);
	
	/**
	 * Parse the specified string to a {@link Link}
	 * @param str the string to parse
	 * @return the {@link Link} created with the string
	 */
	public abstract Link parseLink(String str);
}
