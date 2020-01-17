package com.ai.appium.basics.browser;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import com.ai.appium.basics.utils.DriverUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FaceBookLoginTest {

	
	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = DriverUtils.getMyBrowserDriver("RZ8M90TM71K");
		driver.get("https://m.facebook.com/");
		driver.findElement(By.id("m_login_email")).sendKeys("admin1231");
		driver.findElement(By.id("m_login_password")).sendKeys("admin1231");
		driver.findElement(By.name("login")).click();
		
		
	}
}
