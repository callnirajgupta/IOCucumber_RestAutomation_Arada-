package com.realcube.estate.finance.stepdefinition;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import com.realcube.estate.arada.pageobjectmodel.AradaLoginPage;
import com.realcube.estate.finance.pageobjectmodel.FinanceLoginPage;
import com.realcube.estate.util.SeleniumUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class FinanceLoginStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(FinanceLoginStepDefinition.class);

	
	
	@When("^user login with \"([^\"]*)\" user in Finance$")
	public void user_Login_with_user_Finance(String user) {
		
		FinanceLoginPage.login(SeleniumUtil.getConfigProperties().getProperty(user), SeleniumUtil.getConfigProperties().getProperty(user+"Password"));
		
		
	}
	
}
