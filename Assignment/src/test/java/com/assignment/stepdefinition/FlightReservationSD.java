package com.assignment.stepdefinition;

import java.util.Map;

import com.assignment.cucumber.Driverfactory;
import com.assignment.model.FlightReservation;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

public class FlightReservationSD extends Driverfactory{
	
	FlightReservation fr;
	
	@Then("^user fills in the purchase details$")
	public void user_fills_in_the_purchase_details(DataTable value) throws Throwable {
	    fr = new FlightReservation(driver);
		for (Map<String, String> data : value.asMaps(String.class, String.class)) {

			fr.enterDetails("Name",data.get("Name"),"text");
			fr.enterDetails("Address",data.get("Address"),"text");
			fr.enterDetails("City",data.get("City"),"text");
			fr.enterDetails("State",data.get("State"),"text");
			fr.enterDetails("Zip Code",data.get("Zip Code"),"text");
			fr.enterDetails("Card Type",data.get("Card Type"),"select");
			fr.enterDetails("Credit Card Number",data.get("Credit Card Number"),"text");
			fr.enterDetails("Month",data.get("Month"),"text");
			fr.enterDetails("Year",data.get("Year"),"text");
			fr.enterDetails("Name on Card",data.get("Name on Card"),"text");
			System.out.println("Stop");
		}
	}

	
}
