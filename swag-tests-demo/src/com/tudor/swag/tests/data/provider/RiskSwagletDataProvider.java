package com.tudor.swag.tests.data.provider;

import java.util.Arrays;

import org.testng.annotations.DataProvider;

import com.tudor.swag.tests.pages.common.SwagletPage.Type;
import com.tudor.swag.tests.utils.Column;
import com.tudor.swag.tests.utils.Column.Name;
import com.tudor.swag.tests.utils.TableData;

public class RiskSwagletDataProvider {
	
	@DataProvider(name = "RiskSwagletData")
	public static Object[][] getRiskSwagletData() {
		Object[][] arrayObject = null;
		arrayObject = DataProviderManager.getDataFromFolder("S:\\Dept\\SoftDevel\\Selenium\\SWAG\\DataProvider\\Debug");

		return arrayObject;

	}

//	@DataProvider(name = "RiskSwagletData")
//	public static Object[][] getRiskSwagletData() {
//		return new Object[][] {
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("TGF", "20200114", "20200110", "true", "", "true")))),
//						Type.RISK_FUND_RISK_AND_LIQUDITY_SUMMARY_INDEX },
//				{ new TableData(Arrays
//						.asList(new Column(Name.CURRENT_VALUE, Arrays.asList("TGF", "20200110", "true", "", "true")))),
//						Type.RISK_FX_EXPOSURE_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("BVI", "20200114", "20200115", "true", "", "true")))),
//						Type.RISK_HISTORIC_VAR_QUERY_INDEX },
//				{ new TableData(
//						Arrays.asList(new Column(Name.CURRENT_VALUE, Arrays.asList("5", "3", "true", "", "true")))),
//						Type.RISK_INPUT_DATE_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("20200110", "20200101", "20200114", "paul", "2", "", "", "", "", "", "", "", "",
//								"true", "", "true")))),
//						Type.RISK_INTERACTIVE_SUMMARY_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("20200110", "20200101", "20200114", "paul", "", "", "", "", "", "", "", "",
//								"true", "", "true")))),
//						Type.RISK_INTERACTIVE_SUMMARY_SIMULATION_SERIES },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("20200110", "20200101", "20200114", "paul", "", "", "", "", "", "", "true", "",
//								"true")))),
//						Type.RISK_PnL_SIMULATION_SERIES_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("20200110", "20200101", "20200114", "BVI", "", "", "", "", "", "", "", "true", "",
//								"true")))),
//						Type.RISK_PnL_SIMULATION_SERIES_BY_TRADER_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("2", "20200110", "20200114", "true", "", "true")))),
//						Type.RISK_SUBFUND_DRAWDOWNS_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("2", "20200110", "20200114", "true", "", "true")))),
//						Type.RISK_SUBFUND_PnL_INDEX },
//				{ new TableData(Arrays.asList(
//						new Column(Name.CURRENT_VALUE, Arrays.asList("26", "", "20200110", "true", "", "true")))),
//						Type.RISK_TOP_RISK_FACTORS_FOR_FUND_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("26", "20200110", "20200114", "RiskFactor", "true", "", "true")))),
//						Type.RISK_TRADER_COMMODITY_EXPOSURE_INDEX },
//				{ new TableData(Arrays
//						.asList(new Column(Name.CURRENT_VALUE, Arrays.asList("27", "20200110", "true", "", "true")))),
//						Type.RISK_TRADER_EQUITY_EXPOSURE_INDEX },
//				{ new TableData(Arrays.asList(
//						new Column(Name.CURRENT_VALUE, Arrays.asList("27", "20200110", "PM", "true", "", "true")))),
//						Type.RISK_TRADER_FIX_INCOME_EXPOSURE_INDEX },
//				{ new TableData(Arrays
//						.asList(new Column(Name.CURRENT_VALUE, Arrays.asList("27", "20200110", "true", "", "true")))),
//						Type.RISK_TRADER_FX_EXPOSURE_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("BVI", "3", "20200110", "20200114", "true", "", "true")))),
//						Type.RISK_TRADER_GROUP_FUND_BATCH_HISTORY_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("TGF", "20200928", "20200925", "true", "", "true")))),
//						Type.RISK_TRADER_POINTS_ALERT_INDEX },
//				{ new TableData(Arrays.asList(
//						new Column(Name.CURRENT_VALUE, Arrays.asList("TGF", "", "20200110", "true", "", "true")))),
//						Type.RISK_TRADER_RISK_FACTOR_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("BVI", "20200114", "20200110", "", "true", "", "true")))),
//						Type.RISK_TRADER_RISK_STATISTICS_INDEX } };
//
//	}

	@DataProvider(name = "RiskSwagletDataRegression")
	public static Object[][] getRiskSwagletDataRegression() {
		return new Object[][] {
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("BVI", "3", "20200110", "20200114", "true", "", "true")))),
//						Type.RISK_TRADER_GROUP_FUND_BATCH_HISTORY_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("27", "2", "20200110", "20200114", "true", "", "true")))),
//						Type.RISK_TRADER_GROUP_FUND_BATCH_HISTORY_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("BVI", "3", "20200610", "20200614", "true", "", "true")))),
//						Type.RISK_TRADER_GROUP_FUND_BATCH_HISTORY_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("ALTROC, TFM", "3", "20201001", "20201005", "true", "", "true")))),
//						Type.RISK_TRADER_GROUP_FUND_BATCH_HISTORY_INDEX } };
			{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
					Arrays.asList("20200110", "20200101", "20200114", "paul", "2", "", "", "", "", "", "", "", "",
							"true", "", "true")))),
					Type.RISK_INTERACTIVE_SUMMARY_INDEX },
			{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
					Arrays.asList("", "20200101", "20200105", "paul", "", "BVI", "", "", "", "", "", "", "",
							"true", "", "true")))),
					Type.RISK_INTERACTIVE_SUMMARY_INDEX }};
	}
}
