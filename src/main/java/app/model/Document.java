package app.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

import app.model.elements.Element;
import app.model.factory.Factory;
import app.model.parser.Parser;

/**
 * An abstract document modeling
 * @author Picot Solal
 * @version 0.1
 * @since 2025
 */

public abstract class Document {
	/**
	 * A list of elements like paragraphs or links
	 */
	protected List<Element> content;
	/**
	 * Any specific document as a specific factory so the abstract document as an abstract factory
	 */
	protected Factory factory;
	
	/**
	 * Any specific document as a specific parser 
	 */
	protected Parser parser;
	
	/**
	 * Create an empty document
	 */
	public Document() {
		content = new LinkedList<Element>();
	}
	
	public void addParagraph(String text) {
		content.add(factory.createParagraph(text));
	}
	
	public void addLink(String text, String url) {
		content.add(factory.createLink(text, url));
	}
	
	/**
	 * Write the document in the specified file
	 * @param f the file where we write
	 */
	public void write(File f) {
		Path p = f.toPath();
		try(BufferedWriter bw = Files.newBufferedWriter(p)) {
			for(Element elt : content)
				bw.write(elt.render()+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Read the specified file and copy the content in the document
	 * @param f the file which we read
	 */
	public void read(File f) {
		Path p = f.toPath();
		try(BufferedReader br = Files.newBufferedReader(p)) {
			String line;
			while((line = br.readLine()) != null)
				content.addAll(parser.parseLine(line));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
