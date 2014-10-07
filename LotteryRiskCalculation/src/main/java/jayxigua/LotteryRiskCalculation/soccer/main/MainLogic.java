package jayxigua.LotteryRiskCalculation.soccer.main;

import java.util.Collections;
import java.util.List;

import jayxigua.LotteryRiskCalculation.soccer.entity.SoccerMatch;
import jayxigua.LotteryRiskCalculation.soccer.util.MyExcelUtils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 * 主逻辑
 * 
 * @author jayxigua
 */
public class MainLogic {

	public void run() {
		// 1解析Excel文件，获取entity数据
		List<SoccerMatch> soccerMatchs = getSoccerMatchFromExcel();
		// 2计算逻辑

		// 3展示效果

	}

	public List<SoccerMatch> getSoccerMatchFromExcel() {
		List<SoccerMatch> soccerMatchs = Collections.emptyList();
		XSSFSheet sheet = MyExcelUtils.loadExcelByXslx("2014-10-07");
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);
			soccerMatchs.add(row2SoccerMatch(row));
		}
		return soccerMatchs;
	}

	/**
	 * 解析每行数据至“比赛实体”
	 * 
	 * @param row
	 *            as 哈特力普 谢菲尔德联队 4.2,3.55,1.66 2 3 2,1,3 2,2,6 6,2,2 2,2,6 3,4,3
	 * @return
	 */
	SoccerMatch row2SoccerMatch(XSSFRow row) {
		SoccerMatch sm = new SoccerMatch();
		for (int j = 0; j < row.getLastCellNum(); j++) {
			
		}
		return sm;
	}
}
