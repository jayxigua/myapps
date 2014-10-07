package jayxigua.LotteryRiskCalculation.datasource.tradeinfo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jianbin.zou 2013-12-27
 */
public class TradeInfoParsing {

	/**
	 * 获取排名信息
	 * 
	 * @return
	 */
	public List<String> getTradeInfos() {

		List<String> tradeInfos = new ArrayList<String>();

		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader bio = null;

		try {
			in = this.getClass().getResourceAsStream("/trade/trade.txt");
			isr = new InputStreamReader(in);
			bio = new BufferedReader(isr);
			String line;
			while ((line = bio.readLine()) != null) {
				tradeInfos.add(line);
			}
			bio.close();
			isr.close();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tradeInfos;
	}

	/**
	 * 
	 * @param tradeInfo
	 *            周四307 NBA 01-02 23:55 [西7]勇士 VS 热火[东2] 析 亚 欧 2.53 1.49 2.56
	 *            1.32 ; 真实值： 周四307 \tNBA \t01-02 23:55 \t[西7]勇士 \tVS \t热火[东2]
	 *            \t析 亚 欧 \t2.53 1.49 \t2.56\t1.32\t 中间值：[西7]勇士,热火[东2],2.56 1.32
	 * @return 勇士 热火 2.56 1.32
	 */
	public static String tradeInfoLine2TradeLine(String tradeInfo) {
		StringBuffer tradeLine = new StringBuffer();

		String[] tradeInfos = tradeInfo.split("\t");

		tradeLine.append(getVisitingTeamName(tradeInfos[3].trim())).append(",");
		tradeLine.append(getHomeTeamName(tradeInfos[5].trim())).append(",");
		tradeLine.append(tradeInfos[8].trim()).append(",");
		tradeLine.append(tradeInfos[9].trim());

		return tradeLine.toString();
	}

	/**
	 * 
	 * @param [西7]勇士
	 * @return 勇士
	 */
	static String getVisitingTeamName(String str) {
		int start = str.indexOf("]") + 1;
		return str.substring(start);
	}

	/**
	 * 
	 * @param 热火
	 *            [东2]
	 * @return 热火
	 */
	static String getHomeTeamName(String str) {
		int end = str.indexOf("[");
		return str.substring(0, end);
	}
}
