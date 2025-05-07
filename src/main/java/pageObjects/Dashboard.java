package pageObjects;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.RichTextString;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass;
import utility.Utility;

public class Dashboard extends BaseClass {
	public Dashboard() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class=\"sh-b6sBD\"]")
	WebElement dashboardDropdown;

	@FindBy(xpath = "//div[@class=\"sh-QWeo7\"]")
	WebElement userEmail;
	
	@FindBy(xpath = "//span[text()=\"Recognition\"]//parent::a")
	WebElement recognitionButton;
	
	

	public void clickDashboardDropdown() {
		dashboardDropdown.click();
	}

	public void validateUser() throws EncryptedDocumentException, IOException {
		String actualEmail = Utility.readingDataFromSheet(1, 2);
		Assert.assertEquals(actualEmail, userEmail.getText());
		System.out.println(userEmail.getText());
	}
	
	
	public Feeds clickRecognition() {
		
		recognitionButton.click();
		return new Feeds();
	}
	
}
