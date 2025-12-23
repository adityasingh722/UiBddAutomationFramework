package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Datautils.ExcelUtility;
import pageObjects.home;
import pageObjects.login;
import utils.Base;

public class firstTest extends Base{
	
	@Test(dataProvider = "ExcelData")
	public void login(String userName, String password) throws InterruptedException {

		Base.initBrowser("chrome");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='mat-input-0']")).click();
		System.out.println(userName);
		driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Lets Go']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Ok']")).click();
		

	}
	
	@DataProvider(name = "ExcelData")
	public Object[][] sendData() throws IOException {
		return ExcelUtility.sendDatafromExcel("src/test/resources/data/LoginCredentials.xlsx", "Sheet1");
	}
}
