package app.model.elements;

/**
 * A MarkDown paragraph modeling
 * @author Picot Solal
 * @version 0.1
 * @since 2025
 */

public class ParagraphMarkDown extends Paragraph {
	
	/**
	 * Create a MarkDown paragraph with specified text
	 * @param text the paragraph content
	 * @throws IllegalArgumentException when the content is empty
	 */
	public ParagraphMarkDown(String text) {
		super(text);
	}

	@Override
	public String render() {
		return String.format("%s\n", text);
	}

}
