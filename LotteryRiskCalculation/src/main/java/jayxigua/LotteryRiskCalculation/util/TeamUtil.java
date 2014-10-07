package jayxigua.LotteryRiskCalculation.util;

import jayxigua.LotteryRiskCalculation.entity.NbaTeam;

public class TeamUtil {

	private final static String infoSeparator = ",";
	/**
	 * 球队 历史比赛信息，存放位置
	 */
	private final static String propertiesPath = "/config/nba.properties";

	/**
	 * 根据输入的球队名称，得到team信息
	 * 
	 * @param teamName
	 * @return
	 */
	public static NbaTeam getTeamByName(String teamName) {
		String teamInfo = new PropertyUtil().getPropertyValue("", propertiesPath, teamName);

		String[] infos = teamInfo.split(infoSeparator);
		int[] ints = Strings2Ints(infos);
		NbaTeam team = new NbaTeam(teamName, ints[0], ints[1], ints[2], ints[3], ints[4], ints[5],
				ints[6], ints[7]);
		return team;
	}

	public static NbaTeam getTeam(String teamName, String teamInfo) {
		String[] infos = teamInfo.split(infoSeparator);
		int[] ints = Strings2Ints(infos);
		NbaTeam team = new NbaTeam(teamName, ints[0], ints[1], ints[2], ints[3], ints[4], ints[5],
				ints[6], ints[7]);
		return team;
	}

	private static int[] Strings2Ints(String[] strs) {
		int[] ints = new int[8];
		for (int i = 0; i < 8; i++) {
			ints[i] = Integer.parseInt(strs[i].trim());
		}
		return ints;
	}

}
