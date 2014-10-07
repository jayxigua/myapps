package jayxigua.LotteryRiskCalculation.datasource.tradeinfo.test;

import jayxigua.LotteryRiskCalculation.nba.datasource.tradeinfo.TradeInfoParsing;

import org.junit.Test;

public class TradeInfoParsingTest {
	@Test
	public void getTradeInfos() {
		System.out.println(new TradeInfoParsing().getTradeInfos());
	}

	@Test
	public void tradeInfoLine2TradeLine() {
		System.out
				.println(TradeInfoParsing
						.tradeInfoLine2TradeLine("周四307 	NBA 	01-02 23:55 	[西7]勇士 	VS 	热火[东2] 	析 亚 欧 	2.53  1.49 	2.56	1.32	"));
	}

}
