

import java.io.*;
import java.util.Properties;


public class PropertiesFile {
	
	static Properties prop = new Properties();
	
	public static void readPropertiesFile() {
		try {
			InputStream input = new FileInputStream("D:\\java\\SeleniumFramework\\src\\test\\java\\config.properties");
			prop.load(input);
			BrowserTest.browser = prop.getProperty("browser");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writePropertiesFile() {
		try {
			OutputStream output = new FileOutputStream("D:\\java\\SeleniumFramework\\src\\test\\java\\config.properties");
			prop.setProperty("result", "pass");
			prop.store(output, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
