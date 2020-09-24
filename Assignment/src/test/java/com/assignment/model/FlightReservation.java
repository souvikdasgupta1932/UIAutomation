package com.assignment.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightReservation {
	
	private WebDriver driver;
	private WebElement labelData;
	
	@FindBy(id="cardType")
	WebElement cardType;
	
	public FlightReservation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterDetails(String label, String value, String type) {
		
		
		switch(type) {
		case "text":
			labelData = driver.findElement(By.xpath("//label[text()='"+label+"']/following::input[1]"));
			labelData.sendKeys(value.trim());
			break;
		case "select":
			Select slt = new Select(cardType);
			//slt.selectByValue(value.trim());
			slt.selectByVisibleText(value.trim());
			break;
		default:
			System.out.println("Cant select");
		}
	}
	
	
	
}
