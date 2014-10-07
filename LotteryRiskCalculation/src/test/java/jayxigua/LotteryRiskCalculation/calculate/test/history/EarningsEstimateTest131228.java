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
public class EarningsEstimateTest131228 {

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

		competitions.add(new NbaCompetition("骑士", 2.00, "凯尔特人", 1.54));
		competitions.add(new NbaCompetition("篮网", 6.30, "步行者", 1.01));
		competitions.add(new NbaCompetition("活塞", 1.95, "奇才", 1.57));

		competitions.add(new NbaCompetition("山猫", 3.10, "老鹰", 1.21));
		competitions.add(new NbaCompetition("掘金", 2.00, "灰熊", 1.54));
		competitions.add(new NbaCompetition("森林狼", 1.14, "雄鹿", 3.67));

		competitions.add(new NbaCompetition("76人", 5.32, "太阳", 1.04));
		competitions.add(new NbaCompetition("热火", 1.84, "开拓者", 1.65));
		competitions.add(new NbaCompetition("爵士", 6.30, "快船", 1.01));

		return competitions;
	}

}
