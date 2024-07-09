package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	@FindBy (xpath="//button[@class='main_btnPrimary__Jq9Q5 purge-main_closeBtn__xyGmn ']")
	WebElement closeBtnUserAddMoal;
	@FindBy (xpath="//div[@class='purge-main_title__03Fil']")
	WebElement successText;
	
	
	public void clcikOnInpuEmailBtn() {
		inputEmailBtn.click();
	}
	
	public IntegrationPage clcikFinishBtn() {

		Utility.waitForElementToBeClickable(finishBtn).click();
		return new IntegrationPage();
	}

	
	public void enterEmail(String members) {
		inputEmailModal.sendKeys(members);
		inputEmailModalSpace.click();
		inputEmailModalSubmitBtn.click();
		
	}
	
	public void validateUsersAdded() {
		
		String actText = successText.getText();
		String expText = "Congrats! 1 new user was added";
		Assert.assertEquals(expText, actText);
		
	}

	public void closeSuccessModal() {
		closeBtnUserAddMoal.click();
	}
}
