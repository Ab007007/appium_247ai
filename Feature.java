package com.appium.learning.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class Feature {

	public void toggle() throws MalformedURLException {
		IOSDriver<IOSElement> driver = DriverUtils.getDriver();

		DriverUtils.scrollToElement(driver, "Sliders");

		driver.findElementByAccessibilityId("Switches").click();
		System.out.println(driver.findElements(By.className("UIASwitch")).get(0).getAttribute("value"));

		driver.findElements(By.className("UIASwitch")).get(0).click();

		System.out.println(driver.findElements(By.className("UIASwitch")).get(0).getAttribute("value"));
	}

	public void steppers() throws MalformedURLException {
		IOSDriver<IOSElement> driver = DriverUtils.getDriver();
		RemoteWebElement parentElement = (RemoteWebElement) driver.findElement(By.className("XCUIElementTypeTable"));
		String parentID = parentElement.getId();

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("element", parentID);
		map.put("predicateString", "label == 'Steppers'");

		driver.executeScript("mobile:scroll", map);

		driver.findElementByAccessibilityId("Steppers").click();
		driver.findElementByAccessibilityId("Increment").click();
		driver.findElementByAccessibilityId("Increment").click();
		System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(1).getText());

		System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(2).getText());
		driver.findElementByAccessibilityId("Decrement").click();

		System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(1).getText());
	}

	public void pickerView() throws MalformedURLException {
		IOSDriver<IOSElement> driver = DriverUtils.getDriver();
		RemoteWebElement parentElement = (RemoteWebElement) driver.findElement(By.className("XCUIElementTypeTable"));
		String parentID = parentElement.getId();

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("element", parentID);
		map.put("predicateString", "label == 'Steppers'");

		driver.executeScript("mobile:scroll", map);

		driver.findElementByAccessibilityId("Picker View").click();
		driver.findElementByName("Green color component value").sendKeys("220");
		driver.findElementsByClassName("XCUIElementTypePickerWheel").get(0).sendKeys("55");
		driver.findElementByXPath("//*[@name='Blue color component value']").sendKeys("130");

	}

	public void alerts() throws MalformedURLException {
		IOSDriver<IOSElement> driver = DriverUtils.getDriver();

		driver.findElementByAccessibilityId("Alert Views").click();
		driver.findElementByXPath("//XCUIElementTypeStaticText[@name='Text Entry']").click();
		driver.findElementByXPath("(//XCUIElementTypeCollectionView//XCUIElementTypeOther[@visible='false'])[1]")
				.sendKeys("my text");// ("XCUIElementTypeOther").sendKeys("My Text");
		driver.findElementByAccessibilityId("OK").click();
	}

	public void pickers() throws MalformedURLException
	{
		IOSDriver<IOSElement> driver = DriverUtils.getDriver();

		DriverUtils.scrollToElement(driver, "Picker View");
		driver.findElementByAccessibilityId("Picker View").click();

		System.out.println(driver.findElements(By.className("UIAPickerWheel")).get(0).getAttribute("value"));

		driver.findElements(By.className("UIAPickerWheel")).get(0).sendKeys("85");

		driver.findElements(By.className("UIAPickerWheel")).get(1).sendKeys("215");

		System.out.println(driver.findElements(By.className("UIAPickerWheel")).get(0).getAttribute("value"));

	}


	public void Alerts() throws MalformedURLException

	{
		IOSDriver<IOSElement> driver = DriverUtils.getDriver();

		DriverUtils.scrollToElement(driver, "Alert View");
		driver.findElementByAccessibilityId("Alert View").click();

		driver.findElementByName("Simple").click();

		driver.switchTo().alert().accept();

	}

}
