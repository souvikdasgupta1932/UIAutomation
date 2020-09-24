package com.assignment.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightSelection {
	
	WebDriver driver;
	WebDriverWait wait;
	private WebElement chooseFlight;
	private WebElement flightReserv;
	private WebElement flightHeader;

	public FlightSelection(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver, 30);
	}
	
	@FindBy(xpath="//h2[contains(text(),'Your flight from TLV to SFO has been reserved')]")
	private WebElement message;
	
	
	
	public void selectFlight(String FlightNo, String FlightName) {
		
		chooseFlight  = driver.findElement(By.xpath("//td[text()='"+FlightNo+"']/following::td[text()='"+FlightName+"'][1]"
				+ "/preceding::input[@value='Choose This Flight']"));
		wait.until(ExpectedConditions.visibilityOf(chooseFlight));
		chooseFlight.click();
	}
	
	public boolean verifyFlightReserved() {
		
		wait.until(ExpectedConditions.visibilityOf(message));
		
		boolean msgstatus = message.isDisplayed();
		
		return msgstatus;
		
	}
	
	public boolean verifyCorrectFlightsDisplayed(String departure, String destination) {
		
		flightHeader = driver.findElement(By.xpath("//h3[contains(text(),'Flights from "+departure+" to "+destination+":')]"));
		
		return flightHeader.isDisplayed();
		
	}
	

}
