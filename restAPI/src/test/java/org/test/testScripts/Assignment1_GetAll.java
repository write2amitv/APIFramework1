package org.test.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.test.ResponseValidation.ResponseValidation;
import org.test.testSteps.HTTPMethods;
import org.test.utilities.Json;
import org.test.utilities.JsonParse;
import org.test.utilities.JsonVariable;
import org.test.utilities.LoadPropertiesFile;
import org.testng.annotations.Test;
import org.testng.internal.PropertiesFile;

import com.jayway.restassured.response.Response;

public class Assignment1_GetAll {
		
//	@Test
	public void testcase1() throws IOException
	{
		System.out.println("**********TestCase 1 - - get all Data*******************");
	Properties pr = LoadPropertiesFile.propertiesFile("../restAPI/URI.properties");
	HTTPMethods http = new HTTPMethods(pr);
	
	Response res = http.getAllMethod("Dummy_API_Users");

	ResponseValidation.statusCodeValidation(200, res);
	ResponseValidation.dataValidation("To keep ReqRes free, contributions towards server costs are appreciated!", res, "support.text");
	
	}
	
//	@Test
	public void testcase2() throws IOException
	{
		System.out.println("**********TestCase 2 - - get*******************");
		Properties pr = LoadPropertiesFile.propertiesFile("../restAPI/URI.properties");
		HTTPMethods http = new HTTPMethods(pr);
		
		Response res = http.getMethod("Dummy_API_One_User", "2");
		
		ResponseValidation.statusCodeValidation(200, res);
		ResponseValidation.dataValidation("Janet", res, "data.first_name");
	}
	
	static String responseValueID, savedValue;
	static String uriKey = "Dummy_API_Users";
//	@Test
	public void testCase3Post() throws IOException
	{
		System.out.println("**********TestCase 3 - - post Data*******************");
		String bodyData = Json.LoadJSONFile("../restAPI/src/test/java/org/test/payload/PostBodyData3.json");
		
		Properties pr = LoadPropertiesFile.propertiesFile("../restAPI/URI.properties");
		HTTPMethods http = new HTTPMethods(pr);
		
		Response res = http.postMethod(bodyData, uriKey);
		responseValueID = JsonParse.Parse(res.asString(), "id");
		System.out.println("ID is :: " +responseValueID);
		
		ResponseValidation.statusCodeValidation(201, res);
		savedValue = responseValueID;
		ResponseValidation.dataValidation("Janet", res, "name");
	}
	
//	@Test
	public void testCase4getByID()	throws IOException
	{
		System.out.println("**********TestCase 4 - - Get Data By ID*******************");
	
		Properties pr = LoadPropertiesFile.propertiesFile("../restAPI/URI.properties");
		HTTPMethods http = new HTTPMethods(pr);
		
		Response res = http.getMethod("Dummy_API_Users", savedValue);
		System.out.println("Response Data is " +res.asString());
		ResponseValidation.statusCodeValidation(200, res);
	}
	
	
	@Test
	public void testCase5put() throws IOException
	{
		System.out.println("**********TestCase 5 - - Put Data*******************");
	
		String bodyData = Json.LoadJSONFile("../restAPI/src/test/java/org/test/payload/BodyData4.json");
		Properties pr = LoadPropertiesFile.propertiesFile("../restAPI/URI.properties");
		HTTPMethods http = new HTTPMethods(pr);
		
		Response res = http.putMethod("Dummy_API_Users", "", bodyData);

		res = http.getAllMethod("Dummy_API_Users");
		System.out.println(res.asString());
	
	}
	
	
}
