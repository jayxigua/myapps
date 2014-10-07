package jayxigua.LotteryRiskCalculation.nba.util;

import jayxigua.LotteryRiskCalculation.nba.entity.NbaTeam;

public class EastAndWestUtil {

	static String[] east = { "步行者", "热火", "老鹰", "凯尔特人", "活塞", "山猫", "奇才", "猛龙", "公牛", "骑士", "篮网",
			"尼克斯", "魔术", "76人", "雄鹿" };

	static String[] west = { "雷霆", "开拓者", "马刺", "快船", "火箭", "小牛", "太阳", "掘金", "勇士", "湖人", "森林狼",
			"鹈鹕", "灰熊", "国王", "爵士" };

	/**
	 * 得到东部球队的胜率
	 * 
	 * @return
	 */
	public static double getEastWinRate() {
		return getWinRate(true);
	}

	/**
	 * 得到西部球队的胜率
	 * 
	 * @return
	 */
	public static double getWestWinRate() {
		return getWinRate(false);
	}

	static double getWinRate(boolean isEast) {
		double result = 0;
		String[] teams;
		if (isEast) {
			teams = east;
		} else {
			teams = west;
		}
		int size = teams.length;
		int totalWin = 0;
		int totalRace = 0;
		NbaTeam team;
		for (int i = 0; i < size; i++) {
			team = TeamUtil.getTeamByName(teams[i]);
			totalWin += team.getTotalRacesWon();
			totalRace += team.getTotalRaces();
		}
		result = 100D * totalWin / totalRace;
		return result;
	}

	/**
	 * 是否是东部球队
	 * 
	 * @param name
	 * @return
	 */
	public static boolean isEast(String name) {
		for (int i = 0; i < east.length; i++) {
			if (east[i].equals(name.trim()))
				return true;
		}
		return false;
	}
}
