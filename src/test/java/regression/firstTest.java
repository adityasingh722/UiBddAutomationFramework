package regression;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObjects.home;
import pageObjects.login;
import utils.Base;

public class firstTest extends Base{
	
	
	
	@Test
	public void run() {
		WebDriver driver = initBrowser("Chrome");
		login obj1 = new login(driver);
		obj1.doLogin("11222863893", "Veenasingh@722");
	}

}
