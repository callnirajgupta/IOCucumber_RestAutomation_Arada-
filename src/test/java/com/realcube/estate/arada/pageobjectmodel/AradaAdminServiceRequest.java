package com.realcube.estate.arada.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.realcube.estate.commonstepdef.CommonStepDefinition;
import com.realcube.estate.util.SeleniumUtil;

public class AradaAdminServiceRequest {
	private static final Logger LOGGER = LogManager.getLogger(AradaAdminServiceRequest.class);
	private static final By SERVICE_REQUEST_NO_TEXT_BOX = By.id("srv_req_no");
	private static final By SEARCH_BUTTON = By.id("search");
	private static final String SERVICE_REQUEST_SEARCH_RESULT = "//td[text()='SRNumber']";
	private static final By SERVICE_REQUEST_VIEW_BUTTON = By.xpath("//a[text()='View']");
	private static final String SERVICE_REQUEST_VIEW_DISPLAY = "//h4[contains(text(),' Request #SRNumber')]";
	private static final By SERVICE_STATUS_SELECT = By.name("status");
	private static final By COMMENT_TEXTBOX = By.xpath("//body/p");
	private static final By SUBMIT_BUTTON = By.name("submit");
	private static final By SERVICE_STATUS_UPDATE = By.xpath("//div[@class='alert alert-success dark dark']");

	public static void SearchServiceRequest(String request) {
		LOGGER.info("Inside SearchServiceRequest method ");
		SeleniumUtil.enterText(SERVICE_REQUEST_NO_TEXT_BOX, request);
		SeleniumUtil.clickWebElement(SEARCH_BUTTON);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "SearchServiceRequest successfully");
	}

	public static void validateServiceRequestSearchResult(String request) {
		LOGGER.info("Inside validateServiceRequestSearchResult method ");
		SeleniumUtil.validateWebElementVisible(By.xpath(SERVICE_REQUEST_SEARCH_RESULT.replace("SRNumber", request)));
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "validateServiceRequestSearchResult successfully");
	}

	public static void clickServiceRequestView() {
		LOGGER.info("Inside validateServiceRequestSearchResult method ");
		SeleniumUtil.wait(1000);
		SeleniumUtil.clickWebElement(SERVICE_REQUEST_VIEW_BUTTON);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "validateServiceRequestSearchResult successfully");
	}

	public static void validateServiceRequestViewDisplay(String request) {
		LOGGER.info("Inside validateServiceRequestViewDisplay method ");
		SeleniumUtil.validateWebElementVisible(By.xpath(SERVICE_REQUEST_VIEW_DISPLAY.replace("SRNumber", request)));
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "validateServiceRequestSearchResult successfully");
	}

	public static void validateServiceRequestStatus(String status) {
		LOGGER.info("Inside validateServiceRequestSearchResult method ");
		Assert.assertEquals("The service status not mathcing", status,
				SeleniumUtil.getDefaultSelection(SERVICE_STATUS_SELECT).trim());
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "validateServiceRequestSearchResult successfully");
	}

	public static void updateServiceRequest(String status, String comment) {
		LOGGER.info("Inside validateServiceRequestSearchResults method ");
		SeleniumUtil.selectWebList(SERVICE_STATUS_SELECT, status, "selectByVisibleText");
		SeleniumUtil.switchFrame(0);
		SeleniumUtil.scrollToWebElement(COMMENT_TEXTBOX);
		SeleniumUtil.clickWebElement(COMMENT_TEXTBOX);
		SeleniumUtil.enterText(COMMENT_TEXTBOX, comment);
		SeleniumUtil.switchToDefaultContent();
		SeleniumUtil.clickWebElement(SUBMIT_BUTTON);
		SeleniumUtil.validateWebElementVisible(SERVICE_STATUS_UPDATE);

		LOGGER.info("status update text" + SeleniumUtil.getText(SERVICE_STATUS_UPDATE));
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "updateServiceRequest successfully");
	}

}
