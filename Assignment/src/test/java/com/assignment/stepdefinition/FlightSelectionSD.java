package com.assignment.stepdefinition;

import com.assignment.cucumber.Driverfactory;
import com.assignment.model.FlightSelection;
import com.itextpdf.text.log.SysoCounter;

import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class FlightSelectionSD extends Driverfactory {
	
	FlightSelection fs;
	
	@Then("^the user selects flight \"([^\"]*)\" and No \"([^\"]*)\"$")
	public void the_user_selects_flight_and_No(String name, String no) throws Throwable {
		
		fs = new FlightSelection(driver);
		fs.selectFlight(no,name);
	}

	@Then("^verify the flight is reserved$")
	public void verify_the_flight_is_reserved() throws Throwable {
	    
		Assert.assertTrue(fs.verifyFlightReserved());
	}
	
	@Then("^the user verify flights from \"([^\"]*)\" to \"([^\"]*)\" is displayed$")
	public void the_user_verify_flights_from_to_is_displayed(String departure, String destination) throws Throwable {
		fs = new FlightSelection(driver);
		boolean result = fs.verifyCorrectFlightsDisplayed(departure,destination);
		Assert.assertTrue(result);
	}


}
