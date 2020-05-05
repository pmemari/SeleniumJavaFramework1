package PhantomJS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PhantomJSTest {
	
	public static void main(String[] args) {
		
//		System.setProperty("phantomjs.binary.path", "C:\\Users\\Hp\\Desktop\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		WebDriverManager.phantomjs().setup();
		
		WebDriver driver = new PhantomJSDriver();
		
		driver.get("https://selenium.dev/");
		System.out.println("Title of the webpage is : " + driver.getTitle());
		
		driver.quit();
	}

}
