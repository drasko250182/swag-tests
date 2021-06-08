package com.tudor.swag.tests.common;

public class JsoupParser {

	//TO DO
	public static String getWebElementLocator(String jsoupString) {
		
		String toReturn = "";
		
		String temp = jsoupString.substring(5, jsoupString.length());
		
		String tag = temp.substring(0, temp.indexOf(" "));
		
		String tempValue = temp.substring(temp.indexOf("id") + 4, temp.length());
		
		String idValue = tempValue.substring(0, tempValue.indexOf(" ") - 1);
		
		toReturn = toReturn + ".//input[@id='" + idValue + "']";
		
		
		return toReturn;
		
	}
}



