package com.pizzahq.tests;

import org.junit.Assert;
import org.junit.Test;

import com.pizzahq.dialogs.LoginDialog;
import com.pizzahq.dialogs.LogoutDialog;
import com.pizzahq.modelPages.HomePage;
import com.pizzahq.modelPages.ProfilePage;





public class LoginDialogTest extends BaseTestSuit {
/*
	@Test
	public void fieldValidationErrorMessage() {
		
		HomePage homePage = new HomePage(driver);
		LoginDialog loginDialog = homePage.clickLoginSignupLink();
		
		loginDialog.clickLoginButton();
		Assert.assertEquals("Alert message displayed", "Your login was unsuccessful - please try again",
				loginDialog.getAlertMessage());
		
		
		loginDialog.clickDismissIcon();
		Assert.assertEquals("Alert message not displayed", "",
				loginDialog.getAlertMessage());
		
	} */
	@Test
	public void loginAndProfileValidation() {
		
		HomePage homePage = new HomePage(driver);
		String homeURL = homePage.getCurrentUrl();
		LoginDialog loginDialog = homePage.clickLoginSignupLink();
		
		loginDialog.setUsernameField("bob");
		loginDialog.setPasswordField("ilovepizza");
		loginDialog.clickLoginButton();
		
		ProfilePage profilePage = homePage.clickProfileLink();
		Assert.assertEquals("Welcome bob", profilePage.getWelcomeMessage());
		String profileURL = profilePage.getCurrentUrl();
		
		LogoutDialog logoutDialog = homePage.clickLogoutLink();
		logoutDialog.clickYesButton();
		
		homePage.jumpToUrl(profileURL);
		Assert.assertEquals(homeURL, homePage.getCurrentUrl());
		
	}

}
