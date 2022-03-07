package org.test.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.test.testSteps.HTTPMethods;
import org.test.utilities.Json;
import org.test.utilities.LoadPropertiesFile;
import org.testng.annotations.Test;

public class TC5 {
	@Test
	public void testCase5() throws IOException
	{
		Properties pr = LoadPropertiesFile.propertiesFile("../restAPI/URI.properties");
		String bodyData = Json.LoadJSONFile("../restAPI/src/test/java/org/test/payload/BodyData2.json");
		
		HTTPMethods http = new HTTPMethods(pr);
		
		http.deleteMethod("QA_Env_Employees_URI", "-351504705");
		http.getAllMethod("QA_Env_Employees_URI");
		System.out.println("TC 5 Ends");
	}

}
