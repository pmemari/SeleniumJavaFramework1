package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataProvider {
	private WebDriver driver = null;
	
	@BeforeTest
	public void setupTest() {
		System.out.println("before test setup");
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
	}
	
	@Test(dataProvider = "test1data")
	public void test1(String username, String password) throws InterruptedException {
		System.out.println(username + " | " + password);
		this.driver.get("https://verified.capitalone.com/auth/signin");
		this.driver.findElement(By.id("ods-input-0")).sendKeys(username);
		this.driver.findElement(By.id("ods-input-1")).sendKeys(password);
		Thread.sleep(2000);
	}
	
	@DataProvider(name="test1data")
	public Object[][] getData() {
		String projectPath = System.getProperty("user.dir");
		Object data[][] = testData(projectPath+"/excel/data.xlsx","Sheet1");
		return data;
	}
	
	public Object[][] testData(String excelPath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for (int i=1; i<rowCount; i++) {
			for (int j=0;j<colCount; j++) {
				String cellData = excel.getCellDataString(i, j);
				data[i-1][j] = cellData;
			}
		}
		
		return data;
	}
	
	@AfterTest
	public void teardownTest() {
		System.out.println("After test teardown");
		this.driver.close();
	}

}
