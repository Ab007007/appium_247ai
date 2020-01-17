package com.ai.appium.basics.touchactions;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebElement;

import com.ai.appium.basics.utils.DriverUtils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class DateWidgetsDemo {
	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = DriverUtils.getMyDriver();
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAccessibilityId("Date Widgets").click();
		driver.findElementByXPath("//android.widget.TextView[@content-desc='2. Inline']").click();
		//classname[@attribute='value']
		
		driver.findElementByAccessibilityId("9").click();
		
		WebElement srcEle = driver.findElementByAccessibilityId("15");
		WebElement destEle = driver.findElementByAccessibilityId("45");
	
		
		TouchAction act = new TouchAction(driver);
		
		act.longPress(LongPressOptions.longPressOptions()
				.withElement(ElementOption.element(srcEle))
				.withDuration(Duration.ofSeconds(5)))
		.moveTo(ElementOption.element(destEle)).release().perform();
			
		
		
	}

}
