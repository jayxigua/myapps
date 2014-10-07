package jayxigua.LotteryRiskCalculation.nba.util.test;

import jayxigua.LotteryRiskCalculation.nba.util.EastAndWestUtil;

import org.junit.Test;

public class EastAndWestUtilTest {

	@Test
	public void EastAndWestUtil() {
		System.out.println(EastAndWestUtil.getEastWinRate());
		System.out.println(EastAndWestUtil.getWestWinRate());
	}

	@Test
	public void isEast() {
		System.out.println(EastAndWestUtil.isEast("湖人"));
		System.out.println(EastAndWestUtil.isEast("热火"));
		System.out.println(EastAndWestUtil.isEast("凯尔特人"));
	}
}
