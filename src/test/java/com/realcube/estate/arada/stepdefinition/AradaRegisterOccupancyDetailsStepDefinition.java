package com.realcube.estate.arada.stepdefinition;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.realcube.estate.arada.pageobjectmodel.AradaRegisterOccupancyDetailsPage;
import com.realcube.estate.util.SeleniumUtil;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AradaRegisterOccupancyDetailsStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(AradaRegisterOccupancyDetailsStepDefinition.class);

	@Then("^verify that Occupancy Details screen is displayed$")
	public void occupancyDetailsScreenDisplay() {
		LOGGER.info("verify that Occupancy Details screen is displayed");
		AradaRegisterOccupancyDetailsPage.validateOccupancyDetails();
	}

	@When("^user enter owner occupancy details moveIn as \"([^\"]*)\" and moveInDate as \"([^\"]*)\" and slot as \"([^\"]*)\" and titleDeed as \"([^\"]*)\" and gasActivation as \"([^\"]*)\" and passport as \"([^\"]*)\"$")
	public void user_enter_occupancy_details_move_in_as_and_move_in_date_as_and_slot_as_and_title_deed_as_and_passport_as_and_gas_activation_as(
			String moveIn, String moveInDate, String moveInSlot, String titleDeed, String gasActivation,
			String passport) throws Throwable {
		LOGGER.info("user enter owner occupancy details moveIn");
		AradaRegisterOccupancyDetailsPage.enterOwnerOcccupanyDetails(moveIn, moveInDate, moveInSlot, titleDeed,
				gasActivation, passport);
		AradaRegisterOccupancyDetailsPage.clickTnc();
		AradaRegisterOccupancyDetailsPage.clickNext();
	}

	@When("^user enter tenants occupancy details moveIn as \"([^\"]*)\" and moveInDate as \"([^\"]*)\" and slot as \"([^\"]*)\" and moveinStartDate as \"([^\"]*)\" and moveInEndDate as \"([^\"]*)\" and tenantDeed as \"([^\"]*)\" and gasActivation as \"([^\"]*)\" and passport as \"([^\"]*)\" and ejariCopy as \"([^\"]*)\"$")
	public void user_enter_tenants_occupancy_details_move_in_as_and_move_in_date_as_and_slot_as_and_movein_start_date_as_and_move_in_end_date_as_and_title_deed_as_and_gas_activation_as_and_passport_as(
			String moveIn, String moveInDate, String MoveinSlot, String moveInStartDate, String moveInEndtDate,
			String tenantDeed, String gasActivation, String passport, String ejariCopy) throws Throwable {
		LOGGER.info("user enter tenants occupancy details moveIn");
		AradaRegisterOccupancyDetailsPage.enterTenantOcccupanyDetails(moveIn, moveInStartDate, moveInEndtDate,
				moveInDate, MoveinSlot, tenantDeed, gasActivation, passport, ejariCopy);
		AradaRegisterOccupancyDetailsPage.clickTnc();
		AradaRegisterOccupancyDetailsPage.clickNext();
	}

}
