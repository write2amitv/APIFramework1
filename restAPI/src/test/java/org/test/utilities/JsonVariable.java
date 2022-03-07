package org.test.utilities;

import java.util.regex.Pattern;

public class JsonVariable {
	
	static public String JsonVariableReplacement(String data, String keyname, String keyValue)
	{
		/*System.out.println("keyname is "+keyname);
		System.out.println("keyvalue passed is " +keyValue);*/
		data = data.replaceAll(Pattern.quote("{{"+keyname+"}}"),keyValue);
		System.out.println("Data after replacement " +data);
		return data;
	}

}
