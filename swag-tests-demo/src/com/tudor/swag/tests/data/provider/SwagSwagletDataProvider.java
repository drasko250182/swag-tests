package com.tudor.swag.tests.data.provider;

import java.util.Arrays;

import org.testng.annotations.DataProvider;

import com.tudor.swag.tests.pages.common.SwagletPage.Type;
import com.tudor.swag.tests.utils.Column;
import com.tudor.swag.tests.utils.Column.Name;
import com.tudor.swag.tests.utils.TableData;

public class SwagSwagletDataProvider {
	
	@DataProvider(name = "SwagSwagletData")
	public static Object[][] getCubeSwagletData() {
		Object[][] arrayObject = null;
		arrayObject = DataProviderManager.getDataFromFolder("S:\\Dept\\SoftDevel\\Selenium\\SWAG\\DataProvider\\Swag");

		return arrayObject;

	}

//	@DataProvider(name = "SwagSwagletData")
//	public static Object[][] getCubeSwagletData() {
//		return new Object[][] { { new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE, Arrays.asList("true", "", "true")))),
//				Type.SWAG_USER_PERMISSIONS_INDEX } };
//	}

}
