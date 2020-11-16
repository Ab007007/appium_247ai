package com.appium.learning.basic;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import com.appium.learning.utils.DriverUtils;
import com.appium.learning.utils.Feature;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class ToggleDemo {

	
	public static void main(String[] args) throws MalformedURLException {
		
		
		IOSDriver<IOSElement> driver = DriverUtils.getDriver();
		
		
		Feature f = new Feature();
//		f.pickers();
//		f.alerts();
		f.pickerView();
	}
}
