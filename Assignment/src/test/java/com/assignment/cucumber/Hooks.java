package com.assignment.cucumber;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import com.assignment.utils.Inputs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	Driverfactory driverfactory;
	Inputs ip;

	@Before
	public void inputs() throws IOException {
		Inputs.inputs();
		driverfactory.webDriverinit();
	}

	@After(order = 0)
	public void teardown() {

		driverfactory.driver.quit();
	}

	@After(order = 1)
	public void takeScreenshotOnFaliure(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			
			File destination = Utility.TakeScreenshot(scenario, ip.driver);
			Reporter.addScreenCaptureFromPath(destination.toString());
		}
	}

}
