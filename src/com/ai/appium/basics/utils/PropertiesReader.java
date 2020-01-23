package com.ai.appium.basics.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	
	public static void main(String[] args) throws IOException {
		
		File file = new File("data\\config.properties");
		FileInputStream fis = new FileInputStream(file);
	
		Properties props = new Properties();
		props.load(fis);
		
		System.out.println(props.get("apptype"));
		System.out.println(props.get("username"));
		System.out.println(props.get("password"));
		System.out.println(props.get("timeout"));
		
		
		
		fis.close();
	}
}
