import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {
	
	public static String browser;
	static WebDriver driver;

	public static void main(String[] args) {
		
		PropertiesFile.readPropertiesFile();
		setBrowserConfig();
		runTest();
		PropertiesFile.writePropertiesFile();
	}
	
	public static void setBrowserConfig() {
		if(browser.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
//			System.setProperty("webdriver.chrome.driver","D:\\java\\SeleniumFramework\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.contains("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.contains("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
	}
	
	public static void runTest() {
		
		System.out.println("Inside runTest()");
		driver.get("https://google.com");
//		driver.get("https://selenium.dev/");
		System.out.println("after driver.get");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("Automation step by step");
		WebElement textBox = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]"));
		textBox.sendKeys("Automation step by step");
		
		List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
		int count = listOfInputElements.size();
		
		System.out.println("Count of input elements : " + count);
		
		driver.close();
		System.out.println("after driver.close");
	}
}
