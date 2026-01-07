package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.LoginPage;

public class Reusable extends Base{
	
	
	public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public static Select select;
	public static Actions action;
	
	
	public static WebElement waitforElementClickability(WebElement ele) {
		return wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static WebElement waitforVisibilityOfElement(WebElement ele) {
		return wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void selectByVisibleText(WebElement ele, String text) {
		waitforVisibilityOfElement(ele);
		waitforElementClickability(ele).click();
		select = new Select(ele);
		select.selectByVisibleText(text);
	}
	
	public static void selectByValue(WebElement ele, String value) {
		waitforVisibilityOfElement(ele);
		waitforElementClickability(ele).click();
		select = new Select(ele);
		select.selectByValue(value);
	}
	
	public static void scrollToElement(WebElement ele) {
		action = new Actions(driver);
		action.scrollToElement(ele);
	}

}
