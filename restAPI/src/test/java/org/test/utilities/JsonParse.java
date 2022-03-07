package org.test.utilities;

import org.json.JSONObject;

import com.jayway.restassured.response.Response;

import org.json.JSONArray;

public class JsonParse {
	
	public static String Parse(String res, String key)
	{
		JSONObject ob = new JSONObject(res);
		
		System.out.println("Json parse " +ob.toString());
		System.out.println("Json parse 2" + ob.get(key));
		return ob.get(key).toString();
		
	}
	
	public static void ParseAllKeys(String response, String keyName)
	{
		JSONArray arr = new JSONArray(response);
		int length = arr.length();
		for (int i = 0; i < length; i++)
		{
			JSONObject ob = arr.getJSONObject(i);
			System.out.println(ob.get(keyName));
			
		}
	}
	
	public static String JsonParseUsingJsonPath(Response res, String JsonPath)
	{
		return res.jsonPath().get(JsonPath);
	}

}
