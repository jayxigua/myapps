package jayxigua.LotteryRiskCalculation.soccer.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import jayxigua.LotteryRiskCalculation.soccer.entity.CalculateProResult;
import jayxigua.LotteryRiskCalculation.soccer.entity.ExploitsStateValue;
import jayxigua.LotteryRiskCalculation.soccer.entity.SoccerMatch;
import jayxigua.LotteryRiskCalculation.soccer.entity.SoccerTeam;
import jayxigua.LotteryRiskCalculation.soccer.util.LocalLogUtils;
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
	public static CalculateProResult calculateResultProb(SoccerMatch match) {
		CalculateProResult cpr = new CalculateProResult();

		ExploitsStateValue esvH = calculateTeamStrength(match.getHome());
		ExploitsStateValue esvV = calculateTeamStrength(match.getVisiting());
		LocalLogUtils.infoPrint("esvH (before LIGA_LVEEL_BASE): " + esvH.toString());
		LocalLogUtils.infoPrint("esvV (before LIGA_LVEEL_BASE):  " + esvV.toString());

		// TODO abstract fun
		esvH.setWin(esvH.getWin().multiply(MyNumberUtils.getBaseIncrease(LIGA_LVEEL_BASE, match.getHome().getLigaLevel().toString())));
		esvH.setLose(esvH.getLose().divide(MyNumberUtils.getBaseIncrease(LIGA_LVEEL_BASE, match.getHome().getLigaLevel().toString()), MyNumberUtils.SCALE,
				RoundingMode.HALF_UP));
		esvV.setWin(esvV.getWin().multiply(MyNumberUtils.getBaseIncrease(LIGA_LVEEL_BASE, match.getVisiting().getLigaLevel().toString())));
		esvV.setLose(esvV.getLose().divide(MyNumberUtils.getBaseIncrease(LIGA_LVEEL_BASE, match.getHome().getLigaLevel().toString()), MyNumberUtils.SCALE,
				RoundingMode.HALF_UP));

		LocalLogUtils.infoPrint("esvH " + esvH.toString());
		LocalLogUtils.infoPrint("esvV " + esvV.toString());
		LocalLogUtils.debugPrint("getLast6EachExploits " + match.getLast6EachExploits().toString());

		// 主队胜利概率：主队胜*客队负值
		BigDecimal esvW = esvH.getWin().multiply(esvV.getLose());
		BigDecimal esvP = esvH.getPlanish().multiply(esvV.getPlanish());
		BigDecimal esvL = esvH.getLose().multiply(esvV.getWin());
		cpr.setPowerEsv(new ExploitsStateValue(esvW, esvP, esvL));

		BigDecimal last6W = MyNumberUtils.getBaseIncrease(LAST_6_EACH_BASE, match.getLast6EachExploits().getWin().toString());
		BigDecimal last6P = MyNumberUtils.getBaseIncrease(LAST_6_EACH_BASE, match.getLast6EachExploits().getPlanish().toString());
		BigDecimal last6L = MyNumberUtils.getBaseIncrease(LAST_6_EACH_BASE, match.getLast6EachExploits().getLose().toString());
		cpr.setLast6WEsv(new ExploitsStateValue(last6W, last6P, last6L));

		LocalLogUtils.infoPrint("calculateResultProb-CalculateProResult :" + cpr);
		return cpr;

	}

	/**
	 * 计算队伍的实力
	 * 
	 * @return
	 */
	static ExploitsStateValue calculateTeamStrength(SoccerTeam team) {
		ExploitsStateValue esv = new ExploitsStateValue();
		return esv.exploitsAddition(team.getLast10Exploits(), LAST_10_BASE).exploitsAddition(team.getLast10homeVisitingExploits(), LAST_10_HOME_VIST_BASE);
	}

}
