package com.ai.appium.basics.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverUtils {
	
	
	/***
	 * @author Aravind
	 * @return AndroidDriver<AndroidElement> Object
	 * @throws MalformedURLException
	 * By default AndroidDriver Object created for emulator and API-Demos application will be used
	 */
	public static AndroidDriver<AndroidElement> getMyDriver() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		
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
		
		AndroidDriver<AndroidElement> driver=
				new AndroidDriver<AndroidElement>
		(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		return driver;
	}

	
	
	
	
}
