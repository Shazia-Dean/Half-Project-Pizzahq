package com.pizzahq.dialogs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.pizzahq.modelPages.BaseNavigation;
import com.pizzahq.utility.Utility;

public class SignupDialog extends BaseNavigation {

	public SignupDialog(WebDriver driver) {
		super(driver);
		
	}
	By signupLink = By.linkText("Sign Up");
	By usernameField = By.cssSelector("div.v-dialog--active input[aria-label='Username']");
	By passwordField = By.cssSelector("div.v-dialog--active input[aria-label='Password']");
	By confirmField = By.cssSelector("div.v-dialog--active input[aria-label='Confirm Password']");
	By signUpButton = By.cssSelector("div.v-dialog--active button[aria-label='signup']");
	By cancelButton = By.cssSelector("div.v-dialog--active button[aria-label='cancel']");
	By usernameError = By.cssSelector("div.v-dialog--active #username-err");
	By passwordError = By.cssSelector("div.v-dialog--active #password-err");
	By confirmError = By.cssSelector("div.v-dialog--active #confirm-err");

	public void clickSignupLink() {
		driver.findElement(signupLink).click();
	}
	public void clickSignupButton() {
		driver.findElement(signUpButton).click();
	}
	public String getUsernameError() {
		return Utility.elementExists(driver, usernameError, 1, 0)?
				driver.findElement(usernameError).getText():"";
	}
	public String getPassowrdError() {
		return Utility.elementExists(driver, passwordError, 1, 0)?
				driver.findElement(passwordError).getText():"";
				
	}
	public String getConfirmPassowrdError() {
		return Utility.elementExists(driver, confirmError, 1, 0)?
				driver.findElement(confirmError).getText():"";
	}
	public void setUsernameField(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}
	public void setPasswordField(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	public void setConfirmPasswordField(String confirm) {
		driver.findElement(confirmField).sendKeys(confirm);
	}
	public void selectUsernameFieldText() {
		driver.findElement(usernameField).sendKeys(Keys.CONTROL + "a");
	}
	public void clearUsernameFieldText() {
		driver.findElement(usernameField).sendKeys(Keys.DELETE);
	}
	public void selectPasswordFieldText() {
		driver.findElement(passwordField).sendKeys(Keys.CONTROL + "a");
	}
	public void clearPasswordFieldText() {
		driver.findElement(passwordField).sendKeys(Keys.DELETE);
	}
	public void selectConfirmPasswordFieldText() {
		driver.findElement(confirmField).sendKeys(Keys.CONTROL + "a");
	}
	public void clearConfirmPasswordFieldText() {
		driver.findElement(confirmField).sendKeys(Keys.DELETE);
	}
}
