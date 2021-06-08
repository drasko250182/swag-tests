package com.tudor.swag.tests.pages.common;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public abstract class BasePage {

	protected WebDriver driver;
	protected ExtentTest test;
	protected String url;

	public BasePage(WebDriver driver, ExtentTest test, String url) {
		this.driver = driver;
		this.test = test;
		this.url = url;
	}
	
	public BasePage() {
		
	}

	public abstract BasePage show();
	
	public abstract boolean isDisplayed();

}
