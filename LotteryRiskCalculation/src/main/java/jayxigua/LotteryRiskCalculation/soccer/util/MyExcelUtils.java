package jayxigua.LotteryRiskCalculation.soccer.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MyExcelUtils {

	public static XSSFSheet loadExcelByXslx(String sheetName) {
		try {
			InputStream in = MyExcelUtils.class
					.getResourceAsStream("/500/2014-10-07_足球彩票_风险收益（赔率加赛况）计算.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(in);
			return workbook.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
