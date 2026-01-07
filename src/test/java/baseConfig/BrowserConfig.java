package baseConfig;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import utils.Reusable;

public class BrowserConfig extends Reusable{
	
	BrowserConfig config = new BrowserConfig();
	
	@BeforeTest
	public void initBrowser() {
		config.launchBrowser("chrome");
	}
	
	@AfterTest
	public void closeBrowsersession() {
		config.closeBrowser();
	}

}
