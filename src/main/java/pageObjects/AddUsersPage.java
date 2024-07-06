package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import utility.Utility;

public class AddUsersPage extends BaseClass{
	
	public AddUsersPage () {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="(//button[@class='main_btnOutlinePrimary__9LyIm purge-main_submit__bwVnF '])[3]")
	WebElement inputEmailBtn;
	
	@FindBy (xpath="//textarea[@id='autocomplete']")
	WebElement inputEmailModal;
	
	@FindBy (xpath="//div[@class='purge-main_emailContainer__QW_zz']")
	WebElement inputEmailModalSpace;
	
	
	@FindBy (xpath="//div[normalize-space()='Submit']")
	WebElement inputEmailModalSubmitBtn;
	
	@FindBy (xpath="//footer[@class='purge-main_orderFooter__8BQwc purge-main_createOrderFooter__3TfPz']//button[1]")
	WebElement finishBtn;
	
	
	public void clcikOnInpuEmailBtn() {
		inputEmailBtn.click();
	}
	
	public IntegrationPage clcikFinishBtn() {

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utility.waitForElementToBeClickable(finishBtn).click();
		return new IntegrationPage();
	}

	
	public void enterEmail(String members) {
		inputEmailModal.sendKeys(members);
		inputEmailModalSpace.click();
		inputEmailModalSubmitBtn.click();
		
	}

}
