package jayxigua.LotteryRiskCalculation.entity;

/**
 * 一场NBA比赛
 * 
 * @author jianbin.zou 2014-1-5
 */
public class NbaCompetition {

	private String homeTeamName;
	private double homeEarningsOdds;

	private String visitingTeamName;
	private double visitingEarningsOdds;

	public NbaCompetition(String visitingTeamName, double visitingEarningsOdds,
			String homeTeamName, double homeEarningsOdds) {

		this.homeTeamName = homeTeamName;
		this.homeEarningsOdds = homeEarningsOdds;

		this.visitingTeamName = visitingTeamName;
		this.visitingEarningsOdds = visitingEarningsOdds;
	}

	public String getHomeTeamName() {
		return homeTeamName;
	}

	public void setHomeTeamName(String homeTeamName) {
		this.homeTeamName = homeTeamName;
	}

	public double getHomeEarningsOdds() {
		return homeEarningsOdds;
	}

	public void setHomeEarningsOdds(double homeEarningsOdds) {
		this.homeEarningsOdds = homeEarningsOdds;
	}

	public String getVisitingTeamName() {
		return visitingTeamName;
	}

	public void setVisitingTeamName(String visitingTeamName) {
		this.visitingTeamName = visitingTeamName;
	}

	public double getVisitingEarningsOdds() {
		return visitingEarningsOdds;
	}

	public void setVisitingEarningsOdds(double visitingEarningsOdds) {
		this.visitingEarningsOdds = visitingEarningsOdds;
	}

}
