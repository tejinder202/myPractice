package Automation;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFile2 {

  public static void main(String[] args) {

    try {

	File file = new File("C:/Users/Tejinder/Desktop/TargetXml.xml");

	DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

	Document doc = dBuilder.parse(file);

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

	if (doc.hasChildNodes()) {

		printNote(doc.getChildNodes());

	}

    } catch (Exception e) {
	System.out.println(e.getMessage());
    }

  }

  private static void printNote(NodeList nodeList) {
	  System.out.println(nodeList.getLength());
    for (int count = 0; count < nodeList.getLength(); count++) {
    	System.out.println(count);
	Node tempNode = nodeList.item(count);

	// make sure it's element node.
	if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

		// get node name and value
		System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
		System.out.println("Node Value =" + tempNode.getTextContent());

		if (tempNode.hasAttributes()) {

			// get attributes names and values
			NamedNodeMap attriMap = tempNode.getAttributes();
			System.out.println(attriMap.getLength());
			for (int i = 0; i < attriMap.getLength(); i++) {

				Node attri = attriMap.item(i);
				System.out.println("attr name : " + attri.getNodeName());
				System.out.println("attr value : " + attri.getNodeValue());
				System.out.println(tempNode.getAttributes().item(i).getNodeValue());
			}

		}

		if (tempNode.hasChildNodes()) {

			// loop again if has child nodes
			printNote(tempNode.getChildNodes());

		}

		System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");

	}

    }

  }

}