package com.realcube.estate.arada.stepdefinition;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.realcube.estate.arada.pageobjectmodel.AradaRegisterDetailsPage;
import com.realcube.estate.arada.pageobjectmodel.AradaRegisterUnitDetailsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AradaRegisterUserStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(AradaRegisterUserStepDefinition.class);

	@When("^user enter tenant details as \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_tenant_details_as_and_and(String community, String building, String unit) {
		LOGGER.info("Inside user enter tenant details step");
		AradaRegisterUnitDetailsPage.clickTenantRadio();
		AradaRegisterUnitDetailsPage.enterOwnerTenantDetails(community, building, unit);

		AradaRegisterUnitDetailsPage.clickNext();

	}

	@Then("^user navigate to Resident Details screen$")
	public void user_navigate_to_resident_details_screen() {
		LOGGER.info("user navigate to Resident Details screen step");
		AradaRegisterDetailsPage.validateRegisterDetails();
	}

	@When("^user enter owner details as \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_owner_details_as_and_and(String community, String building, String unit) {
		LOGGER.info("user enter owner detail step");
		AradaRegisterUnitDetailsPage.clickOwnerRadio();
		AradaRegisterUnitDetailsPage.enterOwnerTenantDetails(community, building, unit);
		AradaRegisterUnitDetailsPage.clickNext();

	}

	@Then("^verify that validation message should display as \"([^\"]*)\"$")
	public void verify_that_validation_message_should_display(String message) {
		LOGGER.info("verify that validation message should display step");
		String[] messages = message.split(",");
		AradaRegisterUnitDetailsPage.getErrorMessage(messages);
	}
}
