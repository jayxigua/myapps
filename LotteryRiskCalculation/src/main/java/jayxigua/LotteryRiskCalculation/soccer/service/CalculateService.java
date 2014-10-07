package jayxigua.LotteryRiskCalculation.soccer.service;

import java.math.BigDecimal;

import jayxigua.LotteryRiskCalculation.soccer.entity.ExploitsStateValue;
import jayxigua.LotteryRiskCalculation.soccer.entity.SoccerMatch;
import jayxigua.LotteryRiskCalculation.soccer.entity.SoccerTeam;
import jayxigua.LotteryRiskCalculation.soccer.util.MyNumberUtils;

public class CalculateService {

	public static String LAST_10_BASE = "10";
	public static String LAST_10_HOME_VIST_BASE = "20";
	public static String LAST_6_EACH_BASE = "6";

	public static String LIGA_LVEEL_BASE = "5";

	public static void calculateMatch(SoccerMatch match) {
		calculateResultProb(match);
	}

	/**
	 * 计算比赛结果概率
	 * 
	 * @param match
	 * @return
	 */
	public static void calculateResultProb(SoccerMatch match) {
		ExploitsStateValue esvH = calculateTeamStrength(match.getHome());
		esvH.setWin(esvH.getWin().multiply(MyNumberUtils.getBaseIncrease(LIGA_LVEEL_BASE, match.getHome().getLigaLevel().toString())));
		ExploitsStateValue esvV = calculateTeamStrength(match.getVisiting());
		esvH.setWin(esvV.getWin().multiply(MyNumberUtils.getBaseIncrease(LIGA_LVEEL_BASE, match.getVisiting().getLigaLevel().toString())));

		System.out.println(esvH);
		System.out.println(esvV);

		BigDecimal last6W = MyNumberUtils.getBaseIncrease(LAST_6_EACH_BASE, match.getLast6EachExploits().getWin().toString());
		BigDecimal last6P = MyNumberUtils.getBaseIncrease(LAST_6_EACH_BASE, match.getLast6EachExploits().getPlanish().toString());
		BigDecimal last6L = MyNumberUtils.getBaseIncrease(LAST_6_EACH_BASE, match.getLast6EachExploits().getLose().toString());

		BigDecimal esvW = esvH.getWin().multiply(esvV.getLose());
		BigDecimal esvP = esvH.getPlanish().multiply(esvV.getPlanish());
		BigDecimal esvL = esvH.getLose().multiply(esvV.getWin());

		System.out.println(last6W + "," + esvW + "," + last6W.multiply(esvW));
		System.out.println(last6P + "," + esvP + "," + last6P.multiply(esvW));
		System.out.println(last6L + "," + esvL + "," + last6L.multiply(esvW));

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
