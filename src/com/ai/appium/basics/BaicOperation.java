package com.ai.appium.basics;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaicOperation {
	
	public static void main(String[] args) throws MalformedURLException {
		
		File f  = new File("app\\ApiDemos-debug.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
		cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
		
		AndroidDriver<AndroidElement> driver=
				new AndroidDriver<AndroidElement>
		(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		
		
//		[ADB] Package name: 'io.appium.android.apis'
//			[ADB] Main activity name: 'io.appium.android.apis.ApiDemos'
//		
		/*
		- basic
		--//[htmltag[@attribute='value']
		Logical operation -> and , or
		functions:
			-text()
			-contains(arg1,arg2)
			-starts-with(arg1,arg2)
			-ends-with(arg1,arg2)
			AXES Functions:
			//htmltag[@attibute='value']/following-sibling::siblingtag
*/		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
