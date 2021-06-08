package com.tudor.swag.tests.suites;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.tudor.swag.tests.data.provider.ItAdminSwagletDataProvider;
import com.tudor.swag.tests.data.provider.OrdersSwagletDataProvider;
import com.tudor.swag.tests.data.provider.PeformanceSwagletDataProvider;
import com.tudor.swag.tests.pages.common.SwagletPage.Type;
import com.tudor.swag.tests.suites.common.SwagletSuite;
import com.tudor.swag.tests.utils.TableData;

public class PerformanceSuite extends SwagletSuite {
	
//	@Test(invocationCount = 1, dataProvider = "PerformanceSwagletData", dataProviderClass = PeformanceSwagletDataProvider.class)
//	public void verifyStage(ITestContext context, TableData tableData, Type type) {
//		super.verifyStage(context, tableData, type);
//	}

	@Test(invocationCount = 1, dataProvider = "PerformanceSwagletData", dataProviderClass = PeformanceSwagletDataProvider.class)
	public void verifyData(ITestContext context, TableData tableData, Type type) {
		super.verifyAlphaData(context, tableData, type);
	}
	
//	@Test(dataProvider = "PerformanceSwagletData", dataProviderClass = PeformanceSwagletDataProvider.class)
//	public void verifyHTML(ITestContext context, TableData tableData, Type type) {
//		super.verifyHTMLData(context, tableData, type);
//	}
//	
//	@Test(dataProvider = "PerformanceSwagletData", dataProviderClass = PeformanceSwagletDataProvider.class)
//	public void verifyCSV(ITestContext context, TableData tableData, Type type) {
//		super.verifyCSVData(context, tableData, type);
//	}
//	
//	@Test(dataProvider = "PerformanceSwagletData", dataProviderClass = PeformanceSwagletDataProvider.class)
//	public void verifyJSON(ITestContext context, TableData tableData, Type type) {
//		super.verifyJSONData(context, tableData, type);
//	}

}
