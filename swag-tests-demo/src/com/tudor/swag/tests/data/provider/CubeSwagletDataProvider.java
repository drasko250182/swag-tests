package com.tudor.swag.tests.data.provider;

import java.util.Arrays;

import org.testng.annotations.DataProvider;

import com.tudor.swag.tests.pages.common.SwagletPage.Type;
import com.tudor.swag.tests.utils.Column;
import com.tudor.swag.tests.utils.Column.Name;
import com.tudor.swag.tests.utils.TableData;

public class CubeSwagletDataProvider {
	
	@DataProvider(name = "CubeSwagletData")
	public static Object[][] getCubeSwagletData() {
		Object[][] arrayObject = null;
		arrayObject = DataProviderManager.getDataFromFolder("S:\\Dept\\SoftDevel\\Selenium\\SWAG\\DataProvider\\CubeNew_02062021");

		return arrayObject;

	}

//	@DataProvider(name = "CubeSwagletData")
//	public static Object[][] getCubeSwagletData() {
//		return new Object[][] {
//
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("SD1060", "Trader:\"paul\"", "AsOfDate: [\"20200601\"-\"20200605\"]", "", "true",
//								"", "true")))),
//						Type.CUBE_RISK_CUBE_INDEX },
//
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("BondInterest", "ValueDate: [\"20200601\"-\"20200605\"]",
//								"ValueDate: [\"20200601\"-\"20200605\"]", "true", "", "true")))),
//						Type.CUBE_PnL_CUBE_INDEX } };
//
//	}

	@DataProvider(name = "CubeSwagletDataReggresion")
	public static Object[][] getCubeSwagletDataReggresion() {
		return new Object[][] {
				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
						Arrays.asList("BondAccrued", "ValueDate: [\"20201001\"-\"20201008\"]",
								"ValueDate: [\"20201001\"-\"20201008\"]", "true", "", "true")))),
						Type.CUBE_PnL_CUBE_INDEX },
				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
						Arrays.asList("EndMarketPrice", "ValueDate: [\"20201001\"-\"20201008\"]",
								"ValueDate: [\"20201001\"-\"20201008\"]", "true", "", "true")))),
						Type.CUBE_PnL_CUBE_INDEX },
				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
						Arrays.asList("EndQuantity", "ValueDate: [\"20201001\"-\"20201008\"]",
								"ValueDate: [\"20201001\"-\"20201008\"]", "true", "", "true")))),
						Type.CUBE_PnL_CUBE_INDEX },
				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
						Arrays.asList("PnL", "ValueDate: [\"20201001\"-\"20201008\"]",
								"ValueDate: [\"20201001\"-\"20201008\"]", "true", "", "true")))),
						Type.CUBE_PnL_CUBE_INDEX },
				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
						Arrays.asList("PnS", "ValueDate: [\"20201001\"-\"20201008\"]",
								"ValueDate: [\"20201001\"-\"20201008\"]", "true", "", "true")))),
						Type.CUBE_PnL_CUBE_INDEX },

				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
						Arrays.asList("BondInterest", "ValueDate: [\"20201001\"-\"20201008\"]",
								"ValueDate: [\"20201001\"-\"20201008\"]", "true", "", "true")))),
						Type.CUBE_PnL_CUBE_INDEX } };

	}

}
