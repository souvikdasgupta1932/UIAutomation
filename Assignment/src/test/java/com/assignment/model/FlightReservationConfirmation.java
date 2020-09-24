package com.assignment.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightReservationConfirmation {
	WebDriver driver;
	private WebElement getValue;
	private WebElement confirmation;
	WebDriverWait wait;
	
	public FlightReservationConfirmation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,30);
	}
	
	
	public String captureDetails(String detailsLabel) {
		getValue = driver.findElement(By.xpath("//*[contains(text(),'"+detailsLabel+"')]/following::td[1]"));
		
		return getValue.getText();
	}
	
	public boolean confirmationPurchase(String msg) {
		
		confirmation = driver.findElement(By.xpath("//h1[text()='"+msg+"']"));
		
		return confirmation.isDisplayed();
		
	}
	
	public Map fieldValidation(List<String> field) {
		boolean result;
		String value;
		Map<String, String> map = new LinkedHashMap<String,String>();
		for(String actualfield:field) {
			
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			value = driver.findElement(By.xpath("//td[text()='"+actualfield+"']/following-sibling::td")).getText();
			map.put(actualfield, value);
			
		}
		
		return map;
		
	}
	
	

}
