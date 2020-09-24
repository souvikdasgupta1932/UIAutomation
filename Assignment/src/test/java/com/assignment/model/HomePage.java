package com.assignment.model;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assignment.cucumber.Driverfactory;
import com.assignment.utils.Inputs;

public class HomePage{
	
	Inputs inputs;
	
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	@FindBy(name="fromPort")
	private WebElement departureCity;
	
	@FindBy(name="toPort")
	private WebElement destinationCity;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement findFlightButton;
	
	@FindBy(xpath="//h1[contains(text(),'Welcome to the Simple Travel Agency')]")
	private WebElement header;
	
	private Select select;
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public void goTo() {
		
		this.driver.get(Inputs.URL);
	}
	
	public void validateHeader() {
		
		System.out.println("Test");
		wait.until(ExpectedConditions.visibilityOf(this.header));
	
	}
	
	public void selectCity(String place, String direction) {
		
		switch(direction) {
		
		case "departureCity":
			Select select = new Select(this.departureCity);
			select.selectByValue(place);
			break;
		case "destinationCity":
			 select = new Select(this.destinationCity);
			select.selectByValue(place);
			break;
		default:
			System.out.println("Cant select");
		
		}
		
	}
	
	public void clickFindFlights(String name) {
		String clickXpath = "//input[@value='"+name+"']";
		driver.findElement(By.xpath(clickXpath)).click();;
	}
	
	public boolean verifyCities(List<String> lst, String location) {
		
		List<String> getCities = new ArrayList<String>();
		List<WebElement> actualCity;
		
		switch(location.toLowerCase()) {
		
		case "destination cities":
			actualCity = driver.findElements(By.xpath("//select[@name='toPort']/option"));
			for(int varloop = 0; varloop<actualCity.size();varloop++) {
				getCities.add(actualCity.get(varloop).getAttribute("value"));
			}	
			return getCities.containsAll(lst);
			
		case "departure cities":
			actualCity = driver.findElements(By.xpath("//select[@name='fromPort']/option"));
			for(int varloop = 0; varloop<actualCity.size();varloop++) {
				getCities.add(actualCity.get(varloop).getAttribute("value").trim());
			}
			
			return getCities.containsAll(lst);
			
			
		default:
			System.out.println("Error out Cities!!!!");
			return false;
		
		}
	}

}
