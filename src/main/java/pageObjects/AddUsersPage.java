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
	
	@FindBy (xpath="//div[text()=\"Input Emails\"]")
	WebElement inputEmailBtn;
	
	@FindBy (xpath="//textarea[@id='autocomplete']")
	WebElement inputEmailModal;
	
	@FindBy (xpath="//div[@class='purge-main_emailContainer__QW_zz']")
	WebElement inputEmailModalSpace;
	
	
	@FindBy (xpath="//div[normalize-space()='Submit']")
	WebElement inputEmailModalSubmitBtn;
	
	@FindBy (xpath="//div[text()=\"Next\"]")
	WebElement finishBtn;
	@FindBy (xpath="//button[@class='main_btnPrimary__Jq9Q5 purge-main_closeBtn__xyGmn ']")
	WebElement closeBtnUserAddMoal;
	@FindBy (xpath="//div[@class='purge-main_title__03Fil']")
	WebElement successText;
	
	
	public void clcikOnInpuEmailBtn() {
		inputEmailBtn.click();
	}
	
	public AssignKudos clcikFinishBtn() throws InterruptedException {

		Thread.sleep(1000);
		Utility.waitForElementToBeClickable(finishBtn).click();
		return new AssignKudos();
	}

	
	public void enterEmail(String members) {
		inputEmailModal.sendKeys(members);
		inputEmailModalSpace.click();
		inputEmailModalSubmitBtn.click();
		
	}
	
	public void validateUsersAdded()  {
		
		String actText = successText.getText();
		String expText = "Congrats! 1 new user was added";
		Assert.assertEquals(expText, actText);
		//driver.navigate().refresh();
		
		
	}

	public void closeSuccessModal()  {
		closeBtnUserAddMoal.click();
	}
}
