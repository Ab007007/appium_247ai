package com.ai.appium.basics.gettingText;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorApp 
{
	public static void main(String[] args) throws MalformedURLException
	{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		
		AndroidDriver<AndroidElement> driver=
				new AndroidDriver<AndroidElement>
		(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		
		driver.findElementById("com.android.calculator2:id/digit_5").click();
		driver.findElementByXPath("//android.widget.Button[@content-desc='multiply']").click();
		driver.findElementById("com.android.calculator2:id/digit_5").click();
		
		String result = driver.findElementById("com.android.calculator2:id/result").getText();
		
		System.out.println("Multiplication : " + result);
		
		
	}
}
