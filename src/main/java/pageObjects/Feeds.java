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
	
	@FindBy (xpath ="//div[@class=\"main_summaryText__peJLw\"]")
	WebElement summaryText;
	
	@FindBy (xpath ="//a[text()=\"Create New Program\"]")
	WebElement createNewProgBtn;
	
	
	public void clickOnOptions() {
		options.click();
	}
	public ProgramDetailPage clickOnCreateNewProgBtn() {
		createNewProgBtn.click();
		return new ProgramDetailPage();
	}
	
	public void verifyFeedsPage() {
	String exp = summaryText.getText().split(":")[0];
	System.out.println(exp);
	Assert.assertEquals("Summary for", exp);

		}
}
