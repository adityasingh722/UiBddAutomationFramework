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
import org.testng.annotations.Test;

import Datautils.ExcelUtility;
import pageObjects.home;
import pageObjects.login;
import reusable.Retry;
import utils.Base;

public class firstTest extends Base{
	
	@Test(dataProvider = "ExcelData", retryAnalyzer = Retry.class)
	public void login(String userName, String password) throws InterruptedException {

		Base.initBrowser("chrome");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='mat-input-0']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='mat-input-0']"))).sendKeys(userName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='mat-input-1']"))).sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Lets Go']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Ok']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='navbarDropdownProfile']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='dropdown-item ng-star-inserted'])[4]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Yes ']"))).click();
		driver.quit();
	}
	
	@DataProvider(name = "ExcelData")
	public Object[][] sendData() throws IOException {
		return ExcelUtility.sendDatafromExcel("src/test/resources/data/LoginCredentials.xlsx", "Sheet1");
	}
	
	
}
