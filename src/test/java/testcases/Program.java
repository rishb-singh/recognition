package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.RichTextString;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.Dashboard;
import pageObjects.Feeds;
import pageObjects.HomePage;
import pageObjects.ProgramDetailPage;
import pageObjects.SignInPage;
import pageObjects.SignUpPage;
import utility.Utility;

public class Program extends BaseClass {
	
	HomePage homepage;
	SignUpPage signuppage;
	SignInPage signinpage;
	Dashboard dashboard;
	Feeds feeds;
	ProgramDetailPage programDetailPage; 
	@Test (priority = 1)
	public void login() throws InterruptedException, EncryptedDocumentException, IOException{
		
		homepage = new HomePage();
		signuppage=homepage.clickOnLogIn();	
		signinpage=signuppage.clickOnSignIn();
		signinpage.enterEmail();	
		signinpage.enterPassword();	
		dashboard = signinpage.clickLogin();
		dashboard.clickDashboardDropdown();
		dashboard.validateUser();
		feeds = dashboard.clickRecognition();
		feeds.verifyFeedsPage();
		
	}
	
	@Test (priority = 2)
	public void createFreeProgram() throws EncryptedDocumentException, IOException, InterruptedException {
		feeds.clickOnOptions();
		programDetailPage = feeds.clickOnCreateNewProgBtn();
		programDetailPage.clickFreeProgCheckbox();
		String freeProgName = Utility.readingDataFromSheet( 3, 2);
		programDetailPage.enterProgName("freeProgName");
		String freeProgCurrency = Utility.readingDataFromSheet( 4, 2);
		programDetailPage.enterProgCurrency(freeProgCurrency );

		String frequency = Utility.readingDataFromSheet( 5, 2);
		programDetailPage.selectFrequency(frequency );
		
		// String allowance = Utility.readingDataFromSheet( 6, 2);
		programDetailPage.enterAllowance("200");
		
	}

}
