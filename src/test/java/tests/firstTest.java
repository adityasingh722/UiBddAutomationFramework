package tests;

import java.io.IOException;
import java.security.PublicKey;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

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


import config.ConfigReader;
import io.cucumber.java.it.Data;
import pageObjects.LoginPage;
import reusable.RetryFailedTest;
import reusable.TestBase;

public class firstTest extends TestBase{
	
	@Test(dataProvider = "hashdata")
	public void login(HashMap<Object, Object> map) throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.login(map.get("username").toString(), map.get("password").toString());
		driver.quit();
	}
	
	@DataProvider(name = "ExcelData")
	public Object[][] sendData() throws IOException {
		return sendDatafromExcel("src/test/resources/data/LoginCredentials.xlsx", "Sheet1");
	}
	
	@DataProvider(name = "hashdata")
	public Object[][] jsonData() throws IOException {
		ConfigReader obj = new ConfigReader();
		List<HashMap<Object, Object>> dataSet =  obj.JsonToHashMap(System.getProperty("user.dir")+"\\src\\test\\resources\\data\\data.json");
		
		Object[][] data = {{dataSet.get(0)},{dataSet.get(1)}};
		
		return data;
	}
}
