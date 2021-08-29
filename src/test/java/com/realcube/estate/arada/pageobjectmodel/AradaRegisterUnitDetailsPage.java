package com.realcube.estate.arada.pageobjectmodel;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.realcube.estate.commonstepdef.CommonStepDefinition;
import com.realcube.estate.util.SeleniumUtil;

public class AradaRegisterUnitDetailsPage {
	private static final Logger LOGGER = LogManager.getLogger(AradaRegisterUnitDetailsPage.class);

	private final static String REGISTER_TITLE = "Register Arada";
	private final static By UNIT_DETAILS_SCREEN = By.xpath("//h3[text()='Unit Details']");
	private final static By NEW_OWNER_RADIO = By.xpath("//div[input[@id='new_owner']]//label");
	private final static By NEW_TENANT_RADIO = By.xpath("//div[input[@id='new_tenant']]//label");
	private final static By SELECT_COMMUNITY = By.xpath("//div[text()='Select Community']");
	private final static By COMMUNITY_SEARCH = By.xpath("//div[button[@title='Select Community']]//input");
	private final static String SELECT_TEXT = "//span[contains(text(),'searchText')]";
	private final static By SELECT_BUILDING = By.xpath("//button[@title='Select Building']");
	private final static By SEARCH_BUILDING = By.xpath("//div[button[@title='Select Building']]//input");
	private final static By SELECT_UNIT = By.xpath("//button[@title='Select Unit Number']");
	private final static By SEARCH_UNIT = By.xpath("//div[button[@title='Select Unit Number']]//input");
	private final static By BUTTON_NEXT = By.xpath("//a[text()='Next']");
	private final static By ERROR_MESSAGE = By.xpath("//label[@class='error']");

	public static void validateRegisterTitle() {
		LOGGER.info("Inside validateRegisterTitle Method");

		Assert.assertEquals("The  Register title does not match", REGISTER_TITLE, SeleniumUtil.getTitle());
		Assert.assertTrue("The Register unit details screen does not displayeds",
				SeleniumUtil.getWebElement(UNIT_DETAILS_SCREEN).isDisplayed());
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(),
				"User Register page is loaded successfully");
	}

	public static void clickTenantRadio() {
		LOGGER.info("Inside clickTenantRadios Method");
		SeleniumUtil.clickWebElement(NEW_TENANT_RADIO);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "clickTenantRadios successfully");
	}

	public static void clickOwnerRadio() {
		LOGGER.info("Inside clickOwnerRadio Method");
		SeleniumUtil.clickWebElement(NEW_OWNER_RADIO);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "clickOwnerRadio successfully");
	}

	public static void selectCommunity(String community) {
		LOGGER.info("Inside selectCommunity Method");
		if (!("".equals(community))) {
			SeleniumUtil.clickWebElement(SELECT_COMMUNITY);
			SeleniumUtil.getWebElement(COMMUNITY_SEARCH).sendKeys(community);
			SeleniumUtil.getWebElement(By.xpath(SELECT_TEXT.replace("searchText", community))).click();
		}
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "selectCommunity successfully");
	}

	public static void selectBuilding(String building) {
		LOGGER.info("Inside selectBuilding Method");
		if (!("".equals(building))) {
			SeleniumUtil.clickWebElement(SELECT_BUILDING);
			SeleniumUtil.getWebElement(SEARCH_BUILDING).sendKeys(building);
			SeleniumUtil.getWebElement(By.xpath(SELECT_TEXT.replace("searchText", building))).click();
		}
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "selectBuilding successfully");
	}

	public static void selectUnit(String unit) {
		LOGGER.info("Inside selectUnit Method");
		if (!("".equals(unit))) {
			SeleniumUtil.clickWebElement(SELECT_UNIT);
			SeleniumUtil.getWebElement(SEARCH_UNIT).sendKeys(unit);
			SeleniumUtil.getWebElement(By.xpath(SELECT_TEXT.replace("searchText", unit))).click();
		}
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "selectUnit successfully");
	}

	public static void enterOwnerTenantDetails(String community, String building, String Unit) {
		LOGGER.info("Inside enterOwnerTenantDetails Method");
		selectCommunity(community);
		selectBuilding(building);
		selectUnit(Unit);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "enterOwnerTenantDetails successfully");
	}

	public static void clickNext() {
		LOGGER.info("Inside clickNext Method");
		SeleniumUtil.clickWebElement(BUTTON_NEXT);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "clickNext successfully");
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

}
