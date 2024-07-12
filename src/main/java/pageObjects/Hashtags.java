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
	
	@FindBy(xpath="//label[contains(@class,'main_switchIcon__QW_lp')]")
	WebElement companyValueSwitch;
	@FindBy(xpath="//div[normalize-space()='Edit']")
	WebElement editBtn;
	@FindBy(xpath="//textarea[@id='hastagValues']")
	WebElement input;
	@FindBy(xpath="//h6[normalize-space()='Company Values']")
	WebElement modalClick;
	@FindBy(xpath="//div[normalize-space()='Save Changes']")
	WebElement saveBtn;
	@FindBy(xpath="(//div[contains(@role,'alert')])[1]")
	WebElement successToast;
	@FindBy(xpath="//span[@class='main_statusPill__vF2oK main_pill__J7brs main_lavenderPill__KE2vi']")
	WebElement extractHashtagText;
	@FindBy(xpath="//div[normalize-space()='General']")
	WebElement generalCta;
	
	public void makeCompanyValueMandatory() {
		companyValueSwitch.click();
		successToast.isDisplayed();
		
	}
	
	public void addCompanyValue(String values) {
		editBtn.click();
		input.sendKeys(values);
		modalClick.click();
		saveBtn.click();
		successToast.isDisplayed();
		String act = extractHashtagText.getText();
		Assert.assertEquals(values, act);
	}
	
	public General gotoGeneral() {
		generalCta.click();
		return new General();
	}
	
}
