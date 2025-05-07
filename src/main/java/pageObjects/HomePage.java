package pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class HomePage extends BaseClass {
	

	public HomePage() {
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(xpath="//span[text()=\"Login\"]")
	WebElement loginButton;
	public SignUpPage clickOnLogIn() {
		loginButton.click();
		return new SignUpPage();
	}
}

