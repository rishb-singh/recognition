package pageObjects;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utility.Utility;

import base.BaseClass;

public class FeedsPage extends BaseClass {

	
	public FeedsPage() {
		PageFactory.initElements(driver, this);	
		
		}
	
	@FindBy(xpath="//h1")
	WebElement validatePage;
	
	public void validateFeedsPage(String editedName) throws EncryptedDocumentException, IOException {
		Assert.assertEquals("Recognition Program: "+editedName, validatePage.getText());
	}
	
	public void createPost() {
		
	}

}
