package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.DashboardPage;
import pageObjects.JamabandiRegisterPage;
import reusable.TestBase;

public class JamabandiRaiyat extends TestBase{

	@Test(groups = {"gr1"})
	public void searchJamabandiRaiyat() throws InterruptedException, IOException {
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.changeLanguage();
		String currentId = driver.getWindowHandle();
		dashboard.gotoJamabandiRegister();
		driver.getTitle();
		JamabandiRegisterPage jama = new JamabandiRegisterPage(driver);
		Set<String> Ids = driver.getWindowHandles();
		for(String id : Ids) {
			if(!id.equals(currentId)) {
				driver.switchTo().window(id);
				break;
			}
		}		
		jama.setZilaName("Siwan");
		Thread.sleep(1000);
		jama.setanchalName("Siswan");
		Thread.sleep(1000);
		jama.setHalka("baghauna");
		Thread.sleep(1000);
		jama.setMauja("528");
		Thread.sleep(1000);
		jama.setsearchviaRaiyatName();
	}

}
