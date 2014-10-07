package jayxigua.LotteryRiskCalculation.soccer.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * 一场比赛
 * 
 * @author jayxigua
 * 
 */
public class SoccerMatch {

	private SoccerTeam home;
	private SoccerTeam visiting;

	private List<BigDecimal> odds;
	private ExploitsElement last6EachExploits;

	public SoccerTeam getHome() {
		return home;
	}

	public void setHome(SoccerTeam home) {
		this.home = home;
	}

	public SoccerTeam getVisiting() {
		return visiting;
	}

	public void setVisiting(SoccerTeam visiting) {
		this.visiting = visiting;
	}

	public List<BigDecimal> getOdds() {
		return odds;
	}

	public void setOdds(List<BigDecimal> odds) {
		this.odds = odds;
	}

	public ExploitsElement getLast6EachExploits() {
		return last6EachExploits;
	}

	public void setLast6EachExploits(ExploitsElement last6EachExploits) {
		this.last6EachExploits = last6EachExploits;
	}

	@Override
	public String toString() {
		return "SoccerMatch [home=" + home + ", visiting=" + visiting + ", odds=" + odds + ", last6EachExploits=" + last6EachExploits + "]";
	}

	

}
