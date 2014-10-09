package jayxigua.LotteryRiskCalculation.nba.datasource.rankinginfo.test;

import jayxigua.LotteryRiskCalculation.nba.datasource.rankinginfo.RankingInfoParsing;

import org.junit.Test;

public class RankingInfoParsingTest {

	@Test
	public void getRankingInfo() {
		System.out.println(new RankingInfoParsing().getRankingInfos());
	}

	@Test
	public void rankingInfoLine2TeamLine() {
		System.out
				.println(RankingInfoParsing
						.rankingInfoLine2TeamLine("1 	步行者 	23 	5 	82.1% 	0 	98.6 	89.4 	9.2 	13胜1负 	10胜4负 	16胜3负 	4胜2负 	0胜1负 	13胜2负 	15胜4负 	8胜1负 	7胜3负 	3连胜"));
	}

	@Test
	public void getUnicode() {
		// System.out.println(RankingInfoParsing.getUnicode("步行者"));
		System.out.println(RankingInfoParsing.getUnicode("人76人523人"));
	}

	@Test
	public void decodeUnicode() {
		System.out.println(RankingInfoParsing.decodeUnicode("\\u6b65\\u884c\\u8005"));
		System.out.println(RankingInfoParsing.decodeUnicode("76\\u4eba"));
	}

	@Test
	public void decodeUnicodeUpgrade() {
		System.out.println(RankingInfoParsing.decodeUnicodeUpgrade("\\u6b65\\u884c\\u8005"));
		System.out.println(RankingInfoParsing.decodeUnicodeUpgrade("76\\u4eba"));
		System.out.println(RankingInfoParsing.decodeUnicodeUpgrade("\\u4eba76\\u4eba523\\u4eba"));
	}

}
