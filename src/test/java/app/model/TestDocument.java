package app.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import org.junit.jupiter.api.Test;

import app.model.elements.LinkHTML;
import app.model.elements.LinkMarkDown;
import app.model.elements.ParagraphHTML;
import app.model.elements.ParagraphMarkDown;

class TestDocument {

	@Test
	void testAddParagraphHTML() {
		DocumentHTML d = new DocumentHTML();
		d.addParagraph("test");
		assertTrue(d.content.contains(new ParagraphHTML("test")));
	}
	
	@Test
	void testAddParagraphMarkDown() {
		DocumentMarkDown d = new DocumentMarkDown();
		d.addParagraph("test");
		assertTrue(d.content.contains(new ParagraphMarkDown("test")));
	}
	
	@Test
	void testAddLinkHTML() {
		DocumentHTML d = new DocumentHTML();
		d.addLink("test", "test");
		assertTrue(d.content.contains(new LinkHTML("test", "test")));
	}

	@Test
	void testAddLinkMarkDown() {
		DocumentMarkDown d = new DocumentMarkDown();
		d.addLink("test", "test");
		assertTrue(d.content.contains(new LinkMarkDown("test", "test")));
	}

	@Test
	void testWriteHTML() {
		DocumentHTML d = new DocumentHTML();
		d.addParagraph("test");
		d.addLink("test", "test");
		File f = new File("src/test/resources/app/model/testWrite.html");
		d.write(f);
	}
	
	@Test
	void testWriteMarkDown() {
		DocumentMarkDown d = new DocumentMarkDown();
		d.addParagraph("test");
		d.addLink("test", "test");
		File f = new File("src/test/resources/app/model/testWrite");
		d.write(f);
	}

	@Test
	void testReadHTML() {
		DocumentHTML d = new DocumentHTML();
		File f = new File("src/test/resources/app/model/testRead.html");
		d.read(f);
		assertTrue(d.content.contains(new ParagraphHTML("test")));
		assertTrue(d.content.contains(new LinkHTML("test", "test")));
	}
	
	@Test
	void testReadMarkDown() {
		DocumentMarkDown d = new DocumentMarkDown();
		File f = new File("src/test/resources/app/model/testRead");
		d.read(f);
		assertTrue(d.content.contains(new ParagraphMarkDown("test")));
		assertTrue(d.content.contains(new LinkMarkDown("test", "test")));
	}

}
