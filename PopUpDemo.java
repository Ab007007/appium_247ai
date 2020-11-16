package com.appium.learning.basic;

import org.apache.commons.codec.binary.Base64;	
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.appium.learning.utils.DriverUtils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class PopUpDemo {
	
	public static void main(String[] args) throws MalformedURLException {
		
		
		System.out.println("Welcome to UiCatalog Application");
		
		//IOSDriver<IOSElement> driver = DriverUtils.getDriver();
		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
//		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//		//if ios is more than 10
//		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
////		cap.setCapability(MobileCapabilityType.UDID,"CE016AF5-AC65-4B6B-A7F9-5E");
//		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.2");
////		cap.setCapability(MobileCapabilityType.APPIUM_VERSION, "v1.12.1");
//		cap.setCapability(MobileCapabilityType.APP, "/Users/aravinda/eclipse-workspace/AppiumTraining/app/UICatalog.app");
		 cap.setCapability("platformName", "iOS");
		 cap.setCapability("platformVersion", "11.4.1");
		 cap.setCapability("deviceName", "iphone 6s");
		 cap.setCapability("automationName", "XCUITest");
		 cap.setCapability("app", "/Users/aravinda/Library/Developer/Xcode/DerivedData/UICatalog-atukrztqrlzuepejgprloxbltrcq/Build/Products/Debug-iphonesimulator/UICatalog.app");
		 cap.setCapability("noreset", true);
		 cap.setCapability("udid", "8C5A9BF4-505D-42BB-BBC3-DC7EEB50080D");
		 
		
		IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.findElementByXPath("//XCUIElementTypeStaticText[@name='Alert Views']").click();
		
		driver.findElementByXPath("//XCUIElementTypeStaticText[@name='Text Entry']").click();
	
		driver.findElementByName("XCUIElementTypeOther").sendKeys("abcd");

		driver.findElementByXPath("//XCUIElementTypeButton[@name='OK']").click();
		
	}

}
