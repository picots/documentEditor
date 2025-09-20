package app.model;

/**
 * A basic element of a document
 * @author Picot Solal
 * @version 0.1
 * @since 2025
 */

public interface Element {
	/**
	 * Format the layout of the element
	 * @return the formatting of the element
	 */
	public String render();
}
