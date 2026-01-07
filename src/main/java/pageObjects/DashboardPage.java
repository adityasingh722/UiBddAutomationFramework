package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Reusable;

public class DashboardPage extends Reusable{
	
	@FindBy(xpath = "//button[@id='MainContent_btnClose']")
	WebElement bandKare_btn;
	
	@FindBy(xpath = "//select[@name='ctl00$ddlLanguage']")
	WebElement language_drpdown;
	
	@FindBy(xpath = "//a[contains(text(),'View Jamabandi Register')]")
	WebElement viewJamabandiRegister_link;
	
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void changeLanguage() {
		Reusable.scrollToElement(bandKare_btn);
		Reusable.waitforVisibilityOfElement(bandKare_btn);
		Reusable.waitforElementClickability(bandKare_btn).click();
		Reusable.selectByVisibleText(language_drpdown, "English");
	}
	
	public void gotoJamabandiRegister() {
		Reusable.waitforElementClickability(viewJamabandiRegister_link).click();
	}
	
	
	
	
	
	
	

}
