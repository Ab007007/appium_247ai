package com.ai.appium.basics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchAppWithoutAPK
{
	public static void main(String[] args) throws MalformedURLException {
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		
		AndroidDriver<AndroidElement> driver=
				new AndroidDriver<AndroidElement>
		(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		
		
	}

}
