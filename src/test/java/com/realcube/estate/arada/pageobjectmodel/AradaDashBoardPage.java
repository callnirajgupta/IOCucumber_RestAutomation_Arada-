package com.realcube.estate.arada.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.realcube.estate.commonstepdef.CommonStepDefinition;
import com.realcube.estate.util.SeleniumUtil;

public class AradaDashBoardPage {
	private static final Logger LOGGER = LogManager.getLogger(AradaDashBoardPage.class);
	private static final By DASHBOARD = By.xpath("//span[text()='My Dashboard']");
	private static final By MY_REQUEST = By.xpath("//span[text()='My Requests']");
	private static final By MY_SERVICE = By.xpath("//span[text()='My Services']");
	private static final By LOGOUT = By.xpath("//a[contains(text(), 'Logout') and @class='dropdown-item']");
	private static final By PROFILE = By.xpath("(//img[contains(@class,'img-profile')])[1]");
	private static final By LOGOUT_CONFIRMATION = By.xpath("//a[text()='Logout']");

	public static void validateDashBoard() {
		LOGGER.info("Inside validateDashBoard Method");
		SeleniumUtil.validateWebElementVisible(DASHBOARD);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "validateDashBoards successfully");
	}

	public static void validateAradaLoginUser() {
		LOGGER.info("Inside validateAradaLoginUser Method");
		SeleniumUtil.validateWebElementVisible(DASHBOARD);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "validateAradaLoginUser successfully");
	}

	public static void clickMyRequest() {
		LOGGER.info("Inside clickMyRequest Method");
		SeleniumUtil.clickWebElement(MY_REQUEST);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "clickMyRequest successfully");
	}

	public static void clickMyService() {
		LOGGER.info("Inside clickMyService Method");
		SeleniumUtil.clickWebElement(MY_SERVICE);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "clickMyService successfully");
	}

	public static void logoutArada() {
		LOGGER.info("Inside logoutArada Method");
		SeleniumUtil.clickWebElement(PROFILE);
		SeleniumUtil.clickWebElement(LOGOUT);
		SeleniumUtil.clickWebElement(LOGOUT_CONFIRMATION);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "logoutArada successfully");
	}

}
