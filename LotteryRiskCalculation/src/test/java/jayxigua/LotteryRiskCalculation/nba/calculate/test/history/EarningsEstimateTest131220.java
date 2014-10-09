package jayxigua.LotteryRiskCalculation.nba.calculate.test.history;

import java.util.ArrayList;
import java.util.List;

import jayxigua.LotteryRiskCalculation.nba.calculate.EstimateRun;
import jayxigua.LotteryRiskCalculation.nba.entity.NbaCompetition;

import org.junit.Test;

public class EarningsEstimateTest131220 {

	@Test
	public void runEnv() {

	}

	@Test
	public void calculate() {
		List<NbaCompetition> competitions = createCompetitionList();
		int count = 1;
		for (NbaCompetition competition : competitions) {
			System.out.println("---比赛" + count++ + "---");
			System.out.println(EstimateRun.run(competition));
		}
	}

	List<NbaCompetition> createCompetitionList() {
		List<NbaCompetition> competitions = new ArrayList<NbaCompetition>();
		competitions.add(new NbaCompetition("76人", 2.98, "篮网", 1.23));
		competitions.add(new NbaCompetition("老鹰", 1.12, "爵士", 3.90));
		competitions.add(new NbaCompetition("骑士", 1.07, "雄鹿", 4.65));
		competitions.add(new NbaCompetition("活塞", 1.23, "山猫", 3.00));
		competitions.add(new NbaCompetition("热火", 1.01, "国王", 6.30));
		competitions.add(new NbaCompetition("步行者", 1.26, "火箭", 2.82));
		competitions.add(new NbaCompetition("小牛", 1.18, "猛龙", 3.32));
		competitions.add(new NbaCompetition("掘金", 2.39, "太阳", 2.39));
		competitions.add(new NbaCompetition("湖人", 2.98, "森林狼", 1.23));
		return competitions;
	}

}
