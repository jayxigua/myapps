package jayxigua.LotteryRiskCalculation.nba.calculate.test.history;

import java.util.ArrayList;
import java.util.List;

import jayxigua.LotteryRiskCalculation.nba.calculate.EstimateRun;
import jayxigua.LotteryRiskCalculation.nba.entity.NbaCompetition;

import org.junit.Test;

public class EarningsEstimateTest131225 {

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

		competitions.add(new NbaCompetition("篮网", 1.50, "公牛", 2.07));
		competitions.add(new NbaCompetition("尼克斯", 4.85, "雷霆", 1.06));
		competitions.add(new NbaCompetition("湖人", 5.10, "热火", 1.05));
		competitions.add(new NbaCompetition("马刺", 1.18, "火箭", 3.32));
		competitions.add(new NbaCompetition("勇士", 1.62, "快船", 1.88));

		return competitions;
	}

}
