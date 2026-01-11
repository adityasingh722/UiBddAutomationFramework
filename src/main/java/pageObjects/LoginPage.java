package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import CommonUtils.Helpers;
import CommonUtils.Helpers;

public class LoginPage extends Helpers{
	
	static WebDriver driver;
	
	@FindBy(id = "mat-input-0")
	WebElement userName_txt;
	
	@FindBy(id = "mat-input-1")
	WebElement password_txt;
	
	@FindBy(xpath = "//button[text()='Lets Go']")
	WebElement login_btn;
	
	@FindBy(xpath = "//button[text()='Ok']")
	WebElement ok_btn;
	
	@FindBy(id = "navbarDropdownProfile")
	WebElement profile_drpDown;
	
	@FindBy(xpath = "(//a[@class='dropdown-item ng-star-inserted'])[4]")
	WebElement logout;
	
	@FindBy(xpath = "//button[text()=' Yes ']")
	WebElement yes_btn;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void login(String userName, String password) throws InterruptedException {
		
		waitforElementClickability(userName_txt).click();
		waitforVisibilityOfElement(userName_txt).sendKeys(userName);
		waitforVisibilityOfElement(password_txt).sendKeys(userName);
		waitforVisibilityOfElement(login_btn).click();
		waitforElementClickability(ok_btn).click();
		waitforElementClickability(profile_drpDown).click();
		waitforElementClickability(logout).click();
		waitforElementClickability(yes_btn).click();
		
	}
	
}
