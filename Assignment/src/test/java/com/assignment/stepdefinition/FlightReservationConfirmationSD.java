package com.assignment.stepdefinition;

import java.util.Map;
import java.util.Set;

import org.junit.Assert;

import com.assignment.cucumber.Driverfactory;
import com.assignment.model.FlightReservationConfirmation;
import com.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

public class FlightReservationConfirmationSD extends Driverfactory {
	
	FlightReservationConfirmation frc;
	
	@Then("^the user verify ID is generated$")
	public void the_user_verify_ID_is_generated() throws Throwable {
		frc = new FlightReservationConfirmation(driver);
		String value = frc.captureDetails("Id");
		Reporter.addStepLog("The Purchase Id is: "+ value);
	}

	@Then("^the user verify Status is generated$")
	public void the_user_verify_Status_is_generated() throws Throwable {
		String value = frc.captureDetails("Status");
		Reporter.addStepLog("The Purchase Status is: "+ value);
	}
	
	@Then("^the user verify the purchase is successful$")
	public void the_user_verify_the_purchase_is_successful() throws Throwable {
		frc = new FlightReservationConfirmation(driver);
		boolean result = frc.confirmationPurchase("Thank you for your purchase today!");
		Assert.assertTrue(result);
	}
	
	@Then("^the user verify the correct fields have been populated$")
	public void the_user_verify_the_correct_fields_have_been_populated(DataTable fields) throws Throwable {
		Map<String,String> map = frc.fieldValidation(fields.asList(String.class));
		Set<String> sets = map.keySet();
		for(String set:sets) {
			
			Reporter.addStepLog(set +"-->"+map.get(set));
		}
		
		
	}

}
