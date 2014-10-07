package jayxigua.LotteryRiskCalculation.soccer.service;

import jayxigua.LotteryRiskCalculation.soccer.entity.ExploitsFactor;
import jayxigua.LotteryRiskCalculation.soccer.entity.SoccerMatch;

public class CalculateService {

	public static void calculateMatch(SoccerMatch match) {
		calculateResultProb(match);
	}

	/**
	 * 计算比赛结果概率
	 * 
	 * @param match
	 * @return
	 */
	public static ExploitsFactor calculateResultProb(SoccerMatch match) {
		ExploitsFactor ef = new ExploitsFactor();
		return ef;
	}

	/**
	 * 计算队伍的实力
	 * 
	 * @return
	 */
	static ExploitsFactor calculateTeamStrength() {
		ExploitsFactor ef = new ExploitsFactor();
		return ef;
	}
}
