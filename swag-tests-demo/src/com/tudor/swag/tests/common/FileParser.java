package com.tudor.swag.tests.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.tudor.swag.tests.utils.Cell;
import com.tudor.swag.tests.utils.Row;
import com.tudor.swag.tests.utils.TableData;
import com.tudor.swag.tests.utils.Cell.State;

public class FileParser {

	public static TableData getData(String filePath) {
		TableData toReturn = new TableData();
		List<Row> rows = new ArrayList<Row>();

		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = "\\,";

		try {

			br = new BufferedReader(new FileReader(filePath));
			while ((line = br.readLine()) != null) {
				List<Cell> cells = new ArrayList<Cell>();

				// String[] items = line.split(cvsSplitBy);
				// String[] items = line.split(",", -1);
				String[] items = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				// attributes.trim().split("[,]");
				// String[] items = line.split("\\s*,\\s*");

				// List<String> tempList = new ArrayList<String>();

				for (int j = 0; j < items.length - 1; j++) {
					String tempValue = "";
					if (items[j].contains("\"")) {
						//if (items[j].substring(0, 1).equals("\"")
								//&& items[j].substring(items[j].length() - 2, items[j].length() - 1).equals("\"")) {
							tempValue = items[j].substring(1, items[j].length() - 1);
							Cell cell = new Cell(State.READ, tempValue);
							cells.add(cell);
						//}
					} else {
						Cell cell = new Cell(State.READ, items[j]);
						cells.add(cell);
					}
				}
				Row row = new Row(cells);
				rows.add(row);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		toReturn.setRows(rows);

		return toReturn;
	}
}
