package pageObjects;

import utility.Utility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass;

public class Users extends BaseClass {

	public Users() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[text()=\"Add Users\"]")
	WebElement addUsersBtn;
	@FindBy(xpath = "(//button[text()=\"Member\"]//following::div//button[@title=\"Delete\"])[1]")
	WebElement deleteUsersBtn;
	@FindBy(xpath = "//div[text()=\"Yes, Remove\"]")
	WebElement deleteUsersModalBtn;
	@FindBy(xpath = "//p[@class='purge-main_userHeading__V2bK4']")
	WebElement validateUsersPageText;
	@FindBy(xpath = "//div[@class='purge-main_contactListContainer__HushW']/div[3]/div/div[3]")
	WebElement permissionDd;
	
	@FindBy(xpath = "//div[3]/div[2]/div[3]/div[1]/button[1]")
	WebElement permissionDdDiv;
	
	@FindBy(xpath = "//div[contains(text(),'Permission updated')]")
	WebElement successToast;
	
	@FindBy(xpath = "//div[text()=\"Hashtags\"]")
	WebElement hashtagBtn;
	
	@FindBy(xpath = "//div[@class=\"purge-main_title__03Fil\"]")
	WebElement successUserModalText;
	
	@FindBy(xpath = "//div[text()=\"Close\"]")
	WebElement closeSuccessModalAddUserBtn;
	
	@FindBy(xpath = "//div[text()=\"User has been removed.\"]")
	WebElement successTextDeleteUser;
	
	

	By permissionOptions = By.xpath("//a[@class=\"purge-main_dropdownItem__5goin   custom-dropdown-item\"]");

	public AddUsersPage clickAddUsersBtn() {
		addUsersBtn.click();
		return new AddUsersPage();
	}

	public void clickDeleteUsersBtn() throws InterruptedException {
		Thread.sleep(500);
		deleteUsersBtn.click();

	}

	public void confirmDeleteUsersModal() {
		deleteUsersModalBtn.click();
		
	}

	public void validateUsersPage() throws EncryptedDocumentException, IOException {
		String act = validateUsersPageText.getText();
		String exp = "All users in " + Utility.readingDataFromSheet(3, 2);
		Assert.assertEquals(act, exp);
	}

	public void clickPermissionDd() {
		driver.navigate().refresh();
		WebElement ele = Utility.waitForElementToBeClickable(permissionDd);
		ele.click();
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
	
	public void verifyUserAdded() {
		
		Assert.assertEquals("Congrats! 1 new user was added", successUserModalText.getText());
	}
	
	public void closeSuccessModalAddUser() {
		closeSuccessModalAddUserBtn.click();
		
	}
	public void verifydeleteSuccessToast() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals("User has been removed.", successTextDeleteUser.getText());
	}
}
