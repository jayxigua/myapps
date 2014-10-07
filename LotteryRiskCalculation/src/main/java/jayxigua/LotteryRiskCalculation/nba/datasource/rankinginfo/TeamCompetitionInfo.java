package jayxigua.LotteryRiskCalculation.nba.datasource.rankinginfo;

import java.util.List;

/**
 * @author jianbin.zou 2013-12-27
 */
public class TeamCompetitionInfo {

	static RankingInfoParsing rankingInfoParsing;

	static {
		rankingInfoParsing = new RankingInfoParsing();
	}

	/**
	 * 生成各个球队配置信息
	 */
	public static void generateProperties() {
		List<String> rankingInfos = rankingInfoParsing.getRankingInfos();
		for (String rankingInfo : rankingInfos) {
			String teamLine = RankingInfoParsing.rankingInfoLine2TeamLine(rankingInfo);
			int equalSignIndex = teamLine.indexOf("=");
			String teamUncodeName = teamLine.substring(0, equalSignIndex);
			String teamName = RankingInfoParsing.decodeUnicodeUpgrade(teamUncodeName);

			System.out.println("#" + teamName);
			System.out.println(teamLine);
		}
	}
}
