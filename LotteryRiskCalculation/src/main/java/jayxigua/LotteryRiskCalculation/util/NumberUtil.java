package jayxigua.LotteryRiskCalculation.util;

import java.text.DecimalFormat;

public class NumberUtil {

	static DecimalFormat df = new DecimalFormat("##0.00");

	public static String AccurateDisplay(double d) {
		return df.format(d);
	}

	public static void main(String[] args) {
		System.out.println(AccurateDisplay(1.0D));
		System.out.println(AccurateDisplay(1.001111D));
		System.out.println(AccurateDisplay(1.02900D));
		System.out.println(AccurateDisplay(1111111.0254D));
	}
}
