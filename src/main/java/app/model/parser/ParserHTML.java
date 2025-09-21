package app.model.parser;

import java.util.LinkedList;
import java.util.List;

import app.model.elements.Element;
import app.model.elements.Link;
import app.model.elements.LinkHTML;
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
	 * In case we have a link in a paragraph, we store a link
	 */
	LinkHTML l;
	
	/**
	 * Initialize the {@link app.model.factory.FactoryHTML FactoryHTML}
	 */
	public ParserHTML() {
		super();
		l = null; //there's no link for the moment
		factory = new FactoryHTML();
	}

	@Override
	public Paragraph parseParagraph(String str) {
		String text;
		if (!(str.matches("(?s)<p\\b[^>]*>(.+)</p>")))
			throw new IllegalArgumentException("The specified string isn't an HTML paragraph");
		if(str.matches("(?s)<p\\b[^>]*>.*?<a\\b[^>]*>.*?</a>.*?</p>")) // The paragraph contains a link
			text = str.substring(str.indexOf(">") + 1, str.indexOf("<a")) + str.substring(str.indexOf("a>") + 2, str.lastIndexOf("<"));
		else
			text = str.substring(str.indexOf(">") + 1, str.lastIndexOf("<"));
		return (Paragraph) factory.createParagraph(text);
	}

	@Override
	public Link parseLink(String str) {
		if (!(str.matches("<a\\b[^>]*\\shref='([^']+)'[^>]*>(.+)</a>")))
			throw new IllegalArgumentException("The specified string isn't an HTML link");
		String text = str.substring(str.indexOf(">") + 1, str.lastIndexOf("<"));
		String url = str.substring(str.indexOf("href='") + 6, str.lastIndexOf("'"));
		return (Link) factory.createLink(text, url);
	}
	
	/**
	 * {@inheritDoc}
	 * <br/>If a link is interlocked in a paragraph, the're will be a {@link app.model.elements.Paragraph Paragraph} 
	 * <br/>and a {@link app.model.elements.Link Link} separated
	 * 
	 */
	@Override
	public List<Element> parseLine(String line) {
		LinkedList<Element> elements = new LinkedList<>();
		try {
			// The line contains a paragraph with a link
			if (line.matches("<p\\b[^>]*>.*?<a\\b[^>]*>.*?</a>.*?</p>")) {
				p = parseParagraph(line);
				l = (LinkHTML) parseLink(line.substring(line.indexOf("<a"), line.indexOf("a>")+2));
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
			else if (line.matches("(?s)<a\\b[^>]*>(.*?)</a>"))
				elements.add(parseLink(line));
			
			// The line doesn't match any criteria
			else
				throw new IllegalArgumentException("This line isn't written in HTML");
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return elements;
	}
}
