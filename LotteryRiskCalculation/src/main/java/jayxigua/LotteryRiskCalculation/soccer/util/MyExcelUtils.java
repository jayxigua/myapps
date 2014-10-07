package jayxigua.LotteryRiskCalculation.soccer.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MyExcelUtils {

	public static void loadExcelByXslx() {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(
					"workbooks.xlsx"));
			XSSFSheet sheet = workbook.getSheet("new sheet");
			XSSFRow row1 = sheet.getRow(0);
			if (row1 != null) {
				System.out.println(row1.getCell(0).getStringCellValue());
			}
			XSSFRow row2 = sheet.getRow(1);
			if (row2 == null) {
				System.out.println("Null");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
