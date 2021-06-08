package com.tudor.swag.tests.data.provider;

import org.testng.annotations.DataProvider;

public class ComplianceSwagletDataProvider {
	
	@DataProvider(name = "ComplianceSwagletData")
	public static Object[][] getComplianceSwagletData() {
		Object[][] arrayObject = null;
		arrayObject = DataProviderManager.getDataFromFolder("S:\\Dept\\SoftDevel\\Selenium\\SWAG\\DataProvider\\Compliance");

		return arrayObject;

	}

//	@DataProvider(name = "ComplianceSwagletData")
//	public static Object[][] getComplianceSwagletData() {
//		return new Object[][] {
////				{ new TableData(Arrays.asList(
////						new Column(Name.CURRENT_VALUE, Arrays.asList("true", "name", "2", "3", "true", "", "true")))),
////						Type.COMPLIANCE_RESTRICTED_INSTRUMENTS_INDEX }};
//				{ new TableData(Arrays.asList(
//						new Column(Name.CURRENT_VALUE, Arrays.asList("", "", "", "", "true", "", "true")))),
//						Type.COMPLIANCE_RESTRICTED_INSTRUMENTS_INDEX } };
//	}

}
