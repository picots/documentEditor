package app.model.parser;

import java.util.LinkedList;
import java.util.List;

import app.model.elements.Element;
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
		if(str.matches("\\[(.?)*") || str.matches("(.?)*\\]"))
			throw new IllegalArgumentException("The specified string isn't an MarkDown paragraph");
		return (Paragraph) factory.createParagraph(str);
	}

	@Override
	public Link parseLink(String str) {
		if(!str.matches("\\[(.+)\\]\\((.+)\\)"))
			throw new IllegalArgumentException("The specified string isn't an MarkDown link");
		String text = str.substring(str.indexOf("[")+1, str.lastIndexOf("]"));
		String url = str.substring(str.lastIndexOf("(")+1, str.lastIndexOf(")"));
		return (Link) factory.createLink(text, url);
	}

	@Override
	public List<Element> parseLine(String line) {
		LinkedList<Element> elements = new LinkedList<>();
		try {
			if(line.matches("\\[(.+)\\]\\((.+)\\)")) //a link
				elements.add(parseLink(line));
			else if(line.equals("\n")) { //we change paragraph
				elements.add(p);
				p = null;
			}
			else if(p == null) //new paragraph
				p = parseParagraph(line);
			else if(p != null) //existing paragraph
				p.setText(p.getText() + line);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return elements;
	}
}
