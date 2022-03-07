package org.test.testScriptsAssignment;

import java.io.IOException;
import java.util.Properties;

import org.test.ResponseValidation.ResponseValidation;
import org.test.testSteps.HTTPMethods;
import org.test.utilities.LoadPropertiesFile;
import org.testng.internal.PropertiesFile;

import com.jayway.restassured.response.Response;

public class TC1_GetAll {
	String uriKey = "Dummy_API_Employees:http";
	
	public void testCase1() throws IOException
	{
		Properties pr = LoadPropertiesFile.propertiesFile("../restAPI/src/test/java/org/test/payload/URI.properties");
		HTTPMethods http = new HTTPMethods(pr);
		
		Response res = http.getAllMethod(uriKey);
		ResponseValidation.statusCodeValidation(200, res);
		ResponseValidation.dataValidation("Successfully! Record has been fetched.", res, ".message");
		
		
		
		
	}

}
