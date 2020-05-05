package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Demo2 {

	private WebDriver driver = null;
	
	@BeforeTest
	public void setupTest() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
	}
	
	@Test
	public void googleSearch2() {
		this.driver.get("https://google.com/");
		this.driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		this.driver.findElement(By.xpath("//body[@id='gsr']/div[@id='viewport']/div[@id='searchform']/form[@id='tsf']/div/div/div/center/input[1]")).sendKeys(Keys.RETURN);
	}
	
	@Test
	public void googleSearch3() {
		this.driver.get("https://google.com/");
		this.driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		this.driver.findElement(By.xpath("//body[@id='gsr']/div[@id='viewport']/div[@id='searchform']/form[@id='tsf']/div/div/div/center/input[1]")).sendKeys(Keys.RETURN);
	}
	
	@AfterTest
	public void teardownTest() {
		this.driver.close();
		System.out.println("Test completed successfully");
	}

}
