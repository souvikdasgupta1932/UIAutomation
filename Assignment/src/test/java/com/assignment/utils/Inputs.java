package com.assignment.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Inputs {
	
	public static FileReader reader= null;
	public static String URL;
	public static String ChromePath = null;
	public static WebDriver driver = null;
	
	public static void inputs() throws IOException {
		
		reader = new FileReader("./src/test/resources/testdata/data.properties");
		Properties p = new Properties();
		p.load(reader);
		URL= p.getProperty("URL");
		ChromePath = p.getProperty("DriverPath");
		
		System.out.println(ChromePath);
	}
	

}
