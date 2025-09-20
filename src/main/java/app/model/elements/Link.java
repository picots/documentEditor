package app.model.elements;

import java.util.Objects;

/**
 * An abstract link modeling
 * @author Picot Solal
 * @version 0.1
 * @since 2025
 */ 

public abstract class Link implements Element {
	/**
	 * the link content
	 */
	protected String text;
	/**
	 * the link address
	 */
	protected String url;
	
	/**
	 * Create a link with the specified text and url
	 * @param text the link content
	 * @param url the link address
	 */
	public Link(String text, String url) {
		this.text = text;
		this.url = url;
	}
	
	/**
	 * Get the link content
	 * @return the link content
	 */
	public String getText() {
		return text;
	}
	/**
	 * Change the link content
	 * @param text the new content
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Get the link address
	 * @return the link address
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Change the link address
	 * @param url the new address
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Link))
			return false;
		Link other = (Link) obj;
		return Objects.equals(text, other.text) && Objects.equals(url, other.url);
	}
}
