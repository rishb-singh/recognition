package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.AddUsersPage;
import pageObjects.AssignKudos;
import pageObjects.Dashboard;
import pageObjects.DeleteProgramPage;
import pageObjects.Feeds;
import pageObjects.General;
import pageObjects.Hashtags;
import pageObjects.HomePage;
import pageObjects.IntegrationPage;
import pageObjects.ProgramDetailPage;
import pageObjects.ProgramHomePage;
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
	AssignKudos assignKudos;
	IntegrationPage integrationPage;
	Users users;
	Hashtags hashtags;
	General general;
	DeleteProgramPage deleteProgramPage;
	ProgramHomePage programHomePage;

	String companyValues = "#CompanyValue";
	String editName = "Prog name edit";
	String editAllowance = "500";
	String editFreq = "monthly";

	@Test(priority = 1)
	public void Login() throws InterruptedException, EncryptedDocumentException, IOException {

		homepage = new HomePage();
		signuppage = homepage.clickOnLogIn();
		signinpage = signuppage.clickOnSignIn();
		signinpage.enterEmail();
		signinpage.enterPassword();
		dashboard = signinpage.clickLogin();
		dashboard.clickDashboardDropdown();
		dashboard.validateUser();
		feeds = dashboard.clickRecognition();
		feeds.verifyFeedsPage();

	}

	@Test(priority = 2)
	public void CreateFreeProgram() throws EncryptedDocumentException, IOException, InterruptedException {
		feeds.clickOnOptions();
		programDetailPage = feeds.clickOnCreateNewProgBtn();
		programDetailPage.clickFreeProgCheckbox();
		programDetailPage.clickstartImmediatelyChkBox();
		String freeProgName = Utility.readingDataFromSheet(3, 2);
		programDetailPage.enterProgName(freeProgName);
		String freeProgCurrency = Utility.readingDataFromSheet(4, 2);
		programDetailPage.enterProgCurrency(freeProgCurrency);

		String frequency = Utility.readingDataFromSheet(5, 2);
		programDetailPage.selectFrequency(frequency);

		// String allowance = Utility.readingDataFromSheet( 6, 2);
	//	programDetailPage.enterAllowance("200");
		// Assert.assertTrue(false);
		addUsersPage = programDetailPage.clickNextBtn();
		addUsersPage.clcikOnInpuEmailBtn();
		String users = Utility.readingDataFromSheet(7, 2);
		addUsersPage.enterEmail(users);
		assignKudos = addUsersPage.clcikFinishBtn();
		assignKudos.assignKudosToAll();
		integrationPage = assignKudos.clickFinish();
		integrationPage.vlaidateProgram();
		integrationPage.closeSuccessModal();

	}

	@Test(priority = 3)
	public void AddUserInProgram() throws EncryptedDocumentException, IOException, InterruptedException  {

		users = integrationPage.gotoUsers();
		users.clickAddUsersBtn();
		addUsersPage.clcikOnInpuEmailBtn();
		String user = Utility.readingDataFromSheet(8, 2);
		addUsersPage.enterEmail(user);
		assignKudos = addUsersPage.clcikFinishBtn();
		assignKudos.assignKudosToAll();
		users = assignKudos.clickFinishWhileAdding();
		users.verifyUserAdded();
		users.closeSuccessModalAddUser();
		
	}

	@Test(priority = 4)
	public void DeleteUserInProgram() throws EncryptedDocumentException, IOException, InterruptedException {

		users.clickDeleteUsersBtn();
		users.confirmDeleteUsersModal();
		users.verifydeleteSuccessToast();
	}

/*	@Test(priority = 5)
	public void permission() throws InterruptedException  {
		users.clickPermissionDd();
		users.makeAdmin();
		users.clickPermissionDd();
		users.makeMember(); 
	}
*/
	@Test(priority = 5)
	public void AddHashtags() throws InterruptedException {

		hashtags = users.gotoHashtags();
		
		hashtags.addCompanyValue(companyValues);
		//hashtags.makeCompanyValueMandatory();

	}

	@Test(priority = 7)
	public void GeneralSection() throws InterruptedException {

		general = hashtags.gotoGeneral();
		general.editName(editName);
		general.editAllowance(editAllowance);
		general.editFrequency(editFreq);
		general.clickSave();
		general.confirmUpdate();

	}


	@Test(priority = 8)
	public void DeleteProgram() {

		deleteProgramPage = general.gotoDeleteProgSection();
		deleteProgramPage.clickDeleteProg();
		programHomePage = deleteProgramPage.confirmDeleteProg();
		programHomePage.validatePage();

	}

}
