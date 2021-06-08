package com.tudor.swag.tests.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.tudor.swag.tests.common.DateManager;

public class SoftAssertSwag {

	private SoftAssert softAssert;

	public SoftAssertSwag() {
		this.softAssert = new SoftAssert();
	}

	public void assertEquals(String actual, String expected, String message) {
		this.softAssert.assertEquals(actual, expected, message);
	}

	public void assertEquals(double actual, double expected, String message) {
		this.softAssert.assertEquals(actual, expected, message);
	}

	public void assertEquals(BigDecimal actual, BigDecimal expected, String message) {
		this.softAssert.assertEquals(actual, expected, message);
	}

	public void assertEquals(Integer actual, Integer expected, String message) {
		this.softAssert.assertEquals(actual, expected, message);
	}

	public void assertEquals(BigInteger actual, BigInteger expected, String message) {
		this.softAssert.assertEquals(actual, expected, message);
	}

	public void assertEquals(boolean actual, boolean expected, String message) {
		this.softAssert.assertEquals(actual, expected, message);
	}

	public void assertEquals(HashMap<String, String> actual, HashMap<String, String> expected, Integer rowNumber) {
		Set<Map.Entry<String, String>> set = actual.entrySet();

		for (Map.Entry<String, String> me : set) {
			Integer tempRowNum = rowNumber + 1;
			this.assertEquals(actual.get(me.getKey()), expected.get(me.getKey()),
					'\n' + "[Row: " + tempRowNum.toString() + "] [Column: " + me.getKey() + "] [Production: "
							+ expected.get(me.getKey()) + "] [Stage: " + actual.get(me.getKey()) + "]");
		}
	}

	public void assertList(List<HashMap<String, String>> listActualItems,
			List<HashMap<String, String>> listExpectedItems) {

		for (int i = 0; i < listActualItems.size(); i++) {
			this.assertEquals(listActualItems.get(i), listExpectedItems.get(i), i);
		}
	}

//	public void assertTableData(TableData actualTableData, TableData expectedTableData) {
//		Assert.assertEquals(actualTableData.getRows().size(), expectedTableData.getRows().size(),
//				"Actual row count is not equal as expected");
//
//		for (int i = 0; i < expectedTableData.getRows().size(); i++) {
//			Integer tempRowNum = i + 1;
//			List<Cell> expectedListCell = expectedTableData.getRows().get(i).getCells();
//			List<Cell> actualListCell = actualTableData.getRows().get(i).getCells();
//			for (int j = 0; j < expectedListCell.size(); j++) {
//				Integer tempColumnNum = j + 1;
//				if (i == 0) {
//					this.assertEquals(actualListCell.get(j).getValue(), expectedListCell.get(j).getValue(),
//							'\n' + "Header [Column: " + tempColumnNum.toString() + "] [Expected: "
//									+ expectedListCell.get(j).getValue() + "] [Actual: "
//									+ actualListCell.get(j).getValue() + "]");
//				} else {
//					// System.out.println(expectedListCell.get(j).getValue());
//					// System.out.println(DateManager.isNumeric(expectedListCell.get(j).getValue()));
//					// System.out.println(expectedListCell.get(j).getValue().replaceAll(",", ""));s
//					// System.out.println(actualListCell.get(j).getValue().replaceAll("\"", ""));
//					// System.out.println(actualListCell.get(j).getValue() +
//					// DateManager.isNumeric(actualListCell.get(j).getValue()));
//					// System.out.println(expectedListCell.get(j).getValue() +
//					// DateManager.isNumeric(actualListCell.get(j).getValue()));
//					String actual = actualListCell.get(j).getValue();
//					String expected = expectedListCell.get(j).getValue();
//					System.out.println(actual);
//					System.out.println(expected);
//					if (DateManager.isNumeric(actual)) {
//						if (expected.contains("/")) {
//							// actual.replaceAll("/", "");
//							// expected.replaceAll("/", "");
//							// System.out.println(actual);
//							// System.out.println(expected);
//							this.assertEquals(actual.replaceAll("/", ""), expected.replaceAll("/", ""),
//									'\n' + "[Row: " + tempRowNum.toString() + "] [Column: " + tempColumnNum.toString()
//											+ "] [Expected: " + expected + "] [Actual: " + actual + "]");
//						} else if (actual.length() > 2
//								&& actual.substring(actual.length() - 2, actual.length() - 1).equals("E")) {
//							if (actual.contains("+")) {
//								System.out.println("test");
//							}
//							BigDecimal resultActual = new BigDecimal(actual);
//							// System.out.println(resultActual.longValue());
//
//							// System.out.println(expected.replaceAll(",", ""));
//							// System.out.println(resultActual);
//
//							BigDecimal resultExpected = new BigDecimal(expected.replaceAll(",", ""));
//							// System.out.println(resultExpected);
//							System.out.println("Double" + resultActual + " vs " + resultExpected);
//							// this.assertEquals(resultActual, resultExpected, "Double" + resultActual + "
//							// vs " + resultExpected);
//							this.assertEquals(Long.toString(resultActual.longValue()), expected.replaceAll(",", ""),
//									'\n' + "[Row: " + tempRowNum.toString() + "] [Column: " + tempColumnNum.toString()
//											+ "] [Expected: " + expected.replaceAll(",", "") + "] [Actual: "
//											+ resultActual.longValue() + "]");
//							// actual = result.toString();
//						} else if (actual.contains(".")) {
//							double doubleActual = Double.parseDouble(actual);
//							// BigDecimal resultActual = new BigDecimal(actual); + resultActual.longValue()
//							// System.out.println(resultActual.longValue());
//							double doubleExpected = Double.parseDouble(expected.replaceAll(",", ""));
//							// System.out.println(expected.replaceAll(".", ""));
//							// BigDecimal resultExpected = new BigDecimal(expected.replaceAll(".", ""));
//							this.assertEquals(doubleActual, doubleExpected, doubleActual + " vs " + doubleExpected);
//						} else {
//							int intActual = Integer.valueOf(actual);
//							actual = Integer.toString(intActual);
//							System.out.println("Integer : " + intActual);
//							int intExpected = Integer.valueOf(expected.replaceAll(",", ""));
//							this.assertEquals(intActual, intExpected, intActual + " vs " + intExpected);
//						}
//					}
////
////					if (DateManager.isNumeric(expected)) {
////						if (expected.contains("/")) {
////							expected.replaceAll("/", "");
////						} else if (expected.substring(expected.length() - 2, expected.length() - 1).equals("E")) {
////							BigDecimal result = new BigDecimal(expected);
////							System.out.println(result.longValue());
////							expected = result.toString();
////						} else {
////							int inum2 = Integer.valueOf(expected);
////							expected = Integer.toString(inum2);
////							System.out.println("Integer : " + inum2);
////						}
////					}
//
////					this.assertEquals(actual, expected, '\n' + "[Row: " + tempRowNum.toString() + "] [Column: "
////							+ tempColumnNum.toString() + "] [Expected: " + expected + "] [Actual: " + actual + "]");
//
////					this.assertEquals(actual, expectedListCell.get(j).getValue().replaceAll(",", ""),
////							'\n' + "[Row: " + tempRowNum.toString() + "] [Column: " + tempColumnNum.toString()
////									+ "] [Expected: " + expectedListCell.get(j).getValue().replaceAll(",", "")
////									+ "] [Actual: "
////									+ actualListCell.get(j).getValue().replaceAll("\"", "").replaceAll(",", "") + "]");
//
////					System.out.println(actualListCell.get(j).getValue().replaceAll("\"", "").replaceAll(",", "")
////							+ " vs " + expectedListCell.get(j).getValue().replaceAll(",", ""));
////					this.assertEquals(actualListCell.get(j).getValue().replaceAll("\"", "").replaceAll(",", ""),
////							expectedListCell.get(j).getValue().replaceAll(",", ""),
////							'\n' + "[Row: " + tempRowNum.toString() + "] [Column: " + tempColumnNum.toString()
////									+ "] [Expected: " + expectedListCell.get(j).getValue().replaceAll(",", "")
////									+ "] [Actual: "
////									+ actualListCell.get(j).getValue().replaceAll("\"", "").replaceAll(",", "") + "]");
//				}
//			}
//
//		}
//
//	}

	public List<Boolean> compareListTableData(List<TableData> actualTableData, List<TableData> expectedTableData) {
		List<Boolean> toReturn = new ArrayList<Boolean>();

		for (int i = 0; i < expectedTableData.size(); i++) {
			toReturn.add(this.compareTableData(actualTableData.get(i), expectedTableData.get(i)));
		}

		return toReturn;
	}

	public void assertListTableData(List<TableData> actualTableData, List<TableData> expectedTableData) {
		for (int i = 0; i < expectedTableData.size(); i++) {
			this.assertTableData(actualTableData.get(i), expectedTableData.get(i));
		}
	}

	public Boolean compareTableData(TableData actualTableData, TableData expectedTableData) {
		Boolean toReturn = true;

		if (actualTableData.getRows().size() != expectedTableData.getRows().size()) {
			toReturn = false;
		}

		for (int i = 0; i < expectedTableData.getRows().size(); i++) {
			if (!toReturn) {
				break;
			} else {
				List<Cell> expectedListCell = expectedTableData.getRows().get(i).getCells();
				List<Cell> actualListCell = actualTableData.getRows().get(i).getCells();
				for (int j = 0; j < expectedListCell.size(); j++) {
					if (!actualListCell.get(j).getValue().equals(expectedListCell.get(j).getValue())) {
						toReturn = false;
					}

				}
			}

		}

		return toReturn;
	}

	public void assertTableData(TableData actualTableData, TableData expectedTableData) {
		Assert.assertEquals(actualTableData.getRows().size(), expectedTableData.getRows().size(),
				"Actual row count is not equal as expected");

		for (int i = 0; i < expectedTableData.getRows().size(); i++) {
			Integer tempRowNum = i + 1;
			List<Cell> expectedListCell = expectedTableData.getRows().get(i).getCells();
			List<Cell> actualListCell = actualTableData.getRows().get(i).getCells();
			// String actual = "";
			// String expected = "";
			for (int j = 0; j < expectedListCell.size(); j++) {
				Integer tempColumnNum = j + 1;
				if (i == 0) {
					this.assertEquals(actualListCell.get(j).getValue(), expectedListCell.get(j).getValue(),
							'\n' + "Header [Column: " + tempColumnNum.toString() + "] [Expected: "
									+ expectedListCell.get(j).getValue() + "] [Actual: "
									+ actualListCell.get(j).getValue() + "]");
				} else {
					this.assertEquals(actualListCell.get(j).getValue(), expectedListCell.get(j).getValue(),
							'\n' + "[Row: " + tempRowNum.toString() + "] [Column: " + tempColumnNum.toString()
									+ "] [Expected: " + expectedListCell.get(j).getValue() + "] [Actual: "
									+ actualListCell.get(j).getValue() + "]");
//				actual = actual + actualListCell.get(j).getValue();
//				expected = expected + expectedListCell.get(j).getValue();
//				this.assertEquals(actual, expected,
//						'\n' + "[Expected: " + expected + "] [Actual: "
//								+ actual + "]");
//				
				}

			}

		}

	}

//	public void assertAdjusmentTableData(TableData actualTableData, TableData expectedTableData) {
//		Assert.assertEquals(actualTableData.getRows().size(), expectedTableData.getRows().size(),
//				"Actual row count is not equal as expected");
//
//		for (int i = 0; i < expectedTableData.getRows().size(); i++) {
//			Integer tempRowNum = i + 1;
//			List<Cell> expectedListCell = expectedTableData.getRows().get(i).getCells();
//			List<Cell> actualListCell = actualTableData.getRows().get(i).getCells();
//			// String actual = "";
//			// String expected = "";
//			for (int j = 0; j < expectedListCell.size(); j++) {
//				Integer tempColumnNum = j + 1;
//				if (i == 0) {
//					this.assertEquals(actualListCell.get(j).getValue(), expectedListCell.get(j).getValue(),
//							'\n' + "Header [Column: " + tempColumnNum.toString() + "] [Expected: "
//									+ expectedListCell.get(j).getValue() + "] [Actual: "
//									+ actualListCell.get(j).getValue() + "]");
//				} else {
//					if (actualListCell.get(j).getValue().equals(expectedListCell.get(j).getValue())) {
//						this.assertEquals(actualListCell.get(j).getValue(), expectedListCell.get(j).getValue(),
//								'\n' + "[Row: " + tempRowNum.toString() + "] [Column: " + tempColumnNum.toString()
//										+ "] [Expected: " + expectedListCell.get(j).getValue() + "] [Actual: "
//										+ actualListCell.get(j).getValue() + "]");
//					} else {
//						if (actualListCell.get(i).getValue().contains(".")
//								|| expectedListCell.get(i).getValue().contains(".")) {
//							String tempActual = actualListCell.get(i).getValue().substring(0,
//									actualListCell.get(i).getValue().indexOf("."));
//							String tempExpected = expectedListCell.get(i).getValue().substring(0,
//									expectedListCell.get(i).getValue().indexOf("."));
//							System.out.println(tempActual + " vs " + tempExpected);
//							try {
//								Integer intValueA = Integer.parseInt(tempActual);
//								Integer intValueE = Integer.parseInt(tempExpected);
//								Integer diff = intValueA - intValueE;
//								if(diff > 2) {
//									this.assertEquals(actualListCell.get(j).getValue(), expectedListCell.get(j).getValue(),
//											'\n' + "[Row: " + tempRowNum.toString() + "] [Column: "
//													+ tempColumnNum.toString() + "] [Expected: "
//													+ expectedListCell.get(j).getValue() + "] [Actual: "
//													+ actualListCell.get(j).getValue() + "]");
//								}
//								else {
//									this.assertEquals(actualListCell.get(j).getValue(), actualListCell.get(j).getValue(),
//											'\n' + "[Row: " + tempRowNum.toString() + "] [Column: "
//													+ tempColumnNum.toString() + "] [Expected: "
//													+ expectedListCell.get(j).getValue() + "] [Actual: "
//													+ actualListCell.get(j).getValue() + "]");
//								}
//								
//
//							} catch (NumberFormatException e) {
//								System.out.println("Input String cannot be parsed to Integer.");
//								this.assertEquals(actualListCell.get(j).getValue(), expectedListCell.get(j).getValue(),
//										'\n' + "[Row: " + tempRowNum.toString() + "] [Column: "
//												+ tempColumnNum.toString() + "] [Expected: "
//												+ expectedListCell.get(j).getValue() + "] [Actual: "
//												+ actualListCell.get(j).getValue() + "]");
//							}
//						}
//					}
//
//				}
//
//			}
//
//		}
//
//	}

	public void assertAdjusmentTableData(TableData actualTableData, TableData expectedTableData) {
		Assert.assertEquals(actualTableData.getRows().size(), expectedTableData.getRows().size(),
				"Actual row count is not equal as expected");

		for (int i = 0; i < expectedTableData.getRows().size(); i++) {
			Integer tempRowNum = i + 1;
			List<Cell> expectedListCell = expectedTableData.getRows().get(i).getCells();
			List<Cell> actualListCell = actualTableData.getRows().get(i).getCells();
			// String actual = "";
			// String expected = "";
			for (int j = 0; j < expectedListCell.size(); j++) {
				Integer tempColumnNum = j + 1;
				if (i == 0) {
					this.assertEquals(actualListCell.get(j).getValue(), expectedListCell.get(j).getValue(),
							'\n' + "Header [Column: " + tempColumnNum.toString() + "] [Expected: "
									+ expectedListCell.get(j).getValue() + "] [Actual: "
									+ actualListCell.get(j).getValue() + "]");
				} else {
					if (actualListCell.get(j).getValue().equals(expectedListCell.get(j).getValue())) {
						this.assertEquals(actualListCell.get(j).getValue(), expectedListCell.get(j).getValue(),
								'\n' + "[Row: " + tempRowNum.toString() + "] [Column: " + tempColumnNum.toString()
										+ "] [Expected: " + expectedListCell.get(j).getValue() + "] [Actual: "
										+ actualListCell.get(j).getValue() + "]");
					} else {
						if (actualListCell.get(i).getValue().contains(".")
							&& expectedListCell.get(i).getValue().contains(".")) {
						
							
						}
						
//						if (actualListCell.get(i).getValue().contains(".")
//								&& expectedListCell.get(i).getValue().contains(".")) {
//
//							double doubleActual = 0;
//							double doubleExpected = 0;
//							String roundedActual = null;
//							String roundedExpected = null;
//
//							try {
//								doubleActual = Double.parseDouble(actualListCell.get(i).getValue());
//							} catch (NumberFormatException e) {
//								DecimalFormat df = new DecimalFormat("#,###.00000");
//								BigDecimal num = new BigDecimal(actualListCell.get(i).getValue());
//								roundedActual = df.format(num);
//							}
//
//							try {
//								doubleExpected = Double.parseDouble(expectedListCell.get(i).getValue());
//							} catch (NumberFormatException e) {
//								DecimalFormat df = new DecimalFormat("#,###.00000");
//								BigDecimal num = new BigDecimal(expectedListCell.get(i).getValue());
//								roundedExpected = df.format(num);
//							}
//
//							if (doubleActual == 0 && doubleExpected == 0) {
//								this.assertEquals(roundedActual, roundedExpected,
//										'\n' + "[Row: " + tempRowNum.toString() + "] [Column: "
//												+ tempColumnNum.toString() + "] [Expected: "
//												+ expectedListCell.get(j).getValue() + "] [Actual: "
//												+ actualListCell.get(j).getValue() + "]");
//							} else {
//								roundedActual = String.format("%.5f", doubleActual);
//								roundedExpected = String.format("%.5f", doubleExpected);
//								this.assertEquals(roundedActual, roundedExpected,
//										'\n' + "[Row: " + tempRowNum.toString() + "] [Column: "
//												+ tempColumnNum.toString() + "] [Expected: "
//												+ expectedListCell.get(j).getValue() + "] [Actual: "
//												+ actualListCell.get(j).getValue() + "]");
//							}
//
//						}
					}

				}

			}

		}

	}

//	public void assertTableData(TableData actualTableData, TableData expectedTableData) {
//		Assert.assertEquals(actualTableData.getRows().size(), expectedTableData.getRows().size(),
//				"Actual row count is not equal as expected");
//
//		for (int i = 0; i < expectedTableData.getRows().size(); i++) {
//			Integer tempRowNum = i + 1;
//			List<Cell> expectedListCell = expectedTableData.getRows().get(i).getCells();
//			List<Cell> actualListCell = actualTableData.getRows().get(i).getCells();
//			for (int j = 0; j < expectedListCell.size(); j++) {
//				Integer tempColumnNum = j + 1;
//				if (i == 0) {
//					this.assertEquals(actualListCell.get(j).getValue(), expectedListCell.get(j).getValue(),
//							'\n' + "Header [Column: " + tempColumnNum.toString() + "] [Expected: "
//									+ expectedListCell.get(j).getValue() + "] [Actual: "
//									+ actualListCell.get(j).getValue() + "]");
//				} else {
//					String actual = actualListCell.get(j).getValue();
//					String expected = expectedListCell.get(j).getValue();
//					if (DateManager.isNumeric(actual)) {
//						if (expected.contains("/")) {
//							this.assertEquals(actual.replaceAll("/", ""), expected.replaceAll("/", ""),
//									'\n' + "[Row: " + tempRowNum.toString() + "] [Column: " + tempColumnNum.toString()
//											+ "] [Expected: " + expected + "] [Actual: " + actual + "]");
//						} else if (actual.length() > 2
//								&& actual.substring(actual.length() - 2, actual.length() - 1).equals("E")) {
//							if (actual.contains("+")) {
//								System.out.println("test");
//							}
//							BigDecimal resultActual = new BigDecimal(actual);
//							BigDecimal resultExpected = new BigDecimal(expected.replaceAll(",", ""));
//
//							System.out.println("Double" + resultActual + " vs " + resultExpected);
//
//							// this.assertEquals(resultActual, resultExpected, resultActual + " vs " +
//							// resultExpected);
//
//							this.assertEquals(Long.toString(resultActual.longValue()),
//									Long.toString(resultExpected.longValue()),
//									'\n' + "[Row: " + tempRowNum.toString() + "] [Column: " + tempColumnNum.toString()
//											+ "] [Expected: " + Long.toString(resultExpected.longValue())
//											+ "] [Actual: " + Long.toString(resultActual.longValue()) + "]");
////							this.assertEquals(Long.toString(resultActual.longValue()), expected.replaceAll(",", ""),
////									'\n' + "[Row: " + tempRowNum.toString() + "] [Column: " + tempColumnNum.toString()
////											+ "] [Expected: " + expected.replaceAll(",", "") + "] [Actual: "
////											+ resultActual.longValue() + "]");
//							// actual = result.toString();
//						} else if (actual.contains(".")) {
//							try {
//								double doubleActual = Double.parseDouble(actual);
//								double doubleExpected = Double.parseDouble(expected.replaceAll(",", ""));
//								this.assertEquals(doubleActual, doubleExpected, doubleActual + " vs " + doubleExpected);
//							} catch (NumberFormatException e) {
//								System.out.println(actual + " is not a valid integer number");
//							}
//						} else {
//							try {
//								int intActual = Integer.valueOf(actual);
//								actual = Integer.toString(intActual);
//								System.out.println("Integer : " + intActual);
//								int intExpected = Integer.valueOf(expected.replaceAll(",", ""));
//								this.assertEquals(intActual, intExpected, intActual + " vs " + intExpected);
//							} catch (NumberFormatException e) {
//								System.out.println(actual + " is not a valid integer number");
//							}
//							try {
//								BigInteger bigIntActual = new BigInteger(actual);
//								// actual = Integer.toString(intActual);
//								// System.out.printl//cted = Integer.valueOf(expected.replaceAll(",", ""));
//								BigInteger bigIntExpected = new BigInteger(expected.replaceAll(",", ""));
//								this.assertEquals(bigIntActual, bigIntExpected, bigIntActual + " vs " + bigIntExpected);
//							} catch (NumberFormatException e) {
//								System.out.println(actual + " is not a valid big integer number");
//							}
//							new BigInteger(actual);
//						}
//					} else {
////						this.assertEquals(actualListCell.get(j).getValue().replaceAll("  ", " "),
////								expectedListCell.get(j).getValue(),
////								'\n' + "[Row: " + tempRowNum.toString() + "] [Column: " + tempColumnNum.toString()
////										+ "] [Expected: " + expectedListCell.get(j).getValue() + "] [Actual: "
////										+ actualListCell.get(j).getValue().replaceAll("  ", " ") + "]");
//						this.assertEquals(actualListCell.get(j).getValue().replaceAll("\\s", ""),
//								expectedListCell.get(j).getValue().replaceAll("\\s", ""),
//								'\n' + "[Row: " + tempRowNum.toString() + "] [Column: " + tempColumnNum.toString()
//										+ "] [Expected: " + expectedListCell.get(j).getValue().replaceAll("\\s", "") + "] [Actual: "
//										+ actualListCell.get(j).getValue().replaceAll("\\s", "") + "]");
//					}
//				}
//
//			}
//
//		}
//
//	}

	public void assertTableDataByMap(TableData actualTableData, TableData expectedTableData) {

		HashMap<String, Integer> actualMap = new HashMap<String, Integer>();
		for (int i = 0; i < actualTableData.getRows().size(); i++) {
			String actualRowValue = "";
			List<Cell> actualListCell = actualTableData.getRows().get(i).getCells();
			for (int j = 0; j < actualListCell.size(); j++) {
				actualRowValue = actualRowValue + actualListCell.get(j).getValue() + "|";
			}
			actualMap.put(actualRowValue, i);
		}

		HashMap<String, Integer> expectedMap = new HashMap<String, Integer>();
		for (int i = 0; i < expectedTableData.getRows().size(); i++) {
			String expectedRowValue = "";
			List<Cell> expectedListCell = expectedTableData.getRows().get(i).getCells();
			for (int j = 0; j < expectedListCell.size(); j++) {
				expectedRowValue = expectedRowValue + expectedListCell.get(j).getValue() + "|";
			}
			expectedMap.put(expectedRowValue, i);
		}

		Set<Map.Entry<String, Integer>> setExpectedMap = expectedMap.entrySet();

		for (Map.Entry<String, Integer> meExpectedMap : setExpectedMap) {
			this.assertEquals(actualMap.containsKey(meExpectedMap.getKey()), true, "Row : " + meExpectedMap.getKey()
					+ " at position " + expectedMap.get(meExpectedMap.getKey()) + " not find at STAGE");

		}
		Set<Map.Entry<String, Integer>> setActualMap = actualMap.entrySet();

		for (Map.Entry<String, Integer> meActualMap : setActualMap) {
			this.assertEquals(true, expectedMap.containsKey(meActualMap.getKey()), "Row : " + meActualMap.getKey()
					+ " at position " + actualMap.get(meActualMap.getKey()) + " not find at PROD");

		}

//		if (expectedMap.size() >= actualMap.size()) {
//			Set<Map.Entry<String, Integer>> setExpectedMap = expectedMap.entrySet();
//
//			for (Map.Entry<String, Integer> meExpectedMap : setExpectedMap) {
//				this.assertEquals(actualMap.containsKey(meExpectedMap.getKey()), true,
//						"Row : " + meExpectedMap.getKey() + " at position " + expectedMap.get(meExpectedMap.getKey()) + " not find at STAGE");
//
//			}
//		}
//		else {
//			Set<Map.Entry<String, Integer>> setActualMap = actualMap.entrySet();
//
//			for (Map.Entry<String, Integer> meActualMap : setActualMap) {
//				this.assertEquals(true, expectedMap.containsKey(meActualMap.getKey()),
//						"Row : " + meActualMap.getKey() + " at position " + actualMap.get(meActualMap.getKey()) + " not find at PROD");
//
//			}
//		}

	}

	public void assertItems(List<String> listActualItems, List<String> listExpectedItems) {
		for (int i = 0; i < listExpectedItems.size(); i++) {
			Integer tempRowNum = i + 1;
			this.softAssert.assertEquals(listActualItems.get(i), listExpectedItems.get(i), "Item " + tempRowNum
					+ " is not equal, expected : " + listExpectedItems.get(i) + " but found " + listActualItems.get(i));
		}
	}

	public void assertAll() {
		this.softAssert.assertAll();
	}
}
