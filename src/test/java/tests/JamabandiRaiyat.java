package tests;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.DashboardPage;
import pageObjects.JamabandiRegisterPage;
import utils.Base;

public class JamabandiRaiyat extends Base{

	@Test
	public void searchJamabandiRaiyat() throws InterruptedException {
		launchBrowser("chrome");
		DashboardPage dashboard = new DashboardPage();
		dashboard.changeLanguage();
		String currentId = driver.getWindowHandle();
		dashboard.gotoJamabandiRegister();
		driver.getTitle();
		JamabandiRegisterPage jama = new JamabandiRegisterPage();
		Set<String> Ids = driver.getWindowHandles();
		for(String id : Ids) {
			if(!id.equals(currentId)) {
				driver.switchTo().window(id);
				break;
			}
		}
		System.out.println(driver.getWindowHandle());
		
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
