package app.model.factory;

import app.model.elements.Element;
import app.model.elements.LinkHTML;
import app.model.elements.ParagraphHTML;

/**
 * the factory to build HTML document 
 * @author Picot Solal
 * @version 0.1
 * @since 2025
 */

public class FactoryHTML implements Factory {
	
	@Override
	public Element createParagraph(String text){ 
		return new ParagraphHTML(text);
	}

	@Override
	public Element createLink(String text, String url) {
		return new LinkHTML(text, url);
	}

}
