package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.RichTextString;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.AddUsersPage;
import pageObjects.Dashboard;
import pageObjects.Feeds;
import pageObjects.Hashtags;
import pageObjects.HomePage;
import pageObjects.IntegrationPage;
import pageObjects.ProgramDetailPage;
import pageObjects.SignInPage;
import pageObjects.SignUpPage;
import pageObjects.Users;
import utility.Utility;

public class Program extends BaseClass {
	
	HomePage homepage;
	SignUpPage signuppage;
	SignInPage signinpage;
	Dashboard dashboard;
	Feeds feeds;
	ProgramDetailPage programDetailPage; 
	AddUsersPage addUsersPage;
	IntegrationPage integrationPage;
	Users  users;
	Hashtags hashtags;
	
	String companyValues ="#CompanyValue";
	
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
		programDetailPage.clickstartImmediatelyChkBox();
		String freeProgName = Utility.readingDataFromSheet( 3, 2);
		programDetailPage.enterProgName(freeProgName);
		String freeProgCurrency = Utility.readingDataFromSheet( 4, 2);
		programDetailPage.enterProgCurrency(freeProgCurrency );

		String frequency = Utility.readingDataFromSheet( 5, 2);
		programDetailPage.selectFrequency(frequency );
		
		// String allowance = Utility.readingDataFromSheet( 6, 2);
		programDetailPage.enterAllowance("200");
		// Assert.assertTrue(false);
		addUsersPage = programDetailPage.clickNextBtn();
		addUsersPage.clcikOnInpuEmailBtn();
		String users =Utility.readingDataFromSheet(7, 2);
		addUsersPage.enterEmail(users);
		integrationPage = addUsersPage.clcikFinishBtn();
		integrationPage.vlaidateProgram();
		integrationPage.closeSuccessModal();
		
	}
	
	@Test(priority=3)
	public void addUserInProgram () throws EncryptedDocumentException, IOException {
		
		users =integrationPage.gotoUsers();
		users.clickAddUsersBtn();
		addUsersPage.clcikOnInpuEmailBtn();
		String users =Utility.readingDataFromSheet(8, 2);
		addUsersPage.enterEmail(users);
		addUsersPage.clcikFinishBtn();
		addUsersPage.validateUsersAdded();
		addUsersPage.closeSuccessModal();
	}
	
	@Test(priority=4)
	public void deleteUserInProgram () throws EncryptedDocumentException, IOException {
		
		users.clickDeleteUsersBtn();
		users.confirmDeleteUsersModal();
		users.validateUsersPage();	
	}
	
	@Test(priority = 5)
	public void permission () throws InterruptedException {
		Thread.sleep(500);
		users.clickPermissionDd();
		users.makeAdmin();
		users.clickPermissionDd();
		users.makeMember();
	}
	
	@Test(priority=6)
	public void addHashtags() throws InterruptedException {
		
		hashtags = users.gotoHashtags();
		hashtags.makeCompanyValueMandatory();
		hashtags.addCompanyValue(companyValues);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
