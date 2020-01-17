package com.ai.appium.basics.tests;

import java.net.MalformedURLException;

import com.ai.appium.basics.utils.ApiDemoUtils;
import com.ai.appium.basics.utils.DriverUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class WifiSettingsTest {
	
	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = DriverUtils.getMyDriver();
		
		ApiDemoUtils.wifiSettingsValidator(driver);		
		
		
	}

	
}
