package htmlparser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;


public class Main {
	
	public static ArrayList<String> words = new ArrayList<String>(); 

	public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException, SAXException {
		// TODO Auto-generated method stub
		
		ArrayList<String> words = WordParser.getWords();
		File file = new File("C:\\ZalupaTest\\Zalupa32.xml");
		
		XMLUserHandler.create(words, file);
		
//		file = new File("C:\\ZalupaTest\\Zalupa32parse.xml");
		
//		XMLHandler handler;
//		SAXParserFactory factory = SAXParserFactory.newInstance();
//		SAXParser parser = factory.newSAXParser();
//	
//		handler = new XMLHandler();
//		
//		parser.parse(file, handler);
//		
//		System.out.println(words.size());

		
		
//		FileOutputStream outputStream = new FileOutputStream("C:\\ZalupaTest\\Zalupa32.txt");
//	    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//	    objectOutputStream.writeObject(words);
//	    objectOutputStream.close();
	    
	    
	}
}
