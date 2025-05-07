package pageObjects;

import utility.Utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseClass;

public class SignUpPage extends BaseClass {

	public SignUpPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//a[contains(text(), \"Log In\")])[1]")
	WebElement signInButton;

	

	public SignInPage clickOnSignIn() throws InterruptedException {

	
		signInButton.click();
		return new SignInPage();

	}
}
