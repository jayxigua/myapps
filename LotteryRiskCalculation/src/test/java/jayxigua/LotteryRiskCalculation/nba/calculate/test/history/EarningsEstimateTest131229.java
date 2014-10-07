package jayxigua.LotteryRiskCalculation.nba.calculate.test.history;

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
public class EarningsEstimateTest131229 {

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

		competitions.add(new NbaCompetition("勇士", 1.20, "骑士", 3.16));
		competitions.add(new NbaCompetition("老鹰", 1.64, "魔术", 1.86));
		competitions.add(new NbaCompetition("火箭", 2.25, "雷霆", 1.42));

		competitions.add(new NbaCompetition("国王", 6.00, "马刺", 1.02));
		competitions.add(new NbaCompetition("76人", 2.86, "湖人", 1.25));

		return competitions;
	}

}
