package com.ai.appium.basics.touchactions;

import java.net.MalformedURLException;
import java.time.Duration;

import com.ai.appium.basics.utils.DriverUtils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class DragAndDemo {

	private static AndroidElement srcElement;

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = DriverUtils.getMyDriver();
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAccessibilityId("Drag and Drop").click();
		
		srcElement = driver.findElementsByXPath("//android.view.View").get(0); // ("io.appium.android.apis:id/drag_dot_1");
		AndroidElement destElement = driver.findElementsByXPath("//android.view.View").get(1); // ("io.appium.android.apis:id/drag_dot_1");
	//	AndroidElement destElement = driver.findElementById("	io.appium.android.apis:id/drag_dot_2");
	
		
		TouchAction act = new TouchAction(driver);
		
		act.longPress(LongPressOptions.longPressOptions()
				.withElement(ElementOption.element(srcElement))
				.withDuration(Duration.ofSeconds(2)))
				.moveTo(ElementOption.element(destElement)).release().perform();
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}
}
