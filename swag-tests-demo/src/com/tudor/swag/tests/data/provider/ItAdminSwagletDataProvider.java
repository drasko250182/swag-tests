package com.tudor.swag.tests.data.provider;

import java.util.Arrays;

import org.testng.annotations.DataProvider;

import com.tudor.swag.tests.pages.common.SwagletPage.Type;
import com.tudor.swag.tests.utils.Column;
import com.tudor.swag.tests.utils.TableData;
import com.tudor.swag.tests.utils.Column.Name;

public class ItAdminSwagletDataProvider {
	
	@DataProvider(name = "ItAdminSwagletData")
	public static Object[][] getItAdminSwagletData() {
		Object[][] arrayObject = null;
		arrayObject = DataProviderManager.getDataFromFolder("S:\\Dept\\SoftDevel\\Selenium\\SWAG\\DataProvider\\ItAdmin");

		return arrayObject;

	}

//	@DataProvider(name = "ItAdminSwagletData")
//	public static Object[][] getItAdminSwagletData() {
//		return new Object[][] {
//				{ new TableData(Arrays.asList(
//						new Column(Name.CURRENT_VALUE, Arrays.asList("120", "false", "false", "true", "", "true")))),
//						Type.ITADMIN_TRADER_PERMISSIONS_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("false", "false", "Security Explorer", "true", "", "true")))),
//						Type.ITADMIN_TUDOR_APP_PERMISSIONS_INDEX },
//				{ new TableData(
//						Arrays.asList(new Column(Name.CURRENT_VALUE, Arrays.asList("false", "true", "", "true")))),
//						Type.ITADMIN_TUDOR_APPS_INDEX },
//				{ new TableData(Arrays.asList(new Column(Name.CURRENT_VALUE,
//						Arrays.asList("false", "false", "false", "false", "true", "", "true")))),
//						Type.ITADMIN_TUDOR_USERS_INDEX } };
//
//	}

}
