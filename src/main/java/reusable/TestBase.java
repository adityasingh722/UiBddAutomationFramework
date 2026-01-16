package reusable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase extends ConfigReader{

	public WebDriver driver;
	
	public  WebDriver launchBrowser() throws IOException {
		Properties pro = loadProperties();
		String browserName = pro.getProperty("browserName");
		
		if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		/* options.addArguments("--headless=new"); */  // modern headless
		options.addArguments("--window-size=1920,1080");
		/*
		 * options.addArguments("--start-maximized");
		 * options.addArguments("--incognito"); // running in incognito mode // Set
		 * download directory HashMap<String, Object> prefs = new HashMap<>();
		 * prefs.put("download.default_directory", "C:\\Downloads");
		 * options.setExperimentalOption("prefs", prefs);
		 * options.setExperimentalOption("excludeSwitches",
		 * Arrays.asList("enable-automation")); // Remove automation Infobar
		 * options.setAcceptInsecureCerts(true); //Handle SSL Certificates (for HTTPS
		 * Warning Sites)
		 */		
		driver = new ChromeDriver(options);
		
	} else if (browserName.equalsIgnoreCase("firefox")) {
		System.out.println("Firefox driver not initialized");
	} else if (browserName.equalsIgnoreCase("edge")) {
		System.out.println("Edge driver not initialized");
	}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(2));
		driver.quit();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void launchUrl() throws IOException {
		Properties pro = loadProperties();
		String url = pro.getProperty("url");
		driver = launchBrowser();
		driver.get(url);
	}
	
	public String takeScreenshot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+"image.png");
		FileUtils.copyFile(src, des);
		
		return System.getProperty("user.dir")+"//reports//"+testCaseName+"image.png";
	}

}
