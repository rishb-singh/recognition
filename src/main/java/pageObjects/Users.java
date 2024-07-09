package pageObjects;
import utility.Utility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass;

public class Users extends BaseClass {
	
	public Users() {
		PageFactory.initElements(driver, this);	
		
		}

	
	@FindBy(xpath="//div[contains(@class,'purge-main_buttonContainer__N1kzk')]//a[contains(@class,'')]")
	WebElement addUsersBtn;
	@FindBy(xpath="//div[3]/div[2]//div[@class=\"purge-main_deleteCell__5pGzc\"]/button")
	WebElement deleteUsersBtn;
	@FindBy(xpath="//button[contains(@class,'main_btnDanger__gcHPr purge-main_remove__pQhVt')]")
	WebElement deleteUsersModalBtn;
	@FindBy(xpath="//p[@class='purge-main_userHeading__V2bK4']")
	WebElement validateUsersPageText;
	@FindBy(xpath="//div[3]/div[2]/div[3]/div[1]/button[1]/span[1]")
	WebElement permissionDd;
	@FindBy(xpath="//div[3]/div[2]/div[3]/div[1]/button[1]")
	WebElement permissionDdDiv;
	@FindBy(xpath="//div[contains(text(),'Permission updated')]")
	WebElement successToast;
	@FindBy(xpath="//div[normalize-space()='Hashtags']")
	WebElement hashtagBtn;
	
	
	
	By permissionOptions = By.xpath("//a[@class=\"purge-main_dropdownItem__5goin   custom-dropdown-item\"]");
	
	public AddUsersPage clickAddUsersBtn() {
		addUsersBtn.click();
		return new AddUsersPage();
	}
	
	public void clickDeleteUsersBtn() {
		deleteUsersBtn.click();

	}
	
	public void confirmDeleteUsersModal() {
		deleteUsersModalBtn.click();
	}
	public void validateUsersPage() throws EncryptedDocumentException, IOException {
		String act= validateUsersPageText.getText() ;
		String exp = "All users in " + Utility.readingDataFromSheet(3, 2);
		Assert.assertEquals(act, exp);
	}
	
	public void clickPermissionDd () {
		Utility.waitForElementToBeClickable(permissionDd);
		permissionDd.click();
	}
	
	public void makeAdmin() {
		Utility.selectDropdown("Admin", permissionOptions);
		successToast.isDisplayed();
		Assert.assertEquals("Admin", permissionDdDiv.getText());
		
	}
	
	public void makeMember() {
		Utility.selectDropdown("Member", permissionOptions);
		successToast.isDisplayed();
		Assert.assertEquals("Member", permissionDdDiv.getText());
	}
	
	public Hashtags gotoHashtags() {
		hashtagBtn.click();
		return new Hashtags();
	}
}
