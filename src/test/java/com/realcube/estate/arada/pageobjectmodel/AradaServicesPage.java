package com.realcube.estate.arada.pageobjectmodel;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.realcube.estate.commonstepdef.CommonStepDefinition;
import com.realcube.estate.util.AradaUtil;
import com.realcube.estate.util.SeleniumUtil;

public class AradaServicesPage {
	private static final Logger LOGGER = LogManager.getLogger(AradaServicesPage.class);
	private static final By SERVICES = By.xpath("//h4[text()='Services']");
	private static final By ACESS_CARD_REQUEST = By.xpath("//div[div[contains(text(),'Access Card Request')]]//button");
	private static final By REQUEST_FOR_ACCESS_CARD_FORM = By.xpath("//h4[text()=' Request for Access Card ']");
	private final static String SELECT_TEXT = "//span[contains(text(),'searchText') and @class='text']";
	private final static By SELECT_BUILDING = By.id("id_srv_precinct");
	private final static By SEARCH_BUILDING = By.xpath("//div[button[@title='Select Building']]//input");
	private final static By SELECT_UNIT_NUMBER = By.xpath("//button[@title='Select Unit Number']");
	private final static By SELECT_UNIT = By.id("srv_id_unit");
	private final static By SEARCH_UNIT = By.xpath("//div[button[@title='Select Unit']]//input");
	private final static By SEARCH_UNIT_NUMBER = By.xpath("//div[button[@title='Select Unit Number']]//input");
	private final static By NUMBER_OF_CARD_TEXT = By.id("number_of_card");
	private final static By DAMAGE_RADIO = By.xpath("//span[text()='Damage']");
	private final static By ADDITIONAL_RADIO = By.xpath("//span[text()='Additional']");
	private final static By LOST_RADIO = By.xpath("//span[text()='Lost']");
	private final static By BUILDING_ACCESS_CARD_CHECKBOX = By.xpath("//label[contains(text(),'Building Access Card')]");
	private final static By REMARKS = By.xpath("//p");
	private final static By TERMS_CHECKBOX = By.xpath("//label[@for='tnc']");
	private final static By ACCESS_CARDS_CHOOSE_FILE = By.xpath("//label[text()='Copy of Receipt of Access Cards' and @class='control-label']");
	private final static By SUBMIT_BUTTON = By.name("submit");
	private final static By REQUEST_MESSAGE_TEXT = By.xpath("//div[@class='alert alert-success dark dark']");
	private final static By LAST_REQUEST_NUMBER = By.xpath("//table[@id='recent-orders']/tbody/tr[1]/td[1]");
	private final static By ERROR_MESSAGE_UNIT = By.id("err_msg");
	private final static By ERROR_MESSAGE_ACCESS_TYPE = By.xpath("//span[@class='error']");
	private final static By EMAIL_OR_MOBILE_NUMBER_UPDATE = By.xpath("//div[div[contains(text(),'Email or Mobile Number Update')]]//button");
	private final static By MOVE_IN_REQUEST = By.xpath("//div[div[contains(text(),'Move-In Request')]]//button");
	private final static By MOVE_OUT_REQUEST = By.xpath("//div[div[contains(text(),'Move-Out Request')]]//button");
	private final static By EMAIL_RADIO = By.xpath("//label[text()='Email']");
	private final static By UPDATE_EMAIL_TEXTBOX = By.id("upd_email");
	private final static By REMARK = By.xpath("//html/body/p");
	private final static By UPDATE_SUBMIT_BUTTON = By.id("upd_submit");
	private final static By MOBILE_RADIO = By.xpath("//label[text()='Mobile Number']");
	private final static By MOBILE_COUNTRY_CODE = By.xpath("//div[@class='selected-flag']");
	private final static String MOBILE_COUNTRY_CODE_SELECT = "//ul[@class='country-list dropup']/li/span[text()='countryCode']";
	private final static String MOBILE_COUNTRY_CODE_SELECT_BOTH = "//ul[@class='country-list']/li/span[text()='countryCode']";
	private final static By UPDATE_MOBILE_TEXTBOX = By.id("upd_mobile");
	private final static By UPDATE_BOTH_RADIO = By.xpath("//label[text()='Both']");
	private final static By MOVE_IN_COMMUNITY = By.id("id_srv_precinct");
	private final static By MOVE_IN_UNIT = By.id("srv_id_unit");
	private final static By MOVE_OUT_SELECT_COMMUNITY = By.id("id_srv_precinct");
	private  final static By MOVE_OUT_SELECT_UNIT = By.id("srv_id_unit");
	private  final static By MOVE_OUT_RESIDENT_NAME = By.id("resident_name");
	private final static By RESIDENT_CONTACT_COUNTRY_CODE = By.xpath("//div[label[contains(text(),'Resident Contact Number')]]//div[@class='selected-flag']");
	private  final static By MOVE_OUT_DATE = By.name("move_out_date");
	private final static String MOVE_OUT_DATE_DAY = "//td[text()='date' and @class='new day']";
	private final static By MOVE_OUT_REASON = By.name("reasons_for_leaving");
	private final static By MOVING_OUT_TO= By.id("movingOutTo");
	private static final By VENDOR_NAME = By.id("vendor_name");
	private static final By TNC = By.xpath("//label[@for='tnc']");
	private static final By MOVE_OUT_SUBMIT = By.xpath("//div[@class='col']/button[@name='submit']");
	private static final By MOVE_IN_NEXT = By.xpath("//a[text()='Next']");
	private final static By  ADULT = By.id("adult");
	private final static By  CHILDREN = By.id("children");
	private final static By  ELDERS = By.id("elders");
	private final static By  DETERMINATION_COUNT = By.id("determinationCount");
	private final static By  CONTACT_NUMBER = By.id("contactNo");
	private final static By  EMAIL = By.id("email1");
	private final static By  NATIONALITY_SELECT = By.id("nation1");
	private final static By  OCCUPATION_SELECT = By.id("occupation1");
	private final static By  NUMBER_OF_VECHICLE = By.id("noofveh");
	private final static By  VECHICLE_NUMBER = By.name("vehicleNumber[]");
	private final static By  PET_YES = By.xpath("//div[input[@id='is_pet_yes']]//span");
	private final static By  PET_NO = By.xpath("//div[input[@id='is_pet_no']]//span");
	private final static By  ACCESS_CARD_TEXTBOX = By.id("access_cards");
	private final static By  PAYMENT_SUCCESS = By.xpath("//div[@class='alert alert-success dark']");
	private final static By  SERVICE_LIST = By.xpath("//a[text()='Go To Service List']");
	
	
	

	

	public static void validateServiceScreen() {
		LOGGER.info("Inside validateServiceScreen Method");
		SeleniumUtil.validateWebElementVisible(SERVICES);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "validateServiceScreen successfully");
	}

	public static void clickAccessCardRequest() {
		LOGGER.info("Inside clickAccessCardRequest Method");
		SeleniumUtil.clickWebElement(ACESS_CARD_REQUEST);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "clickAccessCardRequest successfully");
	}

	public static void selectBuilding(String building) {
		LOGGER.info("Inside selectBuilding Method");
		//SeleniumUtil.clickWebElement(SELECT_BUILDING);
		//SeleniumUtil.wait(1000);
		//SeleniumUtil.getWebElement(SEARCH_BUILDING).sendKeys(building);
		//SeleniumUtil.wait(1000);
		
		//SeleniumUtil.getWebElement(By.xpath(SELECT_TEXT.replace("searchText", building))).click();
		SeleniumUtil.selectWebList(SELECT_BUILDING, building, "selectByVisibleText");
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "selectBuilding successfully");
	}

	public static void selectUnit(String unit) {
		LOGGER.info("Inside selectUnit Method");
		//SeleniumUtil.clickWebElement(SELECT_UNIT);
		//SeleniumUtil.wait(1000);
		//SeleniumUtil.scrollToWebElement(SEARCH_UNIT);
		//SeleniumUtil.getWebElement(SEARCH_UNIT).sendKeys(unit);
		//SeleniumUtil.wait(1000);
		//SeleniumUtil.getWebElement(By.xpath(SELECT_TEXT.replace("searchText", unit))).click();
		SeleniumUtil.selectWebList(SELECT_UNIT, unit, "selectByVisibleText");
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "selectUnit successfully");
	}

	public static void selectUnitNumber(String unit) {
		LOGGER.info("Inside selectUnit Method");
		SeleniumUtil.clickWebElement(SELECT_UNIT_NUMBER);
		SeleniumUtil.wait(1000);
		SeleniumUtil.scrollToWebElement(SEARCH_UNIT);
		SeleniumUtil.getWebElement(SEARCH_UNIT).sendKeys(unit);
		SeleniumUtil.wait(1000);

		SeleniumUtil.getWebElement(By.xpath(SELECT_TEXT.replace("searchText", unit))).click();
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "selectUnit successfully");
	}

	public static void RequestForAccessCard(String building, String unit, String reason, String accesstype,
			String numberOfCard, String remark, String copyofReceipt, String tnc) throws Throwable {
		LOGGER.info("Inside RequestForAccessCard Method");
		if (!("".equals(building))) {
			selectBuilding(building);
		}

		if (!("".equals(unit))) {

			selectUnit(unit);

		}
		if (!("".equals(reason))) {
			if ("Additional".equalsIgnoreCase(reason)) {
				SeleniumUtil.wait(5000);
				SeleniumUtil.clickWebElement(ADDITIONAL_RADIO);
			} else if ("Damage".equalsIgnoreCase(reason)) {
				SeleniumUtil.wait(1000);
				SeleniumUtil.clickWebElement(DAMAGE_RADIO);
			} else if ("Lost".equalsIgnoreCase(reason)) {
				SeleniumUtil.wait(1000);
				SeleniumUtil.clickWebElement(LOST_RADIO);
			}

		}

		if (("unchecked".equalsIgnoreCase(accesstype))) {
			SeleniumUtil.clickWebElement(BUILDING_ACCESS_CARD_CHECKBOX);
		}

		if (!("".equals(numberOfCard))) {
			SeleniumUtil.waitWebElementClickable(NUMBER_OF_CARD_TEXT);
			SeleniumUtil.enterText(NUMBER_OF_CARD_TEXT, numberOfCard);
		}
		if (!("".equals(remark))) {

			SeleniumUtil.switchFrame(0);
			SeleniumUtil.scrollToWebElement(REMARKS);
			SeleniumUtil.clickWebElement(REMARKS);
			SeleniumUtil.enterText(REMARKS, remark);
			SeleniumUtil.switchToDefaultContent();
		}

		if (!("".equals(copyofReceipt))) {
			SeleniumUtil.uploadFile(ACCESS_CARDS_CHOOSE_FILE, copyofReceipt);
		}

		if ("checked".equalsIgnoreCase(tnc)) {
			SeleniumUtil.scrollToWebElement(TERMS_CHECKBOX);
			SeleniumUtil.clickWebElement(TERMS_CHECKBOX);
			
		}

		SeleniumUtil.clickWebElement(SUBMIT_BUTTON);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "RequestForAccessCard successfully");
	}
    
	public static void validateRequestSuccessMessage() {
		LOGGER.info("Inside validateRequestSuccessMessages Method");
		SeleniumUtil.validateWebElementVisible(REQUEST_MESSAGE_TEXT);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "validateRequestSuccessMessages successfully");

	}

	
	public static String getLastServiceRequestNumber() {
		LOGGER.info("Inside getLastRequestNumber Method");

		return SeleniumUtil.getText(LAST_REQUEST_NUMBER);

	}
	
	public static void validateErrorMessageUnit(String message) {
		LOGGER.info("Inside validateErrorMessageUnit Method");
		Assert.assertEquals("The error message does not match", message, SeleniumUtil.getText(ERROR_MESSAGE_UNIT));
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "validateErrorMessageUnit successfully");
	}
	public static void validateErrorMessageAccessType(String message) {
		LOGGER.info("Inside validateErrorMessageAccessType Method");
		Assert.assertEquals("The error message does not match", message, SeleniumUtil.getText(ERROR_MESSAGE_ACCESS_TYPE));
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "validateErrorMessageAccessType successfully");
	}

	public static void updateEmail(String email) {
		LOGGER.info("Inside updateEmail Method");
		SeleniumUtil.clickWebElement(EMAIL_RADIO);
		SeleniumUtil.enterText(UPDATE_EMAIL_TEXTBOX, email);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "updateEmail successfully");
	}
	public static void clickUpdateEmailOrMobileServiceRequest() {
		LOGGER.info("Inside clickUpdateEmailOrMobileServiceRequest Method");
		SeleniumUtil.clickWebElement(EMAIL_OR_MOBILE_NUMBER_UPDATE);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "clickUpdateEmailOrMobileServiceRequest successfully");
	}
	
	public static void updateMobile(String mobile) {
		LOGGER.info("Inside updateMobile Method");
		SeleniumUtil.clickWebElement(MOBILE_RADIO);
		String[] contactArray=mobile.split(" ");
		SeleniumUtil.clickWebElement(MOBILE_COUNTRY_CODE);
		SeleniumUtil.wait(2000);
		SeleniumUtil.clickWebElement(By.xpath(MOBILE_COUNTRY_CODE_SELECT.replace("countryCode", contactArray[0])));
		SeleniumUtil.enterText(UPDATE_MOBILE_TEXTBOX, contactArray[1]);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "updateMobile successfully");

	
	}
	
	public static void updateEmailAndMobile(String email,String mobile) {
		LOGGER.info("Inside updateEmailAndMobile Method");
		SeleniumUtil.clickWebElement(UPDATE_BOTH_RADIO);
		
		SeleniumUtil.enterText(UPDATE_EMAIL_TEXTBOX, email);
		
		String[] contactArray=mobile.split(" ");
		SeleniumUtil.clickWebElement(MOBILE_COUNTRY_CODE);
		SeleniumUtil.wait(2000);
		SeleniumUtil.clickWebElement(By.xpath(MOBILE_COUNTRY_CODE_SELECT_BOTH.replace("countryCode", contactArray[0])));
		SeleniumUtil.enterText(UPDATE_MOBILE_TEXTBOX, contactArray[1]);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "updateEmailAndMobile successfully");
		
	}
	public static void enterRemark(String remark) {
		LOGGER.info("Inside enterRemark Method");
		SeleniumUtil.switchFrame(0);
		SeleniumUtil.enterText(REMARK, remark);
		SeleniumUtil.switchToDefaultContent();
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "enterRemark successfully");
	}
	public static void clickUpdateSubmit() {
		LOGGER.info("Inside clickUpdateSubmit Method");
		SeleniumUtil.clickWebElement(UPDATE_SUBMIT_BUTTON);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "clickUpdateSubmit successfully");
	}
	public static void clickMoveOutRequest() {
		LOGGER.info("Inside clickMoveOutRequest Method");
		SeleniumUtil.clickWebElement(MOVE_OUT_REQUEST);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "clickMoveOutRequest successfully");
	}
	
	public static void clickMoveInRequest() {
		LOGGER.info("Inside clickMoveInRequest Method");
		SeleniumUtil.clickWebElement(MOVE_IN_REQUEST);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "clickMoveInRequest successfully");
	}
	public static void clickMoveOutSubmit() {
		LOGGER.info("Inside clickMoveOutSubmit Method");
		SeleniumUtil.scrollToWebElement(MOVE_OUT_SUBMIT);
		SeleniumUtil.clickWebElement(MOVE_OUT_SUBMIT);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "clickMoveOutSubmit successfully");
	}
	
	
	public static void enterMoveOutDetails(String community,String unit,String MoveOutDate,String reason,String moveTo,String feedback,String vendor) {
		LOGGER.info("Inside enterMoveOutDetails Method");
		if(!("".equals(community))) {
			SeleniumUtil.selectWebList(MOVE_OUT_SELECT_COMMUNITY, community, "selectByVisibleText");
		}
		if(!("".equals(unit))) {
			SeleniumUtil.selectWebList(MOVE_OUT_SELECT_UNIT, unit, "selectByVisibleText");
		}
		if("auto".equalsIgnoreCase(MoveOutDate)) {
			SeleniumUtil.scrollToWebElement(MOVE_OUT_DATE);
			SeleniumUtil.clickWebElement(MOVE_OUT_DATE);
			Date date = new Date();
			if(date.getDate()==28 || date.getDate()==29 ||date.getDate()==30 || date.getDate()==31) {
				SeleniumUtil.clickWebElement(By.xpath(MOVE_OUT_DATE_DAY.replace("date", "3")));	
			}
			else {
				SeleniumUtil.clickWebElement(By.xpath(MOVE_OUT_DATE_DAY.replace("date", String.valueOf(date.getDate()+3))));
			}
			}else {
				SeleniumUtil.clickWebElement(By.xpath(MOVE_OUT_DATE_DAY.replace("date", MoveOutDate)));
			}
	
		if(!("".equals(reason))) {
			SeleniumUtil.enterText(MOVE_OUT_REASON, reason);
		}
		
		if(!("".equals(moveTo))) {
			SeleniumUtil.enterText(MOVING_OUT_TO, moveTo);
		}
		if(!("".equals(feedback))) {
			SeleniumUtil.switchFrame(0);
			SeleniumUtil.scrollToWebElement(REMARK);
			SeleniumUtil.enterText(REMARK, feedback);
			SeleniumUtil.switchToDefaultContent();
		}
	
		if(!("".equals(vendor))) {
			SeleniumUtil.selectWebList(VENDOR_NAME, vendor, "selectByVisibleText");
		}
		SeleniumUtil.wait(2000);
		SeleniumUtil.clickWebElement(TNC);
		
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "enterMoveOutDetails successfully");
	}
	
	public static void clickMoveInNext() {
		LOGGER.info("Inside clickMoveInNext Method");
		SeleniumUtil.clickWebElement(MOVE_IN_NEXT);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "clickMoveInNext successfully");
	}
	

	public static void clickServiceList() {
		LOGGER.info("Inside clickServiceList Method");
		SeleniumUtil.clickWebElement(SERVICE_LIST);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "clickServiceList successfully");
	}
	
	
	public static void enterMoveInUnit(String community,String unit) {
		LOGGER.info("Inside enterMoveInUnit Method");
		SeleniumUtil.wait(2000);
		if(!("".equals(community))) {
			SeleniumUtil.selectWebList(MOVE_IN_COMMUNITY, community, "selectByVisibleText");
		}
		if(!("".equals(unit))) {
			SeleniumUtil.selectWebList(MOVE_IN_UNIT, unit, "selectByVisibleText");
		}
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "enterMoveInUnit successfully");
	}
	public static void enterMoveInResidentDetails(String adult,String children,String seniorCitizens,String peopleofDetermination,String nationality,String occupation,String numberOfVechicle,String vechileNumber,String accessCard,String pet) {
		LOGGER.info("Inside enterMoveInResidentDetails Method");
		if(!("".equalsIgnoreCase(adult))) {
			SeleniumUtil.enterText(ADULT, adult);
		}
		if(!("".equalsIgnoreCase(children))) {
			SeleniumUtil.enterText(CHILDREN, children);
		}
		if(!("".equalsIgnoreCase(seniorCitizens))) {
			SeleniumUtil.enterText(ELDERS, seniorCitizens);
		}
		if(!("".equalsIgnoreCase(peopleofDetermination))) {
			SeleniumUtil.enterText(DETERMINATION_COUNT, peopleofDetermination);
		}
     if(!("".equalsIgnoreCase(nationality))) {
			
			SeleniumUtil.selectWebList(NATIONALITY_SELECT, nationality, "selectByVisibleText");
		}
		if(!("".equalsIgnoreCase(occupation))) {
		
			SeleniumUtil.selectWebList(OCCUPATION_SELECT, occupation, "selectByVisibleText");
		}
		
		
		if(!("".equals(numberOfVechicle))) {
			SeleniumUtil.scrollToWebElement(NUMBER_OF_VECHICLE);
			SeleniumUtil.selectWebList(NUMBER_OF_VECHICLE, numberOfVechicle, "selectByVisibleText");
			if(!("".equals(vechileNumber))) {
				SeleniumUtil.enterText(VECHICLE_NUMBER, vechileNumber);		
			}
	}
		
		if(!("".equalsIgnoreCase(accessCard))) {
			
			SeleniumUtil.enterText(ACCESS_CARD_TEXTBOX,accessCard );
		}
		
		if("yes".equalsIgnoreCase(pet)) {
			SeleniumUtil.clickWebElement(PET_YES);
		}else {
			SeleniumUtil.clickWebElement(PET_NO);
		}
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), CommonStepDefinition.getExtentTest(), "enterMoveInResidentDetails successfully");
	}
	
	
}
