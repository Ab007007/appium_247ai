package com.ai.appium.basics.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	public static final String filePath = "data\\testdata.xls";

	public static void writeToExcel(String sheetName, int rowNumber, int columnNumber, String value)
			throws EncryptedDocumentException, IOException {
		File file = new File(filePath);
		FileOutputStream fos = new FileOutputStream(file, true);

		Workbook wb = WorkbookFactory.create(fos);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNumber);
		row.createCell(columnNumber).setCellValue(value);

		wb.write(fos);
		fos.close();
		fos = null;

	}

	public static String getExcelCellValue(String sheetName, int rowNumber, int columnNumber)
			throws EncryptedDocumentException, IOException {
		System.out
				.println("Reading excel Sheet " + sheetName + " with row " + rowNumber + " and column " + columnNumber);
		String cellValue = null;
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNumber);
		Cell cell = row.getCell(columnNumber);
		cellValue = cell.getStringCellValue();
		System.out.println("*****************************Excel value " + cellValue);
		fis.close();
		return cellValue;
	}

	public static int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		int rowCount = 0;
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);

		rowCount = sheet.getLastRowNum() + 1;
		fis.close();

		return rowCount;
	}

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("sampledata");

		int rowCount = sheet.getLastRowNum() + 1;

		System.out.println(rowCount);

		Row row = null;
		String fn = null;
		String ln = null;

		for (int i = 0; i < rowCount; i++) {

			row = sheet.getRow(i);
			fn = row.getCell(0).getStringCellValue();
			ln = row.getCell(1).getStringCellValue();

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
