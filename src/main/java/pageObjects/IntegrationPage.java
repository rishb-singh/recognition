package pageObjects;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass;
import utility.Utility;

public class IntegrationPage  extends BaseClass {
	
	public IntegrationPage () {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//div[@class='purge-main_title__03Fil'])[1]")
	WebElement successModal;
	@FindBy(xpath="//button[@class='main_btnPrimary__Jq9Q5 purge-main_closeBtn__xyGmn ']")
	WebElement successModalCloseBtn;
	@FindBy(xpath="//div[normalize-space()='Users']")
	WebElement usersBtn;
	@FindBy(xpath="//div[normalize-space()='General']")
	WebElement generalCta;
	
	
	public void closeSuccessModal() {
		successModalCloseBtn.click();
	}
	
	public void vlaidateProgram() throws EncryptedDocumentException, IOException {
		String progName = Utility.readingDataFromSheet(3, 2);
		String successMsgActual = successModal.getText();
		String successMsgExpected = "Congrats! Your Program ‘" + progName +"’ has been created";
		Assert.assertEquals(successMsgExpected, successMsgActual);	
	}
	public Users gotoUsers() {
		usersBtn.click();
		return new Users();
	}
	
	public General gotoGeneral() {
		generalCta.click();
		return new General();
	}
	
	
}
