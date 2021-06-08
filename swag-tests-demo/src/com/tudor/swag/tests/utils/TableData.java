package com.tudor.swag.tests.utils;

import java.util.List;

public class TableData {

	private List<Row> rows;
	private List<Cell> cells;
	//implementacija logike (preradjena i prilagodjena) sa linka : https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
	private Cell[][] rowData;
	private String[] columnNames;
	
	private List<Column> listColumn;

	public TableData() {
		this.setRows(rows);
	}
	
//	public TableData(List<Row> rows) {
//		this.setRows(rows);
//	}
	
	public TableData(List<Column> columns) {
		this.setColumns(columns);
	}
	
	
//	public TableData(List<Cell> cells) {
//		this.setCells(cells);
//	}

//	public TableData(Object[][] rowData, Object[] columnNames) {
//
//	}
//
//	public TableData(String[][] rowData, String[] columnNames) {
//
//	}

	public TableData(Cell[][] rowData, String[] columnNames) {

	}

	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}

	private List<Column> columns;

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	public Cell[][] getRowData() {
		return rowData;
	}

	public void setRowData(Cell[][] rowData) {
		this.rowData = rowData;
	}

	public int getRowCount() {
		return rowData.length;
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public List<Cell> getCells() {
		return cells;
	}

	public void setCells(List<Cell> cells) {
		this.cells = cells;
	}

	public List<Column> getListColumn() {
		return listColumn;
	}

	public void setListColumn(List<Column> listColumn) {
		this.listColumn = listColumn;
	}

}
