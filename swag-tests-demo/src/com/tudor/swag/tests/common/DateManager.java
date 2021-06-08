package com.tudor.swag.tests.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateManager {

	public static String getCurrentDateTime() {
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
		} catch (Exception e) {

		}
		return str;
	}

	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	       // Integer i = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}

	public static boolean isLeter(final String str) {

		if (str == null || str.length() == 0) {
			return false;
		}

		for (char c : str.toCharArray()) {
			Character c1 = new Character(c);
			if (c1.equals(",")) {
				return true;
			}

			if (!Character.isLetter(c)) {
				return false;
			}
		}

		return true;

	}

//	public static boolean isNumeric(final String str) {
//
//		Boolean toReturn = false;
//
//		if (str == null || str.length() == 0) {
//			toReturn = false;
//		}
//
//		for (char c : str.toCharArray()) {
//			Character c1 = new Character(c);
//			if (c1.toString().equals(",") || c1.toString().equals(".")) {
//				if (toReturn) {
//					toReturn = true;
//				}
//			}
//
//			else if (Character.isDigit(c)) {
//				if (toReturn) {
//					toReturn = true;
//				}
//			}
//		}
//
//		return toReturn;
//
//	}

}
