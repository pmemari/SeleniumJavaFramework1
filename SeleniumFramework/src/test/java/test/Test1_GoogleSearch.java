package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1_GoogleSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		googleSearch();

	}
	
	public static void googleSearch() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com/");
		
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		
		driver.findElement(By.xpath("//body[@id='gsr']/div[@id='viewport']/div[@id='searchform']/form[@id='tsf']/div/div/div/center/input[1]")).sendKeys(Keys.RETURN);
		driver.close();
		
		System.out.println("Test completed successfully");
	}

}
