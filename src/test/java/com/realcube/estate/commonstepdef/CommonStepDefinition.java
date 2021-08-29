package com.realcube.estate.commonstepdef;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.realcube.estate.action.TestRunner;
import com.realcube.estate.arada.pageobjectmodel.AradaDashBoardPage;
import com.realcube.estate.arada.pageobjectmodel.AradaLoginPage;
import com.realcube.estate.finance.pageobjectmodel.FinanceLoginPage;
import com.realcube.estate.util.SeleniumUtil;
import com.relevantcodes.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;



public class CommonStepDefinition {
	
	private static final Logger LOGGER = LogManager.getLogger(CommonStepDefinition.class);
	public static Scenario scenario;
	private static String scenarioName;
	public static ExtentTest extenttest;
	public WebDriver driver=null;
	

	@Before()
	public void Setup(Scenario scenario) {
		LOGGER.info("Inside Setup method");
		extenttest = TestRunner.getExtentReport().startTest(scenario.getName());
		CommonStepDefinition.scenario=scenario;
		scenarioName=scenario.getName();
		SeleniumUtil.getInstance();
	}
	

	
	@Given("^user navigates to Arada login page$")
	public void user_navigates_to_Arada_login_page() throws Throwable {
		LOGGER.info("user navigates to Arada login page");
		if (Boolean.FALSE.equals(SeleniumUtil.driverStatus)) {
			SeleniumUtil.getDriver();
			SeleniumUtil.maximizeBrowser();
		}
		SeleniumUtil.launchApplication(SeleniumUtil.getConfigProperties().getProperty("AradaUrl"));
		SeleniumUtil.ImplicitWait();
		AradaLoginPage.validateLoginTitle();
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "Login page is loaded successfully");
		
	}
	
	@Given("^user navigates to FINANCE login page$")
	public void user_navigates_to_FINANCE_login_page() throws Throwable {
		LOGGER.info("user navigates to FINANCE login page");
		if (Boolean.FALSE.equals(SeleniumUtil.driverStatus)) {
			SeleniumUtil.getDriver();
			SeleniumUtil.maximizeBrowser();
		}
		SeleniumUtil.launchApplication(SeleniumUtil.getConfigProperties().getProperty("FinanceUrl"));
		SeleniumUtil.ImplicitWait();
		FinanceLoginPage.validateLoginTitle();
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "Login page is loaded successfully");
		
	}
	
	@When("^user login with \"([^\"]*)\" and \"([^\"]*)\" user in Arada$")
	public void user_login_with_and_user_in_arada(String userName, String password) {
		LOGGER.info("user login with "+userName+" and"+password+ "user in Arada");
		AradaLoginPage.login(userName,password);
	}
	
	@And("^user logout successfully from Arada$")
	public void logoutFromArada() {
		LOGGER.info("user logout successfully from Arada");
		AradaDashBoardPage.logoutArada();
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "logout successfully");
	}
	
	
	@After()
	public void TearDown(Scenario scenario) {
		LOGGER.info("Inside Teardown method");

		if (scenario.isFailed()) {
			LOGGER.debug("###################  i am inside screen shot after fail ####################");
			final byte[] screenshot = ((TakesScreenshot) SeleniumUtil.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenarioName);
			//scenario.embed(screenshot, "image/png");
			
			SeleniumUtil.failTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "The Step is failed");

		}
		if (SeleniumUtil.getDriver() != null) {
			
			SeleniumUtil.closeBrowser();
			SeleniumUtil.setDriver(null);
			SeleniumUtil.driverStatus=false;
		}

		
	}
	
	public static ExtentTest getExtentTest() {
		return extenttest;
	}
	
	 public static String getScenarioName() {
			return scenarioName;
		}
}
