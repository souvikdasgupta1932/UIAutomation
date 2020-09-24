package com.assignment.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;

import com.google.common.io.Files;

public class Utility {
	
	public static File TakeScreenshot(Scenario scenario, WebDriver driver) throws IOException {
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "/target/reports/" + screenshotName + ".png");
		Files.copy(sourcePath, destination);
		return destination;
	}

}
