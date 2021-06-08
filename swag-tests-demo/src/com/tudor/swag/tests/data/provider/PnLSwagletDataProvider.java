package com.tudor.swag.tests.data.provider;

import java.util.Arrays;

import org.testng.annotations.DataProvider;

import com.tudor.swag.tests.pages.common.SwagletPage.Type;
import com.tudor.swag.tests.utils.Column;
import com.tudor.swag.tests.utils.Column.Name;
import com.tudor.swag.tests.utils.TableData;

public class PnLSwagletDataProvider {
	
	@DataProvider(name = "PnLSwagletData")
	public static Object[][] getPnLSwagletData() {
		Object[][] arrayObject = null;
		arrayObject = DataProviderManager.getDataFromFolder("S:\\Dept\\SoftDevel\\Selenium\\SWAG\\DataProvider\\PnL");

		return arrayObject;

	}

//	@DataProvider(name = "PnLSwagletData")
//	public static Object[][] getRiskSwagletData() {
//		return new Object[][] {
////				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE, Arrays.asList("Trader , Id", "afox")))),
////						Type.PNL_PnL_ACTIVE_NAME_QUERY_INDEX },
////				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
////						Arrays.asList("Trader", "", "20200110", "20200111", "", "Trader")))),
////						Type.PNL_PnL_ACTIVE_NAME_QUERY_ADVANCED_INDEX },
////				{ new TableData(
////						Arrays.asList(new Column(Name.CURRENT_VALUE, Arrays.asList("Trader", "", "", "60001")))),
////						Type.PNL_PnL_QUERY_INDEX },
////				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE, Arrays.asList("TRADER")))),
////						Type.PNL_PnL_QUERY_ADVANCED_INDEX },
////				{ new TableData(
////						Arrays.asList(new Column(Name.CURRENT_VALUE, Arrays.asList("20200110", "paul", "BVI")))),
////						Type.PNL_PnL_REPORT_INDEX },
////				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE, Arrays.asList("", "", "paul")))),
////						Type.PNL_POSITION_REPORT_INDEX } };
//
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("Id, Instrument Description, P&L", "fof", "BVI", "", "", "", "", "", "20200110",
//								"20200112", "", "", "", "", "", "", "", "", "", "true", "", "true")))),
//						Type.PNL_PnL_ACTIVE_NAME_QUERY_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("Id, Instrument Description, P&L", "TRADER='fof'", "20200110", "20200110", "", "", "", "", "",
//								"", "", "", "", "true", "", "true")))),
//						Type.PNL_PnL_ACTIVE_NAME_QUERY_ADVANCED_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("TID, TRADER, STRATEGY, PNL", "fof", "", "", "", "", "", "", "20200110",
//								"20200112", "", "", "", "", "", "", "", "", "", "true", "", "true")))),
//						Type.PNL_PnL_QUERY_INDEX },
//
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("FUND, PNL", "20200110", "20200112", "TRADER='paul'", "", "", "", "", "", "", "", "", "true", "", "true")))),
//						Type.PNL_PnL_QUERY_ADVANCED_INDEX },
//				{ new TableData(
//						Arrays.asList(new Column(Name.CURRENT_VALUE, Arrays.asList("20200110", "paul", "BVI", "", "true", "", "true")))),
//						Type.PNL_PnL_REPORT_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE, Arrays.asList("20200110", "STRATEGY", "417", "", "true", "", "true")))),
//						Type.PNL_POSITION_REPORT_INDEX } };
//
//	}

}
