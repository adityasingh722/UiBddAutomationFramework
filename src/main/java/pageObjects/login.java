package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Reusable;

public class login extends Reusable{

    WebDriver driver;
    
	public login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this.driver);
	}
	
	@FindBy(id = "mat-input-0")
	WebElement userName_txt;
	
	@FindBy(id = "mat-input-1")
	WebElement password_txt;
	
	@FindBy(id = "mat-input-1")
	WebElement login_btn;
	
	public void doLogin(String userName, String password) {
		userName_txt.sendKeys(userName);
		password_txt.sendKeys(password);
		waitforElementClickability(login_btn).click();
		return new home
	}
	
}
