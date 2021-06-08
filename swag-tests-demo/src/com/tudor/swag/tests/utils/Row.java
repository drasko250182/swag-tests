package com.tudor.swag.tests.utils;

import java.util.List;

public class Row {
	
	public Row(List<Cell> cells) {
		this.setCells(cells);
	}

	private List<Cell> cells;

	public List<Cell> getCells() {
		return cells;
	}

	public void setCells(List<Cell> cells) {
		this.cells = cells;
	}
	
	
}
