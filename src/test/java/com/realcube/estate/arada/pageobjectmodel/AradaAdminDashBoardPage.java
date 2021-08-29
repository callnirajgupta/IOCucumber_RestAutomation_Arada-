package com.realcube.estate.arada.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.realcube.estate.commonstepdef.CommonStepDefinition;
import com.realcube.estate.util.SeleniumUtil;

public class AradaAdminDashBoardPage {
	private static final Logger LOGGER = LogManager.getLogger(AradaAdminDashBoardPage.class);
	private static final By ADMIN_COMMUNITY = By.id("admin_id_community");
	private static final By SERVICE_REQUEST = By.xpath("//span[text()='Service Request']");
	private static final By ACTION_REQUEST = By.xpath("//span[text()='Action Requests']");

	public static void SelectAdminCommunity(String community) {
		LOGGER.info("Inside SelectAdminCommunity method ");
		SeleniumUtil.selectWebList(ADMIN_COMMUNITY, community, "selectByVisibleText");
	}

	public static void clickServiceRequests() {
		LOGGER.info("Inside clickServiceRequests method ");
		SeleniumUtil.validateWebElementVisible(SERVICE_REQUEST);
		SeleniumUtil.scrollToWebElement(SERVICE_REQUEST);
		SeleniumUtil.clickWebElement(SERVICE_REQUEST);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "clickServiceRequests successfully");
	}

	public static void clickActionRequests() {
		LOGGER.info("Inside clickActionRequests method ");
		SeleniumUtil.scrollToWebElement(ACTION_REQUEST);
		SeleniumUtil.clickWebElement(ACTION_REQUEST);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "clickActionRequests successfully");
	}

}
