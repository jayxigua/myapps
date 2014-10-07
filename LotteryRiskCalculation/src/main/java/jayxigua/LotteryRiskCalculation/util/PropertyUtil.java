package jayxigua.LotteryRiskCalculation.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

	@SuppressWarnings("resource")
	public String getPropertyValue(String absolutePath, String relativePath, String name) {
		Properties prop = new Properties();
		InputStream in = null;
		File file = new File(absolutePath);
		if (file.exists()) {
			try {
				in = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				in = this.getClass().getResourceAsStream(relativePath);
			}
		} else {
			in = this.getClass().getResourceAsStream(relativePath);
		}
		try {
			prop.load(in);
			return prop.getProperty(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(new PropertyUtil().getPropertyValue("", "/config/nba.properties", "灰熊"));

		System.out.println(new PropertyUtil().getPropertyValue("", "/config/nba.properties", "湖人"));

		System.out.println(new PropertyUtil().getPropertyValue("", "/config/nba.properties", "雷霆"));

		System.out.println(new PropertyUtil().getPropertyValue("", "/config/nba.properties", "山猫"));

		System.out.println(new PropertyUtil().getPropertyValue("", "/config/nba.properties", "国王"));

		System.out.println(new PropertyUtil().getPropertyValue("", "/config/nba.properties", "勇士"));

		System.out.println(new PropertyUtil().getPropertyValue("", "/config/nba.properties", "鹈鹕"));

		System.out.println(new PropertyUtil().getPropertyValue("", "/config/nba.properties", "灰熊"));
	}
}
