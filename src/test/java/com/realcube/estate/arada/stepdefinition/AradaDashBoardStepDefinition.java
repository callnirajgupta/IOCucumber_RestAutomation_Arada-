package com.realcube.estate.arada.stepdefinition;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.realcube.estate.arada.pageobjectmodel.AradaAdminDashBoardPage;
import com.realcube.estate.arada.pageobjectmodel.AradaDashBoardPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AradaDashBoardStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(AradaDashBoardStepDefinition.class);

	@Then("^verify that Arada dashboard page is displayed$")
	public void dashboardDisplayed() {
		LOGGER.info("verify that Arada dashboard page is displayed");
		AradaDashBoardPage.validateDashBoard();
	}

	@And("^user select admin community \"([^\"]*)\"$")
	public void adminCommunity(String community) {
		LOGGER.info("user select admin community" + community);
		AradaAdminDashBoardPage.SelectAdminCommunity(community);

	}

	@When("^user click on admin service request$")
	public void adminServiceRequest() {
		LOGGER.info("user click on admin service request");
		AradaAdminDashBoardPage.clickServiceRequests();
	}

	@When("^user click on admin action request$")
	public void adminActionRequest() {
		LOGGER.info("user click on admin action request");
		AradaAdminDashBoardPage.clickActionRequests();
	}

}
