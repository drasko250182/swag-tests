package com.tudor.swag.tests.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.tudor.swag.tests.data.provider.DataProviderManager;
import com.tudor.swag.tests.utils.Cell;
import com.tudor.swag.tests.utils.Row;
import com.tudor.swag.tests.utils.TableData;
import com.tudor.swag.tests.utils.Cell.State;

public class ResultManager {

	public void writeToFile(TableData tableData, String filePath) {

		//File fout = new File(filePath);
		FileOutputStream fos = null;
		try {
			//String name = filePath;
			File fout = new File(filePath);
			fos = new FileOutputStream( fout);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

		for (int i = 0; i < tableData.getRows().size(); i++) {
			String tempLine = "";
			for (int j = 0; j < tableData.getRows().get(i).getCells().size(); j++) {
				if (j == 0) {
					tempLine = tempLine + tableData.getRows().get(i).getCells().get(j).getValue();
				} else {
					tempLine = tempLine + " | " + tableData.getRows().get(i).getCells().get(j).getValue();
				}
			}
			try {
				bw.write(tempLine);
				if (i < tableData.getRows().size() - 1) {
					bw.newLine();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public TableData getTableData(String filePath) {

		TableData toReturn = new TableData();
		List<Row> rows = new ArrayList<Row>();

		List<List<String>> listRows = DataProviderManager.readFile(filePath);

		for (int i = 0; i < listRows.size(); i++) {
			List<Cell> cells = new ArrayList<Cell>();
			for (int j = 0; j < listRows.get(i).size(); j++) {
				Cell cell = new Cell(State.READ, listRows.get(i).get(j).trim());
				cells.add(cell);
			}
			Row row = new Row(cells);
			rows.add(row);
		}

		toReturn.setRows(rows);

		return toReturn;

	}

}
