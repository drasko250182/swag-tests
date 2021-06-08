package com.tudor.swag.tests.pages.common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.tudor.swag.tests.common.JsoupParser;
import com.tudor.swag.tests.pages.common.SwagletPage.Type;
import com.tudor.swag.tests.utils.Cell;
import com.tudor.swag.tests.utils.Row;
import com.tudor.swag.tests.utils.TableControl;
import com.tudor.swag.tests.utils.TableData;
import com.tudor.swag.tests.utils.Cell.State;

public class JsonPage extends BasePage {

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

	public JsonPage(WebDriver driver, ExtentTest test, String url, Type swagletType) {
		super(driver, test, url + swagletType.getUrl());
	}

	public JsonPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private WebElement getDivFormattedJson() {
		try {
			return this.driver.findElement(By.xpath(".//div[@id='formattedJson"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("Could not find div formatted Json", e);
		}
	}

	private WebElement getPreTag() {
		try {
			return this.driver.findElement(By.xpath(".//pre"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("Could not find div formatted Json", e);
		}
	}

	public TableData getData() {
		TableData tableData = new TableData();
		List<Row> rows = new ArrayList<Row>();

		WebElement wePre = this.getPreTag();
		String response = wePre.getText();

		String[] values = response.split("}");

		// String[] headerCells = values[0].split(",");
		String[] headerCells = values[0].split("\":");
		List<Cell> cellsHeader = new ArrayList<Cell>();
		for (int j = 0; j < headerCells.length - 1; j++) {
			Integer headerStart;
			Integer headerEnd;
			if (j == 0) {
				headerStart = headerCells[j].indexOf("]") + 4;
				headerEnd = headerCells[j].length();
				Cell cell = new Cell(State.READ, headerCells[j].substring(headerStart, headerEnd));
				cellsHeader.add(cell);
			} else {
				headerStart = headerCells[j].indexOf(",") + 2;
				headerEnd = headerCells[j].length();
				Cell cell = new Cell(State.READ, headerCells[j].substring(headerStart, headerEnd));
				cellsHeader.add(cell);

			}
			// cellsHeader.add(cell);
		}

//		String[] headerCells = values[0].split(",(?![^()]*+\\))");
//		List<Cell> cellsHeader = new ArrayList<Cell>();
//		for (int j = 0; j < headerCells.length; j++) {
//			if (j == 0) {
//				Cell cell = new Cell(State.READ, headerCells[j].substring(3, headerCells[j].indexOf("\"", 3)));
//				cellsHeader.add(cell);
//			} else {
//				if (headerCells[j].indexOf("\"", 2) != -1) {
//					Cell cell = new Cell(State.READ, headerCells[j].substring(1, headerCells[j].indexOf("\"", 2)));
//					cellsHeader.add(cell);
//				}
//			}
//			// cellsHeader.add(cell);
//		}
		Row rowHeader = new Row(cellsHeader);
		rows.add(rowHeader);

		for (int i = 0; i < values.length - 1; i++) {
			// String[] splitCells = values[i].split(",");
			String[] splitCells = values[i].split("\":");
			// String[] splitCells =
			// values[i].split(",(?=(((?!\\]).)*\\[)|[^\\[\\]]*$)(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
			// String[] splitCells = values[i].split(",(?![^()]*+\\))");
			// String[] splitCells = values[i].split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			List<Cell> cells = new ArrayList<Cell>();
			for (int j = 1; j < splitCells.length; j++) {
				Integer start = null;
				Integer end = null;
				if (j == splitCells.length - 1) {
					if (splitCells[j].contains("\"")) {
						if (splitCells[j].substring(0, 1).equals("\"") || splitCells[j].substring(1, 2).equals("\"")) {
							start = 1;
							end = splitCells[j].length() - 1;
						}
					} else {
						start = 0;
						end = splitCells[j].length();
					}
				} else {
					if (splitCells[j].substring(0, 1).equals("[")) {
						start = 2;
						end = splitCells[j].indexOf("]");
					} else {
						start = 0;
						end = splitCells[j].indexOf(",");
						if (splitCells[j].substring(0, 1).equals("\"") || splitCells[j].substring(1, 2).equals("\"")) {
							start = 1;
							// end = splitCells[j].indexOf(",") - 1;
							end = splitCells[j].lastIndexOf("\"") - 2;
						}
					}
				}
				Cell cell = new Cell(State.READ, splitCells[j].substring(start, end).trim());
				cells.add(cell);

//				if (!splitCells[j].equals("")) {
//					Integer start = splitCells[j].indexOf("\":");
//					if (splitCells[j].substring(start + 2, start + 3).equals("\"")) {
//						start = start + 3;
//					} else {
//						start = start + 2;
//					}
//
//					Integer end = -1;
//					if (splitCells[j].substring(splitCells[j].length() - 1, splitCells[j].length()).equals("\"")) {
//						end = splitCells[j].length() - 1;
//					} else {
//						end = splitCells[j].length();
//					}
//					Cell cell = new Cell(State.READ, splitCells[j].substring(start, end).trim());
//					cells.add(cell);
//				}

			}
			Row row = new Row(cells);
			rows.add(row);
		}

//		for (int i = 0; i < values.length - 1; i++) {
//			// String[] splitCells = values[i].split(","); 
//			String[] splitCells = values[i].split(",(?=(((?!\\]).)*\\[)|[^\\[\\]]*$)(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
//			//String[] splitCells = values[i].split(",(?=(((?!\\]).)*\\[)|[^\\[\\]]*$)(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
//			//String[] splitCells = values[i].split(",(?![^()]*+\\))");
//			//String[] splitCells = values[i].split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
//			List<Cell> cells = new ArrayList<Cell>();
//			for (int j = 0; j < splitCells.length; j++) {
//
//				if (!splitCells[j].equals("")) {
//					Integer start = splitCells[j].indexOf("\":");
//					if (splitCells[j].substring(start + 2, start + 3).equals("\"")) {
//						start = start + 3;
//					} else {
//						start = start + 2;
//					}
//
//					Integer end = -1;
//					if (splitCells[j].substring(splitCells[j].length() - 1, splitCells[j].length()).equals("\"")) {
//						end = splitCells[j].length() - 1;
//					} else {
//						end = splitCells[j].length();
//					}
//					Cell cell = new Cell(State.READ, splitCells[j].substring(start, end).trim());
//					cells.add(cell);
//				}
//
//			}
//			Row row = new Row(cells);
//			rows.add(row);
//		}

		tableData.setRows(rows);

		return tableData;
	}

//	public TableData getData() {
//		TableData tableData = new TableData();
//		List<Row> rows = new ArrayList<Row>();
//
//		WebElement weDivFormattedJson = this.getDivFormattedJson();
//
//		String tableHTML = weDivFormattedJson.getAttribute("outerHTML");
//		Document tableDoc = Jsoup.parse(tableHTML);
//		tableDoc.outputSettings(new Document.OutputSettings().prettyPrint(false));
//
//		Elements items = tableDoc.getElementsByClass("blockInner");
//
//		for (int i = 1; i < items.size(); i++) {
//			if (i == 0) {
//				List<Cell> cells = new ArrayList<Cell>();
//				Elements itemsNode = items.get(i).getElementsByClass("kvov objProp");
//				for (int j = 0; j < itemsNode.size(); j++) {
//					itemsNode.get(j).getElementsByTag("span");
//					Cell cell = new Cell(State.READ, itemsNode.get(j).getElementsByTag("span").get(1).text());
//					cells.add(cell);
//				}
////			} else {
////				List<Cell> cells = new ArrayList<Cell>();
////				Elements itemsRow = items.get(i).getElementsByTag("td");
////				for (int j = 0; j < itemsRow.size(); j++) {
////
////					if (itemsRow.get(j).getElementsByTag("input").size() > 0) {
////						String xpath = JsoupParser.getWebElementLocator(itemsRow.get(j).outerHtml());
////
////						WebElement weTemp = null;
////						try {
////							weTemp = driver.findElement(By.xpath(xpath));
////						} catch (Exception e) {
////							e.printStackTrace();
////							throw new AssertionError("Could not find input field ", e);
////						}
////						Cell cell = new Cell(State.WRITE, weTemp.getAttribute("value"));
////
////						cells.add(cell);
////					} else {
////						Cell cell = new Cell(State.READ, itemsRow.get(j).text());
////						cells.add(cell);
////					}
////
////				}
//				Row row = new Row(cells);
//				rows.add(row);
//
//			}
//		}
//
//		tableData.setRows(rows);
//
//		return tableData;
//	}
}
