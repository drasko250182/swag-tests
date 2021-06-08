package com.tudor.swag.tests.export;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class Test {

	public static void main(String[] args) {
//	TestListenerAdapter tla = new TestListenerAdapter();
//    TestNG testng = new TestNG();
//    List<String> suites = new ArrayList<String>();
//    suites.add("H:\\git_projects\\swag-test\\swag-tests\\testNG_Single.xml");
//   
//    testng.setTestSuites(suites);
//    testng.run();
		
		double largeDouble = 345_345_345_345.56;
		BigDecimal big = new BigDecimal(largeDouble);
		big = big.setScale(0, RoundingMode.HALF_UP);
		String rounded = big.toString();
	}
}
