package app.model;

/**
 * An HTML paragraph modeling
 * @author Picot Solal
 * @version 0.1
 * @since 2025
 */

public class ParagraphHTML extends Paragraph {
	
	/**
	 * Create an HTML paragraph with specified text
	 * @param text the paragraph content
	 */
	public ParagraphHTML(String text) {
		super(text);
	}

	@Override
	public String render() {
		return String.format("<p>%s</p>", text);
	}
}
