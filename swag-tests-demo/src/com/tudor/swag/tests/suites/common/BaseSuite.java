package com.tudor.swag.tests.suites.common;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tudor.swag.tests.common.DateManager;
import com.tudor.swag.tests.common.ExtentManager;

public class BaseSuite {

	protected WebDriver driver;
	protected static ExtentReports extent;
	private ExtentTest suiteTest;
	protected ExtentTest test;
	protected String urlStage;

	@BeforeSuite
	public void beforeSuite(ITestContext context) {
		extent = ExtentManager.createInstance(context.getCurrentXmlTest().getParameter("project"),
				context.getCurrentXmlTest().getParameter("browser"),
				Boolean.valueOf(context.getCurrentXmlTest().getParameter("htmlReporter")),
				context.getCurrentXmlTest().getParameter("htmlReportName"),
				context.getCurrentXmlTest().getParameter("htmlReportPath"));

		File folder = new File(context.getCurrentXmlTest().getParameter("screenshotsPath"));
		long size = FileUtils.sizeOfDirectory(folder);
		if (size > 1000000)
			Arrays.stream(new File(context.getCurrentXmlTest().getParameter("screenshotsPath")).listFiles()).forEach(File::delete);
	}

	@BeforeTest
	public void beforeTest() {

	}

	@BeforeClass
	public void beforeClass(ITestContext context) {
		this.urlStage = context.getCurrentXmlTest().getParameter("url");

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

		if (context.getCurrentXmlTest().getParameter("browser").equals("firefox")) {

		} else if (context.getCurrentXmlTest().getParameter("browser").equals("chrome")) {
			desiredCapabilities = DesiredCapabilities.chrome();
			desiredCapabilities.setBrowserName("chrome");
			System.setProperty("webdriver.chrome.driver", context.getCurrentXmlTest().getParameter("chromeDriverPath"));
			this.driver = new ChromeDriver();
		}

		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		this.suiteTest = extent.createTest(getClass().getSimpleName());

		context.setAttribute("SuiteTest", this.suiteTest);
	}

	@BeforeMethod
	public void beforeMethod(Method method, ITestContext context) {
		this.test = this.suiteTest.createNode(method.getName());
	}

	@Parameters({ "htmlReporter", "htmlReportPath" })
	@AfterMethod
	public void afterMethod(ITestResult result, boolean htmlRreporter, String htmlReportPath) {
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				String base64String = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
				this.test.log(Status.FAIL, result.getThrowable(),
						MediaEntityBuilder.createScreenCaptureFromBase64String(base64String).build());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (result.getStatus() == ITestResult.SKIP) {
			this.test.log(Status.SKIP, result.getThrowable());
		}
	}

	@AfterClass
	public void afterClass() {
		this.driver.quit();
	}

	@AfterTest
	public void afterTest(ITestContext context) {
		// this.driver.quit();
	}

	@AfterSuite
	public void afterSuite() {
		extent.flush();
	}

	public String captureScreen(ITestContext context) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = context.getCurrentXmlTest().getParameter("screenshotsPath") + "//"+ DateManager.getCurrentDateTime() + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	public void getScreenshot(ITestContext context, String name) {
		String screenShotName = "";
		try {
			screenShotName = captureScreen(context);
			screenCapture(name, screenShotName);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Object screenCapture(String logDetails, String imagePath) throws IOException {
		test.log(Status.INFO, logDetails, MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());
		return test;
	}
	
}
