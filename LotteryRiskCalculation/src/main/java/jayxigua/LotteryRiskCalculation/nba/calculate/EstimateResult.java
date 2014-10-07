package jayxigua.LotteryRiskCalculation.nba.calculate;

import jayxigua.LotteryRiskCalculation.nba.util.NumberUtil;

/**
 * @author jianbin.zou 2013-12-31
 */
public class EstimateResult implements Comparable<EstimateResult> {

	private String homeTeamName;
	private double homeTeamEarningsOdds;
	private double homeForceResult;

	private String visitingTeamName;
	private double visitingTeamEarningsOdds;
	private double visitingForceResult;

	private double ratio;
	private boolean isHomePowerful;

	EstimateResult(String homeTeamName, double homeForceResult, String visitingTeamName,
			double visitingForceResult) {

		this.homeTeamName = homeTeamName;
		this.homeForceResult = homeForceResult;
		this.visitingTeamName = visitingTeamName;
		this.visitingForceResult = visitingForceResult;

		/**
		 * 以战斗力强的为标准
		 */
		if (homeForceResult > visitingForceResult) {
			this.isHomePowerful = true;
			this.ratio = homeForceResult / visitingForceResult;
		} else {
			this.ratio = visitingForceResult / homeForceResult;
		}
	}

	public double getHomeForceResult() {
		return homeForceResult;
	}

	public void setHomeForceResult(double homeForceResult) {
		this.homeForceResult = homeForceResult;
	}

	public double getVisitingForceResult() {
		return visitingForceResult;
	}

	public void setVisitingForceResult(double visitingForceResult) {
		this.visitingForceResult = visitingForceResult;
	}

	public String getHomeTeamName() {
		return homeTeamName;
	}

	public void setHomeTeamName(String homeTeamName) {
		this.homeTeamName = homeTeamName;
	}

	public String getVisitingTeamName() {
		return visitingTeamName;
	}

	public void setVisitingTeamName(String visitingTeamName) {
		this.visitingTeamName = visitingTeamName;
	}

	public double getRatio() {
		return ratio;
	}

	public boolean isHomePowerful() {
		return isHomePowerful;
	}

	public double getHomeTeamEarningsOdds() {
		return homeTeamEarningsOdds;
	}

	public void setHomeTeamEarningsOdds(double homeTeamEarningsOdds) {
		this.homeTeamEarningsOdds = homeTeamEarningsOdds;
	}

	public double getVisitingTeamEarningsOdds() {
		return visitingTeamEarningsOdds;
	}

	public void setVisitingTeamEarningsOdds(double visitingTeamEarningsOdds) {
		this.visitingTeamEarningsOdds = visitingTeamEarningsOdds;
	}

	public int compareTo(EstimateResult o) {
		if (this.getRatio() - o.getRatio() < 0) {
			return 1;
		}
		return -1;
	}

	@Override
	public String toString() {
		if (homeForceResult > visitingForceResult) {
			return "EstimateResult [homeTeamName=" + homeTeamName + ", homeEstimateResult="
					+ NumberUtil.AccurateDisplay(homeForceResult) + ", visitingTeamName="
					+ visitingTeamName + ", visitingEstimateResult="
					+ NumberUtil.AccurateDisplay(visitingForceResult) + ", ratio="
					+ NumberUtil.AccurateDisplay(ratio) + "]";
		} else {
			return "EstimateResult [visitingTeamName=" + visitingTeamName
					+ ", visitingEstimateResult=" + NumberUtil.AccurateDisplay(visitingForceResult)
					+ ",homeTeamName=" + homeTeamName + ", homeEstimateResult="
					+ NumberUtil.AccurateDisplay(homeForceResult) + ", ratio="
					+ NumberUtil.AccurateDisplay(ratio) + "]";
		}
	}
}
