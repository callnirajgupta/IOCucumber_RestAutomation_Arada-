package com.realcube.estate.finance.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.realcube.estate.commonstepdef.CommonStepDefinition;
import com.realcube.estate.util.SeleniumUtil;

public class FinanceLoginPage {
	private static final Logger LOGGER = LogManager.getLogger(FinanceLoginPage.class);
	private  final static By LOGIN_LOGO = By
			.xpath("//img[@src='https://finance.realcube.estate/uploads/image/exa_logo.jpg']");
	private  final static String LOGIN_TITLE = "Login";
	private final static By LOGIN_EMAIL = By.name("username");
	private  final static By LOGIN_PASSWORD = By.name("password");
	private  final static By LOGIN_BUTTON = By.xpath("//button[text()='Login']");

	public static void validateLoginTitle() {
		LOGGER.info("Inside validateLoginTitle Method");

		Assert.assertEquals("The title does not match",LOGIN_TITLE, SeleniumUtil.getTitle());
		SeleniumUtil.validateWebElementVisible(LOGIN_LOGO, 30);
	}

	public static void login(String email, String password) {
		LOGGER.info("Inside enterEmailAndPassword Method");
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(),
				"Login page Loaded successfully");
		if (!("".equals(email))) {
			SeleniumUtil.validateWebElementVisible(LOGIN_EMAIL, 30);
			SeleniumUtil.getWebElement(LOGIN_EMAIL).sendKeys(email);
		}

		if (!("".equals(password))) {
			SeleniumUtil.validateWebElementVisible(LOGIN_PASSWORD, 30);
			SeleniumUtil.getWebElement(LOGIN_PASSWORD).sendKeys(password);
		}
		SeleniumUtil.getWebElement(LOGIN_BUTTON).click();

	}

}
