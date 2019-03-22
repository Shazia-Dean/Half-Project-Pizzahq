package com.pizzahq.tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import com.pizzahq.dialogs.SignupDialog;
import com.pizzahq.dialogs.SnackbarPopup;
import com.pizzahq.modelPages.HomePage;



public class SignupDialogTest extends BaseTestSuit {

	@Test
	public void fieldValidationErrorMessages() {
		
		HomePage homePage = new HomePage(driver);
		SignupDialog signupDialog =  homePage.clickSignupMenu();
		
		signupDialog.clickSignupLink();
		signupDialog.clickSignupButton();
		
		Assert.assertEquals("Username error displayed", "Username is required",
				signupDialog.getUsernameError());
		Assert.assertEquals("Password error displayed", "Password is required",
				signupDialog.getPassowrdError());
		Assert.assertEquals("Confirm password error displayed", "Please confirm your password",
				signupDialog.getConfirmPassowrdError());
		
		signupDialog.setUsernameField("abc");
		signupDialog.setPasswordField("abc");
		signupDialog.setConfirmPasswordField("def");
		
		Assert.assertEquals("Username error displayed", "Username must be minimum of 6 characters",
				signupDialog.getUsernameError());
		Assert.assertEquals("Password error displayed", "Password must be minimum of 8 characters",
				signupDialog.getPassowrdError());
		Assert.assertEquals("Confirm password error displayed", "Your passwords do not match",
				signupDialog.getConfirmPassowrdError());
		
		signupDialog.selectUsernameFieldText();
		signupDialog.clearUsernameFieldText();
		signupDialog.setUsernameField("donaldtrump");
		Assert.assertEquals("Error message displayed", "Username already exists",
				signupDialog.getUsernameError());
		
		signupDialog.selectUsernameFieldText();
		signupDialog.clearUsernameFieldText();
		signupDialog.selectPasswordFieldText();
		signupDialog.clearPasswordFieldText();
		signupDialog.selectConfirmPasswordFieldText();
		signupDialog.clearConfirmPasswordFieldText();
		
		signupDialog.setUsernameField("robinhood");
		signupDialog.setPasswordField("letmein2019");
		signupDialog.setConfirmPasswordField("letmein2019");
		
		Assert.assertEquals("Username error not displayed", "",
				signupDialog.getUsernameError());
		Assert.assertEquals("Password error not displayed", "",
				signupDialog.getPassowrdError());
		Assert.assertEquals("Confirm password error not displayed", "",
				signupDialog.getConfirmPassowrdError());
		
		signupDialog.clickSignupButton();
		SnackbarPopup snackbarPopup = new SnackbarPopup (driver);
		Assert.assertEquals("Thanks robinhood, you can now login.", snackbarPopup.getSnackbarPopupMessage());
	}
	

}
