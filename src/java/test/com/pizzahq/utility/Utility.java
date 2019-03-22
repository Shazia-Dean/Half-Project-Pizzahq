package com.pizzahq.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pizzahq.tests.BaseTestSuit;


public class Utility {
	public static Boolean elementExists(WebDriver driver, By locator, long timeoutSec, long timeoutMS) {
		try {
			driver.manage().timeouts().implicitlyWait(0,  TimeUnit.SECONDS);
			
			(new WebDriverWait(driver, timeoutSec, timeoutMS))
			.until(ExpectedConditions.elementToBeClickable(locator));
			
			driver.manage().timeouts().implicitlyWait(BaseTestSuit.IMPLICIT_TIMEOUT,  TimeUnit.SECONDS);
			return true;
		}catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(BaseTestSuit.IMPLICIT_TIMEOUT,  TimeUnit.SECONDS);
			return false;
		}
	}

}
