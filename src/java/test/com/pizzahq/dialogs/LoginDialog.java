package com.pizzahq.dialogs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.pizzahq.modelPages.BaseNavigation;
import com.pizzahq.utility.Utility;

public class LoginDialog extends BaseNavigation {

	public LoginDialog(WebDriver driver) {
		super(driver);
	}
	By loginButton = By.cssSelector("#loginDialog button[aria-label='login']");
	By usernameField = By.cssSelector("#loginDialog input[id*='username']");
	By passwordField = By.cssSelector("#loginDialog input[id*='password']");
	By dismissIcon = By.cssSelector("#loginDialog .alertMessage a");
	By alertMessage = By.cssSelector("#loginDialog .alertMessage div");
	
	
	public void clickLoginButton() {
		driver.findElement(loginButton).sendKeys(Keys.ENTER);
	}
	public String getAlertMessage() {
		return Utility.elementExists(driver, alertMessage, 1, 0)?
				driver.findElement(alertMessage).getText():"";
	}
	public void clickDismissIcon() {
		driver.findElement(dismissIcon).click();
	}
	public void setUsernameField(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}
	public void setPasswordField(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
}
