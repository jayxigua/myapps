package jayxigua.LotteryRiskCalculation.nba.calculate.test.history;

import java.util.ArrayList;
import java.util.List;

import jayxigua.LotteryRiskCalculation.nba.calculate.EstimateRun;
import jayxigua.LotteryRiskCalculation.nba.entity.NbaCompetition;

import org.junit.Test;

public class EarningsEstimateTest131226 {

	/**
	 * 加入 东西部因素
	 */
	@Test
	public void calculate() {
		List<NbaCompetition> competitions = createCompetitionList();
		int count = 1;
		for (NbaCompetition competition : competitions) {
			System.out.println("---比赛" + count++ + "---");
			System.out.println(EstimateRun.run(competition));
			System.out.println("--");
		}
	}

	List<NbaCompetition> createCompetitionList() {
		List<NbaCompetition> competitions = new ArrayList<NbaCompetition>();

		competitions.add(new NbaCompetition("老鹰", 1.48, "骑士", 2.11));
		competitions.add(new NbaCompetition("灰熊", 4.02, "火箭", 1.11));
		competitions.add(new NbaCompetition("马刺", 1.48, "小牛", 2.16));
		competitions.add(new NbaCompetition("快船", 2.36, "开拓者", 1.38));

		return competitions;
	}

}
