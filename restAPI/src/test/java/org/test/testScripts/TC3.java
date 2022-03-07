package org.test.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.test.testSteps.HTTPMethods;
import org.test.utilities.JsonParse;
import org.test.utilities.LoadPropertiesFile;
import org.testng.annotations.Test;

public class TC3 {
		
	@Test
	public void testCase3() throws IOException
	{
		Properties pr = LoadPropertiesFile.propertiesFile("../restAPI/URI.properties");
		HTTPMethods http = new HTTPMethods(pr);
		System.out.println("***********ALL RECORDS************");
		http.getAllMethod("QA_Env_Employees_URI");
		System.out.println("***********ALL IDs************");
		http.getAllKeys("QA_Env_Employees_URI", "id");
	}

}
