package com.ai.appium.basics.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		File file  =  new File("data\\testdata.xls");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("sampledata");
		
		int rowCount = sheet.getLastRowNum() + 1;
		
		System.out.println(rowCount);
		
		Row row = null;
		Cell fn = null;
		Cell ln = null;
		
		for (int i = 0; i <rowCount; i++) {
			
			row = sheet.getRow(i);
			fn = row.getCell(0);
			ln = row.getCell(1);
			
			System.out.println(fn + " - " + ln);
			
		}
		
		
//		
//		int sheetCount = wb.getNumberOfSheets();
//		
//		System.out.println(sheetCount);
//		System.out.println(wb.getSheetName(0));
		fis.close();
		
		
	}

}
