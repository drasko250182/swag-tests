package com.tudor.swag.tests.utils;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tudor.swag.tests.common.JsoupParser;
import com.tudor.swag.tests.utils.Cell.State;

public class TableControl {

	private WebDriver driver;
	private WebElement weTable;

	public TableControl(WebDriver driver, WebElement weTable) {
		this.driver = driver;
		this.weTable = weTable;
	}

	private WebElement getCellAt(int row, int column) {
		row++;
		column++;
		return weTable.findElement(By.xpath(".//tr[" + row + "]/td[" + column + "]"));
	}

	private String getValueAt(int row, int column) {
		return this.getCellAt(row, column).getText();
	}

	private void setValueAt(String value, int row, int column) {
		WebElement currentCell = this.getCellAt(row, column);
		WebElement currentCellInput = currentCell.findElement(By.xpath(".//input"));
		currentCellInput.clear();
		currentCellInput.sendKeys(value);
	}

	private Integer getColumnPosition(WebElement weTable, Column column) {
		Integer toReturn = -1;

		WebElement weHeader = weTable.findElement(By.xpath(".//tr"));

		List<WebElement> weListHeaderItems = weHeader.findElements(By.xpath(".//th"));

		for (int i = 0; i < weListHeaderItems.size(); i++) {
			if (column.getBy().getuiName().equals(weListHeaderItems.get(i).getText())) {
				toReturn = i;
				break;
			}
		}

		return toReturn;
	}

	private void setTable(WebElement weTable, TableData tableData) {
		List<WebElement> weListRows = weTable.findElements(By.xpath(".//tr"));

		List<Row> listRows = tableData.getRows();

		for (int i = 0; i < listRows.size(); i++) {
			int rowNumber = i + 2;
			List<WebElement> weListCells = weListRows.get(rowNumber).findElements(By.xpath(".//td"));

			List<Cell> listCells = listRows.get(i).getCells();

			for (int j = 0; j < listCells.size(); j++) {
				if (listCells.get(j).getState().equals(State.WRITE)) {
					weListCells.get(j).findElement(By.xpath(".//input")).clear();
					weListCells.get(j).findElement(By.xpath(".//input")).sendKeys(listCells.get(j).getValue());
				}

			}
		}
	}

	public void setData(List<Column> columns) {
		for (int i = 0; i < columns.size(); i++) {
			Integer columnPosition = this.getColumnPosition(weTable, columns.get(i));
			for (int j = 0; j < columns.get(i).getStringValues().size(); j++) {
				Integer rowPosition = j + 2;
				this.setValueAt(columns.get(i).getStringValues().get(j), rowPosition, columnPosition);
			}
		}
	}

	public void setData(TableData tableData) {
		List<WebElement> weListRows = weTable.findElements(By.xpath(".//tr"));

		for (int i = 0; i < weListRows.size(); i++) {
			if (weListRows.get(i).getAttribute("style").contains("collapse")) {
				weListRows.remove(i);
			}
		}

		List<Column> listColumns = tableData.getColumns();

		for (int i = 0; i < listColumns.size(); i++) {

			List<String> listCells = listColumns.get(i).getStringValues();
			Integer columnPosition = this.getColumnPosition(weTable, listColumns.get(i));

			for (int j = 0; j < listCells.size(); j++) {
				if (!listCells.get(j).equals(" ")) {
					int rowNumber = j + 2;
					List<WebElement> weListCells = weListRows.get(rowNumber).findElements(By.xpath(".//td"));
					WebElement currentCellInput = weListCells.get(columnPosition).findElement(By.xpath(".//input"));
					currentCellInput.clear();
					currentCellInput.sendKeys(listCells.get(j));
//					if (weListRows.get(rowNumber).getAttribute("style").contains("collapse")) {
//						j = j - 1;
//					} else {
//						if (listCells.get(j) != "") {
//						List<WebElement> weListCells = weListRows.get(rowNumber).findElements(By.xpath(".//td"));
//						WebElement currentCellInput = weListCells.get(columnPosition).findElement(By.xpath(".//input"));
//						currentCellInput.clear();
//						currentCellInput.sendKeys(listCells.get(j));
//						}
//					}
				}
			}
		}
	}

	public TableData getData() {
		TableData tableData = new TableData();
		List<Row> rows = new ArrayList<Row>();

		String tableHTML = weTable.getAttribute("outerHTML");
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
				Elements itemsRowHeader = items.get(i).getElementsByTag("th");
				for (int j = 0; j < itemsRowHeader.size(); j++) {
					// stringHeader.add(itemsHeader.get(j).text());
					Cell cell = new Cell(State.READ, itemsRowHeader.get(j).text());
					cells.add(cell);
				}
				
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
