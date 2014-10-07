package jayxigua.LotteryRiskCalculation.datasource.rankinginfo;

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
public class RankingInfoParsing {

	/**
	 * 获取排名信息
	 * 
	 * @return
	 */
	public List<String> getRankingInfos() {

		List<String> rankingInfos = new ArrayList<String>();

		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader bio = null;

		try {
			in = this.getClass().getResourceAsStream("/sina_ranking/datasource.txt");
			isr = new InputStreamReader(in);
			bio = new BufferedReader(isr);
			String line;
			while ((line = bio.readLine()) != null) {
				rankingInfos.add(line);
			}
			bio.close();
			isr.close();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rankingInfos;
	}

	/**
	 * 
	 * @param rankingInfo
	 *            1 步行者 23 5 82.1% 0 98.6 89.4 9.2 13胜1负 10胜4负 16胜3负 4胜2负 0胜1负
	 *            13胜2负 15胜4负 8胜1负 7胜3负 3连胜
	 * 
	 * @return \u6b65\u884c\u8005=22,5,13,1,9,4,2,6
	 */
	public static String rankingInfoLine2TeamLine(String rankingInfo) {

		StringBuffer teamLine = new StringBuffer();

		String[] rankingInfos = rankingInfo.split(" ");
		/**
		 * 球队姓名
		 */
		teamLine.append(getUnicode(rankingInfos[1].trim())).append("=");
		/**
		 * 胜
		 */
		teamLine.append(rankingInfos[2].trim()).append(",");
		/**
		 * 负
		 */
		teamLine.append(rankingInfos[3].trim()).append(",");
		/**
		 * 主场战绩
		 */
		teamLine.append(getVictoryAndLose(rankingInfos[9].trim())).append(",");
		/**
		 * 客场战绩
		 */
		teamLine.append(getVictoryAndLose(rankingInfos[10].trim())).append(",");

		/**
		 * 连胜连负
		 */
		teamLine.append(getConsecutiveVictory(rankingInfos[18].trim())).append(",");
		/**
		 * 最近10场
		 */
		teamLine.append(getTenVictory(rankingInfos[17].trim()));

		return teamLine.toString();
	}

	/**
	 * 获取球队的Unicode
	 * 
	 * @param str
	 * @return
	 */
	public static String getUnicode(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			int chr1 = (char) str.charAt(i);
			if (chr1 >= 19968 && chr1 <= 171941) {// 汉字范围 \u4e00-\u9fa5 (中文)
				result += "\\u" + Integer.toHexString(chr1);
			} else {
				result += str.charAt(i);
			}
		}
		return result;
	}

	public static String decodeUnicode(String dataStr) {
		int start = 0;
		int end = 0;
		final StringBuffer buffer = new StringBuffer();
		while (start > -1) {
			end = dataStr.indexOf("\\u", start + 2);
			String charStr = "";
			if (end == -1) {
				charStr = dataStr.substring(start + 2, dataStr.length());
			} else {
				charStr = dataStr.substring(start + 2, end);
			}
			char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
			buffer.append(new Character(letter).toString());
			start = end;
		}
		return buffer.toString();
	}

	/**
	 * 能将包含中英文的uncode转换为正常字符串
	 * 
	 * @param dataStr
	 * @return
	 */
	public static String decodeUnicodeUpgrade(String dataStr) {
		int start = 0;
		int end = 0;
		int len = dataStr.length();

		final StringBuffer buffer = new StringBuffer();

		while (end < len) {
			start = dataStr.indexOf("\\u", end);
			if (start > end) {
				buffer.append(dataStr.substring(end, start));
				end = start;
			} else {
				start += 2;
				end = start + 4;
				char letter = (char) Integer.parseInt(dataStr.substring(start, end), 16);
				buffer.append(new Character(letter).toString());
			}
		}
		return buffer.toString();
	}

	/**
	 * 
	 * @param str
	 *            13胜1负
	 * @return 13,3
	 */
	public static String getVictoryAndLose(String str) {
		StringBuffer victoryAndLose = new StringBuffer();

		int victoryIndex = str.indexOf("胜");
		victoryAndLose.append(str.substring(0, victoryIndex)).append(",");

		int loseIndex = str.indexOf("负");
		victoryAndLose.append(str.substring(victoryIndex + 1, loseIndex));

		return victoryAndLose.toString();
	}

	/**
	 * 
	 * @param str
	 *            7胜3负
	 * @return 3
	 */
	public static String getTenVictory(String str) {
		int index = str.indexOf("胜");
		return str.substring(0, index);
	}

	/**
	 * 
	 * @param str
	 *            3连胜
	 * @return 3
	 */
	public static String getConsecutiveVictory(String str) {
		int index = str.indexOf("连");
		String value = str.substring(0, index);
		// 连负的修复
		if (str.indexOf("胜") == -1) {
			value = "-" + value;
		}
		return value;
	}
}
