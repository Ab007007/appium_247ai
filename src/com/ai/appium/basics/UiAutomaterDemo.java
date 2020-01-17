package com.ai.appium.basics;

import java.net.MalformedURLException;

import com.ai.appium.basics.utils.DriverUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UiAutomaterDemo {

	public static void main(String[] args) throws MalformedURLException {
		//property(\"Value\")
		AndroidDriver<AndroidElement> driver = DriverUtils.getMyDriver();

		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
			
	}
}
