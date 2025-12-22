package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.login;

public class Reusable extends Base{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));
	
	public void clickButton(WebElement ele) {
		waitforElementVisibility(ele);
		ele.click();
	}
	
	public void setText(WebElement ele, String text) {
		waitforElementVisibility(ele);
		ele.sendKeys(text.trim());
	}
	
	public WebElement waitforElementClickability(WebElement ele) {
		return wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public WebElement waitforElementVisibility(WebElement ele) {
		return wait.until(ExpectedConditions.visibilityOf(ele));
	}

}
