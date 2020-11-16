package com.appium.learning.browser;

import java.net.MalformedURLException;

import com.appium.learning.utils.DriverUtils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class SafariGmail {
	
	public static void main(String[] args) throws MalformedURLException {
		
		IOSDriver<IOSElement> driver = DriverUtils.getBrowser();
		
		driver.get("http://www.google.com/");
	}

}
