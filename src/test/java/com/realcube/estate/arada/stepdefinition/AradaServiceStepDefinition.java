package com.realcube.estate.arada.stepdefinition;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.realcube.estate.arada.pageobjectmodel.AradaDashBoardPage;
import com.realcube.estate.arada.pageobjectmodel.AradaPaymentPage;
import com.realcube.estate.arada.pageobjectmodel.AradaServicesPage;
import com.realcube.estate.util.AradaUtil;
import com.realcube.estate.util.SeleniumUtil;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AradaServiceStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(AradaServiceStepDefinition.class);

	@When("^user click My Request$")
	public void user_click_my_request() {
		LOGGER.info("user click My Request");
		AradaDashBoardPage.clickMyRequest();
	}

	@When("^user click My Service$")
	public void user_click_my_service() {
		LOGGER.info("user click My Service");
		AradaDashBoardPage.clickMyService();

	}

	@When("^user Request for Access Card with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_request_for_access_card_with_and_and_and_and_and_and_and(String building, String unit,
			String reason, String accesstype, String numberOfCard, String remark, String copyofReceipt, String tnc)
			throws Throwable {
		LOGGER.info("user Request for Access Card with");
		AradaServicesPage.clickAccessCardRequest();
		AradaServicesPage.RequestForAccessCard(building, unit, reason, accesstype, numberOfCard, remark, copyofReceipt,
				tnc);

	}

	@Then("^verify that service request is raised successfully$")
	public void verify_that_service_request_is_raised_successfully() {
		LOGGER.info("verify that service request is raised successfully");
		AradaServicesPage.validateRequestSuccessMessage();
		String requestNumber = AradaServicesPage.getLastServiceRequestNumber();

		AradaUtil.setServiceRequest(requestNumber);

	}

	@Then("^verify that validation message display as \"([^\"]*)\"$")
	public void validateMessageServiceRequest(String message) {
		LOGGER.info("verify that validation message display as");
		if (message.contains("unit")) {
			AradaServicesPage.validateErrorMessageUnit(message);
		} else {
			AradaServicesPage.validateErrorMessageAccessType(message);
		}
	}

	@When("^user update email as \"([^\"]*)\" and remark as \"([^\"]*)\"$")
	public void updateEmail(String email, String remark) {
		LOGGER.info("user update email as" + email);
		AradaServicesPage.clickUpdateEmailOrMobileServiceRequest();
		AradaServicesPage.updateEmail(email);
		AradaServicesPage.enterRemark(remark);
		AradaServicesPage.clickUpdateSubmit();
	}

	@When("^user update mobile as \"([^\"]*)\" and remark as \"([^\"]*)\"$")
	public void updateMobile(String mobile, String remark) {
		LOGGER.info("user update mobile as" + mobile);
		AradaServicesPage.clickUpdateEmailOrMobileServiceRequest();
		AradaServicesPage.updateMobile(mobile);
		AradaServicesPage.enterRemark(remark);
		AradaServicesPage.clickUpdateSubmit();
	}

	@When("^user update email as \"([^\"]*)\" and mobile as \"([^\"]*)\" and remark as \"([^\"]*)\"$")
	public void updateEmailAndMobileBoth(String email, String mobile, String remark) {
		LOGGER.info("user update email as" + email + " and mobile as " + mobile);
		AradaServicesPage.clickUpdateEmailOrMobileServiceRequest();
		AradaServicesPage.updateEmailAndMobile(email, mobile);
		AradaServicesPage.enterRemark(remark);
		AradaServicesPage.clickUpdateSubmit();
	}

	@When("^user enter move out request details as community \"([^\"]*)\" and unit \"([^\"]*)\" and moveOut \"([^\"]*)\" and reason \"([^\"]*)\" and moveTo \"([^\"]*)\" and feedBack \"([^\"]*)\" and vendor \"([^\"]*)\"$")
	public void user_enter_move_out_request_details_as_community_and_unit_and_move_out_and_reason_and_move_to_and_feed_back_and_vendor(
			String community, String unit, String MoveOutDate, String reason, String moveTo, String feedback,
			String vendor) {
		LOGGER.info("user enter move out request details as community");
		AradaServicesPage.clickMoveOutRequest();
		AradaServicesPage.enterMoveOutDetails(community, unit, MoveOutDate, reason, moveTo, feedback, vendor);

		AradaServicesPage.clickMoveOutSubmit();
	}

	@When("^user enter move in request unit details as community \"([^\"]*)\" and unit as \"([^\"]*)\"$")
	public void user_enter_move_in_request_as_unit_details_community_and_unit_as(String community, String unit) {
		LOGGER.info("user enter move in request unit details as community");
		AradaServicesPage.clickMoveInRequest();
		AradaServicesPage.enterMoveInUnit(community, unit);
		AradaServicesPage.clickMoveInNext();
	}

	@When("^user enter move in request resident detail as Adult \"([^\"]*)\" and Children \"([^\"]*)\" and SrCitizen \"([^\"]*)\" and NoOfDetermination \"([^\"]*)\" and Nationality \"([^\"]*)\" and Occupation \"([^\"]*)\" and NoOfVechile \"([^\"]*)\" and VechileNumber \"([^\"]*)\" and accessCard \"([^\"]*)\" and Pet \"([^\"]*)\"$")
	public void user_enter_move_in_request_resident_detail_as_adult_and_children_and_sr_citizen_and_no_of_determination_and_nationality_and_occupation_and_no_of_vechile_and_vechile_number_and_access_card_and_pet(
			String adult, String children, String seniorCitizens, String peopleofDetermination, String nationality,
			String occupation, String numberOfVechicle, String vechileNumber, String accessCard, String pet) {
		LOGGER.info("user enter move in request resident detail as Adult");
		AradaServicesPage.enterMoveInResidentDetails(adult, children, seniorCitizens, peopleofDetermination,
				nationality, occupation, accessCard, numberOfVechicle, vechileNumber, pet);
		AradaServicesPage.clickMoveInNext();
	}

	
	@When("^user enter payment details$")
	public void user_enter_payment_details() {
		LOGGER.info("user enter payment details");
		AradaPaymentPage.validatePaymentMerchant();
		AradaPaymentPage.enterPaymeentDetails(SeleniumUtil.getPropertie("CreditCardNo"), SeleniumUtil.getPropertie("CreditCardExpire"), SeleniumUtil.getPropertie("CreditCardCVV"), "abc");
		AradaPaymentPage.clickPay();
	}
	@When("^verify that payment is successfull$")
	public void payment_Successfull() {
		LOGGER.info("verify that payment is successfull");
		AradaPaymentPage.validatePaymeentSuccessMessage();
		AradaServicesPage.clickServiceList();
		String requestNumber = AradaServicesPage.getLastServiceRequestNumber();
		AradaUtil.setServiceRequest(requestNumber);
		
	}
	
	
}
