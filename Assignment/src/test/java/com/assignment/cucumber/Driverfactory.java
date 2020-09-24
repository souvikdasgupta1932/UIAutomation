package com.assignment.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.assignment.utils.Inputs;

public class Driverfactory extends Inputs{

	public static void webDriverinit() {

		System.setProperty("webdriver.chrome.driver", Inputs.ChromePath);

		driver = new ChromeDriver();
		driver.get(Inputs.URL);
		driver.manage().window().maximize();
	}

	public void removeDriver() {
		driver.quit();
	}

}
