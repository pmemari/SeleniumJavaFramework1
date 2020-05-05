package demo;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitDemo {

	public static void main(String[] args) throws InterruptedException {
		test();
	}

	public static void test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Abcd");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);

		//		Waiting 30 seconds for an element to be present on the page, checking for its presence once every 2 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement linkElement = driver.findElement(By.xpath("//body//a[h3=\"ABCD - Events - Tamarack Institute\"]"));
				if (linkElement.isEnabled()) {
					System.out.println("Element Found");
				}
				return linkElement;
			}
		});
		
		element.click();


		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

}
