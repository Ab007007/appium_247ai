package com.ai.appium.basics.tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Driver;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ai.appium.basics.utils.DriverUtils;
import com.ai.appium.basics.utils.EmployeeConnectUtils;
import com.ai.appium.basics.utils.ExcelUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.functions.ExpectedCondition;

public class EmployeeConnectDataDrivenWithExcel {

	public static String sheetName = "logindata";

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		AndroidDriver<AndroidElement> driver = DriverUtils.getMyDriver("com.IS247.Notifier",
				"md53d9dcf7c5801421ba53cb8bb04e2d9b2.SplashView", "emulator-5554");
		String username, password;
		int rowCount = ExcelUtils.getRowCount(sheetName);
		for (int i = 1; i < rowCount ; i++) {
			username = null;
			password = null;
			username = ExcelUtils.getExcelCellValue(sheetName, i, 0);
			password = ExcelUtils.getExcelCellValue(sheetName, i, 1);

			EmployeeConnectUtils.login(driver, username, password);
			//validate i'm on home page
			
			if(!EmployeeConnectUtils.validateFailure(driver))
			{
				EmployeeConnectUtils.clickOnSettings(driver);
				EmployeeConnectUtils.clickOnUserAndUnregister(driver);
				ExcelUtils.writeToExcel(sheetName, i, 2, "PASS");
			}
			else
			{
				driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
				ExcelUtils.writeToExcel(sheetName, i, 2, "FAIL");
			}

		}

	}

}
