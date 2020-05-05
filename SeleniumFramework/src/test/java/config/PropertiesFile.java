package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.TestNG_Demo;

public class PropertiesFile {

	private static Properties props = new Properties();
	private static String projectPath = System.getProperty("user.dir");
	
	public static void main(String[] args) {
		getProperties();
		setProperties();
	}
	
	public static void getProperties() {
		try {
			InputStream input = new FileInputStream(projectPath+"/src/test/java/config/config.properties");
			props.load(input);
			String browser = props.getProperty("browser");
			TestNG_Demo.browserName = browser;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	
	public static void setProperties() {
		try {
			OutputStream output = new FileOutputStream(projectPath+"/src/test/java/config/config.properties");
			props.setProperty("result", "pass");
			props.store(output, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

}
