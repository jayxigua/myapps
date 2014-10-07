package jayxigua.LotteryRiskCalculation.calculate.test.history;

import java.util.ArrayList;
import java.util.List;

import jayxigua.LotteryRiskCalculation.nba.calculate.EstimateRun;
import jayxigua.LotteryRiskCalculation.nba.entity.NbaCompetition;

import org.junit.Test;

/**
 * @author jianbin.zou
 *         自动解析http://nba.sports.sina.com.cn/league_order1.php?&dpc=1 下载的信息
 *         2013-12-27
 */
public class EarningsEstimateTest131227 {

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

		competitions.add(new NbaCompetition("雷霆", 1.08, "山猫", 4.50));
		competitions.add(new NbaCompetition("活塞", 1.36, "魔术", 2.42));
		competitions.add(new NbaCompetition("雄鹿", 2.63, "篮网", 1.30));

		competitions.add(new NbaCompetition("猛龙", 1.47, "尼克斯", 2.13));
		competitions.add(new NbaCompetition("奇才", 3.00, "森林狼", 1.23));
		competitions.add(new NbaCompetition("掘金", 2.00, "鹈鹕", 1.54));

		competitions.add(new NbaCompetition("湖人", 2.07, "爵士", 1.50));
		competitions.add(new NbaCompetition("热火", 1.10, "国王", 4.16));
		competitions.add(new NbaCompetition("太阳", 2.81, "勇士", 1.26));

		return competitions;
	}

}
