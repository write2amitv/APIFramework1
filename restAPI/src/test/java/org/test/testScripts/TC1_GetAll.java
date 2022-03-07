
package org.test.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.test.ResponseValidation.ResponseValidation;
import org.test.testSteps.HTTPMethods;
import org.test.utilities.LoadPropertiesFile;
import org.testng.annotations.Test;
import org.testng.internal.PropertiesFile;

import com.jayway.restassured.response.Response;

public class TC1_GetAll {
	//String uriKey = "Dummy_API_Employees";
	@Test
	public void testCase1() throws IOException
	{
		Properties pr = LoadPropertiesFile.propertiesFile("../restAPI/URI.properties");
		HTTPMethods http = new HTTPMethods(pr);
		
		Response res = http.getAllMethod("Dummy_API_Employees");
		ResponseValidation.statusCodeValidation(200, res);
		ResponseValidation.dataValidation("Successfully! Record has been fetched.", res, ".message");
		
		
		
		
	}

}
