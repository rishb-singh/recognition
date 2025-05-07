package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class AssignKudos extends BaseClass {
	public AssignKudos () {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="(//input[@type=\"text\"])[position() > 1]")
	List<WebElement> assignKudoTextBox;
	
	@FindBy (xpath="//div[text()=\"Finish\"]")
	WebElement finishBtn;
	
	
	
	
	public void assignKudosToAll() {
		for(WebElement ele : assignKudoTextBox ) {
			ele.sendKeys("200");
		}
	}

		
	
	
	public IntegrationPage clickFinish() {
		
		finishBtn.click();
		return new IntegrationPage();
		}

	public Users clickFinishWhileAddingUser() {
		finishBtn.click();
		return new Users();
		
	}
	
	public Users clickFinishWhileAdding() {
		finishBtn.click();
		return new Users();
		
	}
		
	}

