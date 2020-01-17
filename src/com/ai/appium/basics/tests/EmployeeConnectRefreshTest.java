package com.ai.appium.basics.tests;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ai.appium.basics.utils.DriverUtils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class EmployeeConnectRefreshTest 
{
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
//		AndroidDriver<AndroidElement> driver = DriverUtils.getMyDriver("com.IS247.Notifier",
//		"md53d9dcf7c5801421ba53cb8bb04e2d9b2.SplashView","RZ8M90TM71K");
		AndroidDriver<AndroidElement> driver = DriverUtils.getMyDriver("com.IS247.Notifier",
		"md53d9dcf7c5801421ba53cb8bb04e2d9b2.SplashView","RZ8M90TM71K");
		
		Thread.sleep(6000);
		
		driver.findElementByAndroidUIAutomator("text(\"Your NT ID\")").sendKeys("is.user");
		driver.findElementByAndroidUIAutomator("text(\"Password\")").sendKeys("welcome@247");
		driver.findElementByAndroidUIAutomator("text(\"Select NT Domain\")").click();
		
		//247-INC
		driver.findElementByAndroidUIAutomator("text(\"247-INC\")").click();
		
		driver.findElementByAndroidUIAutomator("text(\"Register\")").click();
		
		//if(driver.findElementById("com.IS247.Notifier:id/relLayOk").isDisplayed())
		Thread.sleep(12000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOf(driver.findElementById("com.IS247.Notifier:id/relLayOk")));
		
		element.click();
		Thread.sleep(5000);
		driver.findElementByAndroidUIAutomator("text(\"NOTIFICATIONS\")").click();
		
		Thread.sleep(6000);
		
		Dimension size =  driver.manage().window().getSize();
		System.out.println("Calling swipe");
		
		swipeleftToRight(driver, size);
		System.out.println("Ending swipe");
		
		System.out.println("End");
		
	}

	public static void swipeleftToRight(AndroidDriver<AndroidElement> driver, Dimension size) {
		int startY = (int) size.height / 2;
		int startX = (int) (size.width * 0.02) ; 
		int endX = (int) (size.width * 0.90) ; 
		
		TouchAction act  =  new TouchAction(driver);
		
		act.press(PointOption.point(startX, startY))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(250)))
		.moveTo(PointOption.point(endX, startY)).release().perform();
	}
	
	

	public static void swipeRightToLeft(AndroidDriver<AndroidElement> driver, Dimension size) {
		int startY = (int) size.height / 2;
		int startX = (int) (size.width * 0.95) ; 
		int endX = (int) (size.width * 0.05) ; 
		
		TouchAction act  =  new TouchAction(driver);
		
		act.press(PointOption.point(startX, startY))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(endX, startY)).release().perform();
	}

	
	public static void swipeTopToBottom(AndroidDriver<AndroidElement> driver, Dimension size) {
		int startx = (int) size.width / 2;
		int starty = (int) (size.height * 0.05); 
		int endy = (int) (size.width * 0.95) ; 
		
		TouchAction act  =  new TouchAction(driver);
		
		act.press(PointOption.point(startx, starty))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(startx, endy)).release().perform();
	}
	
	public static void swipeBottomToTop(AndroidDriver<AndroidElement> driver, Dimension size) {
		int startx = (int) size.width / 2;
		int starty = (int) (size.height * 0.95); 
		int endy = (int) (size.width * 0.05) ; 
		
		TouchAction act  =  new TouchAction(driver);
		
		act.press(PointOption.point(startx, starty))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(startx, endy)).release().perform();
	}
	
	
	
}















