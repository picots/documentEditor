package app.model.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import app.model.elements.Element;
import app.model.elements.LinkHTML;
import app.model.elements.LinkMarkDown;
import app.model.elements.ParagraphHTML;
import app.model.elements.ParagraphMarkDown;

class TestParser {
	@Test
	void testParseLineHTML() {
		ParserHTML parser = new ParserHTML();
		LinkedList<Element> list = new LinkedList<>();
		list.add(new ParagraphHTML("test"));
		list.add(new LinkHTML("test", "test"));
		assertEquals(parser.parseLine("<p>test</p>").getFirst(), list.getFirst());
		assertEquals(parser.parseLine("<a href='test'>test</a>").getFirst(), list.getLast());
		assertEquals(parser.parseLine("<p>te<a href='test'>test</a>st</p>"), list);
	}

	@Test
	void testParseLineMarkDown() {
		ParserMarkDown parser = new ParserMarkDown();
		LinkedList<Element> list = new LinkedList<>();
		list.add(new ParagraphMarkDown("test"));
		list.add(new LinkMarkDown("test", "test"));
		parser.parseLine("test");
		assertEquals(parser.parseLine("\n").getFirst(), list.getFirst());
		assertEquals(parser.parseLine("[test](test)").getFirst(), list.getLast());
	}

	@Test
	void testParseParagraphHTML() {
		ParserHTML parser = new ParserHTML();
		assertEquals(parser.parseParagraph("<p>test</p>"), new ParagraphHTML("test"));
		assertEquals(parser.parseParagraph("<p>test\n</p>"), new ParagraphHTML("test\n"));
		assertEquals(parser.parseParagraph("<p class='test'>test</p>").getText(), "test");
		assertEquals(parser.parseParagraph("<p>te<a href='#'>a</a>st</p>").getText(), "test");
		assertThrows(IllegalArgumentException.class, () -> parser.parseParagraph("test"));
	}

	@Test
	void testParseLinkHTML() {
		ParserHTML parser = new ParserHTML();
		assertEquals(parser.parseLink("<a href='test'>test</a>"), new LinkHTML("test", "test"));
		assertThrows(IllegalArgumentException.class, () -> parser.parseLink("<a>test</a>"));
		assertThrows(IllegalArgumentException.class, () -> parser.parseLink("<a href='test'>test\n</a>"));
		assertThrows(IllegalArgumentException.class, () -> parser.parseLink("<a href=''>test</a>"));
		assertThrows(IllegalArgumentException.class, () -> parser.parseLink("<a href='test'></a>"));
		assertThrows(IllegalArgumentException.class, () -> parser.parseLink("test"));
	}

	@Test
	void testParseParagraphMarkDown() {
		ParserMarkDown parser = new ParserMarkDown();
		assertEquals(parser.parseParagraph("test"), new ParagraphMarkDown("test"));
		assertThrows(IllegalArgumentException.class, () -> parser.parseParagraph("["));
		assertThrows(IllegalArgumentException.class, () -> parser.parseParagraph("]"));
	}

	@Test
	void testParseLinkMarkDown() {
		ParserMarkDown parser = new ParserMarkDown();
		assertEquals(parser.parseLink("[test](test)"), new LinkMarkDown("test", "test"));
		assertThrows(IllegalArgumentException.class, () -> parser.parseLink("[](test)"));
		assertThrows(IllegalArgumentException.class, () -> parser.parseLink("[test]()"));
		assertThrows(IllegalArgumentException.class, () -> parser.parseLink("test"));
	}

}
