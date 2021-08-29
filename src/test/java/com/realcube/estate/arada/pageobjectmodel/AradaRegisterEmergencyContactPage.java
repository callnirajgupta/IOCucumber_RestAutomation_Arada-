package com.realcube.estate.arada.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.realcube.estate.commonstepdef.CommonStepDefinition;
import com.realcube.estate.util.SeleniumUtil;

public class AradaRegisterEmergencyContactPage {
	private static final Logger LOGGER = LogManager.getLogger(AradaRegisterEmergencyContactPage.class);
	private final static By EMERGENCY_CONTACT = By.xpath("//h3[text()='Emergency Contact']");
	private final static By EMERGENCY_NAME = By.id("emergencyName");
	private final static By EMERGENCY_EMAIL = By.id("emergencyEmail");
	private final static String EMERGENCY_COUNTRY_CODE = "//ul[@class='country-list dropup']/li/span[text()='+91']";
	private final static By SELECTED_DIAL_CODE = By
			.xpath("//div[label[@for='emergencyNumber']]//div[@class='selected-dial-code']");
	private final static By EMERGENCY_NUMBER = By.id("emergencyNumber");
	private final static By EMERGENCY_RESIDENCE = By.id("emergencyResid");
	private final static By NEXT = By.xpath("//a[text()='Next']");

	public static void validateEmergencyContact() {
		LOGGER.info("Inside validateEmergencyContact Method");

		Assert.assertTrue("The Emergency Contact title does not displayed",
				SeleniumUtil.getWebElement(EMERGENCY_CONTACT).isDisplayed());
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(),
				"User Emergency Contact page is loaded successfully");
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "validateEmergencyContact successfully");
	}

	public static void enterEmergencyContact(String name, String email, String contactNo, String residence) {
		LOGGER.info("Inside enterEmergencyContact Method");
		if (!("".equalsIgnoreCase(name))) {
			SeleniumUtil.enterText(EMERGENCY_NAME, name);
		}
		if (!("".equalsIgnoreCase(email))) {
			SeleniumUtil.enterText(EMERGENCY_EMAIL, email);
		}
		if (!("".equalsIgnoreCase(contactNo))) {

			String[] contactArray = contactNo.split(" ");
			SeleniumUtil.clickWebElement(SELECTED_DIAL_CODE);
			SeleniumUtil.wait(2000);
			// SeleniumUtil.scrollToWebElement(By.xpath(EMERGENCY_COUNTRY_CODE.replace("countryCode",
			// contactArray[0])));
			SeleniumUtil.wait(2000);
			SeleniumUtil.clickWebElement(By.xpath(EMERGENCY_COUNTRY_CODE.replace("countryCode", contactArray[0])));
			SeleniumUtil.enterText(EMERGENCY_NUMBER, contactArray[1]);
		}
		if (!("".equalsIgnoreCase(residence))) {
			SeleniumUtil.selectWebList(EMERGENCY_RESIDENCE, residence, "selectByVisibleText");
		}
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "enterEmergencyContact successfully");
	}

	public static void clickNext() {
		LOGGER.info("Inside clickNext Method");
		SeleniumUtil.clickWebElement(NEXT);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "clickNext successfully");
	}
}
