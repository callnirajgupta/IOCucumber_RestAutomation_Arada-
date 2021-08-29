package com.realcube.estate.arada.stepdefinition;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.realcube.estate.arada.pageobjectmodel.AradaAdminServiceRequest;
import com.realcube.estate.util.AradaUtil;

import io.cucumber.java.en.When;

public class AradaAdminServiceStepDefinition {

	private static final Logger LOGGER = LogManager.getLogger(AradaAdminServiceStepDefinition.class);

	@When("^user search service request$")
	public void searchServiceRequest() {
		LOGGER.info("user search service request");
		AradaAdminServiceRequest.SearchServiceRequest(AradaUtil.getServiceRequest());
		AradaAdminServiceRequest.validateServiceRequestSearchResult(AradaUtil.getServiceRequest());
	}

	@When("^user view and validate service request as \"([^\"]*)\"$")
	public void viewServiceReuest(String status) {
		LOGGER.info("user view and validate service request as" + status);
		AradaAdminServiceRequest.clickServiceRequestView();
		AradaAdminServiceRequest.validateServiceRequestViewDisplay(AradaUtil.getServiceRequest());
		AradaAdminServiceRequest.validateServiceRequestStatus(status);
	}

	@When("^user update \"([^\"]*)\" of service request with comment as \"([^\"]*)\"$")
	public void approveServiceRequest(String status, String comment) {
		LOGGER.info("user update " + status + " of service request with comment as" + comment);
		AradaAdminServiceRequest.updateServiceRequest(status, comment);
	}
}
