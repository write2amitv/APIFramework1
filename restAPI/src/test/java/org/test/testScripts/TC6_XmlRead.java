package org.test.testScripts;

import java.io.IOException;

import org.test.utilities.LoadXmlData;

public class TC6_XmlRead {
	//public void testcase6() throws IOException
	public static void main(String[] args) throws IOException 
	{
		LoadXmlData.readXML("../restAPI/src/test/java/org/test/payload/xmlData.xml");
	}

}
