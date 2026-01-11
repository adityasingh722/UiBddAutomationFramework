package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.Helpers;
import CommonUtils.Helpers;

public class JamabandiRegisterPage extends Helpers{
	
	static WebDriver driver;
	
	@FindBy(xpath = "//select[contains(@name,'District')]")
	WebElement zila_drpdown;
	
	@FindBy(xpath = "//select[contains(@name,'Circle')]")
	WebElement anchal_drpdown;
	
	@FindBy(xpath = "//input[@id='MainContent_btnproceed']")
	WebElement proceed_btn;
	
	@FindBy(xpath = "//select[contains(@name,'Halka')]")
	WebElement halka_drpdown;
	
	@FindBy(xpath = "//select[contains(@name,'Mauja')]")
	WebElement mauja_drpdown;
	
	@FindBy(xpath = "//input[@id='MainContent_rdo_All']")
	WebElement pangi2_btn;
	
	@FindBy(xpath = "//input[@id='MainContent_Chk_orderbyname']")
	WebElement raiyatName_chkbox;
	
	@FindBy(xpath = "//input[@name='ctl00$MainContent$TextBox1']")
	WebElement sumexp_txtbox;
	
	@FindBy(xpath = "//input[@name='ctl00$MainContent$TextBox2']")
	WebElement sumresult_txtbox;
	
	@FindBy(xpath = "//input[@id='MainContent_btnSearch']")
	WebElement search_btn;
	
	public JamabandiRegisterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void setZilaName(String zilaName) {
		selectByVisibleText(zila_drpdown, zilaName);
	}
	
	public void setanchalName(String anchalName) {
		selectByVisibleText(anchal_drpdown, anchalName);
	}
	
	public void setHalka(String halkaName) throws InterruptedException {
		waitforElementClickability(proceed_btn).click();
		Thread.sleep(2000);
		selectByVisibleText(halka_drpdown, halkaName);
	}
	
	public void setMauja(String maujaValue) {
		selectByValue(mauja_drpdown, maujaValue);
	}
	
	public void setsearchviaRaiyatName() {
		waitforElementClickability(pangi2_btn).click();
		waitforElementClickability(raiyatName_chkbox).click();
		waitforVisibilityOfElement(sumresult_txtbox).sendKeys(doSum());
		waitforElementClickability(search_btn).click();
	}
	
	public String doSum() {
		String doSum = sumexp_txtbox.getAttribute("value");
		char[] arr = doSum.trim().toCharArray();
		char first = arr[0];
		char second = arr[arr.length-1];
		String a = Character.toString(first);
		String b = Character.toString(second);
		int c = Integer.parseInt(a);
		int d = Integer.parseInt(b);
		int sum = c+d;
		String result = String.valueOf(sum);
		return result;
	}
	

}
