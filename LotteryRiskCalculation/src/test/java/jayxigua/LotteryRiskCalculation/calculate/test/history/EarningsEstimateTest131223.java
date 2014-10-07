package jayxigua.LotteryRiskCalculation.calculate.test.history;

import java.util.ArrayList;
import java.util.List;

import jayxigua.LotteryRiskCalculation.calculate.EstimateRun;
import jayxigua.LotteryRiskCalculation.entity.NbaCompetition;

import org.junit.Test;

public class EarningsEstimateTest131223 {

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

		competitions.add(new NbaCompetition("山猫", 1.19, "雄鹿", 3.23));
		competitions.add(new NbaCompetition("骑士", 1.76, "活塞", 1.72));
		competitions.add(new NbaCompetition("魔术", 1.97, "尼克斯", 1.56));
		competitions.add(new NbaCompetition("篮网", 3.23, "步行者", 1.19));
		competitions.add(new NbaCompetition("热火", 1.08, "老鹰", 4.47));
		competitions.add(new NbaCompetition("火箭", 1.30, "小牛", 2.63));

		competitions.add(new NbaCompetition("灰熊", 1.25, "爵士", 2.86));
		competitions.add(new NbaCompetition("马刺", 1.01, "猛龙", 6.26));
		competitions.add(new NbaCompetition("掘金", 1.87, "勇士", 1.63));
		competitions.add(new NbaCompetition("太阳", 1.13, "湖人", 3.78));
		competitions.add(new NbaCompetition("国王", 1.70, "鹈鹕", 1.79));

		return competitions;
	}

}
