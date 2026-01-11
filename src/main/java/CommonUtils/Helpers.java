package CommonUtils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	Select select;
	Actions action;
	
	public Helpers(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement waitforElementClickability(WebElement ele) {
		return wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public WebElement waitforVisibilityOfElement(WebElement ele) {
		return wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void selectByVisibleText(WebElement ele, String text) {
		waitforVisibilityOfElement(ele);
		waitforElementClickability(ele).click();
		select = new Select(ele);
		select.selectByVisibleText(text);
	}
	
	public void selectByValue(WebElement ele, String value) {
		waitforVisibilityOfElement(ele);
		waitforElementClickability(ele).click();
		select = new Select(ele);
		select.selectByValue(value);
	}
	
	public void scrollToElement(WebElement ele) {
		action = new Actions(driver);
		action.scrollToElement(ele);
	}

}
