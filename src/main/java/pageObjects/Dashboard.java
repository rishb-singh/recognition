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

	@FindBy(xpath = "//body/div[@id='__next']/div[@id='sticky-header-root']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/button[1]/div[1]/i[1]")
	WebElement dashboardDropdown;

	@FindBy(xpath = "//div[@class='TI76AP']")
	WebElement userEmail;
	
	@FindBy(xpath = "//a[normalize-space()='Recognition']")
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
