package com.realcube.estate.arada.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.realcube.estate.commonstepdef.CommonStepDefinition;
import com.realcube.estate.util.SeleniumUtil;

public class AradaPaymentPage {
	private static final Logger LOGGER = LogManager.getLogger(AradaPaymentPage.class);
	private final static By PAY_BUTTON = By.id("btnHint");
	private final static By CARD_NUMBER = By.xpath("//div[@id='card']//input");
	private final static By EXP_DATE_INPUT = By.id("expDateInput");
	private final static By CVV = By.xpath("//span[@id='cvvSpan']/input");
	private final static By CARD_HOLDER_NAME = By.id("chNameInput");
	private final static By MERCHANT_TITLE = By.xpath("//label[text()='Aljada Developments']");
	private final static By  PAYMENT_SUCCESS = By.xpath("//div[@class='alert alert-success dark']");
	
	public static void validatePaymentMerchant() {
		LOGGER.info("Inside validatePaymentMerchant Method");
		SeleniumUtil.validateWebElementVisible(MERCHANT_TITLE);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "validatePaymentMerchant successfully");
	}

	
	
	public static void enterPaymeentDetails(String cardNumber,String expDate,String cvv,String cardHolderName) {
		LOGGER.info("Inside enterPaymeentDetails meethod");
		
		if (!("".equals(cardNumber))) {

			SeleniumUtil.enterText(CARD_NUMBER, cardNumber);

		}
		if (!("".equals(expDate))) {

			SeleniumUtil.enterText(EXP_DATE_INPUT, expDate);

		}
		if (!("".equals(cvv))) {

			SeleniumUtil.enterText(CVV, cvv);

		}
		if (!("".equals(cardHolderName))) {

			SeleniumUtil.enterText(CARD_HOLDER_NAME, cardHolderName);

		}
	}
	public static void clickPay() {
		LOGGER.info("Inside clickPay method");
		SeleniumUtil.wait(2000);
		SeleniumUtil.javascriptClickElement(PAY_BUTTON);
	}

	public static void validatePaymeentSuccessMessage() {
		LOGGER.info("Inside validateRequestSuccessMessages Method");
		SeleniumUtil.validateWebElementVisible(PAYMENT_SUCCESS,30);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "validatePaymeentSuccessMessage successfully");

	}
}
