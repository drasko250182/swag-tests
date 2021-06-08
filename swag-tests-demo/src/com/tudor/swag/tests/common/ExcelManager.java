package com.tudor.swag.tests.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tudor.swag.tests.utils.Cell.State;
import com.tudor.swag.tests.utils.TableData;

public class ExcelManager {

	public static Object[][] getDataFromExcel(String filePath) {
		Object[][] toReturn = null;
		
		
		return toReturn;
	}
	
	public TableData getData(String filePath) {
		TableData tableData = new TableData();
		List<com.tudor.swag.tests.utils.Row> rows = new ArrayList<com.tudor.swag.tests.utils.Row>();
		
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File(filePath));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(inputStream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
         
        while (iterator.hasNext()) {
        	List<com.tudor.swag.tests.utils.Cell> cells = new ArrayList<com.tudor.swag.tests.utils.Cell>();
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
             
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        //System.out.print(cell.getStringCellValue());
                        com.tudor.swag.tests.utils.Cell cellString = new com.tudor.swag.tests.utils.Cell(State.READ, cell.getStringCellValue());
                        cells.add(cellString);
                        //Cell cellV = new Cell(State.READ, cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        //System.out.print(cell.getBooleanCellValue());
                        com.tudor.swag.tests.utils.Cell cellBoolean = new com.tudor.swag.tests.utils.Cell(State.READ, Boolean.toString(cell.getBooleanCellValue()));
                        cells.add(cellBoolean);
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        //System.out.print(cell.getNumericCellValue());
                       // Cell cellV = new Cell(State.READ, cell.getNumericCellValue());
                        com.tudor.swag.tests.utils.Cell cellNumeric = new com.tudor.swag.tests.utils.Cell(State.READ, String.valueOf(cell.getNumericCellValue()));
                        cells.add(cellNumeric);
                        break;
                }
                //System.out.print(" - ");
            }
            com.tudor.swag.tests.utils.Row row = new com.tudor.swag.tests.utils.Row(cells);
            rows.add(row);
            //System.out.println();
        }
        tableData.setRows(rows);
         
       // workbook.close();
        try {
        	//workbook.close();
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
		
		return tableData;
		
	}
}
