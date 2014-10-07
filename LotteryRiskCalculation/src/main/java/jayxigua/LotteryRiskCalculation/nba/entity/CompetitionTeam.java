package jayxigua.LotteryRiskCalculation.nba.entity;

import java.util.Date;

/**
 * 一支球队异常比赛的信息
 * 
 * @author jianbin.zou 2013-12-18
 */
public class CompetitionTeam {
	/**
	 * 一场比赛的球队信息
	 */
	private NbaTeam team;
	/**
	 * 当前比赛的主客情况
	 */
	private boolean isHome;
	private boolean isWest;
	/**
	 * 赔率
	 */
	private double earningsOdds;
	private Date competitionDate;

	public NbaTeam getTeam() {
		return team;
	}

	public void setTeam(NbaTeam team) {
		this.team = team;
	}

	public boolean isHome() {
		return isHome;
	}

	public void setHome(boolean isHome) {
		this.isHome = isHome;
	}

	public boolean isWest() {
		return isWest;
	}

	public void setWest(boolean isWest) {
		this.isWest = isWest;
	}

	public double getEarningsOdds() {
		return earningsOdds;
	}

	public void setEarningsOdds(double earningsOdds) {
		this.earningsOdds = earningsOdds;
	}

	public Date getCompetitionDate() {
		return competitionDate;
	}

	public void setCompetitionDate(Date competitionDate) {
		this.competitionDate = competitionDate;
	}

}
