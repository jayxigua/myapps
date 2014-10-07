package jayxigua.LotteryRiskCalculation.nba.calculate;

import jayxigua.LotteryRiskCalculation.nba.entity.CompetitionTeam;

public class EarningsEstimate {

	/**
	 * 计算 主客队伍的情况
	 * 
	 * @param homeCompetitionTeam
	 * @param visitingCompetitionTeam
	 * @return
	 */
	public static EstimateResult calculateEstimateResult(CompetitionTeam homeCompetitionTeam,
			CompetitionTeam visitingCompetitionTeam) {

		double homeTeamFightingForce = TeamFightingForce
				.generateTeamFightingForce(homeCompetitionTeam);

		double visitingTeamFightingForce = TeamFightingForce
				.generateTeamFightingForce(visitingCompetitionTeam);

		/**
		 * 构造返回对象
		 */
		EstimateResult estimateResult = new EstimateResult(homeCompetitionTeam.getTeam().getName(),
				homeTeamFightingForce, visitingCompetitionTeam.getTeam().getName(),
				visitingTeamFightingForce);

		// set收益情况
		estimateResult.setHomeTeamEarningsOdds(homeCompetitionTeam.getEarningsOdds());
		estimateResult.setVisitingTeamEarningsOdds(visitingCompetitionTeam.getEarningsOdds());

		return estimateResult;
	}

	/**
	 * 根据风险计算收益
	 * 
	 * @param estimateResult
	 */
	public static double calculatePowerTeamEarningsOdds(EstimateResult estimateResult) {
		double ratio = estimateResult.getRatio();
		double powerfulOddsRate = 100 * ratio / (ratio + 1);
		return powerfulOddsRate * getOdds(estimateResult, true);
	}

	public static double calculateWeakTeamEarningsOdds(EstimateResult estimateResult) {
		double ratio = estimateResult.getRatio();
		double weakRate = 100 * 1 / (ratio + 1);
		return weakRate * getOdds(estimateResult, false);
	}

	/**
	 * 得到收益值
	 * 
	 * @param estimateResult
	 * @param isHomePowerful
	 * @return
	 */
	private static double getOdds(EstimateResult estimateResult, boolean isPowerful) {
		if (estimateResult.isHomePowerful()) {
			if (isPowerful) {
				return estimateResult.getHomeTeamEarningsOdds();
			} else {
				return estimateResult.getVisitingTeamEarningsOdds();
			}
		} else {
			if (isPowerful) {
				return estimateResult.getVisitingTeamEarningsOdds();
			} else {
				return estimateResult.getHomeTeamEarningsOdds();
			}
		}
	}
}
