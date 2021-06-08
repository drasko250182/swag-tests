package com.tudor.swag.tests.data.provider;

import java.util.Arrays;

import org.testng.annotations.DataProvider;

import com.tudor.swag.tests.pages.common.SwagletPage.Type;
import com.tudor.swag.tests.utils.Column;
import com.tudor.swag.tests.utils.Column.Name;
import com.tudor.swag.tests.utils.TableData;

public class PeformanceSwagletDataProvider {
	
	@DataProvider(name = "PerformanceSwagletData")
	public static Object[][] getPerformanceSwagletData() {
		Object[][] arrayObject = null;
		arrayObject = DataProviderManager.getDataFromFolder("S:\\Dept\\SoftDevel\\Selenium\\SWAG\\DataProvider\\Performance");

		return arrayObject;

	}

//	@DataProvider(name = "PerformanceSwagletData")
//	public static Object[][] getPerformanceSwagletData() {
//		return new Object[][] {
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("", "", "paul", "", "", "", "20200110", "20200110", "", "", "", "", "", "", "",
//								"", "", "", "", "", "true", "", "true")))),
//						Type.PERFORMANCE_ACCOUNT_PERFORMANCE_BY_ACCOUNT },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("", "", "paul", "", "", "", "20200110", "20200110", "", "", "", "", "", "", "",
//								"", "", "", "", "", "true", "", "true")))),
//						Type.PERFORMANCE_ACCOUNT_PERFORMANCE_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("BVI", "", "20200110", "20200110", "", "", "", "", "", "", "", "", "", "", "",
//								"true", "", "true")))),
//						Type.PERFORMANCE_FUND_PERFORMANCE_BY_FUND },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("BVI", "", "20200110", "20200110", "", "", "", "", "", "", "", "", "", "", "",
//								"true", "", "true")))),
//						Type.PERFORMANCE_FUND_PERFORMANCE_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("BVI", "", "TRADERS", "", "20200110", "", "", "", "", "", "", "true", "",
//								"true")))),
//						Type.PERFORMANCE_GROUP_SUMMARY_INDEX },
//				{ new TableData(Arrays
//						.asList(new Column(Name.CURRENT_VALUE, Arrays.asList("paul", "", "", "", "true", "", "true")))),
//						Type.PERFORMANCE_SYSTEMS_NOTIONAL_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("paul", "", "", "", "20200110", "20200110", "", "", "", "", "", "", "", "", "",
//								"", "", "", "", "true", "", "true")))),
//						Type.PERFORMANCE_TRADER_PERFORMANCE_BY_SUBFUND },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("paul", "", "", "", "20200110", "20200110", "", "", "", "", "", "", "", "", "",
//								"", "", "", "", "true", "", "true")))),
//						Type.PERFORMANCE_TRADER_PERFORMANCE_BY_TRADER },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("paul", "", "", "62", "20200110", "20200110", "", "", "", "", "", "", "", "", "",
//								"", "", "", "true", "", "true")))),
//						Type.PERFORMANCE_TRADER_PERFORMANCE_BY_TRADER_AND_PnL_ITEM },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("2", "", "", "20200110", "20200110", "", "", "", "", "", "", "", "", "", "", "",
//								"true", "", "true")))),
//						Type.PERFORMANCE_TRADER_PERFORMANCE_BY_TRADER_GROUP },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("2", "", "62", "20200110", "20200110", "", "", "", "", "", "", "", "", "", "", "",
//								"true", "", "true")))),
//						Type.PERFORMANCE_TRADER_PERFORMANCE_BY_TRADER_GROUP_AND_PnL_ITEM },
//				{ new TableData(
//						Arrays.asList(new Column(Name.CURRENT_VALUE,
//								Arrays.asList("paul", "", "", "", "20200110", "20200110", "", "", "", "", "", "", "",
//										"", "", "", "", "", "", "true", "", "true")))),
//						Type.PERFORMANCE_TRADER_PERFORMANCE_INDEX } };
//	}

}
