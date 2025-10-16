package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Reusable;

public class home extends Reusable{
	
	WebDriver driver;
	
	public home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this.driver);
	}
	
	@FindBy(id = "mat-input-0")
	WebElement userName_txt;
	
	@FindBy(xpath = "//a[@id='navbarDropdownProfile']")
	WebElement profile_icon;
	
	public WebElement isElementVisible(WebElement ele) {
		return waitforElementVisibility(profile_icon);
	}
	

}
