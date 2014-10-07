package jayxigua.LotteryRiskCalculation.soccer.service;

import jayxigua.LotteryRiskCalculation.soccer.entity.ExploitsStateValue;
import jayxigua.LotteryRiskCalculation.soccer.entity.SoccerMatch;
import jayxigua.LotteryRiskCalculation.soccer.entity.SoccerTeam;

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
	public static ExploitsStateValue calculateResultProb(SoccerMatch match) {
		ExploitsStateValue ef = new ExploitsStateValue();
		return ef;
	}

	/**
	 * 计算队伍的实力
	 * 
	 * @return
	 */
	static ExploitsStateValue calculateTeamStrength(SoccerTeam team) {
		ExploitsStateValue esv = new ExploitsStateValue();
		return esv.exploitsAddition(team.getLast10Exploits(), "10").exploitsAddition(team.getLast10homeVisitingExploits(), "10");
	}

}
