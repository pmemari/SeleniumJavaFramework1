package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {
	
	private static WebDriver driver = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		googleSearch();

		
	}
	
	public static void googleSearch() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		// go to google.com
		driver.get("https://google.com/");
		
		//enter text in search box
		GoogleSearchPage.textbox_search(driver).sendKeys("Automation Step by Step");
		
		//click on search button
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
		
		//close browser
		driver.close();
		
		System.out.println("Test completed successfully");
	}

}
