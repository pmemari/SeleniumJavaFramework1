package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ApplitoolsDemo {
	
	public static void main(String[] args) {

		//Open Chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Initialize the eyes SDK and set your private API key
		Eyes eyes = new Eyes();
		eyes.setApiKey("7QmA8HTrfrZcOPzCbeiVMxlq4107Yc110vtD7Al3Ay1VdBo110");
		eyes.setMatchLevel(MatchLevel.STRICT);
		
		try {
			//Start the test and send the browser's view point to 800x600
			eyes.open(driver, "HelloWorld", "My first Selenium Java test1",new RectangleSize(800,600));
			
			//Navigate the driver to the "hello world!" web-site
			driver.get("https://applitools.com/helloworld/?diff2");
			
			//Visual checkpoint #1
			eyes.checkWindow("Hello!");
			
			//Click the "Click me!" button			
			driver.findElement(By.tagName("button")).click();
			
			//Visual checkpoint #2
			eyes.checkWindow("Click!");
			
			//End the test
			eyes.close();
			
		} finally {
			
			//Close the browser
			driver.close();
			
			//If the test was aborted before eyes.close was called
			eyes.abortIfNotClosed();
		}
	}
}
