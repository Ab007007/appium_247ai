package com.ai.appium.basics.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EmployeeConnectUtils {

	
	
	public static boolean validateFailure(AndroidDriver<AndroidElement> driver)
	{
		boolean flag = true;
		try
		{
			driver.findElementByXPath("//android.widget.Button[@text='OK']").isDisplayed();
			
		}
		catch(NoSuchElementException ex)
		{
			flag = false;
			System.out.println("Exception occurend");
		}
			
		return flag;
	}
	/**
	 * @param driver
	 */
	public static void login(AndroidDriver<AndroidElement> driver, String userName, String password) {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementById("com.IS247.Notifier:id/imageView")));
		
		driver.findElementByAndroidUIAutomator("text(\"Your NT ID\")").sendKeys(userName);
		driver.findElementByAndroidUIAutomator("text(\"Password\")").sendKeys(password);
		driver.findElementByAndroidUIAutomator("text(\"Select NT Domain\")").click();
		
		//247-INC
		driver.findElementByAndroidUIAutomator("text(\"247-INC\")").click();
		
		driver.findElementByAndroidUIAutomator("text(\"Register\")").click();
		
		DriverUtils.waitForLoaderToDisapper(driver);
	}
	
	
	public static void clickOnSettings(AndroidDriver<AndroidElement> driver)
	{
		System.out.println("Clicking on setting button on home page");
		DriverUtils.click(driver, driver.findElementByXPath("//android.widget.TextView[@text='SETTINGS']"));
		
	}
	
	
	public static void clickOnUserAndUnregister(AndroidDriver<AndroidElement> driver)
	{
		DriverUtils.click(driver,driver.findElementByXPath("//android.widget.RelativeLayout[@index='1']"));
		DriverUtils.click(driver, driver.findElementById("com.IS247.Notifier:id/lblUnReg")); //.click();
		
		driver.findElementById("com.IS247.Notifier:id/layoutEditor").sendKeys("i'm done!!!");
		DriverUtils.click(driver, driver.findElementById("com.IS247.Notifier:id/btnUnregisterSubmit"));
		
		//driver.switchTo().alert().accept();
		DriverUtils.click(driver, driver.findElementByXPath("//android.widget.Button[@text='YES']"));

	}
	
}
