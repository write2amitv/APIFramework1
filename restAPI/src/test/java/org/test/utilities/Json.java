package org.test.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Json {
	
	public static String LoadJSONFile(String path) throws FileNotFoundException
	{
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);

		JSONTokener jt = new JSONTokener(fi);
		JSONObject body = new JSONObject(jt);

		return body.toString();

	}

}
