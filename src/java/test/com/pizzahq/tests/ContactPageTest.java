package com.pizzahq.tests;

import org.junit.Assert;
import org.junit.Test;

import com.pizzahq.modelPages.ContactPage;
import com.pizzahq.modelPages.HomePage;



public class ContactPageTest extends BaseTestSuit {

	@Test
	public void mandatoryErrorMessages() {
		
		HomePage homePage = new HomePage(driver);
		ContactPage contactPage = homePage.clickContactLink();
		
		contactPage.clickSubmitButton();
		
		Assert.assertEquals("Forename error displayed", "Forename is required",
				contactPage.getForenameError());
		Assert.assertEquals("Email error displayed", "Email is required",
				contactPage.getEmailError());
		Assert.assertEquals("Message error displayed", "Message is required",
				contactPage.getMessageError());
		
		contactPage.setForenameField("Dan");
		contactPage.setEmailField("dan@abc.com");
		contactPage.setMessageField("Nice Pizza");
		
		Assert.assertEquals("Forename error not displayed", "",
				contactPage.getForenameError());
		Assert.assertEquals("Email error not displayed", "",
				contactPage.getEmailError());
		Assert.assertEquals("Message error not displayed", "",
				contactPage.getMessageError());
	}
	@Test
	public void fieldValidationErrorMessages() {
		
		HomePage homePage = new HomePage(driver);
		ContactPage contactPage = homePage.clickContactLink();
		
		contactPage.setEmailField("xxx");
		contactPage.setTelephoneField("xxx");
		
		contactPage.clickSubmitButton();;
		Assert.assertEquals("Email validation error displayed", "Email is invalid",
				contactPage.getEmailError());
		Assert.assertEquals("Telephone validation error displayed", "Telephone is invalid",
				contactPage.getTelephoneError());
		
		contactPage.clickClearButton();
		Assert.assertEquals("Email validation error not displayed", "",
				contactPage.getEmailError());
		Assert.assertEquals("Telephone validation error not displayed", "",
				contactPage.getTelephoneError());
	}
	@Test
	public void verifySuccessMessages() {
		
		HomePage homePage = new HomePage(driver);
		ContactPage contactPage = homePage.clickContactLink();
		
		contactPage.setForenameField("Dan");
		contactPage.setEmailField("dan@abc.com");
		contactPage.setMessageField("Nice pizza");
		
		contactPage.clickSubmitButton();
		Assert.assertEquals("Success message displayed", "Thanks Dan, we appreciate your feedback",
				contactPage.getSuccessMessage());
	}
	
}
