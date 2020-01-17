package com.ai.appium.basics.hybrid;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

public class HybridAppDemo {
	
	public static void main(String[] args) throws MalformedURLException {
		File f  = new File("app\\WebViewTest.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
		cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.UDID, "01abd5130382753e");
		
		AndroidDriver<AndroidElement> driver=
				new AndroidDriver<AndroidElement>
		(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
		driver.findElementByAccessibilityId("go website").click();
		driver.findElementById("android:id/button1").click();
		
		Set<String> contextIds = driver.getContextHandles();
		
		for (String string : contextIds) {
			
			System.out.println(string);
//			/NATIVE_APP
//			WEBVIEW_com.snc.test.webview2
		}
		
		
		driver.context("WEBVIEW_com.snc.test.webview2");
		
		driver.findElement(By.name("q")).sendKeys("247 ai");
		
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		List<AndroidElement> serachResults = driver.findElements(By.xpath("//h1"));
		
		
		for (AndroidElement androidElement : serachResults) {
			System.out.println(androidElement.getText());
		}
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@class='erkvQe']"))));
//		
//		
//		List<AndroidElement> autoSuggestions = driver.findElements(By.xpath("//li[@class='sbct']"));
//		
//		for (AndroidElement androidElement : autoSuggestions) {
//			System.out.println(androidElement.getText());
//		}
//		
		
		//driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
		
		
	
	}
}
