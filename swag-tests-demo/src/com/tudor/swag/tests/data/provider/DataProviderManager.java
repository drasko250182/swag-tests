package com.tudor.swag.tests.data.provider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.tudor.swag.tests.pages.common.SwagletPage.Type;
import com.tudor.swag.tests.utils.Column;
import com.tudor.swag.tests.utils.TableData;
import com.tudor.swag.tests.utils.Column.Name;

public class DataProviderManager {

	public static List<String> getFilesFromFolder(String folderPath) {

		List<String> temp = new ArrayList<String>();
		List<String> result = new ArrayList<String>();

		try (Stream<Path> walk = Files.walk(Paths.get(folderPath))) {

			temp = walk.filter(Files::isRegularFile).map(x -> x.toString()).collect(Collectors.toList());

			temp.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < temp.size(); i++) {
			if(!temp.get(i).contains("_FALSE")) {
				result.add(temp.get(i));
			}
		}
		return result;
	}

	public static List<List<String>> readFile(String filePath) {

		List<List<String>> toReturn = new ArrayList<List<String>>();

		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = "\\| ";

		try {

			br = new BufferedReader(new FileReader(filePath));
			while ((line = br.readLine()) != null) {

				if (!line.substring(0, 2).equals("//")) {

					String[] items = line.split(cvsSplitBy);

					List<String> tempList = new ArrayList<String>();

					for (int j = 0; j < items.length; j++) {
						tempList.add(items[j]);
					}
					toReturn.add(tempList);
				}

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

		return toReturn;

	}

	public static Object[][] getDataFromFolder(String folderPath) {

		Object[][] toReturn = null;

		List<String> files = getFilesFromFolder(folderPath);
		Integer temp = 0;
		
		HashMap<Integer, List<List<String>>> map = new HashMap<>();

		for (int i = 0; i < files.size(); i++) {

			List<List<String>> listLines = readFile(files.get(i));
			map.put(i, listLines);

			temp = temp + listLines.size() - 1;

		}

		toReturn = new Object[temp][2];
		Integer count = 0;

		for (int i = 0; i < map.size(); i++) {
		//for (int i = 0; i < files.size(); i++) {
			// count++;
			//List<List<String>> listLines = readFile(files.get(i));
			List<List<String>> listLines = map.get(i);
			String tempType = files.get(i).substring(files.get(i).lastIndexOf("\\") + 1, files.get(i).indexOf("."));

			Integer currentCount = count;
			for (int j = 1; j < listLines.size(); j++) {

				toReturn[currentCount][0] = new TableData(
						Arrays.asList(new Column(Name.CURRENT_VALUE, listLines.get(j))));

				switch (tempType) {
				case "RestrictedInstrumentsIndex":
					toReturn[currentCount][1] = Type.COMPLIANCE_RESTRICTED_INSTRUMENTS_INDEX;
					break;
				case "PnLCubeIndex":
					toReturn[currentCount][1] = Type.CUBE_PnL_CUBE_INDEX;
					break;
				case "RiskCubeIndex":
					toReturn[currentCount][1] = Type.CUBE_RISK_CUBE_INDEX;
					break;
				case "TraderPermissionsIndex":
					toReturn[currentCount][1] = Type.ITADMIN_TRADER_PERMISSIONS_INDEX;
					break;
				case "TudorAppPermissionsIndex":
					toReturn[currentCount][1] = Type.ITADMIN_TUDOR_APP_PERMISSIONS_INDEX;
					break;
				case "TudorAppsIndex":
					toReturn[currentCount][1] = Type.ITADMIN_TUDOR_APPS_INDEX;
					break;
				case "TudorUsersIndex":
					toReturn[currentCount][1] = Type.ITADMIN_TUDOR_USERS_INDEX;
					break;
				case "AllocationsEquitiesEquiities":
					toReturn[currentCount][1] = Type.ORDERS_ALLOCATIONS_EQUITIES_EQUITIES;
					break;
				case "AllocationsEquitiesIndex":
					toReturn[currentCount][1] = Type.ORDERS_ALLOCATIONS_EQUITIES_INDEX;
					break;
				case "AllocationsNotionalsIndex":
					toReturn[currentCount][1] = Type.ORDERS_ALLOCATIONS_NOTIONALS_INDEX;
					break;
				case "AllocationsNotionalsNotionals":
					toReturn[currentCount][1] = Type.ORDERS_ALLOCATIONS_NOTIONALS_NOTIONALS;
					break;
				case "SystemAllocRebalanceReportFromFile":
					toReturn[currentCount][1] = Type.ORDERS_SYSTEMS_ALLOC_REBALANCE_REPORT_FROMFILE;
					break;
				case "SystemAllocRebalanceReportIndex":
					toReturn[currentCount][1] = Type.ORDERS_SYSTEMS_ALLOC_REBALANCE_REPORT_INDEX;
					break;
				case "AccountPerformanceByAccount":
					toReturn[currentCount][1] = Type.PERFORMANCE_ACCOUNT_PERFORMANCE_BY_ACCOUNT;
					break;
				case "AccountPerformanceIndex":
					toReturn[currentCount][1] = Type.PERFORMANCE_ACCOUNT_PERFORMANCE_INDEX;
					break;
				case "FundPerformanceByFund":
					toReturn[currentCount][1] = Type.PERFORMANCE_FUND_PERFORMANCE_BY_FUND;
					break;
				case "FundPerformanceIndex":
					toReturn[currentCount][1] = Type.PERFORMANCE_FUND_PERFORMANCE_INDEX;
					break;
				case "GroupSummaryIndex":
					toReturn[currentCount][1] = Type.PERFORMANCE_GROUP_SUMMARY_INDEX;
					break;
				case "SystemNotionalIndex":
					toReturn[currentCount][1] = Type.PERFORMANCE_SYSTEMS_NOTIONAL_INDEX;
					break;
				case "TraderPerformanceBySubfund":
					toReturn[currentCount][1] = Type.PERFORMANCE_TRADER_PERFORMANCE_BY_SUBFUND;
					break;
				case "TraderPerformanceByTrader":
					toReturn[currentCount][1] = Type.PERFORMANCE_TRADER_PERFORMANCE_BY_TRADER;
					break;
				case "TraderPerformanceByTraderAndPnlItem":
					toReturn[currentCount][1] = Type.PERFORMANCE_TRADER_PERFORMANCE_BY_TRADER_AND_PnL_ITEM;
					break;
				case "TraderPerformanceByTraderGroup":
					toReturn[currentCount][1] = Type.PERFORMANCE_TRADER_PERFORMANCE_BY_TRADER_GROUP;
					break;
				case "TraderPerformanceByTraderGroupAndPnlItem":
					toReturn[currentCount][1] = Type.PERFORMANCE_TRADER_PERFORMANCE_BY_TRADER_GROUP_AND_PnL_ITEM;
					break;
				case "TraderPerformanceIndex":
					toReturn[currentCount][1] = Type.PERFORMANCE_TRADER_PERFORMANCE_INDEX;
					break;
				case "PnLActiveNameQueryIndex":
					toReturn[currentCount][1] = Type.PNL_PnL_ACTIVE_NAME_QUERY_INDEX;
					break;
				case "PnLActiveNameQueryAdvancedIndex":
					toReturn[currentCount][1] = Type.PNL_PnL_ACTIVE_NAME_QUERY_ADVANCED_INDEX;
					break;
				case "PnLQueryIndex":
					toReturn[currentCount][1] = Type.PNL_PnL_QUERY_INDEX;
					break;
				case "PnLQueryAdvancedIndex":
					toReturn[currentCount][1] = Type.PNL_PnL_QUERY_ADVANCED_INDEX;
					break;
				case "PnLReportIndex":
					toReturn[currentCount][1] = Type.PNL_PnL_REPORT_INDEX;
					break;
				case "PositionReportIndex":
					toReturn[currentCount][1] = Type.PNL_POSITION_REPORT_INDEX;
					break;
				case "CurveIndex":
					toReturn[currentCount][1] = Type.PRICING_CURVE_INDEX;
					break;
				case "FraQueryIndex":
					toReturn[currentCount][1] = Type.PRICING_FRA_QUERY_INDEX;
					break;
				case "FxCrossesIndex":
					toReturn[currentCount][1] = Type.PRICING_FX_CROSESS_INDEX;
					break;
				case "IrFutureQueryIndex":
					toReturn[currentCount][1] = Type.PRICING_IR_FUTURE_QUERY_INDEX;
					break;
				case "FundRiskAndLiquiditySummaryIndex":
					toReturn[currentCount][1] = Type.RISK_FUND_RISK_AND_LIQUDITY_SUMMARY_INDEX;
					break;
				case "FxExposureIndex":
					toReturn[currentCount][1] = Type.RISK_FX_EXPOSURE_INDEX;
					break;
				case "HistoricVarQueryIndex":
					toReturn[currentCount][1] = Type.RISK_HISTORIC_VAR_QUERY_INDEX;
					break;
				case "InputDateIndex":
					toReturn[currentCount][1] = Type.RISK_INPUT_DATE_INDEX;
					break;
				case "InteractiveSummaryIndex":
					toReturn[currentCount][1] = Type.RISK_INTERACTIVE_SUMMARY_INDEX;
					break;
				case "InteractiveSummarySimulationSeries":
					toReturn[currentCount][1] = Type.RISK_INTERACTIVE_SUMMARY_SIMULATION_SERIES;
					break;
				case "PnLSimulationSeriesByTraderIndex":
					toReturn[currentCount][1] = Type.RISK_PnL_SIMULATION_SERIES_BY_TRADER_INDEX;
					break;
				case "PnLSimulationSeriesIndex":
					toReturn[currentCount][1] = Type.RISK_PnL_SIMULATION_SERIES_INDEX;
					break;
				case "SubFundDrawdownsIndex":
					toReturn[currentCount][1] = Type.RISK_SUBFUND_DRAWDOWNS_INDEX;
					break;
				case "SubFundPnLIndex":
					toReturn[currentCount][1] = Type.RISK_SUBFUND_PnL_INDEX;
					break;
				case "TopRiskFactorsForFundIndex":
					toReturn[currentCount][1] = Type.RISK_TOP_RISK_FACTORS_FOR_FUND_INDEX;
					break;
				case "TraderCommodityExposureIndex":
					toReturn[currentCount][1] = Type.RISK_TRADER_COMMODITY_EXPOSURE_INDEX;
					break;
				case "TraderEquityExposureIndex":
					toReturn[currentCount][1] = Type.RISK_TRADER_EQUITY_EXPOSURE_INDEX;
					break;
				case "TraderFixIncomeExposureIndex":
					toReturn[currentCount][1] = Type.RISK_TRADER_FIX_INCOME_EXPOSURE_INDEX;
					break;
				case "TraderFxExposureIndex":
					toReturn[currentCount][1] = Type.RISK_TRADER_FX_EXPOSURE_INDEX;
					break;
				case "TraderGroupFundBatchHistoryIndex":
					toReturn[currentCount][1] = Type.RISK_TRADER_GROUP_FUND_BATCH_HISTORY_INDEX;
					break;
				case "TraderPointsAlertIndex":
					toReturn[currentCount][1] = Type.RISK_TRADER_POINTS_ALERT_INDEX;
					break;
				case "TraderRiskFactorIndex":
					toReturn[currentCount][1] = Type.RISK_TRADER_RISK_FACTOR_INDEX;
					break;
				case "TraderRiskStatisticsIndex":
					toReturn[currentCount][1] = Type.RISK_TRADER_RISK_STATISTICS_INDEX;
					break;
				case "UserPermissionsIndex":
					toReturn[currentCount][1] = Type.SWAG_USER_PERMISSIONS_INDEX;
					break;
				default:
					break;
				}
				currentCount++;
			}
			// currentCount--;
			count = currentCount;

		}

		return toReturn;

	}
	
	
}
