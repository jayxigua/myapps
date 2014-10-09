package jayxigua.LotteryRiskCalculation.soccer.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class MyNumberUtils {

	public static String SPLIT = ",";
	public static String EMPTY = "-";
	public static int SCALE = 2;

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
		String[] ss = str.split(SPLIT);
		for (String s : ss) {
			BigDecimal bd = new BigDecimal(s).setScale(SCALE, RoundingMode.HALF_UP);
			digit.add(bd);
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
		BigDecimal rt = bd.divide(new BigDecimal(base), SCALE, RoundingMode.HALF_UP);
		LocalLogUtils.debugPrint("getBaseIncrease: rt " + rt.toString() + ",base " + base + "," + increaseValue);
		return rt;
	}
}
