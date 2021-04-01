package Drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSetup {

	static String URL;
	static String location;
	static WebDriver driver;
	public static String userDir = System.getProperty("user.dir");

	public static WebDriver getDriver() {

		String Browser = "Chrome";
		if (Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", userDir +  "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", userDir + "\\drivers\\geckodriver.exe");
			FirefoxOptions fo = new FirefoxOptions();
			driver= new FirefoxDriver(fo);
		} 

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);

		driver.get("https://www.urbanladder.com/");
		
		return driver;
	}
}

