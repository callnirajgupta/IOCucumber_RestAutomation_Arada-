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

public class AradaRegisterOccupancyDetailsPage {
	private static final Logger LOGGER = LogManager.getLogger(AradaRegisterOccupancyDetailsPage.class);
	private final static By OCCUPANCY_DETAILS = By.xpath("//h3[text()='Occupancy Details']");
	private final static By MOVE_IN_YES = By.xpath("//label[text()='Yes']");
	private final static By MOVE_IN_NO = By.xpath("//label[text()='No']");
	private final static By MOVE_IN_DATE_SELECT = By.id("date3");
	private final static String MOVE_IN_DATE_DAY = "//td[text()='date'and @class='day']";
	private final static By MOVE_IN_TIME_SLOT = By.xpath("//div[@id='slot_dates']//label");
	private final static By TITLE_DEED = By.xpath("//label[@for='title_deed']");
	private final static By GAS_ACTIVATION_RECEIPT = By.xpath("//label[@for='gas_activation']");
	private final static By PASSPORT_VISA = By.xpath("//label[text()='Passport/Visa']");
	private final static By TNC = By.xpath("//label[@for='tnc']");
	private final static By NEXT_BUTTON = By.xpath("//a[text()='Next']");
	private final static By TENANT_START_DATE = By.id("date1");
	private final static By TENANT_END_DATE = By.id("date2");
	private final static By TENANT_CONTRACT = By.xpath("//label[@for='tenancy_contract']");
	private final static By UPLOAD_EJARI_COPY = By.xpath("//label[contains(text(),'Upload Ejari  Copy')]");

	public static void validateOccupancyDetails() {
		LOGGER.info("Inside validateOccupancyDetails Method");

		Assert.assertTrue("The Occupancy Details title does not displayed",
				SeleniumUtil.getWebElement(OCCUPANCY_DETAILS).isDisplayed());
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(),
				"User Occupancy Details page is loaded successfully");
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(),
				"validateOccupancyDetails successfully");
	}

	public static void enterOwnerOcccupanyDetails(String moveIn, String moveInDate, String moveInSlot, String titleDeed,
			String gasActivation, String passport) throws Throwable {
		LOGGER.info("Inside enterOwnerOcccupanyDetails Method");
		if ("No".equalsIgnoreCase(moveIn)) {
			SeleniumUtil.clickWebElement(MOVE_IN_NO);
			if (!("".equalsIgnoreCase(titleDeed))) {
				SeleniumUtil.uploadFile(TITLE_DEED, titleDeed);
			}
			if (!("".equalsIgnoreCase(gasActivation))) {
				SeleniumUtil.uploadFile(GAS_ACTIVATION_RECEIPT, gasActivation);
			}
			if (!("".equalsIgnoreCase(passport))) {
				SeleniumUtil.uploadFile(PASSPORT_VISA, passport);

			}

		} else {
			if (!("".equalsIgnoreCase(moveInDate))) {
				SeleniumUtil.clickWebElement(MOVE_IN_DATE_SELECT);
				if ("auto".equalsIgnoreCase(moveInDate)) {
					Date date = new Date();
					System.out.println("datee of the month" + date.getDate());
					SeleniumUtil.clickWebElement(
							By.xpath(MOVE_IN_DATE_DAY.replace("date", String.valueOf(date.getDate() + 3))));
				} else {
					SeleniumUtil.clickWebElement(By.xpath(MOVE_IN_DATE_DAY.replace("date", moveInDate)));
				}

			}
			if (!("".equalsIgnoreCase(moveInSlot))) {
				List<WebElement> moveInSlotList = SeleniumUtil.getWebElements(MOVE_IN_TIME_SLOT);
				System.out.println("************************" + moveInSlotList.size());
				SeleniumUtil.wait(1000);
				moveInSlotList.get(moveInSlotList.size() - 1).click();
			}
			if (!("".equalsIgnoreCase(titleDeed))) {
				SeleniumUtil.uploadFile(TITLE_DEED, titleDeed);
			}
			if (!("".equalsIgnoreCase(gasActivation))) {
				SeleniumUtil.uploadFile(GAS_ACTIVATION_RECEIPT, gasActivation);
			}
			if (!("".equalsIgnoreCase(passport))) {
				SeleniumUtil.uploadFile(PASSPORT_VISA, passport);

			}
		}
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(),
				"enterOwnerOcccupanyDetails successfully");
	}

	public static void enterTenantOcccupanyDetails(String moveIn, String startDate, String EndDate, String moveInDate,
			String moveInSlot, String tenancyContract, String gasActivation, String passport, String ejariCopy)
			throws Throwable {
		LOGGER.info("Inside enterTenantOcccupanyDetails Method");
		if ("No".equalsIgnoreCase(moveIn)) {
			SeleniumUtil.clickWebElement(MOVE_IN_NO);
			SeleniumUtil.wait(2000);
			if (!("".equalsIgnoreCase(startDate))) {

				SeleniumUtil.clickWebElement(TENANT_START_DATE);
				if ("auto".equalsIgnoreCase(moveInDate)) {
					Date date = new Date();
					if (date.getDate() == 28 || date.getDate() == 29 || date.getDate() == 30 || date.getDate() == 31) {
						SeleniumUtil.clickWebElement(By.xpath(MOVE_IN_DATE_DAY.replace("date", "3")));
					} else {
						System.out.println("datee of the month" + date.getDate());
						SeleniumUtil.clickWebElement(
								By.xpath(MOVE_IN_DATE_DAY.replace("date", String.valueOf(date.getDate() + 3))));
					}
				} else {
					SeleniumUtil.clickWebElement(By.xpath(MOVE_IN_DATE_DAY.replace("date", moveInDate)));
				}

			}
			if (!("".equalsIgnoreCase(EndDate))) {

				SeleniumUtil.clickWebElement(TENANT_END_DATE);
				SeleniumUtil.wait(2000);
				if ("auto".equalsIgnoreCase(moveInDate)) {
					Date date = new Date();
					System.out.println("datee of the month" + date.getDate());
					if (date.getDate() == 28 || date.getDate() == 29 || date.getDate() == 30 || date.getDate() == 31) {
						SeleniumUtil.clickWebElement(By.xpath(MOVE_IN_DATE_DAY.replace("date", "3")));
					} else {
						SeleniumUtil.clickWebElement(
								By.xpath(MOVE_IN_DATE_DAY.replace("date", String.valueOf(date.getDate() + 5))));
					}
				} else {
					SeleniumUtil.clickWebElement(By.xpath(MOVE_IN_DATE_DAY.replace("date", moveInDate)));
				}

			}
			if (!("".equalsIgnoreCase(tenancyContract))) {
				SeleniumUtil.uploadFile(TENANT_CONTRACT, tenancyContract);
			}
			if (!("".equalsIgnoreCase(gasActivation))) {
				SeleniumUtil.uploadFile(GAS_ACTIVATION_RECEIPT, gasActivation);
			}
			if (!("".equalsIgnoreCase(passport))) {
				SeleniumUtil.uploadFile(PASSPORT_VISA, passport);
			}

		} else {
			if (!("".equalsIgnoreCase(moveInDate))) {
				SeleniumUtil.clickWebElement(MOVE_IN_DATE_SELECT);
				SeleniumUtil.wait(2000);
				if ("auto".equalsIgnoreCase(moveInDate)) {
					Date date = new Date();
					if (date.getDate() == 28 || date.getDate() == 29 || date.getDate() == 30 || date.getDate() == 31) {
						SeleniumUtil.clickWebElement(By.xpath(MOVE_IN_DATE_DAY.replace("date", "3")));
					} else {
						System.out.println("datee of the month" + date.getDate());
						SeleniumUtil.wait(5000);
						SeleniumUtil.clickWebElement(
								By.xpath(MOVE_IN_DATE_DAY.replace("date", String.valueOf(date.getDate() + 3))));
						System.out.println("date selected");
						SeleniumUtil.wait(5000);
					}

				} else {
					SeleniumUtil.clickWebElement(By.xpath(MOVE_IN_DATE_DAY.replace("date", moveInDate)));
				}

			}
			if (!("".equalsIgnoreCase(moveInSlot))) {
				List<WebElement> moveInSlotList = SeleniumUtil.getWebElements(MOVE_IN_TIME_SLOT);
				System.out.println("************************" + moveInSlotList.size());
				SeleniumUtil.wait(1000);
				moveInSlotList.get(moveInSlotList.size() - 1).click();
			}
			if (!("".equalsIgnoreCase(startDate))) {

				SeleniumUtil.clickWebElement(TENANT_START_DATE);
				SeleniumUtil.wait(2000);
				if ("auto".equalsIgnoreCase(moveInDate)) {
					Date date = new Date();
					System.out.println("datee of the month" + date.getDate());
					SeleniumUtil.clickWebElement(
							By.xpath(MOVE_IN_DATE_DAY.replace("date", String.valueOf(date.getDate() + 3))));
				} else {
					SeleniumUtil.clickWebElement(By.xpath(MOVE_IN_DATE_DAY.replace("date", moveInDate)));
				}

			}
			if (!("".equalsIgnoreCase(EndDate))) {

				SeleniumUtil.clickWebElement(TENANT_END_DATE);
				SeleniumUtil.wait(2000);
				if ("auto".equalsIgnoreCase(moveInDate)) {
					Date date = new Date();
					System.out.println("datee of the month" + date.getDate());
					SeleniumUtil.clickWebElement(
							By.xpath(MOVE_IN_DATE_DAY.replace("date", String.valueOf(date.getDate() + 5))));
				} else {
					SeleniumUtil.clickWebElement(By.xpath(MOVE_IN_DATE_DAY.replace("date", moveInDate)));
				}
			}
			if (!("".equalsIgnoreCase(tenancyContract))) {
				SeleniumUtil.uploadFile(TENANT_CONTRACT, tenancyContract);
			}
			if (!("".equalsIgnoreCase(gasActivation))) {
				SeleniumUtil.uploadFile(GAS_ACTIVATION_RECEIPT, gasActivation);
			}
			if (!("".equalsIgnoreCase(passport))) {
				SeleniumUtil.uploadFile(PASSPORT_VISA, passport);

			}
			if (!("".equalsIgnoreCase(ejariCopy))) {
				SeleniumUtil.uploadFile(UPLOAD_EJARI_COPY, ejariCopy);

			}
		}
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(),
				"enterTenantOcccupanyDetails successfully");
	}

	public static void clickTnc() {
		LOGGER.info("Inside clickTnc Method");
		SeleniumUtil.clickWebElement(TNC);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(),
				"clickTnc successfully");
	}

	public static void clickNext() {
		LOGGER.info("Inside clickNext Method");
		SeleniumUtil.clickWebElement(NEXT_BUTTON);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(),
				"clickNext successfully");
	}
}
