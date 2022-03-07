package org.test.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.test.testSteps.HTTPMethods;
import org.test.utilities.Json;
import org.test.utilities.JsonVariable;
import org.test.utilities.LoadPropertiesFile;
import org.testng.annotations.Test;

public class TC4 
{
	@Test
	public void testCase4() throws IOException
	{
	Properties pr = LoadPropertiesFile.propertiesFile("../restAPI/URI.properties");
	String bodyData = Json.LoadJSONFile("../restAPI/src/test/java/org/test/payload/BodyData2.json");
	
	bodyData = JsonVariable.JsonVariableReplacement(bodyData, "id", TC1.responseidValue);
	HTTPMethods http = new HTTPMethods(pr);
	http.putMethod("QA_Env_Employees_URI", TC1.responseidValue, bodyData);
	http.getAllMethod("QA_Env_Employees_URI");
	System.out.println("TC 4 Ends");
	}
	
}
