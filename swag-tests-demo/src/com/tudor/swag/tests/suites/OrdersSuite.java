package com.tudor.swag.tests.suites;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.tudor.swag.tests.data.provider.ComplianceSwagletDataProvider;
import com.tudor.swag.tests.data.provider.OrdersSwagletDataProvider;
import com.tudor.swag.tests.pages.common.SwagletPage.Type;
import com.tudor.swag.tests.suites.common.SwagletSuite;
import com.tudor.swag.tests.utils.TableData;



public class OrdersSuite extends SwagletSuite {

//	@Test(invocationCount = 1, dataProvider = "OrdersSwagletData", dataProviderClass = OrdersSwagletDataProvider.class)
//	public void verifyAlpha(ITestContext context, TableData tableData, Type type) {
//		super.verifyAlpha(context, tableData, type);
//	}
	
//	@Test(invocationCount = 1, dataProvider = "OrdersSwagletData", dataProviderClass = OrdersSwagletDataProvider.class)
//	public void verifyStage(ITestContext context, TableData tableData, Type type) {
//		super.verifyStage(context, tableData, type);
//	}
	

	@Test(invocationCount = 1, dataProvider = "OrdersSwagletData", dataProviderClass = OrdersSwagletDataProvider.class)
	public void verifyData(ITestContext context, TableData tableData, Type type) {
		super.verifyAlphaData(context, tableData, type);
	}
	
//	@Test(invocationCount = 1, dataProvider = "OrdersSwagletData", dataProviderClass = OrdersSwagletDataProvider.class)
//	public void verifyHTML(ITestContext context, TableData tableData, Type type) {
//		super.verifyHTMLData(context, tableData, type);
//	}
////
//	@Test(invocationCount = 1, dataProvider = "OrdersSwagletData", dataProviderClass = OrdersSwagletDataProvider.class)
//	public void verifyCSV(ITestContext context, TableData tableData, Type type) {
//		super.verifyCSVData(context, tableData, type);
//	}
//
//	@Test(invocationCount = 1, dataProvider = "OrdersSwagletData", dataProviderClass = OrdersSwagletDataProvider.class)
//	public void verifyJSON(ITestContext context, TableData tableData, Type type) {
//		super.verifyJSONData(context, tableData, type);
//	}
//
//	@Test(invocationCount = 1, dataProvider = "OrdersSwagletData", dataProviderClass = OrdersSwagletDataProvider.class)
//	public void verifyXML(ITestContext context, TableData tableData, Type type) {
//		super.verifyXMLData(context, tableData, type);
//	}
	
//	@Test(invocationCount = 1, dataProvider = "OrdersSwagletData", dataProviderClass = OrdersSwagletDataProvider.class)
//	public void verifyExcelWebQuery(ITestContext context, TableData tableData, Type type) {
//		super.verifyExcelWebQueryData(context, tableData, type);
//	}

}
