package com.tudor.swag.tests.pages.common;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.tudor.swag.tests.common.JsoupParser;
import com.tudor.swag.tests.utils.Cell;
import com.tudor.swag.tests.utils.Row;
import com.tudor.swag.tests.utils.TableData;
import com.tudor.swag.tests.utils.Cell.State;

public class HTMLPage extends BasePage {

	@Override
	public BasePage show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public HTMLPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	private WebElement getTable() {
		try {
			return this.driver.findElement(By.xpath(".//table"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("Could not find div formatted Json", e);
		}
	}

	public TableData getData() {
		TableData tableData = new TableData();
		List<Row> rows = new ArrayList<Row>();

		String tableHTML = this.getTable().getAttribute("outerHTML");
		Document tableDoc = Jsoup.parse(tableHTML);
		tableDoc.outputSettings(new Document.OutputSettings().prettyPrint(false));

		Elements items = tableDoc.getElementsByTag("tr");

		for (int i = 0; i < items.size(); i++) {
			if (i == 0) {
				List<Cell> cells = new ArrayList<Cell>();
				Elements itemsHeader = items.get(i).getElementsByTag("th");
				for (int j = 0; j < itemsHeader.size(); j++) {
					// stringHeader.add(itemsHeader.get(j).text());
					Cell cell = new Cell(State.READ, itemsHeader.get(j).text());
					cells.add(cell);
				}
				Row row = new Row(cells);
				rows.add(row);
			} else {
				List<Cell> cells = new ArrayList<Cell>();
				Elements itemsRow = items.get(i).getElementsByTag("td");
				for (int j = 0; j < itemsRow.size(); j++) {

					if (itemsRow.get(j).getElementsByTag("input").size() > 0) {
						String xpath = JsoupParser.getWebElementLocator(itemsRow.get(j).outerHtml());

						WebElement weTemp = null;
						try {
							weTemp = driver.findElement(By.xpath(xpath));
						} catch (Exception e) {
							e.printStackTrace();
							throw new AssertionError("Could not find input field ", e);
						}
						Cell cell = new Cell(State.WRITE, weTemp.getAttribute("value"));

						cells.add(cell);
					} else {
						Cell cell = new Cell(State.READ, itemsRow.get(j).text());
						cells.add(cell);
					}

				}
				Row row = new Row(cells);
				rows.add(row);

			}
		}

		tableData.setRows(rows);

		return tableData;
	}

}
