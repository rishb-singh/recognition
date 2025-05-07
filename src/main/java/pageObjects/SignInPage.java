package pageObjects;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import utility.Utility;

public class SignInPage extends BaseClass {

	public SignInPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id=\"email\"]")
	WebElement emailField;

	@FindBy(xpath = "//input[@id=\"password\"]")
	WebElement passwordField;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement loginCTA;

	public void enterEmail() throws InterruptedException, EncryptedDocumentException, IOException {
		// reading data from excel
		String email = Utility.readingDataFromSheet(1, 2);
		emailField.sendKeys(email);

	}

	public void enterPassword() throws EncryptedDocumentException, IOException {
		// reading data from excel
		String password = Utility.readingDataFromSheet(2, 2);
		passwordField.sendKeys(password);
	}

	public Dashboard clickLogin() {
		loginCTA.click();
		return new Dashboard();
	}
}
