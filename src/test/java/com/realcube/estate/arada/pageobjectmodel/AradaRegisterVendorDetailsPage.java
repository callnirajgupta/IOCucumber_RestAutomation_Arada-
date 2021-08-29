package com.realcube.estate.arada.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.realcube.estate.commonstepdef.CommonStepDefinition;
import com.realcube.estate.util.SeleniumUtil;

public class AradaRegisterVendorDetailsPage {
	private static final Logger LOGGER = LogManager.getLogger(AradaRegisterOccupancyDetailsPage.class);
	private final static By VENDOR_DETAILS = By.xpath("//h3[text()='Vendor Details']");
	private final static By VENDOR_NAME = By.id("vendor_name");
	private final static By TNC = By.xpath("//label[@for='tnc1']");
	private final static By SUBMIT_BUTTON = By.xpath("//a[text()='Submit']");
	private final static By REQUEST_SENT = By.xpath("//h3[text()='Request Sent!']");
	private final static By COMPANY_NAME = By.id("companyName");
	private final static By CONTACT_NAME = By.id("contactName");
	private final static String CONTACT_NUMBER_COUNTRY_CODE = "//ul[@class='country-list']/li/span[text()='+91']";
	private final static By CONTACT_NUMBER_SELECT_CODE = By
			.xpath("//div[label[@for='contact_number']]//div[@class='selected-dial-code']");
	private final static By CONTACT_NUMBER_TEXT = By.id("vendorContactNo");
	private final static By EMAIL = By.id("emailId");

	public static void validateVendorDetails() {
		LOGGER.info("Inside validateVendorDetails Method");
		Assert.assertTrue("The vendor Details title does not displayed",
				SeleniumUtil.getWebElement(VENDOR_DETAILS).isDisplayed());
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(),
				"User Vendor Details page is loaded successfully");
	}

	public static void selectVendor(String vendorName) {
		LOGGER.info("Inside selectVendor Method");
		SeleniumUtil.selectWebList(VENDOR_NAME, vendorName, "selectByVisibleText");
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "selectVendor successfully");
	}

	public static void clickTnc() {
		LOGGER.info("Inside clickTnc Method");
		SeleniumUtil.clickWebElement(TNC);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "clickTnc successfully");
	}

	public static void clickSubmit() {
		LOGGER.info("Inside clickSubmit Method");
		SeleniumUtil.clickWebElement(SUBMIT_BUTTON);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "clickSubmit successfully");
	}

	public static void validateRequestSentTextDisplay() {
		LOGGER.info("Inside validateRequestSentTextDisplay Method");
		Assert.assertTrue("The Request sent text displayed", SeleniumUtil.getWebElement(REQUEST_SENT).isDisplayed());
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(),
				"The Request sent text displayed");
	}

	public static void EnterVendorOthersDetails(String company, String contactName, String contactNo, String email) {
		LOGGER.info("Inside EnterVendorOthersDetails Method");
		if (!("".equalsIgnoreCase(company))) {
			SeleniumUtil.enterText(COMPANY_NAME, company);
		}
		if (!("".equalsIgnoreCase(contactName))) {
			SeleniumUtil.enterText(CONTACT_NAME, contactName);
		}

		if (!("".equalsIgnoreCase(contactNo))) {
			String[] contactArray = contactNo.split(" ");
			SeleniumUtil.clickWebElement(CONTACT_NUMBER_SELECT_CODE);
			SeleniumUtil.wait(2000);
			SeleniumUtil
					.scrollToWebElement(By.xpath(CONTACT_NUMBER_COUNTRY_CODE.replace("countryCode", contactArray[0])));
			SeleniumUtil.wait(2000);
			SeleniumUtil.clickWebElement(By.xpath(CONTACT_NUMBER_COUNTRY_CODE.replace("countryCode", contactArray[0])));
			SeleniumUtil.enterText(CONTACT_NUMBER_TEXT, contactArray[1]);
		}

		if (!("".equalsIgnoreCase(email))) {

			SeleniumUtil.enterText(EMAIL, email);
		}
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "EnterVendorOthersDetails successfully");
	}
}
