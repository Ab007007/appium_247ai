package com.appium.learning.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverUtils {

	public static IOSDriver<IOSElement> getDriver() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
//	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
//	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//	//if ios is more than 10
//	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
////	cap.setCapability(MobileCapabilityType.UDID,"CE016AF5-AC65-4B6B-A7F9-5E");
//	cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.2");
////	cap.setCapability(MobileCapabilityType.APPIUM_VERSION, "v1.12.1");
//	cap.setCapability(MobileCapabilityType.APP, "/Users/aravinda/eclipse-workspace/AppiumTraining/app/UICatalog.app");
		cap.setCapability("platformName", "iOS");
		cap.setCapability("platformVersion", "11.4.1");
		cap.setCapability("deviceName", "iphone 6s");
		cap.setCapability("automationName", "XCUITest");
		cap.setCapability("app",
				"/Users/aravinda/Library/Developer/Xcode/DerivedData/UICatalog-atukrztqrlzuepejgprloxbltrcq/Build/Products/Debug-iphonesimulator/UICatalog.app");
		cap.setCapability("noreset", true);
		cap.setCapability("udid", "8C5A9BF4-505D-42BB-BBC3-DC7EEB50080D");

		IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		return driver;
	}

	public static IOSDriver<IOSElement> getBrowser() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iphone 6s");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		// if ios is more than 10
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		cap.setCapability(MobileCapabilityType.UDID, "8C5A9BF4-505D-42BB-BBC3-DC7EEB50080D");
//	cap.setCapability("noreset", true);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4.1");
		cap.setCapability(MobileCapabilityType.APPIUM_VERSION, "v1.16.0");
//	cap.setCapability(MobileCapabilityType.APP, "/Users/aravinda/eclipse-workspace/AppiumTraining/app/UICatalog.app");

		IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static void scrollToElement(IOSDriver<IOSElement> driver, String name) {
		RemoteWebElement parentElement = (RemoteWebElement) driver.findElement(By.className("XCUIElementTypeTable"));
		String parentID = parentElement.getId();

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("element", parentID);
		map.put("predicateString", "label == '" + name + "'");

		driver.executeScript("mobile:scroll", map);
	}

}
