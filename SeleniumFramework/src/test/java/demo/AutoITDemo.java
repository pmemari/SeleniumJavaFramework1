package demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AutoITDemo {
	
	public static void main(String[] args) throws Exception {
		test();
	}
	
	public static void test() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://tinyupload.com/");
		System.out.println("page loaded");
		driver.findElement(By.name("uploaded_file")).sendKeys("D:\\file1.txt");
		System.out.println("uploaded_file found");
//		
//		Runtime.getRuntime().exec("D:\\FileUploadScript.exe");
//		
		Thread.sleep(3000);
		
		driver.close();
	}

}
