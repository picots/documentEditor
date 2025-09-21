package app.model.elements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestElement {

	@Test
	void testLinkMarkDown() {
		LinkMarkDown l = new LinkMarkDown("test", "test");
		assertEquals(l.getText(), "test");
		assertEquals(l.getUrl(), "test");
		assertThrows(IllegalArgumentException.class, ()->new LinkMarkDown("", "test"));
		assertThrows(IllegalArgumentException.class, ()->new LinkMarkDown("test", ""));
	}
	
	@Test
	void testLinkHTML() {
		LinkHTML l = new LinkHTML("test", "test");
		assertEquals(l.getText(), "test");
		assertEquals(l.getUrl(), "test");
		assertThrows(IllegalArgumentException.class, ()->new LinkHTML("", "test"));
		assertThrows(IllegalArgumentException.class, ()->new LinkHTML("test", ""));
	}

	@Test
	void testParagraphMarkDown() {
		ParagraphMarkDown p = new ParagraphMarkDown("test");
		assertEquals(p.getText(), "test");
		assertThrows(IllegalArgumentException.class, ()->new ParagraphMarkDown(""));
	}
	
	@Test
	void testParagraphHTML() {
		ParagraphHTML p = new ParagraphHTML("test");
		assertEquals(p.getText(), "test");
		assertThrows(IllegalArgumentException.class, ()->new ParagraphHTML(""));
	}
}
