package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.Dashboard;
import pageObjects.Feeds;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import pageObjects.SignUpPage;

public class Program extends BaseClass {
	
	HomePage homepage;
	SignUpPage signuppage;
	SignInPage signinpage;
	Dashboard dashboard;
	Feeds feeds;
	@Test
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

		// adding comment in master
		
	
	}

}
