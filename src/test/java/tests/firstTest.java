package tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Datautils.ExcelUtility;
import pageObjects.LoginPage;
import reusable.Retry;
import utils.Base;

public class firstTest extends Base{
	
	@Test(dataProvider = "ExcelData", retryAnalyzer = Retry.class)
	public void login(String userName, String password) throws InterruptedException {
		launchBrowser("chrome");
		LoginPage login = new LoginPage();
		login.login(userName, password);
		driver.quit();
	}
	
	@DataProvider(name = "ExcelData")
	public Object[][] sendData() throws IOException {
		return ExcelUtility.sendDatafromExcel("src/test/resources/data/LoginCredentials.xlsx", "Sheet1");
	}
	
	
}
