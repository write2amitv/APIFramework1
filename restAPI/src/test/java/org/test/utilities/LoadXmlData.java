package org.test.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadXmlData {
	
	public static void readXML(String xmlPath) throws IOException
	{
		File f = new File(xmlPath);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		String s;
		while((s=br.readLine()) != null)
		{
			System.out.println(s);
		}
	}

}
