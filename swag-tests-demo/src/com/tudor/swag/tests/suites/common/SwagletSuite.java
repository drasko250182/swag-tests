package com.tudor.swag.tests.suites.common;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.ITestContext;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.tudor.swag.tests.common.ExcelManager;
import com.tudor.swag.tests.common.FileParser;
import com.tudor.swag.tests.common.FolderManager;
import com.tudor.swag.tests.common.ResultManager;
import com.tudor.swag.tests.common.TestManager;
import com.tudor.swag.tests.pages.common.HTMLPage;
import com.tudor.swag.tests.pages.common.JsonPage;
import com.tudor.swag.tests.pages.common.SwagletPage;
import com.tudor.swag.tests.pages.common.SwagletPage.Type;
import com.tudor.swag.tests.pages.common.XMLPage;
import com.tudor.swag.tests.utils.SoftAssertSwag;
import com.tudor.swag.tests.utils.TableData;

public abstract class SwagletSuite extends BaseSuite {

//	public void verifyData(ITestContext context, TableData tableData, Type type) {
//		ArrayList<String> tabs = new ArrayList<String>();
//		tabs = new ArrayList<String>(driver.getWindowHandles());
//		
//		if (tabs.size() == 2) {
//			driver.switchTo().window(tabs.get(0));
//		}
//		
//		this.test.getModel().setName(
//				Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + TestManager.getTestName(type));
//
//		Markup mTestDescription = MarkupHelper.createLabel("Parameters: " + TestManager.getTestDescription(tableData),
//				ExtentColor.WHITE);
//		test.log(Status.INFO, mTestDescription);
//
//		SwagletPage swagletPageStage = new SwagletPage(driver, test, urlStage, type);
//
//		this.test.info("Navigate to stage " + urlStage);
//
//		swagletPageStage.show();
//		Assert.assertTrue(swagletPageStage.isDisplayed(type), TestManager.getTestName(type) + " is not fetched");
//		this.test.info(TestManager.getTestName(type) + " Stage is fetched");
//
//		swagletPageStage.setTableParameter(tableData);
//
//		this.test.info("Populated current values on stage , picture below : stage");
//		getScreenshot(context, "stage");
//
//		swagletPageStage.callService();
//
//		TableData tableDataTableResultsStage = swagletPageStage.getTableResults();
//
//		this.test.info("Data value on stage , picture below : stage data");
//		getScreenshot(context, "stage data");
//
//		if (tabs.size() == 1) {
//			((JavascriptExecutor) driver).executeScript("window.open()");
//			tabs = new ArrayList<String>(driver.getWindowHandles());
//		}
//
//		this.test.info("Switch to second tab");
//
//		driver.switchTo().window(tabs.get(1));
//
//		//String urlProduction = urlStage.replace("swag-stage:8080", "swag:8080");
//		String urlProduction = urlStage.replace("swag:8080", "swag-stage:8080");
//
//		SwagletPage swagletPageProduction = new SwagletPage(driver, test, urlProduction, type);
//
//		this.test.info("Navigate to production " + urlProduction);
//
//		swagletPageProduction.show();
//		Assert.assertTrue(swagletPageProduction.isDisplayed(type), TestManager.getTestName(type) + " is not fetched");
//		this.test.info(TestManager.getTestName(type) + " Production is fetched");
//
//		swagletPageProduction.setTableParameter(tableData);
//
//		this.test.info("Populated current values on prod , picture below : production");
//		getScreenshot(context, "production");
//
//		swagletPageProduction.callService();
//
//		TableData tableDataTableResultsProduction = swagletPageProduction.getTableResults();
//
//		this.test.info("Data value on prod , picture below : production data");
//		getScreenshot(context, "production data");
//
//		SoftAssertSwag sas = new SoftAssertSwag();
//
//		sas.assertTableData(tableDataTableResultsStage, tableDataTableResultsProduction);
//
//		sas.assertAll();
//
//		Markup m = MarkupHelper.createLabel("Data on stage and production are verified", ExtentColor.GREEN);
//		test.log(Status.INFO, m);
//	}

	public void verifyStage(ITestContext context, TableData tableData, Type type) {
		this.test.getModel().setName(
				Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + TestManager.getTestName(type));

		Markup mTestDescription = MarkupHelper.createLabel("Parameters: " + TestManager.getTestDescription(tableData),
				ExtentColor.WHITE);
		test.log(Status.INFO, mTestDescription);

		SwagletPage swagletPageStage = new SwagletPage(driver, test, "https://swag-stage.global.tudor.com/swag/", type);

		this.test.info("Navigate to stage " + "https://swag-stage.global.tudor.com/swag/");

		swagletPageStage.show();
		Assert.assertTrue(swagletPageStage.isDisplayed(type), TestManager.getTestName(type) + " is not fetched");
		this.test.info(TestManager.getTestName(type) + " Stage is fetched");

		swagletPageStage.setTableParameter(tableData);

		this.test.info("Populated current values on stage , picture below : stage");
		getScreenshot(context, "stage");

		swagletPageStage.callService();

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

		String validationErrorStage = null;
		TableData tableDataTableResultsStage = null;
		boolean isValidationErrorExistStage = swagletPageStage.isError();
		if (isValidationErrorExistStage) {
			validationErrorStage = swagletPageStage.getValidationError();
		} else {
			tableDataTableResultsStage = swagletPageStage.getListTableResults();
		}

		if (isValidationErrorExistStage) {
			Markup m = MarkupHelper.createLabel("Validation ERROR on STAGE, " + validationErrorStage,
					ExtentColor.ORANGE);
			test.log(Status.ERROR, m);
		} else if (tableDataTableResultsStage == null) {
			Markup m = MarkupHelper.createLabel("Exception on STAGE ", ExtentColor.PINK);
			test.log(Status.FAIL, m);
		} else {
			Assert.assertEquals(swagletPageStage.isResultReturn(), true, "Result not returned");
			Markup m = MarkupHelper.createLabel("STAGE is verified", ExtentColor.GREEN);
			test.log(Status.PASS, m);
		}
		this.test.info("Data value on stage , picture below : stage data");
		getScreenshot(context, "stage data");

	}

//	public void verifyAlpha(ITestContext context, TableData tableData, Type type) {
//		this.test.getModel().setName(
//				Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + TestManager.getTestName(type));
//
//		Markup mTestDescription = MarkupHelper.createLabel("Parameters: " + TestManager.getTestDescription(tableData),
//				ExtentColor.WHITE);
//		test.log(Status.INFO, mTestDescription);
//		
//		String urlAlpha = "http://tomcat-swag1-alpha:8080/swag/";
//		SwagletPage swagletPageAlpha = new SwagletPage(driver, test, urlAlpha, type);
//
//		this.test.info("Navigate to alpha " + urlAlpha);
//
//		swagletPageAlpha.show();
//		Assert.assertTrue(swagletPageAlpha.isDisplayed(type), TestManager.getTestName(type) + " is not fetched");
//		this.test.info(TestManager.getTestName(type) + " Alpha is fetched");
//
//		swagletPageAlpha.setTableParameter(tableData);
//
//		this.test.info("Populated current values on alpha , picture below : alpha");
//		getScreenshot(context, "alpha");
//
//		swagletPageAlpha.callService();
//
//		// TableData tableDataTableResultsProd = swagletPageStage.getTableResults();
//		Assert.assertEquals(swagletPageAlpha.isResultReturn(), true, "Result not returned");
//
//		this.test.info("Data value on al[ha , picture below : alpha data");
//		getScreenshot(context, "alpha data");
//
//	}

	public void verifyStageData(ITestContext context, TableData tableData, Type type) {
		this.test.getModel().setName(
				Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + TestManager.getTestName(type));

		Markup mTestDescription = MarkupHelper.createLabel("Parameters: " + TestManager.getTestDescription(tableData),
				ExtentColor.WHITE);
		test.log(Status.INFO, mTestDescription);

		SwagletPage swagletPageStage = new SwagletPage(driver, test, urlStage, type);

		this.test.info("Navigate to stage " + urlStage);

		swagletPageStage.show();
		Assert.assertTrue(swagletPageStage.isDisplayed(type), TestManager.getTestName(type) + " is not fetched");
		this.test.info(TestManager.getTestName(type) + " Stage is fetched");

		swagletPageStage.setTableParameter(tableData);

		this.test.info("Populated current values on stage , picture below : stage");
		getScreenshot(context, "stage");

		swagletPageStage.callService();

		TableData tableDataStage = swagletPageStage.getTableResults();

		ResultManager resultManager = new ResultManager();
		if (context.getCurrentXmlTest().getParameter("xmlJSON").equals(String.valueOf(true))) {
			resultManager.writeToFile(tableDataStage, context.getCurrentXmlTest().getParameter("dataResults")
					+ TestManager.getTestName(type) + "_" + TestManager.getTestSpecification(tableData) + ".txt");
		}

		TableData tableDataExpected = resultManager.getTableData(context.getCurrentXmlTest().getParameter("dataResults")
				+ TestManager.getTestName(type) + "_" + TestManager.getTestSpecification(tableData) + ".txt");

		SoftAssertSwag sas = new SoftAssertSwag();

		sas.assertTableData(tableDataStage, tableDataExpected);
		sas.assertAll();

		Markup m = MarkupHelper.createLabel("Data on stage and production are verified", ExtentColor.GREEN);
		test.log(Status.INFO, m);

	}

	public void verifyData(ITestContext context, TableData tableData, Type type) {
		ArrayList<String> tabs = new ArrayList<String>();
		tabs = new ArrayList<String>(driver.getWindowHandles());

		if (tabs.size() == 2) {
			driver.switchTo().window(tabs.get(0));
		}

		this.test.getModel().setName(
				Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + TestManager.getTestName(type));

		Markup mTestDescription = MarkupHelper.createLabel("Parameters: " + TestManager.getTestDescription(tableData),
				ExtentColor.WHITE);
		test.log(Status.INFO, mTestDescription);

		String urlProduction = urlStage;
		SwagletPage swagletPageProd = new SwagletPage(driver, test, urlProduction, type);

		this.test.info("Navigate to prod " + urlProduction);

		swagletPageProd.show();
		Assert.assertTrue(swagletPageProd.isDisplayed(type), TestManager.getTestName(type) + " is not fetched");
		this.test.info(TestManager.getTestName(type) + " Prod is fetched");

		swagletPageProd.setTableParameter(tableData);

		this.test.info("Populated current values on prod , picture below : prod");
		getScreenshot(context, "prod");

		swagletPageProd.callService();
		
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

		TableData tableDataTableResultsProd = swagletPageProd.getTableResults();

		this.test.info("Data value on prod , picture below : prod data");
		getScreenshot(context, "prod data");

		if (tabs.size() == 1) {
			((JavascriptExecutor) driver).executeScript("window.open()");
			tabs = new ArrayList<String>(driver.getWindowHandles());
		}

		this.test.info("Switch to second tab");

		driver.switchTo().window(tabs.get(1));

		// String urlProduction = urlStage.replace("swag-stage:8080", "swag:8080");
		// String urlStage = urlProduction.replace("swag:8080", "swag-stage:8080");
		//String urlStage = "http://tomcat-swag1-alpha:8080/swag/";
		String urlAlpha = "https://swag-alpha.global.tudor.com/swag/";
		
		//String urlStage = "https://swag-stage.global.tudor.com/swag/";

		SwagletPage swagletPageStage = new SwagletPage(driver, test, urlAlpha, type);

		this.test.info("Navigate to stage " + urlAlpha);

		swagletPageStage.show();
		Assert.assertTrue(swagletPageStage.isDisplayed(type), TestManager.getTestName(type) + " is not fetched");
		this.test.info(TestManager.getTestName(type) + " Stage is fetched");

		swagletPageStage.setTableParameter(tableData);

		this.test.info("Populated current values on stage , picture below : stage");
		getScreenshot(context, "stage");

		swagletPageStage.callService();
		
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

		TableData tableDataTableResultsStage = swagletPageStage.getTableResults();

		this.test.info("Data value on stage , picture below : stage data");
		getScreenshot(context, "stage data");

		SoftAssertSwag sas = new SoftAssertSwag();

		sas.assertTableData(tableDataTableResultsStage, tableDataTableResultsProd);
		// sas.assertTableDataByMap(tableDataTableResultsStage,
		// tableDataTableResultsProd);

		sas.assertAll();

		Markup m = MarkupHelper.createLabel("Data on stage and production are verified", ExtentColor.GREEN);
		test.log(Status.INFO, m);
	}

	public void verifyAlphaData(ITestContext context, TableData tableData, Type type) {
		ArrayList<String> tabs = new ArrayList<String>();
		tabs = new ArrayList<String>(driver.getWindowHandles());

		if (tabs.size() == 2) {
			driver.switchTo().window(tabs.get(0));
		}

		this.test.getModel().setName(
				Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + TestManager.getTestName(type));

		Markup mTestDescription = MarkupHelper.createLabel("Parameters: " + TestManager.getTestDescription(tableData),
				ExtentColor.WHITE);
		test.log(Status.INFO, mTestDescription);

		String urlProduction = urlStage;
		SwagletPage swagletPageProd = new SwagletPage(driver, test, urlProduction, type);

		this.test.info("Navigate to prod " + urlProduction);

		swagletPageProd.show();
		Assert.assertTrue(swagletPageProd.isDisplayed(type), TestManager.getTestName(type) + " is not fetched");
		this.test.info(TestManager.getTestName(type) + " Prod is fetched");

		swagletPageProd.setTableParameter(tableData);

		// this.test.info("Populated current values on prod , picture below : prod");
		// getScreenshot(context, "prod");

		swagletPageProd.callService();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

		String validationErrorProd = null;
		TableData tableDataTableResultsProd = null;
		boolean isValidationErrorExistProd = swagletPageProd.isError();
		if (isValidationErrorExistProd) {
			validationErrorProd = swagletPageProd.getValidationError();
		} else {
			tableDataTableResultsProd = swagletPageProd.getListTableResults();

		}

		this.test.info("Data value on prod , picture below : prod data");
		getScreenshot(context, "prod data");

		if (tabs.size() == 1) {
			((JavascriptExecutor) driver).executeScript("window.open()");
			tabs = new ArrayList<String>(driver.getWindowHandles());
		}

		this.test.info("Switch to second tab");

		driver.switchTo().window(tabs.get(1));

		//String urlALPHA = "https://swag-alpha.global.tudor.com/swag/";
		String urlALPHA = "https://swag-stage.global.tudor.com/swag/";

		SwagletPage swagletPageAlpha = new SwagletPage(driver, test, urlALPHA, type);

		this.test.info("Navigate to ALPHA " + urlALPHA);

		swagletPageAlpha.show();
		Assert.assertTrue(swagletPageAlpha.isDisplayed(type), TestManager.getTestName(type) + " is not fetched");
		this.test.info(TestManager.getTestName(type) + " ALPHA is fetched");

		swagletPageAlpha.setTableParameter(tableData);

		// this.test.info("Populated current values on ALPHA , picture below : ALPHA");
		// getScreenshot(context, "ALPHA");

		swagletPageAlpha.callService();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

		String validationErrorAlpha = null;
		TableData tableDataTableResultsAlpha = null;
		boolean isValidationErrorExistAlpha = swagletPageAlpha.isError();
		if (isValidationErrorExistAlpha) {
			validationErrorAlpha = swagletPageAlpha.getValidationError();

		} else {
			tableDataTableResultsAlpha = swagletPageAlpha.getListTableResults();
		}

		this.test.info("Data value on ALPHA , picture below : ALPHA data");
		getScreenshot(context, "ALPHA data");

		if (isValidationErrorExistProd || isValidationErrorExistAlpha) {
			Assert.assertEquals(validationErrorAlpha, validationErrorProd, "Validation error not eqauls");
			Markup m = MarkupHelper.createLabel("Validation ERROR on ALPHA and production, " + validationErrorProd,
					ExtentColor.ORANGE);
			test.log(Status.ERROR, m);

		} else if (tableDataTableResultsProd == null) {
			if (tableDataTableResultsAlpha == null) {
				Assert.assertEquals(true, true, "Env are the same with error");
				Markup m = MarkupHelper.createLabel("Data on ALPHA and production are verified with Exception",
						ExtentColor.PURPLE);
				test.log(Status.WARNING, m);
				//test.log(Status.F, m);
			} else {
				Markup m = MarkupHelper.createLabel("Prod return Exception, Alpha return data", ExtentColor.RED);
				test.log(Status.FATAL, m);
				Assert.assertEquals(false, true, "Prod return Exception, Alpha return data");
			}
		} else if (tableDataTableResultsAlpha == null) {
			Markup m = MarkupHelper.createLabel("Prod return data, Alpha return Exception", ExtentColor.RED);
			test.log(Status.FATAL, m);
			Assert.assertEquals(false, true, "Prod return data, Alpha return Exception");
		} else {
			SoftAssertSwag sas = new SoftAssertSwag();
			sas.assertTableData(tableDataTableResultsAlpha, tableDataTableResultsProd);
			sas.assertAll();
			Markup m = MarkupHelper.createLabel("Data on ALPHA and production are verified", ExtentColor.GREEN);
			test.log(Status.PASS, m);
		}

//		if (tableDataTableResultsProd == null) {
//			if (tableDataTableResultsAlpha == null) {
//
//				Assert.assertEquals(true, true, "Env are the same with error");
//				Markup m = MarkupHelper.createLabel("Data on ALPHA and production are verified with Exception",
//						ExtentColor.ORANGE);
//				test.log(Status.WARNING, m);
//			} else {
//				Markup m = MarkupHelper.createLabel("Prod return Exception, Alpha return data", ExtentColor.RED);
//				test.log(Status.FATAL, m);
//				Assert.assertEquals(false, true, "Prod return Exception, Alpha return data");
//			}
//
//		} else if (tableDataTableResultsAlpha == null) {
//			Markup m = MarkupHelper.createLabel("Prod return data, Alpha return Exception", ExtentColor.RED);
//			test.log(Status.FATAL, m);
//			Assert.assertEquals(false, true, "Prod return data, Alpha return Exception");
//		} else if (isValidationErrorExistAlpha || isValidationErrorExistProd) {
//			Assert.assertEquals(validationErrorAlpha, validationErrorProd, "Validation error not eqauls");
//			Markup m = MarkupHelper.createLabel("Validation ERROR on ALPHA and production, " + validationErrorProd,
//					ExtentColor.LIME);
//			test.log(Status.WARNING, m);
//		} else {
//			SoftAssertSwag sas = new SoftAssertSwag();
//			sas.assertTableData(tableDataTableResultsAlpha, tableDataTableResultsProd);
//			sas.assertAll();
//			Markup m = MarkupHelper.createLabel("Data on ALPHA and production are verified", ExtentColor.GREEN);
//			test.log(Status.PASS, m);
//		}

	}

	public void verifyAlphaDataBy(ITestContext context, TableData tableData, Type type) {
		ArrayList<String> tabs = new ArrayList<String>();
		tabs = new ArrayList<String>(driver.getWindowHandles());

		if (tabs.size() == 2) {
			driver.switchTo().window(tabs.get(0));
		}

		this.test.getModel().setName(
				Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + TestManager.getTestName(type));

		Markup mTestDescription = MarkupHelper.createLabel("Parameters: " + TestManager.getTestDescription(tableData),
				ExtentColor.WHITE);
		test.log(Status.INFO, mTestDescription);

		String urlProduction = urlStage;
		SwagletPage swagletPageProd = new SwagletPage(driver, test, urlProduction, type);

		this.test.info("Navigate to prod " + urlProduction);

		swagletPageProd.show();
		Assert.assertTrue(swagletPageProd.isDisplayed(type), TestManager.getTestName(type) + " is not fetched");
		this.test.info(TestManager.getTestName(type) + " Prod is fetched");

		swagletPageProd.setTableParameter(tableData);

		swagletPageProd.callService();

		TableData tableDataTableResultsProd = null;
		List<TableData> listTblData = new ArrayList<TableData>();
		String validationErrorProd = null;
		boolean isValidationErrorExistProd = swagletPageProd.isError();
		if (isValidationErrorExistProd) {
			validationErrorProd = swagletPageProd.getValidationError();
		} else {
			tableDataTableResultsProd = swagletPageProd.getListTableResults();
			this.test.info("Data value on prod , picture below : prod data");
			getScreenshot(context, "prod data");
			listTblData.add(tableDataTableResultsProd);

			for (int i = 0; i < 4; i++) {
				swagletPageProd.callService();
				tableDataTableResultsProd = swagletPageProd.getListTableResults();
				this.test.info("Data value on prod , picture below : prod data");
				getScreenshot(context, "prod data");
				listTblData.add(tableDataTableResultsProd);

			}
		}

		if (tabs.size() == 1) {
			((JavascriptExecutor) driver).executeScript("window.open()");
			tabs = new ArrayList<String>(driver.getWindowHandles());
		}

		this.test.info("Switch to second tab");

		driver.switchTo().window(tabs.get(1));

		String urlALPHA = "http://tomcat-swag1-alpha:8080/swag/";
		// String urlALPHA = "http://swag:8080/swag/";

		SwagletPage swagletPageAlpha = new SwagletPage(driver, test, urlALPHA, type);

		this.test.info("Navigate to ALPHA " + urlALPHA);

		swagletPageAlpha.show();
		Assert.assertTrue(swagletPageAlpha.isDisplayed(type), TestManager.getTestName(type) + " is not fetched");
		this.test.info(TestManager.getTestName(type) + " ALPHA is fetched");

		swagletPageAlpha.setTableParameter(tableData);

		// this.test.info("Populated current values on ALPHA , picture below : ALPHA");
		// getScreenshot(context, "ALPHA");

		swagletPageAlpha.callService();

		TableData tableDataTableResultsAlpha = null;
		List<TableData> listTblDataAlpha = new ArrayList<TableData>();
		String validationErrorAlpha = null;
		boolean isValidationErrorExistAlpha = swagletPageAlpha.isError();
		if (isValidationErrorExistAlpha) {
			validationErrorAlpha = swagletPageAlpha.getValidationError();
		} else {
			tableDataTableResultsAlpha = swagletPageAlpha.getListTableResults();
			this.test.info("Data value on ALPHA , picture below : ALPHA data");
			getScreenshot(context, "ALPHA data");
			listTblDataAlpha.add(tableDataTableResultsAlpha);
			for (int i = 0; i < 4; i++) {
				swagletPageAlpha.callService();
				tableDataTableResultsAlpha = swagletPageAlpha.getListTableResults();
				this.test.info("Data value on ALPHA , picture below : ALPHA data");
				getScreenshot(context, "ALPHA data");
				listTblDataAlpha.add(tableDataTableResultsAlpha);

			}
		}

		if (isValidationErrorExistProd || isValidationErrorExistAlpha) {
			Assert.assertEquals(validationErrorAlpha, validationErrorProd, "Validation error not eqauls");
			Markup m = MarkupHelper.createLabel("Validation ERROR on ALPHA and production, " + validationErrorProd,
					ExtentColor.ORANGE);
			test.log(Status.ERROR, m);

		} else if (tableDataTableResultsProd == null) {
			if (tableDataTableResultsAlpha == null) {
				Assert.assertEquals(true, true, "Env are the same with error");
				Markup m = MarkupHelper.createLabel("Data on ALPHA and production are verified with Exception",
						ExtentColor.PINK);
				test.log(Status.FAIL, m);
			} else {
				Markup m = MarkupHelper.createLabel("Prod return Exception, Alpha return data", ExtentColor.RED);
				test.log(Status.FATAL, m);
				Assert.assertEquals(false, true, "Prod return Exception, Alpha return data");
			}
		} else if (tableDataTableResultsAlpha == null) {
			Markup m = MarkupHelper.createLabel("Prod return data, Alpha return Exception", ExtentColor.RED);
			test.log(Status.FATAL, m);
			Assert.assertEquals(false, true, "Prod return data, Alpha return Exception");
		} else {
			Boolean ifListContainsEqualsTbl = false;
			SoftAssertSwag sas = new SoftAssertSwag();
			List<Boolean> listCmpTblData = sas.compareListTableData(listTblDataAlpha, listTblData);
			// List<Boolean> listCmpTblData = sas.compareListTableData(listTblDataAlpha,
			// listTblDataAlpha);
			for (int i = 0; i < listCmpTblData.size(); i++) {
				if (listCmpTblData.get(i)) {
					Markup m = MarkupHelper.createLabel("Data on ALPHA and production are verified", ExtentColor.GREEN);
					test.log(Status.PASS, m);
					break;
				} else {
					if (!ifListContainsEqualsTbl) {
						sas.assertListTableData(listTblDataAlpha, listTblData);
						sas.assertAll();
					}
				}
			}
//			sas.assertAll();
//			Markup m = MarkupHelper.createLabel("Data on ALPHA and production are verified", ExtentColor.GREEN);
//			test.log(Status.PASS, m);
		}

//		if (tableDataTableResultsProd == null) {
//			if (tableDataTableResultsAlpha == null) {
//
//				Assert.assertEquals(true, true, "Env are the same with error");
//				Markup m = MarkupHelper.createLabel("Data on ALPHA and production are verified with Exception",
//						ExtentColor.ORANGE);
//				test.log(Status.WARNING, m);
//			} else {
//				Markup m = MarkupHelper.createLabel("Prod return Exception, Alpha return data", ExtentColor.RED);
//				test.log(Status.FATAL, m);
//				Assert.assertEquals(false, true, "Prod return Exception, Alpha return data");
//			}
//
//		} else if (tableDataTableResultsAlpha == null) {
//			Markup m = MarkupHelper.createLabel("Prod return data, Alpha return Exception", ExtentColor.RED);
//			test.log(Status.FATAL, m);
//			Assert.assertEquals(false, true, "Prod return data, Alpha return Exception");
//		} else if (isValidationErrorExistAlpha || isValidationErrorExistProd) {
//			Assert.assertEquals(validationErrorAlpha, validationErrorProd, "Validation error not eqauls");
//			Markup m = MarkupHelper.createLabel("Validation ERROR on ALPHA and production, " + validationErrorProd,
//					ExtentColor.LIME);
//			test.log(Status.WARNING, m);
//		} else {
//			SoftAssertSwag sas = new SoftAssertSwag();
//			sas.assertTableData(tableDataTableResultsAlpha, tableDataTableResultsProd);
//			sas.assertAll();
//			Markup m = MarkupHelper.createLabel("Data on ALPHA and production are verified", ExtentColor.GREEN);
//			test.log(Status.PASS, m);
//		}

	}

	public void verifyAlpha(ITestContext context, TableData tableData, Type type) {
		ArrayList<String> tabs = new ArrayList<String>();
		tabs = new ArrayList<String>(driver.getWindowHandles());

		if (tabs.size() == 2) {
			driver.switchTo().window(tabs.get(0));
		}

		this.test.getModel().setName(
				Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + TestManager.getTestName(type));

		Markup mTestDescription = MarkupHelper.createLabel("Parameters: " + TestManager.getTestDescription(tableData),
				ExtentColor.WHITE);
		test.log(Status.INFO, mTestDescription);

		String urlProduction = urlStage;
		SwagletPage swagletPageProd = new SwagletPage(driver, test, urlProduction, type);

		this.test.info("Navigate to prod " + urlProduction);

		swagletPageProd.show();
		Assert.assertTrue(swagletPageProd.isDisplayed(type), TestManager.getTestName(type) + " is not fetched");
		this.test.info(TestManager.getTestName(type) + " Prod is fetched");

		swagletPageProd.setTableParameter(tableData);

		this.test.info("Populated current values on prod , picture below : prod");
		getScreenshot(context, "prod");

		long start = System.currentTimeMillis();
		swagletPageProd.callService();
		long finish = System.currentTimeMillis();
		long prodTime = finish - start;
		this.test.info("Data value on prod time : " + prodTime);

		TableData tableDataTableResultsProd = swagletPageProd.getTableResults();

		this.test.info("Data value on prod , picture below : prod data");
		getScreenshot(context, "prod data");

		if (tabs.size() == 1) {
			((JavascriptExecutor) driver).executeScript("window.open()");
			tabs = new ArrayList<String>(driver.getWindowHandles());
		}

		this.test.info("Switch to second tab");

		driver.switchTo().window(tabs.get(1));

		// String urlProduction = urlStage.replace("swag-stage:8080", "swag:8080");
		// String urlStage = urlProduction.replace("swag:8080", "swag-stage:8080");
		String urlALPHA = "http://tomcat-swag1-alpha:8080/swag/";

		SwagletPage swagletPageAlpha = new SwagletPage(driver, test, urlALPHA, type);

		this.test.info("Navigate to ALPHA " + urlALPHA);

		swagletPageAlpha.show();
		Assert.assertTrue(swagletPageAlpha.isDisplayed(type), TestManager.getTestName(type) + " is not fetched");
		this.test.info(TestManager.getTestName(type) + " ALPHA is fetched");

		swagletPageAlpha.setTableParameter(tableData);

		this.test.info("Populated current values on ALPHA , picture below : ALPHA");
		getScreenshot(context, "ALPHA");

		long startAlpha = System.currentTimeMillis();
		swagletPageAlpha.callService();
		long finishAlpha = System.currentTimeMillis();
		long alphaTime = finishAlpha - startAlpha;
		this.test.info("Data value on alpha time : " + alphaTime);

		TableData tableDataTableResultsAlpha = swagletPageAlpha.getTableResults();

		this.test.info("Data value on ALPHA , picture below : ALPHA data");
		getScreenshot(context, "ALPHA data");

		SoftAssertSwag sas = new SoftAssertSwag();

		sas.assertTableData(tableDataTableResultsAlpha, tableDataTableResultsProd);
		// sas.assertTableDataByMap(tableDataTableResultsStage,
		// tableDataTableResultsProd);

		sas.assertAll();

		Markup m = MarkupHelper.createLabel("Data on ALPHA and production are verified", ExtentColor.GREEN);
		test.log(Status.INFO, m);
	}

	public void verifyJSONData(ITestContext context, TableData tableData, Type type) {

		ArrayList<String> tabs = new ArrayList<String>();
		tabs = new ArrayList<String>(driver.getWindowHandles());

		if (tabs.size() == 2) {
			driver.close();
			driver.switchTo().window(tabs.get(0));
		}

		this.test.getModel().setName(
				Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + TestManager.getTestName(type));

		Markup mTestDescription = MarkupHelper.createLabel("Parameters: " + TestManager.getTestDescription(tableData),
				ExtentColor.WHITE);
		test.log(Status.INFO, mTestDescription);

		String url = urlStage.replace("swag:8080", "swag-stage:8080");
		// String url = urlStage;
		SwagletPage swagletPage = new SwagletPage(driver, test, url, type);

		this.test.info("Navigate to stage " + url);

		swagletPage.show();
		Assert.assertTrue(swagletPage.isDisplayed(type), TestManager.getTestName(type) + " is not fetched");
		this.test.info(TestManager.getTestName(type) + " Stage is fetched");

		swagletPage.setTableParameter(tableData);

		this.test.info("Populated current values , picture below");
		getScreenshot(context, "");

		swagletPage.callService();

		TableData tableDataTableResults = swagletPage.getTableResults();

		this.test.info("Data value , picture below : data");
		getScreenshot(context, "stage data");

		swagletPage.clickJSON();

		tabs = new ArrayList<String>(driver.getWindowHandles());

		if (tabs.size() == 2) {
			this.test.info("Switch to second tab");
			driver.switchTo().window(tabs.get(1));
		}

		JsonPage jsonPage = new JsonPage(driver, test);

		TableData json = jsonPage.getData();

		SoftAssertSwag sas = new SoftAssertSwag();

		sas.assertTableData(json, tableDataTableResults);

		sas.assertAll();

		Markup m = MarkupHelper.createLabel("Data on stage and JSON page are verified", ExtentColor.GREEN);
		test.log(Status.INFO, m);
	}

	public void verifyHTMLData(ITestContext context, TableData tableData, Type type) {

		ArrayList<String> tabs = new ArrayList<String>();
		tabs = new ArrayList<String>(driver.getWindowHandles());

		if (tabs.size() == 2) {
			driver.close();
			driver.switchTo().window(tabs.get(0));
		}

		this.test.getModel().setName(
				Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + TestManager.getTestName(type));

		Markup mTestDescription = MarkupHelper.createLabel("Parameters: " + TestManager.getTestDescription(tableData),
				ExtentColor.WHITE);
		test.log(Status.INFO, mTestDescription);

		// String url = urlStage.replace("swag:8080", "swag-stage:8080");
		String url = urlStage.replace("swag:8080", "tomcat-swag1-alpha:8080");
		SwagletPage swagletPage = new SwagletPage(driver, test, url, type);

		this.test.info("Navigate to stage " + url);

		swagletPage.show();
		Assert.assertTrue(swagletPage.isDisplayed(type), TestManager.getTestName(type) + " is not fetched");
		this.test.info(TestManager.getTestName(type) + " Stage is fetched");

		swagletPage.setTableParameter(tableData);

		this.test.info("Populated current values , picture below");
		getScreenshot(context, "");

		swagletPage.callService();

		TableData tableDataTableResults = swagletPage.getTableResults();

		this.test.info("Data value , picture below : data");
		getScreenshot(context, "stage data");

		swagletPage.clickHTML();

		tabs = new ArrayList<String>(driver.getWindowHandles());

		if (tabs.size() == 2) {
			this.test.info("Switch to second tab");
			driver.switchTo().window(tabs.get(1));
		}

		HTMLPage htmlPage = new HTMLPage(driver, test);

		TableData json = htmlPage.getData();

		SoftAssertSwag sas = new SoftAssertSwag();

		sas.assertTableData(json, tableDataTableResults);

		sas.assertAll();

		Markup m = MarkupHelper.createLabel("Data on stage and HTML page are verified", ExtentColor.GREEN);
		test.log(Status.INFO, m);
	}

	public void verifyCSVData(ITestContext context, TableData tableData, Type type) {

//		ArrayList<String> tabs = new ArrayList<String>();
//		tabs = new ArrayList<String>(driver.getWindowHandles());
//
//		if (tabs.size() == 2) {
//			driver.close();
//			driver.switchTo().window(tabs.get(0));
//		}

		this.test.getModel().setName(
				Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + TestManager.getTestName(type));

		Markup mTestDescription = MarkupHelper.createLabel("Parameters: " + TestManager.getTestDescription(tableData),
				ExtentColor.WHITE);
		test.log(Status.INFO, mTestDescription);

		String url = urlStage.replace("swag:8080", "swag-stage:8080");
		SwagletPage swagletPage = new SwagletPage(driver, test, url, type);

		this.test.info("Navigate to stage " + url);

		swagletPage.show();
		Assert.assertTrue(swagletPage.isDisplayed(type), TestManager.getTestName(type) + " is not fetched");
		this.test.info(TestManager.getTestName(type) + " Stage is fetched");

		swagletPage.setTableParameter(tableData);

		this.test.info("Populated current values , picture below");
		getScreenshot(context, "");

		swagletPage.callService();

		TableData tableDataTableResults = swagletPage.getTableResults();

		this.test.info("Data value , picture below : data");
		getScreenshot(context, "stage data");

		swagletPage.clickCSV();

		// tabs = new ArrayList<String>(driver.getWindowHandles());

//		if (tabs.size() == 2) {
//			this.test.info("Switch to second tab");
//			driver.switchTo().window(tabs.get(1));
//		}

		TableData csv = FileParser
				.getData(FolderManager.getLatestFilefromDir("C:\\Users\\djanjevi\\Downloads").getPath());

		SoftAssertSwag sas = new SoftAssertSwag();

		sas.assertTableData(csv, tableDataTableResults);

		sas.assertAll();

		Markup m = MarkupHelper.createLabel("Data on stage and HTML page are verified", ExtentColor.GREEN);
		test.log(Status.INFO, m);
	}

	public void verifyXMLData(ITestContext context, TableData tableData, Type type) {

		ArrayList<String> tabs = new ArrayList<String>();
		tabs = new ArrayList<String>(driver.getWindowHandles());

		if (tabs.size() == 2) {
			driver.close();
			driver.switchTo().window(tabs.get(0));
		}

		this.test.getModel().setName(
				Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + TestManager.getTestName(type));

		Markup mTestDescription = MarkupHelper.createLabel("Parameters: " + TestManager.getTestDescription(tableData),
				ExtentColor.WHITE);
		test.log(Status.INFO, mTestDescription);

		String url = urlStage.replace("swag:8080", "swag-stage:8080");
		// String url = urlStage;
		SwagletPage swagletPage = new SwagletPage(driver, test, url, type);

		this.test.info("Navigate to stage " + url);

		swagletPage.show();
		Assert.assertTrue(swagletPage.isDisplayed(type), TestManager.getTestName(type) + " is not fetched");
		this.test.info(TestManager.getTestName(type) + " Stage is fetched");

		swagletPage.setTableParameter(tableData);

		this.test.info("Populated current values , picture below");
		getScreenshot(context, "");

		swagletPage.callService();

		TableData tableDataTableResults = swagletPage.getTableResults();

		this.test.info("Data value , picture below : data");
		getScreenshot(context, "stage data");

		swagletPage.clickXML();

		tabs = new ArrayList<String>(driver.getWindowHandles());

		if (tabs.size() == 2) {
			this.test.info("Switch to second tab");
			driver.switchTo().window(tabs.get(1));
		}

		XMLPage xmlPage = new XMLPage(driver, test);

		TableData xml = xmlPage.getData();

		SoftAssertSwag sas = new SoftAssertSwag();

		sas.assertTableData(xml, tableDataTableResults);

		sas.assertAll();

		Markup m = MarkupHelper.createLabel("Data on stage and XML page are verified", ExtentColor.GREEN);
		test.log(Status.INFO, m);
	}

	public void verifyExcelWebQueryData(ITestContext context, TableData tableData, Type type) {

		ArrayList<String> tabs = new ArrayList<String>();
		tabs = new ArrayList<String>(driver.getWindowHandles());

		if (tabs.size() == 2) {
			driver.close();
			driver.switchTo().window(tabs.get(0));
		}

		this.test.getModel().setName(
				Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + TestManager.getTestName(type));

		Markup mTestDescription = MarkupHelper.createLabel("Parameters: " + TestManager.getTestDescription(tableData),
				ExtentColor.WHITE);
		test.log(Status.INFO, mTestDescription);

		String url = urlStage.replace("swag:8080", "swag-stage:8080");
		// String url = urlStage;
		SwagletPage swagletPage = new SwagletPage(driver, test, url, type);

		this.test.info("Navigate to stage " + url);

		swagletPage.show();
		Assert.assertTrue(swagletPage.isDisplayed(type), TestManager.getTestName(type) + " is not fetched");
		this.test.info(TestManager.getTestName(type) + " Stage is fetched");

		swagletPage.setTableParameter(tableData);

		this.test.info("Populated current values , picture below");
		getScreenshot(context, "");

		swagletPage.callService();

		TableData tableDataTableResults = swagletPage.getTableResults();

		this.test.info("Data value , picture below : data");
		getScreenshot(context, "stage data");

//		swagletPage.clickXML();
//
//		tabs = new ArrayList<String>(driver.getWindowHandles());
//
//		if (tabs.size() == 2) {
//			this.test.info("Switch to second tab");
//			driver.switchTo().window(tabs.get(1));
//		}
//
//		XMLPage xmlPage = new XMLPage(driver, test);
//
//		TableData xml = xmlPage.getData();

		ExcelManager excelManager = new ExcelManager();
		TableData excel = excelManager.getData("H:\\Decembar 2020\\Test.xlsx");

		SoftAssertSwag sas = new SoftAssertSwag();

		// sas.assertTableData(xml, tableDataTableResults);
		sas.assertTableData(excel, tableDataTableResults);

		sas.assertAll();

		Markup m = MarkupHelper.createLabel("Data on stage and XML page are verified", ExtentColor.GREEN);
		test.log(Status.INFO, m);
	}

//	public void verifyXMLData(ITestContext context, TableData tableData, Type type) {
//
//		ArrayList<String> tabs = new ArrayList<String>();
//
//		this.test.getModel().setName(
//				Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + TestManager.getTestName(type));
//
//		Markup mTestDescription = MarkupHelper.createLabel("Parameters: " + TestManager.getTestDescription(tableData),
//				ExtentColor.WHITE);
//		test.log(Status.INFO, mTestDescription);
//
//		String urlProduction = urlStage.replace("swag:8080", "swag-stage:8080");
//		SwagletPage swagletPage = new SwagletPage(driver, test, urlProduction, type);
//
//		this.test.info("Navigate to stage " + urlProduction);
//
//		swagletPage.show();
//		Assert.assertTrue(swagletPage.isDisplayed(type), TestManager.getTestName(type) + " is not fetched");
//		this.test.info(TestManager.getTestName(type) + " Production is fetched");
//
//		swagletPage.setTableParameter(tableData);
//
//		this.test.info("Populated current values , picture below");
//		getScreenshot(context, "production");
//
//		swagletPage.callService();
//
//		this.test.info("Data value , picture below : data");
//		getScreenshot(context, "production data");
//
//		swagletPage.clickXML();
//		
//		tabs = new ArrayList<String>(driver.getWindowHandles());
//
//		if (tabs.size() == 2) {
//			this.test.info("Switch to second tab");
//			driver.switchTo().window(tabs.get(1));
//		}
//
//		XMLPage xmlPage = new XMLPage(driver, test);
//
//		TableData xmlProductionTableData = xmlPage.getData();
//		
//		driver.close();
//		driver.switchTo().window(tabs.get(0));
//
//		String urlStage = urlProduction.replace("swag:8080", "swag-stage:8080");
//
//		SwagletPage swagletPageStage = new SwagletPage(driver, test, urlStage, type);
//
//		this.test.info("Navigate to stage " + urlStage);
//
//		swagletPageStage.show();
//		Assert.assertTrue(swagletPageStage.isDisplayed(type), TestManager.getTestName(type) + " is not fetched");
//		this.test.info(TestManager.getTestName(type) + " Stage is fetched");
//
//		swagletPageStage.setTableParameter(tableData);
//
//		this.test.info("Populated current values on stage , picture below : stage");
//		getScreenshot(context, "stage");
//		
//		swagletPageStage.callService();
//
//		this.test.info("Data value , stage below : data");
//		getScreenshot(context, "stage data");
//
//		swagletPageStage.clickXML();
//		
//		tabs = new ArrayList<String>(driver.getWindowHandles());
//
//		if (tabs.size() == 2) {
//			this.test.info("Switch to second tab");
//			driver.switchTo().window(tabs.get(1));
//		}
//
//		XMLPage xmlPageStage = new XMLPage(driver, test);
//
//		TableData xmlStageTableData = xmlPageStage.getData();
//		
//		driver.close();
//		driver.switchTo().window(tabs.get(0));
//		
//		SoftAssertSwag sas = new SoftAssertSwag();
//
//		sas.assertTableData(xmlProductionTableData, xmlStageTableData);
//
//		sas.assertAll();
//
//		Markup m = MarkupHelper.createLabel("Data on stage and XML page are verified", ExtentColor.GREEN);
//		test.log(Status.INFO, m);
//	}

}
