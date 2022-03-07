package org.test.testSteps;

import static com.jayway.restassured.RestAssured.*;

import java.util.Properties;

import org.test.utilities.JsonParse;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class HTTPMethods {
	
	Properties pr;
	public HTTPMethods(Properties pr)
	{
		this.pr=pr;
		
	}
	
	
	public Response postMethod(String bodyData, String uriKey)
	{
		System.out.println("body data is " +bodyData);
		System.out.println("URI key is " +uriKey + " and prop is " +pr.getProperty(uriKey));
		
		Response res=
				given()
				.contentType(ContentType.JSON)
				.body(bodyData)
				.when()
				.post(pr.getProperty(uriKey));
		
		System.out.println("Status cOde is " +res.statusCode());
		return res;
	}
	
	public Response getMethod(String uriKey, String id)
	{
		String uri = pr.getProperty(uriKey)+"/"+id;
		Response res=
				given().contentType(ContentType.JSON)
				.when().get(uri);
		
		System.out.println("Status cOde is " +res.statusCode());
		return res;
	}
	
	public void deleteMethod(String uriKey, String id)
	{
		String uri = pr.getProperty(uriKey)+"/"+id;
		
		Response res=
				given().contentType(ContentType.JSON)
				.when().delete(uri);
		
		System.out.println("Status cOde is " +res.statusCode());
	}
	
	
	public Response putMethod(String uriKey, String id, String bodyData)
	{
		String uri = pr.getProperty(uriKey)+"/"+id;
		
		Response res=
				given().contentType(ContentType.JSON).body(bodyData)
				.when().put(uri);
		
		System.out.println("Status cOde is " +res.statusCode());
		return res;
	}
	
	public Response getAllMethod(String uriKey)
	{
		String uri = pr.getProperty(uriKey);
		Response res = 
				given().contentType(ContentType.JSON)
				.when().get(uri);
		
		System.out.println("Status Code is " +res.statusCode());
		//System.out.println("All JSON data is " +res.asString());
		
		return res;
	}
	
	public void getAllKeys(String uriKey, String keyName)
	{
		String uri = pr.getProperty(uriKey); 
		Response res = 
				given().contentType(ContentType.JSON)
				.when().get(uri);
		JsonParse.ParseAllKeys(res.asString(), keyName);
	}
}
