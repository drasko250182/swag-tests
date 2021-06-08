package com.tudor.swag.tests.common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	public static ExtentReports createInstance(String project, String browser, boolean htmlReporter,
			String htmlReportName, String htmlReportPath) {
		ExtentReports extent = new ExtentReports();

		if (htmlReporter) {
			ExtentHtmlReporter reporter = new ExtentHtmlReporter(
					htmlReportPath + "/" + htmlReportName + "_" + browser + ".html");
			extent.attachReporter(reporter);

			// reporter.loadXMLConfig("logger-config.xml");
			reporter.config().setTheme(Theme.DARK);
		}

		return extent;
	}

}
