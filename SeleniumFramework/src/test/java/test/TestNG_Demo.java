package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;
import demo.Log4jDemo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Demo {

	private WebDriver driver = null;
	public static String browserName = null;
	private static Logger logger = (Logger) LogManager.getLogger(Log4jDemo.class);
	private static String projectPath = System.getProperty("user.dir");
	
	@BeforeTest
	public void setupTest() {
		PropertiesFile.getProperties();
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			this.driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			this.driver = new FirefoxDriver();
		}
		
		logger.info("Browser started");
		
	}
	
	@Test
	public void googleSearch() {
		
		this.driver.get("https://google.com/");
		this.driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		this.driver.findElement(By.xpath("//body[@id='gsr']/div[@id='viewport']/div[@id='searchform']/form[@id='tsf']/div/div/div/center/input[1]")).sendKeys(Keys.RETURN);
	}
	
	@AfterTest
	public void teardownTest() {
		this.driver.close();
		logger.info("Test completed successfully");
		PropertiesFile.setProperties();
	}

}
