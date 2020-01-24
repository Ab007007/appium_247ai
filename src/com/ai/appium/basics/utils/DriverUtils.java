package com.ai.appium.basics.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class DriverUtils {
	
	
	/***
	 * @author Aravind
	 * @return AndroidDriver<AndroidElement> Object
	 * @throws MalformedURLException
	 * By default AndroidDriver Object created for emulator and API-Demos application will be used
	 */
	public static AndroidDriver<AndroidElement> getMyDriver() throws MalformedURLException
	{
		File f  = new File("app\\ApiDemos-debug.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
//		cap.setCapability("appPackage", "io.appium.android.apis");
//		cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
		
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		
		AndroidDriver<AndroidElement> driver=
				new AndroidDriver<AndroidElement>
		(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	
	public static void waitForLoaderToDisapper(AndroidDriver<AndroidElement> driver)
	{
		System.out.println("Waiting for loader to disappaer");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		System.out.println("Waiting for loader to appear");
		wait.until(ExpectedConditions.visibilityOf(driver.findElementById("com.IS247.Notifier:id/progressBar1")));

		System.out.println("Loader is appeared... Waiting for it to disappear");
		wait.until(ExpectedConditions.invisibilityOf(driver.findElementById("com.IS247.Notifier:id/progressBar1")));
		
		System.out.println("Loader is disappeared");
		
	}
	
	
	public static void click(AndroidDriver<AndroidElement> driver,AndroidElement ele)
	{
		System.out.println("Verify the element and Click");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		System.out.println("Element is clickable");
		ele.click();
		
		
	}
	
	
	
	public static AndroidDriver<AndroidElement> getMyBrowserDriver(String udid) throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(MobileCapabilityType.UDID, udid);
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		AndroidDriver<AndroidElement> driver=
				new AndroidDriver<AndroidElement>
		(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	
	/***
	 * 
	 * @param pkgName - specify the application package name 
	 * @param activityName -  specify the application Activity 
	 * @param udid - Device unique id on which the execution to be performed
	 * @return - driver object of AndroidDriver<AndroidElement> type
	 * @throws MalformedURLException
	 */
	public static AndroidDriver<AndroidElement> getMyDriver(String pkgName,String activityName, String udid) throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
		cap.setCapability("appPackage", pkgName );
		cap.setCapability("appActivity", activityName);
		cap.setCapability(MobileCapabilityType.UDID, udid);
	//	cap.setCapability("autoAcceptAlerts", true);
		
		AndroidDriver<AndroidElement> driver=
				new AndroidDriver<AndroidElement>
		(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
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
