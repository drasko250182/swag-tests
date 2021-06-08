package com.tudor.swag.tests.suites;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.tudor.swag.tests.data.provider.OrdersSwagletDataProvider;
import com.tudor.swag.tests.data.provider.PeformanceSwagletDataProvider;
import com.tudor.swag.tests.data.provider.PnLSwagletDataProvider;
import com.tudor.swag.tests.pages.common.SwagletPage.Type;
import com.tudor.swag.tests.suites.common.SwagletSuite;
import com.tudor.swag.tests.utils.TableData;

public class PnLSuite extends SwagletSuite {
	
//	@Test(invocationCount = 1, dataProvider = "PnLSwagletData", dataProviderClass = PnLSwagletDataProvider.class)
//	public void verifyStage(ITestContext context, TableData tableData, Type type) {
//		super.verifyStage(context, tableData, type);
//	}

	@Test(invocationCount = 1, dataProvider = "PnLSwagletData", dataProviderClass = PnLSwagletDataProvider.class)
	public void verifyData(ITestContext context, TableData tableData, Type type) {
		super.verifyAlphaData(context, tableData, type);
	}
	
//	@Test(dataProvider = "PnLSwagletData", dataProviderClass = PnLSwagletDataProvider.class)
//	public void verifyHTML(ITestContext context, TableData tableData, Type type) {
//		super.verifyHTMLData(context, tableData, type);
//	}
//	
//	@Test(dataProvider = "PnLSwagletData", dataProviderClass = PnLSwagletDataProvider.class)
//	public void verifyCSV(ITestContext context, TableData tableData, Type type) {
//		super.verifyCSVData(context, tableData, type);
//	}
//	
//	@Test(dataProvider = "PnLSwagletData", dataProviderClass = PnLSwagletDataProvider.class)
//	public void verifyJSON(ITestContext context, TableData tableData, Type type) {
//		super.verifyJSONData(context, tableData, type);
//	}
	
	

}