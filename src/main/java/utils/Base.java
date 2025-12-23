package utils;

import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.messages.types.Exception;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public  static WebDriver driver;
	public  static WebDriver initBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		/* options.addArguments("--start-maximized"); */
		options.addArguments("--incognito"); // running in incognito mode
		// Set download directory
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", "C:\\Downloads");
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation")); // Remove automation Infobar
		options.setAcceptInsecureCerts(true); //Handle SSL Certificates (for HTTPS Warning Sites)
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
	} else if (browserName.equalsIgnoreCase("firefox")) {
		System.out.println("Firefox driver not initialized");
	} else if (browserName.equalsIgnoreCase("edge")) {
		System.out.println("Edge driver not initialized");
	}
		driver.get("https://cportal.jbvnl.co.in/cportal/#/user/login");
		return driver;
	}

}
