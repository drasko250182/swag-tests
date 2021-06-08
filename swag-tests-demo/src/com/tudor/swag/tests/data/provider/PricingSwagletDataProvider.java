package com.tudor.swag.tests.data.provider;

import java.util.Arrays;

import org.testng.annotations.DataProvider;

import com.tudor.swag.tests.pages.common.SwagletPage.Type;
import com.tudor.swag.tests.utils.Column;
import com.tudor.swag.tests.utils.Column.Name;
import com.tudor.swag.tests.utils.TableData;

public class PricingSwagletDataProvider {
	
	@DataProvider(name = "PricingSwagletData")
	public static Object[][] getPricingSwagletData() {
		Object[][] arrayObject = null;
		arrayObject = DataProviderManager.getDataFromFolder("S:\\Dept\\SoftDevel\\Selenium\\SWAG\\DataProvider\\Pricing");

		return arrayObject;

	}

//	@DataProvider(name = "PricingSwagletData")
//	public static Object[][] getPricingSwagletData() {
//		return new Object[][] {
//				{ new TableData(Arrays
//						.asList(new Column(Name.CURRENT_VALUE, Arrays.asList("20200110", "USD", "true", "", "true")))),
//						Type.PRICING_CURVE_INDEX },
//				{ new TableData(
//						Arrays.asList(new Column(Name.CURRENT_VALUE, Arrays.asList("20200110", "true", "", "true")))),
//						Type.PRICING_FRA_QUERY_INDEX },
//				{ new TableData(
//						Arrays.asList(new Column(Name.CURRENT_VALUE, Arrays.asList("20200110", "true", "", "true")))),
//						Type.PRICING_FX_CROSESS_INDEX },
//				{ new TableData(
//						Arrays.asList(new Column(Name.CURRENT_VALUE, Arrays.asList("20200110", "true", "", "true")))),
//						Type.PRICING_IR_FUTURE_QUERY_INDEX } };
//
//	}

}
