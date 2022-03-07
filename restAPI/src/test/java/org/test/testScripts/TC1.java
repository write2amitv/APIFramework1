package org.test.testScripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.plaf.synth.SynthScrollBarUI;

import org.test.ResponseValidation.ResponseValidation;
import org.test.testSteps.HTTPMethods;
import org.test.utilities.Json;
import org.test.utilities.JsonParse;
import org.test.utilities.JsonVariable;
import org.test.utilities.LoadPropertiesFile;
import org.test.utilities.RandomData;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class TC1 {
	static String responseidValue;
	
	@Test
	public void testCase1() throws IOException {
		String bodyData = Json.LoadJSONFile("../restAPI/src/test/java/org/test/payload/BodyData.json");
		String randomId = RandomData.randomValue();
		bodyData = JsonVariable.JsonVariableReplacement(bodyData, "id", randomId);
		
		Properties pr = LoadPropertiesFile.propertiesFile("../restAPI/URI.properties");
		HTTPMethods http = new HTTPMethods(pr);
		
		Response res = http.postMethod(bodyData, "QA_Env_Employees_URI");
		responseidValue = JsonParse.Parse(res.asString(), "id");
		System.out.println("Test Case1 Ends");
		ResponseValidation.statusCodeValidation(200, res);
		
	}

}
