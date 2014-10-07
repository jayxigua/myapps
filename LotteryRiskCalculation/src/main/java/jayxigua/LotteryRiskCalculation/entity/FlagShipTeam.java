package jayxigua.LotteryRiskCalculation.entity;

/**
 * 旗舰队伍
 * 
 * @author jianbin.zou 2013-12-22
 */
public class FlagShipTeam {

	private String name;
	private String beatName;

	/**
	 * 第一期：旗舰失败率情况，以及失败的赔率，计算需要购买多少风险投资
	 */
	private double winRate;

	private double earningsOdds;
	private double betaEarningsOdds;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeatName() {
		return beatName;
	}

	public void setBeatName(String beatName) {
		this.beatName = beatName;
	}

	public double getWinRate() {
		return winRate;
	}

	public void setWinRate(double winRate) {
		this.winRate = winRate;
	}

	public double getEarningsOdds() {
		return earningsOdds;
	}

	public void setEarningsOdds(double earningsOdds) {
		this.earningsOdds = earningsOdds;
	}

	public double getBetaEarningsOdds() {
		return betaEarningsOdds;
	}

	public void setBetaEarningsOdds(double betaEarningsOdds) {
		this.betaEarningsOdds = betaEarningsOdds;
	}

}
