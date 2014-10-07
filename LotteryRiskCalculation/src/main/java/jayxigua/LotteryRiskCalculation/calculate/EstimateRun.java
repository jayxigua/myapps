package jayxigua.LotteryRiskCalculation.calculate;

import jayxigua.LotteryRiskCalculation.entity.NbaCompetition;
import jayxigua.LotteryRiskCalculation.entity.CompetitionTeam;
import jayxigua.LotteryRiskCalculation.util.TeamUtil;

public class EstimateRun {

	/**
	 * 获取比赛信息，计算一场比赛的 主客队伍的情况
	 * 
	 * @param competition
	 * @return
	 */
	public static EstimateResult run(NbaCompetition competition) {
		CompetitionTeam homeCompetitionTeam = new CompetitionTeam();
		homeCompetitionTeam.setTeam(TeamUtil.getTeamByName(competition.getHomeTeamName()));
		homeCompetitionTeam.setEarningsOdds(competition.getHomeEarningsOdds());
		homeCompetitionTeam.setHome(true);

		CompetitionTeam visitingCompetitionTeam = new CompetitionTeam();
		visitingCompetitionTeam.setTeam(TeamUtil.getTeamByName(competition.getVisitingTeamName()));
		visitingCompetitionTeam.setEarningsOdds(competition.getVisitingEarningsOdds());
		visitingCompetitionTeam.setHome(false);

		return EarningsEstimate.calculateEstimateResult(homeCompetitionTeam, visitingCompetitionTeam);
	}

	// public static final double CHOOSE_MARFA = 60;
	//
	// public static String EarningsEstimates(EstimateResult estimateResult) {
	//
	// double homeEstimateResult = estimateResult.getHomeEstimateResult();
	// double visitingEstimateResult =
	// estimateResult.getVisitingEstimateResult();
	//
	// double big = homeEstimateResult;
	// double small = visitingEstimateResult;
	//
	// if (homeEstimateResult < visitingEstimateResult) {
	// small = homeEstimateResult;
	// big = visitingEstimateResult;
	// }
	//
	// StringBuffer sb = new StringBuffer();
	//
	// double winRate = big * 100 / (big + small);
	// if (winRate > CHOOSE_MARFA) {
	// sb.append("胜率：" + winRate+"，收益估算"+winRate);
	// } else {
	//
	// }
	// }
}
