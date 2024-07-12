package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class DeleteProgramPage  extends BaseClass {

	
	public DeleteProgramPage() {
		PageFactory.initElements(driver, this);	
		
		}
	
	@FindBy(xpath="//div[contains(text(),'Delete Program')]")
	WebElement deleteProgBtn;
	@FindBy(xpath="//div[normalize-space()='Yes, Delete']")
	WebElement confirmationModalBtn;
	
	public void clickDeleteProg() {
		deleteProgBtn.click();
	}
	
	public ProgramHomePage confirmDeleteProg() {
		confirmationModalBtn.click();
		return new ProgramHomePage();
	}
}
