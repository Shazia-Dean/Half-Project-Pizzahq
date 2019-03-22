package com.pizzahq.modelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pizzahq.dialogs.LoginDialog;
import com.pizzahq.dialogs.LogoutDialog;
import com.pizzahq.dialogs.SignupDialog;

public class BaseNavigation {

	protected WebDriver driver;
	
	public BaseNavigation(WebDriver driver) {
		this.driver = driver;
	}
	By contactLink  = By.cssSelector(".nav-contact");
	By menuLink = By.cssSelector(".nav-menu");
	By LoginSignupLink = By.className("nav-login-signup");
	By profileLink = By.className("nav-profile");
	By logoutLink = By.linkText("Logout");
	
	public ContactPage clickContactLink() {
		driver.findElement(contactLink).click();
		return new ContactPage(driver);
	}
	public LoginDialog clickLoginSignupLink() {
		driver.findElement(LoginSignupLink).click();
		return new LoginDialog(driver);
	}
	public ProfilePage clickProfileLink() {
		driver.findElement(profileLink).click();
		return new ProfilePage(driver);
	}
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	public void jumpToUrl(String url) {
		driver.navigate().to(url);
	}
	public LogoutDialog clickLogoutLink() {
		driver.findElement(logoutLink).click();
		return new LogoutDialog(driver);
	}
	public SignupDialog clickSignupMenu() {
		driver.findElement(LoginSignupLink).click();
		return new SignupDialog(driver);
	}
}
