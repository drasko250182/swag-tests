package com.tudor.swag.tests.pages.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class XMLPage extends BasePage {

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

	public XMLPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public TableData getData() {
		TableData tableData = new TableData();
		HashMap<Integer, Boolean> mapIfValueExist = new HashMap<>();
		List<Row> rows = new ArrayList<Row>();

		List<WebElement> weListRows = this.driver.findElements(By.xpath(".//row"));
		Row rowHeader = null;

		for (int i = 0; i < weListRows.size(); i++) {
			String stringRow = weListRows.get(i).getAttribute("innerHTML");
			List<Cell> cells = new ArrayList<Cell>();
			if (i == 0) {
				List<Cell> cellsHeader = new ArrayList<Cell>();
				// Pattern pattern = Pattern.compile("</(.*?)>", Pattern.DOTALL);
				Pattern pattern = Pattern.compile("<(.*?)>", Pattern.DOTALL);
				Matcher matcher = pattern.matcher(stringRow);
				Integer headerCounter = 0;
				while (matcher.find()) {
					if (matcher.group(1).contains("/")) {
//						Cell cell = new Cell(State.READ, matcher.group(1).substring(1));
//						cellsHeader.add(cell);

						if (matcher.group(1).substring(0, 1).equals("/")) {
							Cell cell = new Cell(State.READ, matcher.group(1).substring(1));
							cellsHeader.add(cell);
							mapIfValueExist.put(headerCounter, true);
							headerCounter++;
						} else {
							Cell cell = new Cell(State.READ,
									matcher.group(1).substring(0, matcher.group(1).length() - 1));
							cellsHeader.add(cell);
							mapIfValueExist.put(headerCounter, false);
							headerCounter++;
						}
					}
					// headerCounter++;
				}
				rowHeader = new Row(cellsHeader);
				rows.add(rowHeader);
			}

//			//Pattern pattern_1 = Pattern.compile(">(.*?)</", Pattern.DOTALL);
//			Pattern pattern_1 = Pattern.compile("<(.*?)/", Pattern.DOTALL);
//			Matcher matcher_1 = pattern_1.matcher(stringRow);
//			Integer cellCounter = 0;
//			while (matcher_1.find()) {
//				String temp = matcher_1.group(1);
//				if (temp.indexOf(">") == -1) {
//					System.out.println(temp);
//					Cell cell = new Cell(State.READ, temp);
//					cells.add(cell);

//				} else {
//
//					if (temp.contains("/>")) {
//						Cell cellEmpty = new Cell(State.READ, "");
//						cells.add(cellEmpty);
//					}
//
//					//String tempValue = temp.substring(temp.indexOf(">") + 1, temp.length());
//					String tempValue = temp.substring(temp.lastIndexOf(">") + 1, temp.length());
//					System.out.println(tempValue);
//					Cell cell = new Cell(State.READ, tempValue);
//					cells.add(cell);
//				}
//				cellCounter++;
//			}

			Pattern pattern_1 = Pattern.compile(">(.*?)<", Pattern.DOTALL);
			// Pattern pattern_1 = Pattern.compile("<(.*?)/", Pattern.DOTALL);
			Matcher matcher_1 = pattern_1.matcher(stringRow);
			Integer cellCounter = 0;
			// for(int cellCounter = 0; cellCounter < rowHeader.getCells().size();
			// cellCounter++) {
			while (matcher_1.find()) {
				if(mapIfValueExist.containsKey(cellCounter)) {
				if (mapIfValueExist.get(cellCounter)) {
					String temp = matcher_1.group(1);
					Cell cell = new Cell(State.READ, temp);
					cells.add(cell);
					cellCounter++;
				}

				else {
					Cell cellEmpty = new Cell(State.READ, "");
					cells.add(cellEmpty);
					cellCounter++;
				}
				}
			}

//			while (matcher_1.find()) {
//				String temp = matcher_1.group(1);
//				if (mapIfValueExist.get(cellCounter)) {
//					Cell cellEmpty = new Cell(State.READ, temp);
//					cells.add(cellEmpty);
//				} else {
//					Cell cellEmpty = new Cell(State.READ, "");
//					cells.add(cellEmpty);
//				}
//
////				if (temp.indexOf("<") == -1) {
////					System.out.println(temp);
////					Cell cellEmpty = new Cell(State.READ, temp);
////					cells.add(cellEmpty);
////				} else {
////					System.out.println(temp);
////					Cell cell = new Cell(State.READ, temp.substring(temp.indexOf(">"), temp.indexOf("<")));
////					cells.add(cell);
////
//////					if (temp.contains("/>")) {
//////						Cell cellEmpty = new Cell(State.READ, "");
//////						cells.add(cellEmpty);
//////					}
//////
//////					//String tempValue = temp.substring(temp.indexOf(">") + 1, temp.length());
//////					String tempValue = temp.substring(temp.lastIndexOf(">") + 1, temp.length());
//////					System.out.println(tempValue);
//////					Cell cell = new Cell(State.READ, tempValue);
//////					cells.add(cell);
////				}
//				cellCounter++;
//			}

			Row row = new Row(cells);
			rows.add(row);

		}

		tableData.setRows(rows);

		return tableData;
	}

//	public TableData getData() {
//		TableData tableData = new TableData();
//		HashMap<Integer, Boolean> mapIfValueExist = new HashMap<>();
//		List<Row> rows = new ArrayList<Row>();
//
//		List<WebElement> weListRows = this.driver.findElements(By.xpath(".//row"));
//
//		for (int i = 0; i < weListRows.size(); i++) {
//			String stringRow = weListRows.get(i).getAttribute("innerHTML");
//			List<Cell> cells = new ArrayList<Cell>();
//			String[] arrayValues = stringRow.split("</");
//
//			if (i == 0) {
//				for (int j = 0; j < arrayValues.length - 1; j++) {
//					List<Cell> cellsHeader = new ArrayList<Cell>();
//					//String headerCell = arrayValues[j].substring(1, arrayValues[j].indexOf(">"));
//					if (arrayValues[j].contains(">")) {
//						String headerCell = arrayValues[j].substring(1, arrayValues[j].indexOf(">"));
//						mapIfValueExist.put(j, true);
//						Cell cell = new Cell(State.READ, arrayValues[j].substring(1, arrayValues[j].indexOf(">") - 1));
//						cellsHeader.add(cell);
//					} else {
//						String headerCell = arrayValues[j].substring(1, arrayValues[j].length());
//						mapIfValueExist.put(j, false);
//						Cell cell = new Cell(State.READ, arrayValues[j].substring(1, arrayValues[j].indexOf(">")));
//						cellsHeader.add(cell);
//					}
//				}
//
//			}
//
//			for (int j = 0; j < arrayValues.length - 1; j++) {
//				List<Cell> cellsRow = new ArrayList<Cell>();
//				if (mapIfValueExist.get(j)) {
//					String rowCell = arrayValues[j].substring(arrayValues[j].indexOf("<"), arrayValues[j].length() - 1);
//					Cell cell = new Cell(State.READ, rowCell);
//					cellsRow.add(cell);
//				} else {
//					String rowCell = "";
//					Cell cell = new Cell(State.READ, rowCell);
//					cellsRow.add(cell);
//				}
//			}
//
//			Row row = new Row(cells);
//			rows.add(row);
//
//		}
//
//		tableData.setRows(rows);
//
//		return tableData;
//	}

}
