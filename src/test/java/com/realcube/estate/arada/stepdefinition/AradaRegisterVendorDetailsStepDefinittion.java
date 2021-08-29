package com.realcube.estate.arada.stepdefinition;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.realcube.estate.arada.pageobjectmodel.AradaRegisterOccupancyDetailsPage;
import com.realcube.estate.arada.pageobjectmodel.AradaRegisterVendorDetailsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AradaRegisterVendorDetailsStepDefinittion {
	private static final Logger LOGGER = LogManager.getLogger(AradaRegisterVendorDetailsStepDefinittion.class);

	@Then("^verify that Vendor Details screen is displayed$")
	public void vendorDetailsDisplay() {
		LOGGER.info("verify that Vendor Details screen is displayed");
		AradaRegisterVendorDetailsPage.validateVendorDetails();
	}

	@Then("^verify that request sent screen is displayed$")
	public void vendorRequestSentTextDisplay() {
		LOGGER.info("verify that request sent screen is displayed");
		AradaRegisterVendorDetailsPage.validateRequestSentTextDisplay();
	}

	@When("^user select vendor name as \"([^\"]*)\"$")
	public void selectVendorName(String vendorName) {
		LOGGER.info("user select vendor name as");
		AradaRegisterVendorDetailsPage.selectVendor(vendorName);
		AradaRegisterVendorDetailsPage.clickTnc();
		AradaRegisterVendorDetailsPage.clickSubmit();
	}

	@When("^user select vendor name as \"([^\"]*)\" and companyName as \"([^\"]*)\" and contactName as \"([^\"]*)\" and contactNo as \"([^\"]*)\" and email as \"([^\"]*)\"$")
	public void user_select_vendor_name_as_and_company_name_as_and_contact_name_as_and_contact_no_as_and_email_as(
			String vendorName, String company, String contactName, String contactNo, String email) {
		LOGGER.info("user select vendor name as other");
		AradaRegisterVendorDetailsPage.selectVendor(vendorName);
		AradaRegisterVendorDetailsPage.EnterVendorOthersDetails(company, contactName, contactNo, email);
		AradaRegisterVendorDetailsPage.clickTnc();
		AradaRegisterVendorDetailsPage.clickSubmit();
	}

}
