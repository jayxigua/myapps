package jayxigua.LotteryRiskCalculation.soccer.service;

import jayxigua.LotteryRiskCalculation.soccer.entity.Exploits;
import jayxigua.LotteryRiskCalculation.soccer.entity.ExploitsFactor;
import jayxigua.LotteryRiskCalculation.soccer.entity.SoccerMatch;
import jayxigua.LotteryRiskCalculation.soccer.entity.SoccerTeam;
import jayxigua.LotteryRiskCalculation.soccer.util.MyNumberUtils;

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
	static ExploitsFactor calculateTeamStrength(SoccerTeam team) {
		ExploitsFactor ef = new ExploitsFactor();
		ef.setWin(MyNumberUtils.getBaseIncrease("", team.getLast10Exploits()));
		return ef;
	}

	/**
	 * 因素叠加
	 * 
	 * @param original
	 * @param exploits
	 * @param base
	 * @return
	 */
	static ExploitsFactor exploitsAddition(ExploitsFactor original, Exploits exploits, String base) {
		ExploitsFactor target = new ExploitsFactor();
		target.setWin(original.getWin().multiply(MyNumberUtils.getBaseIncrease(base, exploits.getWin().toString())));
		target.setWin(original.getPlanish().multiply(MyNumberUtils.getBaseIncrease(base, exploits.getPlanish().toString())));
		target.setWin(original.getLose().multiply(MyNumberUtils.getBaseIncrease(base, exploits.getLose().toString())));
		return target;
	}
}
