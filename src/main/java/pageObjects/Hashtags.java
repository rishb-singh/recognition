package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass;

public class Hashtags extends BaseClass {
	
	public Hashtags() {
		PageFactory.initElements(driver, this);	
		
		}
	
	@FindBy(xpath="")
	WebElement companyValueSwitch;
	
	@FindBy(xpath="//div[text()=\"Add/Edit\"]")
	WebElement editBtn;
	
	@FindBy(xpath="//textarea[@id='hastagValues']")
	WebElement input;
	
	@FindBy(xpath="//h6[normalize-space()='Company Values']")
	WebElement modalClick;
	
	@FindBy(xpath="//div[normalize-space()='Save Changes']")
	WebElement saveBtn;
	
	@FindBy(xpath="(//div[contains(@role,'alert')])[1]")
	WebElement successToast;
	
	@FindBy(xpath="//span[contains(@class,\"BNPbb\")]")
	WebElement extractHashtagText;
	
	@FindBy(xpath="//div[normalize-space()='General']")
	WebElement generalCta;
	
	public void makeCompanyValueMandatory() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		companyValueSwitch.click();
		successToast.isDisplayed();
		
	}
	
	public void addCompanyValue(String values) {
		editBtn.click();
		input.sendKeys(values);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modalClick.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		saveBtn.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		successToast.isDisplayed();
		String act = extractHashtagText.getText();
		Assert.assertEquals(values, act);
	}
	
	public General gotoGeneral() {
		generalCta.click();
		return new General();
	}
	
}
