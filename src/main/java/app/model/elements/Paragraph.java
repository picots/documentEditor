package app.model.elements;

import java.util.Objects;

/**
 * An abstract paragraph modeling
 * @author Picot Solal
 * @version 0.1
 * @since 2025
 */ 

public abstract class Paragraph implements Element {
	/**
	 * the paragraph content
	 */
	protected String text;
	
	/**
	 * Create a paragraph with the specified text
	 * @param text the paragraph content
	 * @throws IllegalArgumentException when the content is empty
	 */
	public Paragraph(String text) {
		if(text.equals(""))
			throw new IllegalArgumentException("the paragraph content can't be empty");
		this.text = text;
	}
	
	/**
	 * Get the paragraph content 
	 * @return the paragraph content
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Change the  paragraph content
	 * @param text the new content
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Paragraph))
			return false;
		Paragraph other = (Paragraph) obj;
		return Objects.equals(text, other.text);
	}
}
