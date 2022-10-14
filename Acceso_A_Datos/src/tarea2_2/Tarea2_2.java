package tarea2_2;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class Tarea2_2 {
	private static final File xml = new File("C:\\Users\\asosa\\Documents\\Acceso_A_Datos\\src\\tarea2_2\\compras.xml");
	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		// TODO Auto-generated method stub
		var domdocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xml);
		System.out.println("uri del xml: " + domdocument.getDocumentURI());
		var cabecera = domdocument.getNodeType();
		System.out.println("Nodo documento? " + (cabecera==Node.DOCUMENT_NODE));
		System.out.println("Versión: " + domdocument.getXmlVersion());
		System.out.println("Encoding: " + domdocument.getXmlEncoding());
		System.out.println("Tamaño de lista de nodos: " + domdocument.getChildNodes().getLength());
		var compras = domdocument.getElementsByTagName("Compras");
		for (int i = 0; i < compras.getLength(); i++) {
			var compra = compras.item(i);
			System.out.println(compra.getTextContent());
			System.out.println("Padre: " + compra.getParentNode().getNodeName());
			System.out.println("Primer nodo válido: " + compra.getFirstChild().getNextSibling().getTextContent());
			System.out.println("Último nodo válido: " + compra.getLastChild().getPreviousSibling().getTextContent());
			var childNodes = compra.getChildNodes();
			System.out.println(childNodes.item(0).getParentNode().getAttributes().getNamedItem("cp").getNodeValue());
			
		}
	}

}
