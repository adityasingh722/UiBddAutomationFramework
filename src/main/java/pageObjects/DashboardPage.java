package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Helpers;

public class DashboardPage extends Helpers{
	
	WebDriver driver;
	
	@FindBy(xpath = "//button[@id='MainContent_btnClose']")
	WebElement bandKare_btn;
	
	@FindBy(xpath = "//select[@name='ctl00$ddlLanguage']")
	WebElement language_drpdown;
	
	@FindBy(xpath = "//a[contains(text(),'View Jamabandi Register')]")
	WebElement viewJamabandiRegister_link;
	
	
	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void changeLanguage() {
		scrollToElement(bandKare_btn);
		waitforVisibilityOfElement(bandKare_btn);
		waitforElementClickability(bandKare_btn).click();
		selectByVisibleText(language_drpdown, "English");
	}
	
	public void gotoJamabandiRegister() {
		waitforElementClickability(viewJamabandiRegister_link).click();
	}
	
	
	
	
	
	
	

}
