package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass;

public class Feeds extends BaseClass {
	
	public Feeds() {
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath ="//span[contains(@class,'purge-main_moreIcon__nBasH')]")
	WebElement options;
	
	@FindBy (xpath ="//h1[@class=\"purge-main_heading__i9Irx\"]")
	WebElement recognitionLabel;
	
	@FindBy (xpath ="//div[contains(text(),'Create New Program')]")
	WebElement createNewProgBtn;
	
	
	public void clickOnOptions() {
		options.click();
	}
	public ProgramDetailPage clickOnCreateNewProgBtn() {
		createNewProgBtn.click();
		return new ProgramDetailPage();
	}
	
	public void verifyFeedsPage() {
	String exp = recognitionLabel.getText().split(":")[0];
	System.out.println(exp);
	Assert.assertEquals("Recognition Program", exp);

		}
}
