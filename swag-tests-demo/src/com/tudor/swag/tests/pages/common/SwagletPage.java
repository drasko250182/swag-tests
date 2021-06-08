package com.tudor.swag.tests.pages.common;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.tudor.swag.tests.common.FolderManager;
import com.tudor.swag.tests.utils.Column;
import com.tudor.swag.tests.utils.TableControl;
import com.tudor.swag.tests.utils.TableData;

public class SwagletPage extends BasePage {

	public enum Type {

		// compliance,
		COMPLIANCE_RESTRICTED_INSTRUMENTS_INDEX("compliance/restrictedInstruments/index?help=true&verbose=true"),

		// cube
		CUBE_PnL_CUBE_INDEX("cube/pnLCube/index?help=true&verbose=true"),
		CUBE_RISK_CUBE_INDEX("cube/riskCube/index?help=true&verbose=true"),

		// itadmin, tudorUsers -> index
		ITADMIN_TRADER_PERMISSIONS_INDEX("itadmin/traderPermissions/index?help=true&verbose=true"),
		ITADMIN_TUDOR_APP_PERMISSIONS_INDEX("itadmin/tudorAppPermissions/index?help=true&verbose=true"),
		ITADMIN_TUDOR_APPS_INDEX("itadmin/tudorApps/index?help=true&verbose=true"),
		ITADMIN_TUDOR_USERS_INDEX("itadmin/tudorUsers/index?help=true&verbose=true"),

		// orders
		ORDERS_ALLOCATIONS_EQUITIES_EQUITIES("orders/allocationsEquities/equities?help=true&verbose=true"),
		ORDERS_ALLOCATIONS_EQUITIES_INDEX("orders/allocationsEquities/index?help=true&verbose=true"),
		ORDERS_ALLOCATIONS_NOTIONALS_INDEX("orders/allocationsNotionals/index?help=true&verbose=true"),
		ORDERS_ALLOCATIONS_NOTIONALS_NOTIONALS("orders/allocationsNotionals/notionals?help=true&verbose=true"),
		ORDERS_SYSTEMS_ALLOC_REBALANCE_REPORT_FROMFILE(
				"orders/systemsAllocRebalanceReport/fromFile?help=true&verbose=true"),
		ORDERS_SYSTEMS_ALLOC_REBALANCE_REPORT_INDEX("orders/systemsAllocRebalanceReport/index?help=true&verbose=true"),

		// performance
		PERFORMANCE_ACCOUNT_PERFORMANCE_BY_ACCOUNT("performance/accountPerformance/byAccount?help=true&verbose=true"),
		PERFORMANCE_ACCOUNT_PERFORMANCE_INDEX("performance/accountPerformance/index?help=true&verbose=true"),
		PERFORMANCE_FUND_PERFORMANCE_BY_FUND("performance/fundPerformance/byFund?help=true&verbose=true"),
		PERFORMANCE_FUND_PERFORMANCE_INDEX("performance/fundPerformance/index?help=true&verbose=true"),
		PERFORMANCE_GROUP_SUMMARY_INDEX("performance/groupSummary/index?help=true&verbose=true"),
		PERFORMANCE_SYSTEMS_NOTIONAL_INDEX("performance/systemsNotional/index?help=true&verbose=true"),
		PERFORMANCE_TRADER_PERFORMANCE_BY_SUBFUND("performance/traderPerformance/bySubfund?help=true&verbose=true"),
		PERFORMANCE_TRADER_PERFORMANCE_BY_TRADER("performance/traderPerformance/byTrader?help=true&verbose=true"),
		PERFORMANCE_TRADER_PERFORMANCE_BY_TRADER_AND_PnL_ITEM(
				"performance/traderPerformance/byTraderAndPnLItem?help=true&verbose=true"),
		PERFORMANCE_TRADER_PERFORMANCE_BY_TRADER_GROUP(
				"performance/traderPerformance/byTraderGroup?help=true&verbose=true"),
		PERFORMANCE_TRADER_PERFORMANCE_BY_TRADER_GROUP_AND_PnL_ITEM(
				"performance/traderPerformance/byTraderGroupAndPnLItem?help=true&verbose=true"),
		PERFORMANCE_TRADER_PERFORMANCE_INDEX("performance/traderPerformance/index?help=true&verbose=true"),

		// pnl
		PNL_PnL_ACTIVE_NAME_QUERY_INDEX("pnl/pnLActiveNameQuery/index?help=true&verbose=true"),
		PNL_PnL_ACTIVE_NAME_QUERY_ADVANCED_INDEX("pnl/pnLActiveNameQueryAdvanced/index?help=true&verbose=true"),
		PNL_PnL_QUERY_INDEX("pnl/pnLQuery/index?help=true&verbose=true"),
		PNL_PnL_QUERY_ADVANCED_INDEX("pnl/pnLQueryAdvanced/index?help=true&verbose=true"),
		PNL_PnL_REPORT_INDEX("pnl/pnlReport/index?help=true&verbose=true"),
		PNL_POSITION_REPORT_INDEX("pnl/positionReport/index?help=true&verbose=true"),

		// pricing
		PRICING_CURVE_INDEX("pricing/curve/index?help=true&verbose=true"),
		PRICING_FRA_QUERY_INDEX("pricing/fraQuery/index?help=true&verbose=true"),
		PRICING_FX_CROSESS_INDEX("pricing/fxCrosses/index?help=true&verbose=true"),
		PRICING_IR_FUTURE_QUERY_INDEX("pricing/irFutureQuery/index?help=true&verbose=true"),

		// risk
		RISK_FUND_RISK_AND_LIQUDITY_SUMMARY_INDEX("risk/fundRiskAndLiquiditySummary/index?help=true&verbose=true"),
		RISK_FX_EXPOSURE_INDEX("risk/fxExposure/index?help=true&verbose=true"),
		RISK_HISTORIC_VAR_QUERY_INDEX("risk/historicVaRQuery/index?help=true&verbose=true"),
		RISK_INPUT_DATE_INDEX("risk/inputDate/index?help=true&verbose=true"),
		RISK_INTERACTIVE_SUMMARY_INDEX("risk/interactiveSummary/index?help=true&verbose=true"),
		RISK_INTERACTIVE_SUMMARY_SIMULATION_SERIES("risk/interactiveSummary/simulationSeries?help=true&verbose=true"),
		RISK_PnL_SIMULATION_SERIES_INDEX("risk/pnlSimulationSeries/index?help=true&verbose=true"),
		RISK_PnL_SIMULATION_SERIES_BY_TRADER_INDEX("risk/pnlSimulationSeriesByTrader/index?help=true&verbose=true"),
		RISK_SUBFUND_DRAWDOWNS_INDEX("risk/subFundDrawdowns/index?help=true&verbose=true"),
		RISK_SUBFUND_PnL_INDEX("risk/subFundPnl/index?help=true&verbose=true"),
		RISK_TOP_RISK_FACTORS_FOR_FUND_INDEX("risk/topRiskFactorsForFund/index?help=true&verbose=true"),
		RISK_TRADER_COMMODITY_EXPOSURE_INDEX("risk/traderCommodityExposure/index?help=true&verbose=true"),
		RISK_TRADER_EQUITY_EXPOSURE_INDEX("risk/traderEquityExposure/index?help=true&verbose=true"),
		RISK_TRADER_FIX_INCOME_EXPOSURE_INDEX("risk/traderFixIncomeExposure/index?help=true&verbose=true"),
		RISK_TRADER_FX_EXPOSURE_INDEX("risk/traderFxExposure/index?help=true&verbose=true"),
		RISK_TRADER_GROUP_FUND_BATCH_HISTORY_INDEX("risk/traderGroupFundBatchHistory/index?help=true&verbose=true"),
		RISK_TRADER_POINTS_ALERT_INDEX("risk/traderPointsAlert/index?help=true&verbose=true"),
		RISK_TRADER_RISK_FACTOR_INDEX("risk/traderRiskFactor/index?help=true&verbose=true"),
		RISK_TRADER_RISK_STATISTICS_INDEX("risk/traderRiskStatistics/index?help=true&verbose=true"),

		// swag
		SWAG_USER_PERMISSIONS_INDEX("swag/userPermissions/index?help=true&verbose=true");

		private String url;

		Type(String url) {
			this.url = url;
		}

		public String getUrl() {
			return url;
		}

	}

	private TableControl tableParameters;

	public SwagletPage(WebDriver driver, ExtentTest test, String url, Type swagletType) {
		super(driver, test, url + swagletType.getUrl());
	}

	@Override
	public boolean isDisplayed() {
		return true;
	}

	@Override
	public BasePage show() {
		this.driver.get(url);
		this.driver.manage().window().maximize();
		return this;
	}

	private WebElement getTitle() {
		try {
			return this.driver.findElement(By.xpath(".//title"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("Could not find title", e);
		}
	}

	private WebElement getTblParameter() {
		try {
			return this.driver.findElement(By.xpath(".//table"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("Could not find table parameters", e);
		}
	}

	private WebElement getTblResults() {
		try {
			this.driver.findElement(By.xpath(".//div[@id='callResults']/table/tbody/tr/th"));
			return this.driver.findElement(By.xpath(".//div[@id='callResults']/table"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("Could not find table results", e);
		}
	}

	private List<WebElement> getListTblResults() {
		return this.driver.findElements(By.xpath(".//div[@id='callResults']/table"));
//		try {
//			this.driver.findElement(By.xpath(".//div[@id='callResults']/table/tbody/tr/th"));
//			return this.driver.findElement(By.xpath(".//div[@id='callResults']/table"));
//		} catch (Exception e) {
//			e.printStackTrace();
//			//throw new AssertionError("Could not find table results", e);
//			return null;
//		}
	}

	private List<WebElement> getListRowValidationError() {
		return this.driver.findElements(By.xpath(".//div[@id='callResults']/table/tbody/tr/td/font"));
	}

	private WebElement getBtnCallService() {
		try {
			return driver.findElement(By.xpath(".//input[@id='callService']"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("Could not find button call service", e);
		}
	}

	private WebElement getImgSpinner() {
		try {
			return driver.findElement(By.xpath(".//img[@id='spinner']"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("Could not find image spinner", e);
		}
	}

	private WebElement getLnkJSON() {
		try {
			return driver.findElement(By.xpath(".//a[@id='linkWithParams_json']"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("Could not find link JSON", e);
		}
	}

	private WebElement getLnkHTML() {
		try {
			return driver.findElement(By.xpath(".//a[@id='linkWithParams_html']"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("Could not find link HTML", e);
		}
	}

	private WebElement getLnkXML() {
		try {
			return driver.findElement(By.xpath(".//a[@id='linkWithParams_xml']"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("Could not find link XML", e);
		}
	}

	private WebElement getLnkCSV() {
		try {
			return driver.findElement(By.xpath(".//a[@id='linkWithParams_csv']"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("Could not find link CSV", e);
		}
	}

	public boolean isDisplayed(Type type) {
		WebElement weTitle = this.getTitle();

		String url = type.getUrl();
		String title = url.substring(url.indexOf("/") + 1, url.indexOf("/", url.indexOf("/") + 1));

		switch (title) {
		case "restrictedInstruments":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "pnLCube":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "riskCube":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "traderPermissions":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "tudorAppPermissions":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "tudorApps":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "tudorUsers":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "allocationsEquities":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "allocationsNotionals":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "systemsAllocRebalanceReport":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "accountPerformance":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "fundPerformance":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "groupSummary":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "systemsNotional":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "traderPerformance":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "pnLActiveNameQuery":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "pnLActiveNameQueryAdvanced":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "pnLQuery":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "pnLQueryAdvanced":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "pnlReport":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "positionReport":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "curve":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "fraQuery":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "fxCrosses":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "irFutureQuery":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "fundRiskAndLiquiditySummary":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "fxExposure":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "historicVaRQuery":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "inputDate":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "interactiveSummary":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "pnlSimulationSeries":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "pnlSimulationSeriesByTrader":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "subFundDrawdowns":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "subFundPnl":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "topRiskFactorsForFund":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "traderCommodityExposure":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "traderEquityExposure":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "traderFixIncomeExposure":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
		case "traderFxExposure":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "traderGroupFundBatchHistory":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "traderPointsAlert":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;
		case "traderRiskFactor":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
		case "traderRiskStatistics":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
		case "userPermissions":
			if (weTitle.getAttribute("innerHTML").contains(title))
				return true;
			break;

		default:
			break;
		}

		return false;
	}

	public BasePage waitForDataToBeRendered() {
		try {
//			new WebDriverWait(this.driver, 300)
//			.until(ExpectedConditions.attributeToBe(this.getImgSpinner(), "style", ""));
			new WebDriverWait(this.driver, 5).until(ExpectedConditions
					.not(ExpectedConditions.attributeContains(this.getImgSpinner(), "style", "display: none;")));
			new WebDriverWait(this.driver, 600)
					.until(ExpectedConditions.attributeContains(this.getImgSpinner(), "style", "display: none;"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return this;
	}

	public BasePage callService() {
		this.test.info("Click on button call service");
		this.getBtnCallService().click();
		this.test.info("Button call service is pressed");
		this.test.info("Wait for data to be rendered");
		this.waitForDataToBeRendered();
		return this;
	}

	public void setTableParameter(List<Column> columns) {
		new TableControl(driver, this.getTblParameter()).setData(columns);
	}

	public void setTableParameter(TableData tableData) {
		// new TableControl(driver, this.getTblParameter()).setData(tableData);
		this.tableParameters = new TableControl(driver, this.getTblParameter());
		this.tableParameters.setData(tableData);
	}

	public TableData getTableResults() {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		TableControl tableControl = new TableControl(driver, this.getTblResults());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return tableControl.getData();
	}

	public TableData getListTableResults() {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> listTbLResults = this.getListTblResults();
		if (listTbLResults.size() == 0) {
			return null;
		} else {
			TableControl tableControl = new TableControl(driver, listTbLResults.get(0));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return tableControl.getData();
		}
	}

	public String getValidationError() {
		// return
		// this.getListRowValidationError().get(0).findElement(By.xpath(".//tbody/descendant::font")).getText();
		return this.getListRowValidationError().get(0).getText();
	}

	public boolean ifValidationErrorExist() {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		if (this.getListRowValidationError().size() == 1) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return true;
		} else {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return false;
		}

	}

	public boolean isError() {
		WebElement weCallService = driver.findElement(By.xpath(".//div[@id='callResults']"));
		String tableHTML = weCallService.getAttribute("outerHTML");
		Document tableDoc = Jsoup.parse(tableHTML);
		tableDoc.outputSettings(new Document.OutputSettings().prettyPrint(false));

		Elements items = tableDoc.getElementsByTag("font");
		// long startGetAll = System.currentTimeMillis();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		if (items.size() == 1) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// long finishGetAll = System.currentTimeMillis();
			// long getAllTime = finishGetAll - startGetAll;
			// System.out.println("GEt on prod time : " + getAllTime);
			return true;
		} else {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// long finishGetAll = System.currentTimeMillis();
			// long getAllTime = finishGetAll - startGetAll;
			// System.out.println("Validation time : " + getAllTime);
			return false;
		}

//		long startGetAll = System.currentTimeMillis();
//		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//		if (this.getListRowValidationError().size() == 1) {
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			long finishGetAll = System.currentTimeMillis();
//			long getAllTime = finishGetAll - startGetAll;
//			System.out.println("GEt on prod time : " + getAllTime);
//			return true;
//		} else {
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			long finishGetAll = System.currentTimeMillis();
//			long getAllTime = finishGetAll - startGetAll;
//			System.out.println("Validation time : " + getAllTime);
//			return false;
//		}

	}

	public boolean isResultReturn() {
		if (this.getTableResults().equals(null)) {
			return false;
		} else {
			return true;
		}
	}

	public BasePage clickJSON() {
		this.test.info("Click on JSON link");
		this.getLnkJSON().click();
		this.test.info("JSON link is pressed");
		return this;
	}

	public BasePage clickHTML() {
		this.test.info("Click on HTML link");
		this.getLnkHTML().click();
		this.test.info("HTML link is pressed");
		return this;
	}

	public BasePage clickXML() {
		this.test.info("Click on XML link");
		this.getLnkXML().click();
		this.test.info("XML link is pressed");
		return this;
	}

	public BasePage clickCSV() {
		this.test.info("Click on CVS link");
//		File folder = new File("C:\\Users\\djanjevi\\Downloads");
//		long size = FileUtils.sizeOfDirectory(folder);
//		System.out.println(size);
		File lastFile = FolderManager.getLatestFilefromDir("C:\\Users\\djanjevi\\Downloads");
		// System.out.println(lastFile.getName());
		this.getLnkCSV().click();
		this.waitDownloaded(lastFile);
		// File folder = new File("C:\\Users\\djanjevi\\Downloads");
		// size = FileUtils.sizeOfDirectory(folder);
		// System.out.println(size);
		this.test.info("CSV link is pressed");
		return this;
	}

	public BasePage waitDownloaded(File lastFile) {
		// while(lastFile ==
		// FolderManager.getLatestFilefromDir("C:\\Users\\djanjevi\\Downloads")) {
		while (lastFile.getName()
				.equals(FolderManager.getLatestFilefromDir("C:\\Users\\djanjevi\\Downloads").getName())) {
			// System.out.println(FolderManager.getLatestFilefromDir("C:\\Users\\djanjevi\\Downloads").getName());
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return this;
	}

}
