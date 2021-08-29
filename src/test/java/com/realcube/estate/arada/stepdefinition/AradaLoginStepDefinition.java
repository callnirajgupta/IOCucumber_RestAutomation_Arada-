package com.realcube.estate.arada.stepdefinition;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import com.realcube.estate.arada.pageobjectmodel.AradaLoginPage;
import com.realcube.estate.arada.pageobjectmodel.AradaRegisterUnitDetailsPage;
import com.realcube.estate.util.SeleniumUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AradaLoginStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(AradaLoginStepDefinition.class);

	@When("^user login with \"([^\"]*)\" user in Arada$")
	public void user_Login_with_user_Arada(String user) {
		LOGGER.info("user login with " + user + " user in Arada");
		AradaLoginPage.login(SeleniumUtil.getConfigProperties().getProperty(user),
				SeleniumUtil.getConfigProperties().getProperty(user + "Password"));
	}

	@And("^user click register button$")
	public void user_click_register_button() {
		LOGGER.info("user click register button");
		AradaLoginPage.clickRegister();
		AradaRegisterUnitDetailsPage.validateRegisterTitle();
	}
}
