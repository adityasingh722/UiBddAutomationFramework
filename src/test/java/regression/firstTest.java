package regression;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObjects.home;
import pageObjects.login;

public class firstTest {
	
	WebDriver driver;
	
	
	@Test
	public void run(String username, String password) {
		login obj1 = new login(driver);
		obj1.doLogin(username, password);
		home obj2 = new home(driver);
		obj2.waitforElementVisibility(null)
	}

}
