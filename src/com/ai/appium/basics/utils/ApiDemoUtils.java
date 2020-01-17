package com.ai.appium.basics.utils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ApiDemoUtils
{
	
	public static void wifiSettingsValidator(AndroidDriver<AndroidElement> driver) {
		System.out.println("Clicking on Preference");
		driver.findElementByXPath("//android.widget.TextView[@content-desc='Preference']").click();
		
		System.out.println("Clicking on Preference dependencies");
		driver.findElementByXPath("	//android.widget.TextView[@content-desc='3. Preference dependencies']").click();
		
		System.out.println("Validating checkbox");
		AndroidElement checkBox = driver.findElement(MobileBy.id("android:id/checkbox"));
		
		if(!checkBox.isSelected())
		{
			System.out.println("Checkbox is not selected");
			checkBox.click();
		}
		else
		{
			System.out.println("Checkbox is already selected, so not performing click operation");
		}
		
		
		System.out.println("Clicking on Wifi-Settings ");
		driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
		
		driver.findElementById("android:id/edit").sendKeys("Dummy");
		driver.findElementById("android:id/button1").click();
	}


}
