package jayxigua.LotteryRiskCalculation.exhibition;

import jayxigua.LotteryRiskCalculation.calculate.EarningsEstimate;
import jayxigua.LotteryRiskCalculation.calculate.EstimateResult;
import jayxigua.LotteryRiskCalculation.util.NumberUtil;

public class EstimateResultShow {

	public static final String ESTIMATE_RESULT_BY_FORCE = "胜率高的队伍：%s,胜率为：%s，%s场球队；另一队伍为%s。";

	public static final String EARNINGS_ODDS = "胜率高的队伍：%s,收益预算为：%s；另一队伍为%s，收益预算为：%s。";

	/**
	 * 展示球队实例结果信息
	 * 
	 * @param estimateResult
	 */
	public static void showEstimateResultByForce(EstimateResult estimateResult) {

		String showResult;
		if (estimateResult.isHomePowerful()) {
			showResult = String.format(ESTIMATE_RESULT_BY_FORCE, estimateResult.getHomeTeamName(),
					NumberUtil.AccurateDisplay(estimateResult.getRatio()), "主",
					estimateResult.getVisitingTeamName());
		} else {
			showResult = String.format(ESTIMATE_RESULT_BY_FORCE,
					estimateResult.getVisitingTeamName(),
					NumberUtil.AccurateDisplay(estimateResult.getRatio()), "客",
					estimateResult.getHomeTeamName());
		}
		System.out.println(showResult);
	}

	public static void showEarningsOdds(EstimateResult estimateResult) {
		String showResult;
		if (estimateResult.isHomePowerful()) {
			showResult = String.format(EARNINGS_ODDS, estimateResult.getHomeTeamName(), NumberUtil
					.AccurateDisplay(EarningsEstimate
							.calculatePowerTeamEarningsOdds(estimateResult)), estimateResult
					.getVisitingTeamName(), NumberUtil.AccurateDisplay(EarningsEstimate
					.calculateWeakTeamEarningsOdds(estimateResult)));
		} else {
			showResult = String.format(EARNINGS_ODDS, estimateResult.getVisitingTeamName(),
					NumberUtil.AccurateDisplay(EarningsEstimate
							.calculatePowerTeamEarningsOdds(estimateResult)), estimateResult
							.getHomeTeamName(), NumberUtil.AccurateDisplay(EarningsEstimate
							.calculateWeakTeamEarningsOdds(estimateResult)));
		}
		System.out.println(showResult);
	}

}
