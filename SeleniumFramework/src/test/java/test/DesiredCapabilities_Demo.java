package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCapabilities_Demo {

	public static void main(String[] args) {
		WebDriverManager.iedriver().setup();
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);
		
		WebDriver driver = new InternetExplorerDriver(caps);
				
		driver.get("https://google.com");
		System.out.println("after get");
		driver.findElement(By.name("q")).sendKeys("ABCD");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		driver.close();
		driver.quit();

	}

}
