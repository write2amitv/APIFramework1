package org.test.utilities;

import java.util.Random;

public class RandomData {
	
	public static String randomValue()
	{
		Random r = new Random();
		Integer i = r.nextInt();
		return i.toString();
	}

}
