package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemoWithTestNG {

	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		this.htmlReporter = new ExtentSparkReporter("extent.html");
		this.extent = new ExtentReports();
		this.extent.attachReporter(htmlReporter);
	}
	
	@BeforeTest
	public void setupTest() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
	}

	@Test
	public void test1() throws IOException {
		ExtentTest test = this.extent.createTest("MyFirstTest", "Sample description");
		
		this.driver.get("https://google.com");
		test.pass("Navigated to google.com");
		
		test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        test.addScreenCaptureFromPath("screenshot.png");
	}
	
	@Test
	public void test2() throws IOException {
		ExtentTest test = this.extent.createTest("MyFirstTest", "Sample description");
		
		test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        test.addScreenCaptureFromPath("screenshot.png");
	}

	@AfterTest
	public void tearDownTest() {
		this.driver.close();
		this.driver.quit();
		System.out.println("Test completed successfully");
	}
	
	@AfterSuite
	public void tearDown() {
		this.extent.flush();
	}
}
