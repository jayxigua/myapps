package jayxigua.LotteryRiskCalculation.soccer.service;

import java.math.BigDecimal;
import java.util.List;

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
	public static List<BigDecimal> calculateResultProb(SoccerMatch match) {

	}

	/**
	 * 计算队伍的实力
	 * 
	 * @return
	 */
	static List<BigDecimal> calculateTeamStrength() {

	}
}
