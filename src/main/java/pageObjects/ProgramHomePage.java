package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass;

public class ProgramHomePage extends BaseClass {

	
	public ProgramHomePage() {
		PageFactory.initElements(driver, this);	
		}
	
	@FindBy(xpath="//h1[normalize-space()='All Recognition Programs']")
	WebElement pageTitle;
	
	public void validatePage() {
		Assert.assertEquals("All Recognition Programs", pageTitle.getText());
	}
	
}
