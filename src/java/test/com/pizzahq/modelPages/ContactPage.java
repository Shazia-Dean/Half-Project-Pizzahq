package com.pizzahq.modelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pizzahq.utility.Utility;

public class ContactPage extends BaseNavigation {

	public ContactPage(WebDriver driver) {
		super(driver);
		
	}

	By submitButton = By.cssSelector("a[aria-label='submit']");
	By forenameField = By.cssSelector("#forename");
	By forenameError = By.id("forename-err");
	By emailField = By.cssSelector("#email");
	By emailError = By.id("email-err");
	By messageField = By.cssSelector("#message");
	By messageError = By.id("message-err");
	By telephoneField = By.cssSelector("#telephone");
	By telephoneError = By.id("telephone-err");
	By clearButton = By.cssSelector("a[aria-label='clear']");
	By successMessage = By.cssSelector("div.success-message div");
	
	public void clickSubmitButton() {
		driver.findElement(submitButton).click();
	}
	public void clickClearButton() {
		driver.findElement(clearButton).click();
	}
	
	public String getForenameError() {
		return Utility.elementExists(driver, forenameError, 1, 0)?
				driver.findElement(forenameError).getText():"";
	}
	public String getEmailError() {
		return Utility.elementExists(driver, emailError, 1, 0)?
				driver.findElement(emailError).getText():"";
	}
	public String getMessageError() {
		return Utility.elementExists(driver, messageError, 1, 0)?
				driver.findElement(messageError).getText():"";
	}
	public String getTelephoneError() {
		return Utility.elementExists(driver, telephoneError, 1, 0)?
				driver.findElement(telephoneError).getText():"";
	}
	public void setForenameField(String forename) {
		driver.findElement(forenameField).sendKeys(forename);
	}
	public void setEmailField(String email) {
		driver.findElement(emailField).sendKeys(email);
	}
	public void setMessageField(String message) {
		driver.findElement(messageField).sendKeys(message);
	}
	public void setTelephoneField(String telephone) {
		driver.findElement(telephoneField).sendKeys(telephone);
	}
	public String getSuccessMessage() {
		return Utility.elementExists(driver, successMessage, 60, 0)?
				driver.findElement(successMessage).getText():"";
	}
}
	