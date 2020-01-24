package com.ai.appium.basics.tests;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ai.appium.basics.utils.DriverUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Notifications {

	
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = DriverUtils.getMyDriver();
		
//		driver.openNotifications();
		driver.openNotifications();

	    List<AndroidElement> allnotifications=driver.findElements(By.id("android:id/title"));

	    for (WebElement webElement : allnotifications) {
	        System.out.println(webElement.getText());
	        if(webElement.getText().contains("something")){
	            System.out.println("Notification found");
	            break;
	        }
	    }
	}
}
