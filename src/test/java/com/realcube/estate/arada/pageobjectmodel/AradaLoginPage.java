package com.realcube.estate.arada.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.realcube.estate.commonstepdef.CommonStepDefinition;
import com.realcube.estate.util.SeleniumUtil;

public class AradaLoginPage {
	private static final Logger LOGGER = LogManager.getLogger(AradaLoginPage.class);
	private final static By LOGIN_LOGO = By.xpath("//img[contains(@src,'main-logo.png')]");
	private final static String LOGIN_TITLE = "Login to Arada";
	private final static By LOGIN_EMAIL = By.name("username");
	private final static By LOGIN_PASSWORD = By.name("password");
	private final static By SUBMIT_BUTTON = By.xpath("//button[text()='Login']");
	private final static By REGISTER = By.xpath("//a[text()='Register']");

	public static void validateLoginTitle() {
		LOGGER.info("Inside validateLoginTitle Method");

		Assert.assertEquals("The title does not match", LOGIN_TITLE, SeleniumUtil.getTitle());
		SeleniumUtil.validateWebElementVisible(LOGIN_LOGO);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "validateLoginTitle successfully");
	}

	public static void login(String email, String password) {
		LOGGER.info("Inside login Method");
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(),
				"Login page Loaded successfully");
		if (!("".equals(email))) {
			SeleniumUtil.validateWebElementVisible(LOGIN_EMAIL);
			SeleniumUtil.getWebElement(LOGIN_EMAIL).sendKeys(email);
		}

		if (!("".equals(password))) {
			SeleniumUtil.validateWebElementVisible(LOGIN_PASSWORD);
			SeleniumUtil.getWebElement(LOGIN_PASSWORD).sendKeys(password);
		}
		SeleniumUtil.getWebElement(SUBMIT_BUTTON).click();
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "login successfully");
	}

	public static void clickRegister() {
		LOGGER.info("Inside clickRegister Method");
		SeleniumUtil.validateWebElementVisible(REGISTER);
		SeleniumUtil.getWebElement(REGISTER).click();
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "clickRegister successfully");
	}

}
