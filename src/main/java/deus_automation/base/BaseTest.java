package deus_automation.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import deus_automation.utils.Property;

public class BaseTest {
	
	public WebDriver driver;
	public Property util = new Property();
	
	public WebDriver setUpDriver() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\webdriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		 driver = new ChromeDriver(options);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				
		
		return driver;
	}
	
	@BeforeClass
	public void start() {
		try {
			driver = setUpDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Reporter.log("Launching Chrome");
		driver.get(util.url());
		Reporter.log("Site opened");
	}
	
	@AfterClass
	public void end() {
		Reporter.log("Closing chrome after test");
		driver.close();
		driver.quit();
	}

}
