package com.realcube.estate.arada.pageobjectmodel;

import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.realcube.estate.commonstepdef.CommonStepDefinition;
import com.realcube.estate.util.SeleniumUtil;

public class AradaRegisterDetailsPage {
	private static final Logger LOGGER = LogManager.getLogger(AradaRegisterDetailsPage.class);

	private final static By REGISTER_DETAILS_SCREEN = By.xpath("//h3[text()='Resident Details']");
	private final static By APPLYING_COMPANY_TENANT = By.xpath("//div[input[@id='occupier']]/label");
	private final static By APPLYING_TENANT = By.xpath("//div[input[@id='tenant']]/label");
	private final static By APPLYING_CORPORATE_TENANT = By.xpath("//div[input[@id='owner']]/label");
	private final static By ADULT = By.id("adult");
	private final static By CHILDREN = By.id("children");
	private final static By ELDERS = By.id("elders");
	private final static By DETERMINATION_COUNT = By.id("determinationCount");
	private final static By NAME = By.id("name1");
	private final static By CONTACT_NUMBER = By.id("contactNo");
	private final static By EMAIL = By.id("email1");
	private final static By NATIONALITY_SELECT = By.id("id_nationality1");
	private final static By SEARCH = By.xpath("//div[@class='dropdown-menu show']//input");
	private final static By OCCUPATION_SELECT = By.id("occupation1");
	private final static By NUMBER_OF_VECHICLE = By.id("noofveh");
	private final static By PET_YES = By.xpath("//div[input[@id='is_pet_yes']]//span");
	private final static By PET_NO = By.xpath("//div[input[@id='is_pet_no']]//span");
	private final static By NEXT = By.xpath("//a[text()='Next']");
	private final static By ERROR_MESSAGE = By.xpath("//label[@class='error']");
	private final static String COUNTRY_CODE_TENANT = "//ul[@class='country-list']/li/span[text()='countryCode']";
	private final static String COUNTRY_CODE_OWNER = "//ul[@class='country-list dropup']/li/span[text()='countryCode']";
	private final static By SELECTED_DIAL_CODE = By
			.xpath("//div[label[@for='contact1']]//div[@class='selected-dial-code']");
	private final static By VECHILE_NO = By.name("vehicleNumber[]");

	public static void validateRegisterDetails() {
		LOGGER.info("Inside validateRegisterDetailss Method");

		Assert.assertTrue("The Register Details title does not displayed",
				SeleniumUtil.getWebElement(REGISTER_DETAILS_SCREEN).isDisplayed());
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(),
				"User Register Details page is loaded successfully");
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "validateRegisterDetails successfully");
	}

	public static void selectApplyOnBehalf(String owner) {
		LOGGER.info("Inside selectApplyOnBehalf Method");
		if ("tenant".equalsIgnoreCase(owner)) {
			SeleniumUtil.clickWebElement(APPLYING_TENANT);
		} else if ("company".equalsIgnoreCase(owner)) {
			SeleniumUtil.clickWebElement(APPLYING_COMPANY_TENANT);
		} else if ("corporate".equalsIgnoreCase(owner)) {
			SeleniumUtil.clickWebElement(APPLYING_CORPORATE_TENANT);
		}
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "selectApplyOnBehalf successfully");
	}

	public static void getErrorMessage(String[] messages) {
		LOGGER.info("Inside getErrorMessage Method");
		List<WebElement> webelements = SeleniumUtil.getWebElements(ERROR_MESSAGE);
		for (int i = 0; i < webelements.size(); i++) {

			Assert.assertEquals("Error message not macthing for  unit Details screen", messages[i],
					webelements.get(i).getText());
		}
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "getErrorMessage successfully");
	}

	public static void enterNumberOfPeopleResideInUnit(String adult, String children, String seniorCitizens,
			String peopleofDetermination) {
		LOGGER.info("Inside enterNumberOfPeopleResideInUnit Method");
		if (!("".equalsIgnoreCase(adult))) {
			SeleniumUtil.enterText(ADULT, adult);
		}
		if (!("".equalsIgnoreCase(children))) {
			SeleniumUtil.enterText(CHILDREN, children);
		}
		if (!("".equalsIgnoreCase(seniorCitizens))) {
			SeleniumUtil.enterText(ELDERS, seniorCitizens);
		}
		if (!("".equalsIgnoreCase(peopleofDetermination))) {
			SeleniumUtil.enterText(DETERMINATION_COUNT, peopleofDetermination);
		}
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "enterNumberOfPeopleResideInUnit successfully");
	}

	public static void primaryTenantContactDetails(String name, String contact, String email, String nationality,
			String occupation) {
		LOGGER.info("Inside primaryTenantContactDetails Method");
		if (!("".equalsIgnoreCase(name))) {
			SeleniumUtil.enterText(NAME, name);
		}
		if (!("".equalsIgnoreCase(contact))) {
			String[] contactArray = contact.split(" ");
			SeleniumUtil.clickWebElement(SELECTED_DIAL_CODE);
			// SeleniumUtil.wait(2000);
			// SeleniumUtil.scrollToWebElement(By.xpath(COUNTRY_CODE_TENANT.replace("countryCode",
			// contactArray[0])));
			SeleniumUtil.wait(3000);
			SeleniumUtil.clickWebElement(By.xpath(COUNTRY_CODE_TENANT.replace("countryCode", contactArray[0])));
			SeleniumUtil.enterText(CONTACT_NUMBER, contactArray[1]);
		}
		if (!("".equalsIgnoreCase(email)) || "auto".equalsIgnoreCase(email)) {
			Date date = new Date();
			String emailID = "test" + date.getTime() + "@gmail.com";
			SeleniumUtil.enterText(EMAIL, emailID);
		} else {
			SeleniumUtil.enterText(EMAIL, email);
		}

		if (!("".equalsIgnoreCase(nationality))) {

			SeleniumUtil.selectWebList(NATIONALITY_SELECT, nationality, "selectByVisibleText");
		}
		if (!("".equalsIgnoreCase(occupation))) {

			SeleniumUtil.selectWebList(OCCUPATION_SELECT, occupation, "selectByVisibleText");
		}
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "primaryTenantContactDetails successfully");
	}

	public static void primaryOwnerContactDetails(String name, String contact, String email, String nationality,
			String occupation) {
		LOGGER.info("Inside primaryOwnerContactDetails Method");
		if (!("".equalsIgnoreCase(name))) {
			SeleniumUtil.enterText(NAME, name);
		}
		if (!("".equalsIgnoreCase(contact))) {
			String[] contactArray = contact.split(" ");
			// SeleniumUtil.scrollToWebElement(SELECTED_DIAL_CODE);
			SeleniumUtil.clickWebElement(SELECTED_DIAL_CODE);
			// SeleniumUtil.wait(2000);
			// SeleniumUtil.scrollToWebElement(By.xpath(COUNTRY_CODE_OWNER.replace("countryCode",
			// contactArray[0])));
			SeleniumUtil.wait(2000);
			LOGGER.info("Scroll to countrfy code");
			SeleniumUtil.clickWebElement(By.xpath(COUNTRY_CODE_OWNER.replace("countryCode", contactArray[0])));

			SeleniumUtil.enterText(CONTACT_NUMBER, contactArray[1]);
		}
		if (!("".equalsIgnoreCase(email)) || "auto".equalsIgnoreCase(email)) {
			Date date = new Date();
			String emailID = "test" + date.getTime() + "@gmail.com";
			SeleniumUtil.enterText(EMAIL, emailID);
		} else {
			SeleniumUtil.enterText(EMAIL, email);
		}

		if (!("".equalsIgnoreCase(nationality))) {

			SeleniumUtil.selectWebList(NATIONALITY_SELECT, nationality, "selectByVisibleText");
		}
		if (!("".equalsIgnoreCase(occupation))) {

			SeleniumUtil.selectWebList(OCCUPATION_SELECT, occupation, "selectByVisibleText");
		}
		
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "primaryOwnerContactDetails successfully");
	}

	public static void enterNumberOfVechicle(String numberOfVechicle, String vechileNumber) {
		LOGGER.info("Inside enterNumberOfVechicle Method");
		if (!("".equals(numberOfVechicle))) {
			SeleniumUtil.scrollToWebElement(NUMBER_OF_VECHICLE);
			SeleniumUtil.selectWebList(NUMBER_OF_VECHICLE, numberOfVechicle, "selectByVisibleText");
			if (!("".equals(vechileNumber))) {
				SeleniumUtil.enterText(VECHILE_NO, vechileNumber);
			}
		}
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "enterNumberOfVechicle successfully");

	}

	public static void selectPet(String pet) {
		LOGGER.info("Inside selectPet Method");
		if ("yes".equalsIgnoreCase(pet)) {
			SeleniumUtil.clickWebElement(PET_YES);
		} else {
			SeleniumUtil.clickWebElement(PET_NO);
		}
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "selectPet successfully");
	}

	public static void clickNext() {
		LOGGER.info("Inside clickNext Method");
		SeleniumUtil.clickWebElement(NEXT);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "clickNext successfully");
	}

}
