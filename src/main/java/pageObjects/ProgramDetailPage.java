package pageObjects;
import utility.Utility;

import org.apache.poi.ss.usermodel.RichTextString;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class ProgramDetailPage extends BaseClass {
	
	public ProgramDetailPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='programName']")
	WebElement progNameField;

	@FindBy(xpath = "//input[@id='currencyName']")
	WebElement progCurrencyNameField;
	
	@FindBy(xpath = "//label[@for='attachMonetaryValue']")
	WebElement freeProgCheckbox;
	
	@FindBy(xpath = "//button[@type='button']")
	WebElement progFrequencyDropdownField;
	
	@FindBy(xpath = "//input[@id='allowancePerUser']")
	WebElement allowanceField;
	
	@FindBy(xpath = "//button[@class=\"main_btnPrimary__Jq9Q5  \"]")
	WebElement nextBtn;
	
	@FindBy(xpath = "//label[@for='programStartImmediately']")
	WebElement startImmediatelyChkBox;
	
	
	
	By frequencyOptions = By.xpath("//a[@class='purge-main_dropdownItem__oaG8h menuListItem']");
	
	public void clickstartImmediatelyChkBox() {
		startImmediatelyChkBox.click();
		
	}
	
	public void clickFreeProgCheckbox() {
		freeProgCheckbox.click();
	}

	public void enterProgName(String progName) {
		progNameField.sendKeys(progName);
	}
	
	public void enterAllowance(String allowance) {
		
		allowanceField.sendKeys( String.valueOf(allowance));
	}

	public void enterProgCurrency(String progCurrency) {
		progCurrencyNameField.sendKeys(progCurrency);
	}
	
	public AddUsersPage clickNextBtn() throws InterruptedException {
		nextBtn.click();
		//Thread.sleep(2500);
		return new AddUsersPage();
	}
	
	public void selectFrequency(String frequency) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000)"); 
		progFrequencyDropdownField.click();
		Utility.selectDropdown(frequency, frequencyOptions); 
	}
	
	
}
