package day17;

import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GetAllXmlData {
	
	public static void printXML(Element e) {
		NodeList children = e.getChildNodes();
		for(int i = 0; i<children.getLength();i++) {
			Node child = children.item(i);
			System.out.println(child.getNodeName() + ":" + child.getNodeValue());
			if(child.hasChildNodes()) {
				System.out.println("there is another");
				printXML((Element)child);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		dbf.setValidating(true);
		dbf.setIgnoringElementContentWhitespace(true);
		DocumentBuilder db=dbf.newDocumentBuilder();
		
		Document dom=db.parse(new FileInputStream("books.xml"));
		
		Element e=dom.getDocumentElement();
		
		printXML(e);
	}
}
