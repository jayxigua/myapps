package jayxigua.LotteryRiskCalculation.soccer.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jayxigua.LotteryRiskCalculation.soccer.entity.ExploitsElement;
import jayxigua.LotteryRiskCalculation.soccer.entity.SoccerMatch;
import jayxigua.LotteryRiskCalculation.soccer.entity.SoccerTeam;
import jayxigua.LotteryRiskCalculation.soccer.service.CalculateService;
import jayxigua.LotteryRiskCalculation.soccer.util.LocalLogUtils;
import jayxigua.LotteryRiskCalculation.soccer.util.MyExcelUtils;
import jayxigua.LotteryRiskCalculation.soccer.util.MyNumberUtils;

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
		for (SoccerMatch soccerMatch : soccerMatchs) {
			CalculateService.calculateMatch(soccerMatch);
		}
	}

	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	// 1
	public List<SoccerMatch> getSoccerMatchFromExcel() {
		List<SoccerMatch> soccerMatchs = new ArrayList<SoccerMatch>();
		XSSFSheet sheet = MyExcelUtils.loadExcelByXslx(df.format(new Date()));
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
	 *            as 0:哈特力普 1:谢菲尔德联队 2:4.2,3.55,1.66 3:2 4:3 5:2,1,3 6:2,2,6
	 *            7:6,2,2 8:2,2,6 9:3,4,3
	 * @return
	 */
	SoccerMatch row2SoccerMatch(XSSFRow row) {
		SoccerMatch sm = new SoccerMatch();
		for (int j = 0; j < row.getLastCellNum(); j++) {
			sm.setHome(new SoccerTeam(row.getCell(0).toString(), new Double(row.getCell(3).toString()).intValue(), row.getCell(6).toString(), row.getCell(8)
					.toString()));
			sm.setVisiting(new SoccerTeam(row.getCell(1).toString(), new Double(row.getCell(4).toString()).intValue(), row.getCell(7).toString(), row
					.getCell(9).toString()));
			sm.setOdds(MyNumberUtils.get3DigitFromStr(row.getCell(2).toString()));
			sm.setLast6EachExploits(new ExploitsElement(row.getCell(5).toString()));
		}
		LocalLogUtils.debugPrint(sm.toString());
		return sm;
	}
}
