package jayxigua.LotteryRiskCalculation.calculate.test.history;

import java.util.ArrayList;
import java.util.List;

import jayxigua.LotteryRiskCalculation.nba.calculate.EstimateRun;
import jayxigua.LotteryRiskCalculation.nba.entity.NbaCompetition;

import org.junit.Test;

public class EarningsEstimateTest131222 {

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

		competitions.add(new NbaCompetition("步行者", 1.02, "凯尔特人", 6.0));
		competitions.add(new NbaCompetition("雷霆", 1.04, "猛龙", 5.35));
		competitions.add(new NbaCompetition("快船", 1.28, "森林狼", 2.72));

		return competitions;
	}

}
