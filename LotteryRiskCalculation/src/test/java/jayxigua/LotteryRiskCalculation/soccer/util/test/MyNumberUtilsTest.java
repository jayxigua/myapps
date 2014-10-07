package jayxigua.LotteryRiskCalculation.soccer.util.test;

import jayxigua.LotteryRiskCalculation.soccer.util.MyNumberUtils;

import org.junit.Test;

public class MyNumberUtilsTest {

	@Test
	public void get3DigitFromStr() {
		MyNumberUtils.get3DigitFromStr("3.65,3.50,1.77");
	}
}
