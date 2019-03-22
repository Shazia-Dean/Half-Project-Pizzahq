package com.pizzahq.modelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pizzahq.utility.Utility;

public class ProfilePage extends BaseNavigation {

	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	By welcomeMessage = By.tagName("h2");
	By userName = By.cssSelector("h2 em");
	
	public String getWelcomeMessage() {
		return Utility.elementExists(driver, userName, 1, 0) ? 
				driver.findElement(welcomeMessage).getText().replace("person ", "") : "";
	}
}
