package com.pizzahq.dialogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pizzahq.modelPages.BaseNavigation;
import com.pizzahq.utility.Utility;

public class SnackbarPopup extends BaseNavigation {

	public SnackbarPopup(WebDriver driver) {
		super(driver);
		
	}
	By popupMessage = By.cssSelector("div.v-snack--active span.popup-message");
	
	public String getSnackbarPopupMessage() {
		return Utility.elementExists(driver, popupMessage, 1, 0)?
				driver.findElement(popupMessage).getText():"";
				
	}

}
