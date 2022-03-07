package org.test.ResponseValidation;

import org.test.utilities.JsonParse;
import org.testng.Assert;

import com.jayway.restassured.response.Response;

public class ResponseValidation {
	
	public static void statusCodeValidation(int responseCode, Response res)
	{
		//System.out.println("response code " +responseCode + " Status code : " +res.statusCode());
		Assert.assertEquals(res.statusCode(), responseCode, "Status code does not match");
/*		if(responseCode == res.statusCode())
		{
			System.out.println("Status Code Matching " +res.statusCode());
		}
		else
		{
			System.out.println("Status Code not Matching " +res.statusCode());
		}*/
		
	}
	
	public static void dataValidation(String expectedData, Response res, String jsonPath)
	{
		String actualData = JsonParse.JsonParseUsingJsonPath(res, jsonPath);
		
		Assert.assertEquals(actualData, expectedData, "Data does not Match");
		
		/*if (actualData.equals(expectedData))
		{
			System.out.println("Data matches");
		}
		else if (actualData.contains("Too Many Requests"))
		{
			System.out.println("Server not responding");
		}
		else
		{
			System.out.println("Data does not match" +actualData);
		}*/
				
	}

}
