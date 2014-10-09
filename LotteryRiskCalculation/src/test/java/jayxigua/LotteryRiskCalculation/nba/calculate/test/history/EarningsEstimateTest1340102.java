package jayxigua.LotteryRiskCalculation.nba.calculate.test.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jayxigua.LotteryRiskCalculation.nba.calculate.EstimateResult;
import jayxigua.LotteryRiskCalculation.nba.calculate.EstimateRun;
import jayxigua.LotteryRiskCalculation.nba.datasource.tradeinfo.TradeInfoParsing;
import jayxigua.LotteryRiskCalculation.nba.entity.NbaCompetition;

import org.junit.Test;

/**
 * @author jianbin.zou
 *         自动解析http://nba.sports.sina.com.cn/league_order1.php?&dpc=1 下载的信息
 *         2013-12-27
 */
public class EarningsEstimateTest1340102 {

	/**
	 * 加入 东西部因素
	 */
	@Test
	public void calculate() {
		List<NbaCompetition> competitions = createCompetitionList();

		List<EstimateResult> estimateResultList = new ArrayList<EstimateResult>();

		for (NbaCompetition competition : competitions) {
			EstimateResult result = EstimateRun.run(competition);
			estimateResultList.add(result);
		}

		EstimateResult[] estimateResults = new EstimateResult[estimateResultList.size()];

		estimateResultList.toArray(estimateResults);
		Arrays.sort(estimateResults);

		for (int i = 0; i < estimateResults.length; i++) {
			System.out.println("第" + (i + 1) + "场比赛");
			System.out.println(estimateResults[i]);
		}

	}

	List<NbaCompetition> createCompetitionList() {
		List<NbaCompetition> competitions = new ArrayList<NbaCompetition>();

		List<String> tradeInfos = new TradeInfoParsing().getTradeInfos();
		for (String tradeInfo : tradeInfos) {
			String tradeLine = TradeInfoParsing.tradeInfoLine2TradeLine(tradeInfo);
			String[] tradeLines = tradeLine.split(",");

			competitions.add(new NbaCompetition(tradeLines[0], Double.parseDouble(tradeLines[2]),
					tradeLines[1], Double.parseDouble(tradeLines[3])));
		}

		return competitions;
	}
}
