package com.tudor.swag.tests.pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

public class MainPage extends BasePage {

	public MainPage(WebDriver driver, ExtentTest test, String url) {
		super(driver, test, url);
	}

	@Override
	public BasePage show() {
		return null;
	}

	private WebElement getHlnkOrdersAllocationsEquitiesEquities() {
		try {
			return driver.findElement(
					By.xpath(".//a[@href='orders/allocationsEquities/equities?help=true&amp;verbose=true']"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("Could not find button call service", e);
		}
	}

	public void navigateToOrdersAllocationsEquitiesEquitiesPage() {
		WebElement weHlnkOrdersAllocationsEquitiesEquities = this.getHlnkOrdersAllocationsEquitiesEquities();
		weHlnkOrdersAllocationsEquitiesEquities.click();
	}

	@Override
	public boolean isDisplayed() {
		return false;
	}

}
