package org.test.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.test.ResponseValidation.ResponseValidation;
import org.test.testSteps.HTTPMethods;
import org.test.utilities.LoadPropertiesFile;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class TC2 {
	
	@Test
	public void testcase2() throws IOException
	{
		System.out.println("*******************Test case 2************************");
		Properties pr=LoadPropertiesFile.propertiesFile("../restAPI/URI.properties");
		HTTPMethods http = new HTTPMethods(pr);
		Response res = http.getMethod("QA_Env_Employees_URI", TC1.responseidValue);
		
		System.out.println("Response code " +res.statusCode());
		System.out.println("REsponse Data " +res.asString());
		
		ResponseValidation.dataValidation("Amit", res, "fistname");
		
		System.out.println("*******************Test case 2 Ends************************"); 
	}

}
