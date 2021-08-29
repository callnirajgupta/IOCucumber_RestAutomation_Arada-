package com.realcube.estate.arada.stepdefinition;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.realcube.estate.arada.pageobjectmodel.AradaRegisterEmergencyContactPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AradaRegisterEmergencyContactStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(AradaRegisterEmergencyContactStepDefinition.class);

	@Then("^verify that Emergency contact screen should display$")
	public void EmergencyContactScreenDisplay() {
		LOGGER.info("verify that Emergency contact screen should display");
		AradaRegisterEmergencyContactPage.validateEmergencyContact();
	}

	@When("^user enter emergency contact details name as \"([^\"]*)\" and email as \"([^\"]*)\" and contactNo as \"([^\"]*)\" and residence as \"([^\"]*)\"$")
	public void user_enter_emergency_contact_details_name_as_and_email_as_and_contact_no_as_and_residence_as(
			String name, String email, String contactNo, String reesidence) {
		LOGGER.info("user enter emergency contact details name as");
		AradaRegisterEmergencyContactPage.enterEmergencyContact(name, email, contactNo, reesidence);
		AradaRegisterEmergencyContactPage.clickNext();
	}
}
