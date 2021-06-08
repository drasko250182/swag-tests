package com.tudor.swag.tests.common;

import java.util.List;

import com.tudor.swag.tests.pages.common.SwagletPage.Type;
import com.tudor.swag.tests.utils.Column;
import com.tudor.swag.tests.utils.TableData;

public class TestManager {

	public static String getTestName(Type type) {
		String toReturn = "";

		String temp = type.getUrl().substring(0, type.getUrl().indexOf("?"));

		String[] arrOfStr = temp.split("/");

		for (int i = 0; i < arrOfStr.length; i++) {
			String output = arrOfStr[i].substring(0, 1).toUpperCase() + arrOfStr[i].substring(1);
			if (i != 0) {
				toReturn = toReturn + output;
			}
		}

		return toReturn;
	}

	public static String getTestDescription(TableData tableData) {
		String toReturn = "";

		List<Column> listColumn = tableData.getColumns();

		for (int i = 0; i < listColumn.size(); i++) {
			toReturn = toReturn + '\n';
			toReturn = toReturn + listColumn.get(i).getBy().getuiName() + " : [";

			for (int j = 0; j < listColumn.get(i).getStringValues().size(); j++) {
				Integer tempIndex = j + 1;
				toReturn = toReturn + tempIndex + " : " + listColumn.get(i).getStringValues().get(j) + " | ";
			}
			String temp = toReturn.substring(0, toReturn.length() - 2);
			toReturn = temp + " ] ";
		}

		return toReturn;
	}

	public static String getTestSpecification(TableData tableData) {
		String toReturn = "";

		List<Column> listColumn = tableData.getColumns();

		for (int i = 0; i < listColumn.size(); i++) {
			// toReturn = toReturn + '\n';
			// toReturn = toReturn + listColumn.get(i).getBy().getuiName() + " : [";

			for (int j = 0; j < listColumn.get(i).getStringValues().size(); j++) {
				if (!listColumn.get(i).getStringValues().get(j).equals(" ")
						&& !listColumn.get(i).getStringValues().get(j).equals("")) {
					if (listColumn.get(i).getStringValues().get(j).contains(".csv")) {
						String temp = listColumn.get(i).getStringValues().get(j).replaceAll("/", "");
						toReturn = toReturn + temp.substring(0, temp.length() - 4) + "_";

					} else if (listColumn.get(i).getStringValues().get(j).contains("\"")) {
						String temp = listColumn.get(i).getStringValues().get(j).replaceAll("\"", "");
						toReturn = toReturn + temp+ "_";
					} 
					else if (listColumn.get(i).getStringValues().get(j).contains(":")) {
						String temp = listColumn.get(i).getStringValues().get(j).replaceAll(":", "");
						toReturn = toReturn + temp+ "_";
					}
					else {
						toReturn = toReturn + listColumn.get(i).getStringValues().get(j) + "_";
					}
				}

			}
			String temp = toReturn.substring(0, toReturn.length() - 1);
			toReturn = temp.replaceAll(":", "");
		}

		return toReturn;
	}

}
