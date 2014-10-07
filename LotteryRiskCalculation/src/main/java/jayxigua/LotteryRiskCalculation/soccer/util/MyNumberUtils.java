package jayxigua.LotteryRiskCalculation.soccer.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MyNumberUtils {

	public static String Split = ",";

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
			digit.add(bd.setScale(1, BigDecimal.ROUND_HALF_UP).abs());
		}
		return digit;
	}
}
