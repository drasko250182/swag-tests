package com.tudor.swag.tests.data.provider;

import java.util.Arrays;

import org.testng.annotations.DataProvider;

import com.tudor.swag.tests.pages.common.SwagletPage.Type;
import com.tudor.swag.tests.utils.Column;
import com.tudor.swag.tests.utils.Column.Name;
import com.tudor.swag.tests.utils.TableData;

public class OrdersSwagletDataProvider {

	@DataProvider(name = "OrdersSwagletData")
	public static Object[][] getOrdersSwagletData() {
		Object[][] arrayObject = null;
		arrayObject = DataProviderManager.getDataFromFolder("S:\\Dept\\SoftDevel\\Selenium\\SWAG\\RegressionTest\\Orders");

		return arrayObject;
	}
	
	//	@DataProvider(name = "OrdersSwagletData")
//	public static Object[][] getOrdersSwagletData() {
//		return new Object[][] {
//
//				{ new TableData(Arrays.asList(
//						new Column(Name.CURRENT_VALUE, Arrays.asList("paul", "", "", "20201002", "true", "", "true")))),
//						Type.ORDERS_ALLOCATIONS_EQUITIES_EQUITIES },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("mmalbasi", "", "", "20201002", "true", "", "true")))),
//						Type.ORDERS_ALLOCATIONS_EQUITIES_INDEX },
//				{ new TableData(Arrays.asList(
//						new Column(Name.CURRENT_VALUE, Arrays.asList("paul", "", "", "20201002", "true", "", "true")))),
//						Type.ORDERS_ALLOCATIONS_NOTIONALS_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("sysma10", "", "", "20201002", "true", "", "true")))),
//						Type.ORDERS_ALLOCATIONS_NOTIONALS_NOTIONALS },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("/dept/Reports/SystemsAllocRebal/fromFile/inputRebal.csv", "", "", "", "true", "",
//								"true")))),
//						Type.ORDERS_SYSTEMS_ALLOC_REBALANCE_REPORT_FROMFILE },
//				{ new TableData(Arrays
//						.asList(new Column(Name.CURRENT_VALUE, Arrays.asList("", "20201002", "true", "", "true")))),
//						Type.ORDERS_SYSTEMS_ALLOC_REBALANCE_REPORT_INDEX } };
//	}

}
