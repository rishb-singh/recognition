package pageObjects;
import utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass;

public class General extends BaseClass {

	
	public General() {
		PageFactory.initElements(driver, this);	
		
		}
	
	@FindBy(xpath="//input[@id='programName']")
	WebElement progNameField;
	@FindBy(xpath="//input[@id='allowancePerUser']")
	WebElement allowanceField;
	@FindBy(xpath="//button[@class='main_btnPrimary__Jq9Q5 purge-main_saveBtn__7SbYO ']")
	WebElement saveBtn;
	@FindBy(xpath="//button[contains(@class,'btn btn-block')]")
	WebElement frequencyDdBtn;
	@FindBy(xpath="//body/div/div/div/div/div[contains(@role,'alert')]/div[1]")
	WebElement successToast;
	@FindBy(xpath="(//button[@class='main_btnPrimary__Jq9Q5 purge-main_doneCta__bUbVc '])[1]")
	WebElement confirmatioModal;
	@FindBy(xpath="//div[normalize-space()='Delete program']")
	WebElement deleteProgCta;
	@FindBy(xpath="//span[@class='purge-main_mobileHide__oOzht']")
	WebElement gotoFeedsCta;
	
	By frequencyDdOpt = By.xpath("//div[1]/div[2]/a");
	
	public void editName (String name) throws InterruptedException {

		String act = progNameField.getText();
		progNameField.sendKeys(Keys.DOWN.CONTROL+"a");
		progNameField.sendKeys(Keys.BACK_SPACE);
		progNameField.sendKeys(Keys.UP.CONTROL);
		progNameField.sendKeys(name);
		Assert.assertEquals(name , progNameField.getAttribute("value"));
		
		
	}
	
	public void editAllowance(String allowance) {
		allowanceField.sendKeys(Keys.DOWN.CONTROL+"a");
		allowanceField.sendKeys(Keys.BACK_SPACE);
		allowanceField.sendKeys(Keys.UP.CONTROL);
		allowanceField.sendKeys(allowance);
		Assert.assertEquals(allowanceField.getAttribute("value"), allowance);
		
	}
	public void editFrequency(String freq) {
		
	
		frequencyDdBtn.click();
		Utility.selectDropdown(freq, frequencyDdOpt);
		Assert.assertEquals(frequencyDdBtn.getText(), freq);
		
	}
	
	public void clickSave() {
		saveBtn.click();
		Assert.assertEquals(true, successToast.isDisplayed());
		
	}
	
	public void closeConfirmationModal() {
		confirmatioModal.click();
	}
	
	public DeleteProgramPage gotoDeleteProgSection() {
		deleteProgCta.click();
		return new DeleteProgramPage();
	}
	
	public FeedsPage gotoFeeds() {
		gotoFeedsCta.click();
		return new FeedsPage();
	}
	
}
