package jayxigua.LotteryRiskCalculation.nba.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jayxigua.LotteryRiskCalculation.nba.calculate.EstimateResult;
import jayxigua.LotteryRiskCalculation.nba.calculate.EstimateRun;
import jayxigua.LotteryRiskCalculation.nba.datasource.tradeinfo.TradeInfoParsing;
import jayxigua.LotteryRiskCalculation.nba.entity.NbaCompetition;
import jayxigua.LotteryRiskCalculation.nba.exhibition.EstimateResultShow;

/**
 * @author jianbin.zou 2014-1-5
 */
public class EarningsEstimateRun {
	public static void main(String[] args) {

		List<NbaCompetition> competitions = createCompetitionList();

		List<EstimateResult> estimateResultList = new ArrayList<EstimateResult>();

		for (NbaCompetition competition : competitions) {
			EstimateResult result = EstimateRun.run(competition);
			estimateResultList.add(result);
		}
		// 构建结果数组（根据胜率排序）
		EstimateResult[] estimateResults = new EstimateResult[estimateResultList.size()];
		estimateResultList.toArray(estimateResults);
		Arrays.sort(estimateResults);

		for (int i = 0; i < estimateResults.length; i++) {
			System.out.println("第" + (i + 1) + "场比赛");
			EstimateResultShow.showEstimateResultByForce(estimateResults[i]);
			EstimateResultShow.showEarningsOdds(estimateResults[i]);
		}

	}

	/**
	 * 将解析trade后，生成的数据，构建Competition对象
	 * 
	 * @return
	 */
	static List<NbaCompetition> createCompetitionList() {
		List<NbaCompetition> competitions = new ArrayList<NbaCompetition>();

		List<String> tradeInfos = new TradeInfoParsing().getTradeInfos();
		for (String tradeInfo : tradeInfos) {
			// 解析成有用的数据行
			String tradeLine = TradeInfoParsing.tradeInfoLine2TradeLine(tradeInfo);
			String[] tradeLines = tradeLine.split(",");

			competitions.add(new NbaCompetition(tradeLines[0], Double.parseDouble(tradeLines[2]),
					tradeLines[1], Double.parseDouble(tradeLines[3])));
		}

		return competitions;
	}
}
