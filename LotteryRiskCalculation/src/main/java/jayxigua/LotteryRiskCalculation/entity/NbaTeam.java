package jayxigua.LotteryRiskCalculation.entity;

/**
 * 一支NBA球队
 * 
 * @author jianbin.zou 2013-12-18
 */
public class NbaTeam {

	/**
	 * 球队信息
	 * 
	 * @param name
	 * @param totalRacesWon
	 * @param totalRacesLose
	 * @param homeRacesWon
	 * @param homeRacesLose
	 * @param visitingRacesWon
	 * @param visitingRacesLose
	 * @param recentResults
	 */
	public NbaTeam(String name, int totalRacesWon, int totalRacesLose, int homeRacesWon,
			int homeRacesLose, int visitingRacesWon, int visitingRacesLose, int recentResults) {
		super();
		this.name = name;

		this.totalRacesWon = totalRacesWon;
		this.totalRaces = totalRacesWon + totalRacesLose;
		this.homeRacesWon = homeRacesWon;
		this.homeRaces = homeRacesWon + homeRacesLose;
		this.visitingRacesWon = visitingRacesWon;
		this.visitingRaces = visitingRacesWon + visitingRacesLose;

		this.recentResults = recentResults;
	}

	/**
	 * 
	 * @param name
	 * @param totalRacesWon
	 * @param totalRacesLose
	 * @param homeRacesWon
	 * @param homeRacesLose
	 * @param visitingRacesWon
	 * @param visitingRacesLose
	 * @param recentResults
	 * @param recentTenResults
	 *            新增最近10场比赛的情况
	 */
	public NbaTeam(String name, int totalRacesWon, int totalRacesLose, int homeRacesWon,
			int homeRacesLose, int visitingRacesWon, int visitingRacesLose, int recentResults,
			int recentTenResults) {
		super();
		this.name = name;

		this.totalRacesWon = totalRacesWon;
		this.totalRaces = totalRacesWon + totalRacesLose;
		this.homeRacesWon = homeRacesWon;
		this.homeRaces = homeRacesWon + homeRacesLose;
		this.visitingRacesWon = visitingRacesWon;
		this.visitingRaces = visitingRacesWon + visitingRacesLose;

		this.recentResults = recentResults;
		this.recentTenResults = recentTenResults;
	}

	private String name;

	private int totalRacesWon;
	private int totalRaces;

	private int homeRacesWon;
	private int homeRaces;

	private int visitingRacesWon;
	private int visitingRaces;

	private int recentResults;
	private int recentTenResults;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalRacesWon() {
		return totalRacesWon;
	}

	public void setTotalRacesWon(int totalRacesWon) {
		this.totalRacesWon = totalRacesWon;
	}

	public int getTotalRaces() {
		return totalRaces;
	}

	public void setTotalRaces(int totalRaces) {
		this.totalRaces = totalRaces;
	}

	public int getHomeRacesWon() {
		return homeRacesWon;
	}

	public void setHomeRacesWon(int homeRacesWon) {
		this.homeRacesWon = homeRacesWon;
	}

	public int getHomeRaces() {
		return homeRaces;
	}

	public void setHomeRaces(int homeRaces) {
		this.homeRaces = homeRaces;
	}

	public int getVisitingRacesWon() {
		return visitingRacesWon;
	}

	public void setVisitingRacesWon(int visitingRacesWon) {
		this.visitingRacesWon = visitingRacesWon;
	}

	public int getVisitingRaces() {
		return visitingRaces;
	}

	public void setVisitingRaces(int visitingRaces) {
		this.visitingRaces = visitingRaces;
	}

	public int getRecentResults() {
		return recentResults;
	}

	public void setRecentResults(int recentResults) {
		this.recentResults = recentResults;
	}

	public int getRecentTenResults() {
		return recentTenResults;
	}

	public void setRecentTenResults(int recentTenResults) {
		this.recentTenResults = recentTenResults;
	}

	@Override
	public String toString() {
		return "Team [name=" + name + ", totalRacesWon=" + totalRacesWon + ", totalRaces="
				+ totalRaces + ", homeRacesWon=" + homeRacesWon + ", homeRaces=" + homeRaces
				+ ", visitingRacesWon=" + visitingRacesWon + ", visitingRaces=" + visitingRaces
				+ ", recentResults=" + recentResults + ", recentTenResults=" + recentTenResults
				+ "]";
	}

}
