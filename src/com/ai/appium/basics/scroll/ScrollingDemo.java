package com.ai.appium.basics.scroll;

import java.net.MalformedURLException;

import com.ai.appium.basics.utils.DriverUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollingDemo {

	public static void main(String[] args) throws MalformedURLException {
		//property(\"Value\")
		AndroidDriver<AndroidElement> driver = DriverUtils.getMyDriver();

		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		driver.findElementByAndroidUIAutomator
		("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
		
		driver.findElementByAndroidUIAutomator("text(\"Tabs\")").click();
		
	}
}
