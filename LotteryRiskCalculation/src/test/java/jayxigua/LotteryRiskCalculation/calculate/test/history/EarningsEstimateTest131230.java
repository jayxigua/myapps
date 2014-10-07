package jayxigua.LotteryRiskCalculation.calculate.test.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jayxigua.LotteryRiskCalculation.calculate.EstimateResult;
import jayxigua.LotteryRiskCalculation.calculate.EstimateRun;
import jayxigua.LotteryRiskCalculation.entity.NbaCompetition;

import org.junit.Test;

/**
 * @author jianbin.zou
 *         自动解析http://nba.sports.sina.com.cn/league_order1.php?&dpc=1 下载的信息
 *         2013-12-27
 */
public class EarningsEstimateTest131230 {

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

		competitions.add(new NbaCompetition("老鹰", 1.88, "凯尔特人", 1.62));
		competitions.add(new NbaCompetition("骑士", 6.30, "步行者", 1.01));
		competitions.add(new NbaCompetition("勇士", 1.25, "魔术", 2.86));

		competitions.add(new NbaCompetition("国王", 4.65, "火箭", 1.07));
		competitions.add(new NbaCompetition("篮网", 6.30, "马刺", 1.01));
		competitions.add(new NbaCompetition("猛龙", 1.60, "公牛", 1.91));

		competitions.add(new NbaCompetition("开拓者", 2.39, "雷霆", 1.37));
		competitions.add(new NbaCompetition("雄鹿", 2.60, "湖人", 1.31));

		return competitions;
	}

}
