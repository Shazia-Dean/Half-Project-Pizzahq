package com.pizzahq.dialogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pizzahq.modelPages.BaseNavigation;

public class LogoutDialog extends BaseNavigation {

	public LogoutDialog(WebDriver driver) {
		super(driver);
		
	}
	By yesButton = By.cssSelector("div.v-dialog--active button[aria-label='yes']");
	
	public void clickYesButton() {
		driver.findElement(yesButton).click();
	}
	
}
