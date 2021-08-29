package com.realcube.estate.finance.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.realcube.estate.util.SeleniumUtil;

public class FinanceDashBoardPage {
	private static final Logger LOGGER = LogManager.getLogger(FinanceDashBoardPage.class);
	private static final By DASHBOARD = By.xpath("//h1[text()='Dashboard']");
	private static final By FINANCE_LOGIN = By.xpath("//a[@id='userDropdown']/span[text()='Finance']");
	
	
	public static void validateDashBoard() {
		LOGGER.info("Inside validateLoginTitle Method");
		SeleniumUtil.validateWebElementVisible(DASHBOARD);
	}

	public static void validateFinanceLogin() {
		LOGGER.info("Inside validateLoginTitle Method");
		SeleniumUtil.validateWebElementVisible(FINANCE_LOGIN);
	}
}
