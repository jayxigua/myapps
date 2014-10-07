package jayxigua.LotteryRiskCalculation.calculate;

import jayxigua.LotteryRiskCalculation.entity.CompetitionTeam;
import jayxigua.LotteryRiskCalculation.entity.NbaTeam;
import jayxigua.LotteryRiskCalculation.util.EastAndWestUtil;

/**
 * @author jianbin.zou 2013-12-22
 */
public class TeamFightingForce {

	private final static int BASE = 100 * 100 * 100 * 100;

	private final static int RECENT_BASE = 30;
	private final static int RECENT_TEN_BASE = 50;

	private final static int EAST_AND_WEST_FACTORS = 50;

	private final static int IS_HOME_BASE = 50;
	private final static int IS_HOME_FACTOR = 50;

	/**
	 * 一个球队的实力计算
	 * 
	 * @param competitionTeam
	 * @return
	 */
	public static double generateTeamFightingForce(CompetitionTeam competitionTeam) {

		double teamFightingForce = 0;
		/**
		 * 计算算法：100+最近比赛情况 *胜率*主客胜率； 方案设定时间：2013-12-20
		 */
		teamFightingForce = recentContinuousResults(competitionTeam)
				* recentTenResults(competitionTeam) * totalRacesWinRate(competitionTeam)
				* isHomeWinRate(competitionTeam) * eastAndWestFactors(competitionTeam) / BASE;

		return teamFightingForce;
	}

	/**
	 * 总胜率
	 * 
	 * @param competitionTeam
	 * @return
	 */
	static double totalRacesWinRate(CompetitionTeam competitionTeam) {
		double result = 0;
		NbaTeam team = competitionTeam.getTeam();
		int totalRacesWon = team.getTotalRacesWon();
		int totalRaces = team.getTotalRaces();
		result = 100 * totalRacesWon / totalRaces;
		// System.out.println("totalRacesWinRate：" + result);
		return result;
	}

	/**
	 * 主客场胜率
	 * 
	 * @param competitionTeam
	 * @return
	 */
	static double isHomeWinRate(CompetitionTeam competitionTeam) {
		double result = 0;
		NbaTeam team = competitionTeam.getTeam();

		int racesWon;
		int races;
		int isHome = 0;
		/**
		 * 根据当前为主客获取计算数据
		 */
		if (competitionTeam.isHome()) {
			racesWon = team.getHomeRacesWon();
			races = team.getHomeRaces();
			// 临时估算
			isHome = IS_HOME_FACTOR;
		} else {
			racesWon = team.getVisitingRacesWon();
			races = team.getVisitingRaces();
		}
		// result = 100 * racesWon / races;
		// 降低主客场胜率的影响力
		result = isHome + IS_HOME_BASE + 100 * racesWon / races;
		// System.out.println("isHomeWinRate：" + result);
		return result;
	}

	/**
	 * 最近连续场次比赛结果影响
	 * 
	 * @param competitionTeam
	 * @return
	 */
	static double recentContinuousResults(CompetitionTeam competitionTeam) {
		double result = 0;
		NbaTeam team = competitionTeam.getTeam();
		int totalRaces = team.getTotalRaces();
		result = 100 + RECENT_BASE * team.getRecentResults() / totalRaces;
		// System.out.println("recentContinuousResults：" + result);
		return result;
	}

	/**
	 * 最近10场次比赛结果影响
	 * 
	 * @param competitionTeam
	 * @return
	 */
	static double recentTenResults(CompetitionTeam competitionTeam) {
		double result = 0;
		NbaTeam team = competitionTeam.getTeam();
		result = 100 + RECENT_TEN_BASE * team.getRecentTenResults() / 10;
		// System.out.println("recentTenResults：" + result);
		return result;
	}

	/**
	 * 东西部球队因素
	 * 
	 * @param competitionTeam
	 * @return
	 */
	static double eastAndWestFactors(CompetitionTeam competitionTeam) {
		double result = 0;
		NbaTeam team = competitionTeam.getTeam();
		if (EastAndWestUtil.isEast(team.getName())) {
			result = EAST_AND_WEST_FACTORS + EastAndWestUtil.getEastWinRate();
		} else {
			result = EAST_AND_WEST_FACTORS + EastAndWestUtil.getWestWinRate();
		}
		// System.out.println("eastAndWestFactors：" +
		// NumberUtil.AccurateDisplay(result));
		return result;
	}
}
