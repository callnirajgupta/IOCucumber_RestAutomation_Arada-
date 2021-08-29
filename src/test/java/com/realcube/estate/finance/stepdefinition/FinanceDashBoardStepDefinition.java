package com.realcube.estate.finance.stepdefinition;

import com.realcube.estate.arada.pageobjectmodel.AradaDashBoardPage;
import com.realcube.estate.finance.pageobjectmodel.FinanceDashBoardPage;

import io.cucumber.java.en.Then;

public class FinanceDashBoardStepDefinition {
	@Then("^verify that Finance dashboard page is displayed$")
	public void dashboardDisplayed() {
		FinanceDashBoardPage.validateDashBoard();
		FinanceDashBoardPage.validateFinanceLogin();
	}

}
