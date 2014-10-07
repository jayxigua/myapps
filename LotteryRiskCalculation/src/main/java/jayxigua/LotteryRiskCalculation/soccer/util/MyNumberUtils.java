package jayxigua.LotteryRiskCalculation.soccer.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class MyNumberUtils {

	public static String Split = ",";

	static MathContext mc = new MathContext(3, RoundingMode.HALF_UP);

	/**
	 * 返回（精确到2位小数）数字
	 * 
	 * @param str
	 *            as 3.65,3.50,1.77
	 * @return
	 */
	public static List<BigDecimal> get3DigitFromStr(String str) {
		List<BigDecimal> digit = new ArrayList<BigDecimal>();
		String[] ss = str.split(Split);
		for (String s : ss) {
			BigDecimal bd = new BigDecimal(s);
			digit.add(bd.setScale(2, BigDecimal.ROUND_HALF_UP).abs());
		}
		return digit;
	}

	/**
	 * 
	 * @param base
	 * @param increaseValue
	 * @return
	 */
	public static BigDecimal getBaseIncrease(String base, String increaseValue) {
		BigDecimal bd = new BigDecimal(base).add(new BigDecimal(increaseValue));
		return bd.divide(new BigDecimal(base), 2, RoundingMode.HALF_UP);
	}
}