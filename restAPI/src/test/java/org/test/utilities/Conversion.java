package org.test.utilities;

import org.json.JSONObject;
import org.json.XML;

public class Conversion {
	
	static public void xmlToJson(String xmlData)
	{
		JSONObject js = XML.toJSONObject(xmlData);
		
		//return js.toString();
	}
	
	public String JsonToXml(String jsonData)
	{
		JSONObject js = new JSONObject(jsonData);
		String xmlData = XML.toString(js);
		return xmlData;
	}

}
