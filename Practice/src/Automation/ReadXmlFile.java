package Automation;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import java.util.Arrays;

public class ReadXmlFile {
        static int i,k; static int count, elem; static int k1;
        static String[][] myStringArray = new String[30][500];


public static void main(String[] args) {
        try {
File file = new File("C:/Users/Tejinder/Desktop/TargetXml.xml"); //**To create a File object
DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); //** To create a documentBuilder
Document doc = dBuilder.parse(file); //**To create a document object that has parsed xml file
//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());


//if (doc.hasChildNodes()) {
printNote(doc.getChildNodes()); //** If there are child nodes, then call the printNote function

//}
for (i = 1; i < count; i++) {
for (k = 0; k < elem; k++) {
System.out.println(i+"/"+k+": "+myStringArray[k][i]);
}
}
//System.out.println(count+"/"+elem+"\n"+3+"/"+1+": "+myStringArray[1][3]);
}

catch (Exception e) {
System.out.println(e.getMessage());
        }
}

    public static void printNote(NodeList nodeList) {
count=0;
for (k = 0; k < nodeList.getLength(); k++) {
        //System.out.println(nodeList.getLength());
Node tempNode = nodeList.item(k);
// ** make sure it's element node.
if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
// **get node name and value
//System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
if (tempNode.hasAttributes()) {
  // get attributes names and values
NamedNodeMap attriMap = tempNode.getAttributes();
//System.out.println(attriMap.getLength());
elem=attriMap.getLength();
for ( i=0 ; i < elem; i++) {

myStringArray[i][count]= tempNode.getAttributes().item(i).getNodeValue();

}

}

}

if (tempNode.getNodeName() == "vars") count--;
count++;

if (tempNode.hasChildNodes()) {

// k again if has child nodes
printNote(tempNode.getChildNodes());

}

//System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]\n");

}
}
}
