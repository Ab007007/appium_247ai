package com.ai.appium.basics.tests;

import java.net.MalformedURLException;
import java.sql.Driver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ai.appium.basics.utils.DriverUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.functions.ExpectedCondition;

public class EmployeeConnectLoginTest {

	
	
	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = DriverUtils.getMyDriver("com.IS247.Notifier",
				"md53d9dcf7c5801421ba53cb8bb04e2d9b2.SplashView","emulator-5554");
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementById("com.IS247.Notifier:id/imageView")));
		
		
		driver.findElementByAndroidUIAutomator("text(\"Your NT ID\")").sendKeys("is.user");
		driver.findElementByAndroidUIAutomator("text(\"Password\")").sendKeys("welcome@247");
		driver.findElementByAndroidUIAutomator("text(\"Select NT Domain\")").click();
		
		//247-INC
		driver.findElementByAndroidUIAutomator("text(\"247-INC\")").click();
		
		driver.findElementByAndroidUIAutomator("text(\"Register\")").click();
		
		DriverUtils.waitForLoaderToDisapper(driver);
		
		DriverUtils.click(driver, driver.findElementByXPath("//android.widget.TextView[@text='SETTINGS']"));
		DriverUtils.click(driver,driver.findElementByXPath("//android.widget.RelativeLayout[@index='1']"));
		
		DriverUtils.click(driver, driver.findElementById("com.IS247.Notifier:id/lblUnReg")); //.click();
		
		driver.findElementById("com.IS247.Notifier:id/layoutEditor").sendKeys("i'm done!!!");
		DriverUtils.click(driver, driver.findElementById("com.IS247.Notifier:id/btnUnregisterSubmit"));
		
		//driver.switchTo().alert().accept();
		DriverUtils.click(driver, driver.findElementByXPath("//android.widget.Button[@text='YES']"));
	}
}
