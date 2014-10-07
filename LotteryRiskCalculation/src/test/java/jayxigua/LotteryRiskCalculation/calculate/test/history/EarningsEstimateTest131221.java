package jayxigua.LotteryRiskCalculation.calculate.test.history;

import java.util.ArrayList;
import java.util.List;

import jayxigua.LotteryRiskCalculation.calculate.EstimateRun;
import jayxigua.LotteryRiskCalculation.entity.NbaCompetition;

import org.junit.Test;

public class EarningsEstimateTest131221 {

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
		
		competitions.add(new NbaCompetition("尼克斯", 1.38, "灰熊", 2.36));
		competitions.add(new NbaCompetition("凯尔特人", 1.75, "奇才", 1.75));
		competitions.add(new NbaCompetition("魔术", 1.59, "国王", 1.92));
		competitions.add(new NbaCompetition("山猫", 1.34, "爵士", 2.48));

		competitions.add(new NbaCompetition("活塞", 2.08, "火箭", 1.50));
		competitions.add(new NbaCompetition("公牛", 1.54, "骑士", 2.00));
		competitions.add(new NbaCompetition("雄鹿", 1.57, "76人", 1.95));
		competitions.add(new NbaCompetition("马刺", 1.66, "雷霆", 1.83));

		competitions.add(new NbaCompetition("太阳", 1.65, "小牛", 1.84));
		competitions.add(new NbaCompetition("开拓者", 1.06, "鹈鹕", 4.85));
		competitions.add(new NbaCompetition("勇士", 1.01, "湖人", 6.30));
		competitions.add(new NbaCompetition("快船", 1.15, "掘金", 3.60));
		return competitions;
	}

}
