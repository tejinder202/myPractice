package src.Automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.util.regex.*;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Document;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.thoughtworks.selenium.Selenium;

import java.util.Arrays;
public class FirstTestCase {
	static int i,k; static int count, elem; static int k1;
    static String[][] myStringArray = new String[2][100];
/*	public static void main(String[] args) throws Exception {
		testFb();
			}*/
	
  private static WebDriver driver;
  private static String baseUrl;
  public Selenium selenium;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

 
  @Test
  public static void testFb() throws Exception {
	// ERROR: Caught exception [ERROR: Unsupported command [setSpeed | 1000 | ]]
	// ERROR: Caught exception [unknown command [forXml]]
	//driver.findElement(By.xpath("//label/input")).click();    
//			driver = new FirefoxDriver();
//			baseUrl = "https://www.facebook.com/";
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    try {

	    	File file = new File("C:/Users/Tejinder/Desktop/TargetXml.xml"); //**To create a File object
	    	DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); //** To create a documentBuilder
	    	Document doc = dBuilder.parse(file); //**To create a document object that has parsed xml file
	    	//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());


	    	if (doc.hasChildNodes()) {
	    	printNote(doc.getChildNodes()); //** If there are child nodes, then call the printNote function

	    	}
//	    	for (i = 1; i < count; i++) {
//	    	for (k = 0; k < elem; k++) {
//	    	System.out.println(i+"/"+k+": "+myStringArray[k][i]);
//	    	}
//	    	}
	    	//System.out.println(count+"/"+elem+"\n"+2+"/"+2+": "+myStringArray[2][2]);
	    		int j = 0;
	       		driver = new FirefoxDriver();
	       		//driver = new InternetExplorerDriver();
	       		for (j = 1; j < count; j++) {
	    		driver.get("https://www.facebook.com/");
				baseUrl = "https://www.facebook.com/";
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    	driver.findElement(By.id("email")).clear();
		    	driver.findElement(By.id("email")).sendKeys(myStringArray[0][j]);
		    	driver.findElement(By.id("pass")).clear();
		    	driver.findElement(By.id("pass")).sendKeys(myStringArray[1][j]);
		    	//driver.findElement(By.xpath("//label/input")).click();
		    //System.out.println(tempNode.getAttributes().item(i).getNodeValue());
	    	}

	        } catch (Exception e) {
	    	System.out.println(e.getMessage());
	        }
 }

	
  @AfterMethod
public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      Assert.fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
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
	  elem = attriMap.getLength();
	  for ( i=0 ; i < elem; i++) {

	  myStringArray[i][count]= tempNode.getAttributes().item(i).getNodeValue();

	  }

	  }

	  }

	  if (tempNode.getNodeName() == "vars") count--;
	  count++;

	  if (tempNode.hasChildNodes()) {

	  // loop again if has child nodes
	  printNote(tempNode.getChildNodes());

	  }

	  //System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]\n");

	          }

	  }

	          }
