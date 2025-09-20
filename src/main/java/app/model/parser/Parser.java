package app.model.parser;

import java.util.LinkedList;
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
	 * In case, a link is interlocked in a paragraph, we store the current paragraph
	 */
	Paragraph p = null;
	
	/**
	 * For the same reason previously said, we also store the current link
	 */
	Link l = null;
	
	/**
	 * Create an abstract parser for any type of {@link app.model.Document Document}
	 */
	public Parser() {
		p = null; //if the paragraph exists, he's not null
		l = null; //same for a link
	}
	
	/**
	 * Parse the specified line with the specific document format
	 * <br/>If a link is interlocked in a paragraph, the're will be a {@link app.elements.Paragraph Paragraph} 
	 * and a {@link app.elements.Link Link} separated in the 
	 * @param line the line to parse
	 * @return a list of elements we have parsed in the line 
	 * @throws {@link IllegalArgumentException} when the line isn't written in the correct language
	 */
	public List<Element> parseLine(String line) {
		LinkedList<Element> elements = new LinkedList<>();
		try {
			// The line contains a paragraph with a link
			if (line.matches("<p\\b[^>]*>.*?<a\\b[^>]*>.*?</a>.*?</p>")) {
				p = parseParagraph(line);
				l = parseLink(line.substring(line.indexOf("<a"), line.indexOf("a>") + 1));
				elements.add(p);
				elements.add(l);
			}
			
			// The line contains a paragraph without any link
			else if (line.matches("(?s)<p\\b[^>]*>(.*?)</p>"))
				elements.add(parseParagraph(line));
			
			//The line starts with <p> but doesn't end with </p> and there's no current paragraph
			else if (line.startsWith("<p>") && p == null)
				p = (Paragraph) factory.createParagraph(line.substring(line.indexOf(">")));
			
			//The line ends with </p>  and there's a current paragraph
			else if (line.endsWith("</p>") && p != null) {
				p.setText(p.getText() + line.substring(0, line.indexOf("<")));
				elements.add(p);
			} 
			
			//there's a current paragraph without any tags
			else if (p != null)
				p.setText(p.getText() + line);

			// The line contains a link outside a paragraph
			else if (line.matches("(?s)<a\b[^>]*>(.*?)</a>"))
				elements.add(parseLink(line));
			
			// The line doesn't match any criteria
			else
				throw new IllegalArgumentException("This line isn't written in HTML");
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return elements;
	}
	
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
