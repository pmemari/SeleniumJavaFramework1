package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPageObject;

public class GoogleSearchPageTest {

	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		googleSearchTest();	
	}
	
	public static void googleSearchTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();	
		
		GoogleSearchPageObject searchPageObj = new GoogleSearchPageObject(driver);
		
		driver.get("https://google.com/");
		
		searchPageObj.setTextInSearchBox("Automation Step by Step");
		searchPageObj.clickSearchButton();
		
		driver.close();
	}
}
