package com.appium.learning.basic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class Practice {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		IOSDriver<IOSElement> driver = getDriverObj();
		
		scrollToElement(driver, "Web View");
		driver.findElementByAccessibilityId("Web View").click();
		
		Thread.sleep(3000);
		Set<String> appType = driver.getContextHandles();
		
		Iterator<String> it = appType.iterator();
		String nativeAppID = it.next();
		String webAppID = it.next();
				
		driver.context(webAppID);
		
		driver.get("http://google.com");
		
		driver.findElementByName("q").sendKeys("24/7 ai");
		driver.findElementByName("q").sendKeys(Keys.ENTER);
		
		
		System.out.println(driver.getCurrentUrl());
		
		
		
		//driver.get("http://www.google.com");
//		
//	//	popupHandler(driver);
//	//	driver.navigate().back();
//		
//		switchToDemo(driver);
//		driver.navigate().back();
//		
//		steppersTest(driver);
//		driver.navigate().back();
//		
//		swipeDemo(driver);
//		driver.navigate().back();
//		
//		swipeToElement(driver,"150");
//		driver.navigate().back();
//		
//		
		
		System.out.println("ENDED");
		
	}

	public static IOSDriver<IOSElement> getBrowser() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
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



	private static void swipeToElement(IOSDriver<IOSElement> driver,String number) {
		driver.findElementByAccessibilityId("Picker View").click();
		
		driver.findElementByXPath("//XCUIElementTypePickerWheel[@name='Red color component value']").sendKeys(number);
	}





	private static IOSDriver<IOSElement> getDriverObj() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
//		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//		//if ios is more than 10
//		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
//	//	cap.setCapability(MobileCapabilityType.UDID,"CE016AF5-AC65-4B6B-A7F9-5E");
//		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.2");
//	//	cap.setCapability(MobileCapabilityType.APPIUM_VERSION, "v1.12.1");
//		cap.setCapability(MobileCapabilityType.APP, "/Users/aravinda/eclipse-workspace/AppiumTraining/app/UICatalog.app");
		cap.setCapability("platformName", "iOS");
		cap.setCapability("platformVersion", "11.4.1");
		cap.setCapability("deviceName", "iphone 6s");
		cap.setCapability("automationName", "XCUITest");
		cap.setCapability("app",
				"/Users/aravinda/Library/Developer/Xcode/DerivedData/UICatalog-atukrztqrlzuepejgprloxbltrcq/Build/Products/Debug-iphonesimulator/UICatalog.app");
		cap.setCapability("noreset", true);
		cap.setCapability("udid", "8C5A9BF4-505D-42BB-BBC3-DC7EEB50080D");

		IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}





	private static void swipeDemo(IOSDriver<IOSElement> driver) {
		driver.findElementByAccessibilityId("Picker View").click();
		
		
		RemoteWebElement parentElement = (RemoteWebElement)driver.findElement(By.xpath("//XCUIElementTypePickerWheel[@name='Red color component value']"));
			
		String parentID = parentElement.getId();
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("direction", "up");
		map.put("element", parentID);
		map.put("predicateString", "value == '85'");
		
		driver.executeScript("mobile:swipe", map);
	}





	private static void steppersTest(IOSDriver<IOSElement> driver) {
		scrollToElement(driver,"Search Bars");
		driver.findElementByAccessibilityId("Steppers").click();
		
		//driver.findElementsByXPath("//XCUIElementTypeOther[@name='DEFAULT']/following-sibling::XCUIElementTypeCell").get(0).
		driver.findElementsByXPath("//XCUIElementTypeButton[@name='Increment']").get(0).click();
		driver.findElementsByXPath("//XCUIElementTypeButton[@name='Increment']").get(0).click();
		driver.findElementsByXPath("//XCUIElementTypeButton[@name='Increment']").get(0).click();

		System.out.println("Count " + driver.findElementsByXPath("//XCUIElementTypeStaticText").get(1).getText());
		
		
		
		driver.findElementByXPath("(//XCUIElementTypeButton[@name='Increment'])[2]").click();
		driver.findElementByXPath("(//XCUIElementTypeButton[@name='Increment'])[2]").click();
		driver.findElementByXPath("(//XCUIElementTypeButton[@name='Increment'])[2]").click();
		
		System.out.println("Count : " + driver.findElementByXPath("(//XCUIElementTypeStaticText)[3]").getText());
	}





	private static void scrollToElement(IOSDriver<IOSElement> driver, String text) {
		RemoteWebElement parentElement = (RemoteWebElement)driver.findElement(By.className("XCUIElementTypeTable"));
		String parentID = parentElement.getId();
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("direction", "down");
		map.put("element", parentID);
		map.put("predicateString", "label == '" + text + "'");
		
		driver.executeScript("mobile:scroll", map);
	}





	private static void switchToDemo(IOSDriver<IOSElement> driver) {
		driver.findElementByXPath("//XCUIElementTypeStaticText[@name='Alert Views']").click();

		driver.findElementByAccessibilityId("Simple").click();
	//	driver.findElementByAccessibilityId("OK").click();
		
		driver.switchTo().alert().accept();
	}

	
	
	
	
	private static void popupHandler(IOSDriver<IOSElement> driver) {
		driver.findElementByXPath("//XCUIElementTypeStaticText[@name='Alert Views']").click();

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name='Text Entry']").click();

		driver.findElementByXPath("//XCUIElementTypeAlert//XCUIElementTypeTextField").sendKeys("abcd");

		driver.findElementByXPath("//XCUIElementTypeButton[@name='OK']").click();
	}

}
