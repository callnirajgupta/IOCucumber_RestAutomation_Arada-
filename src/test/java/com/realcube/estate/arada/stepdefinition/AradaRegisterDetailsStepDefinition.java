package com.realcube.estate.arada.stepdefinition;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.realcube.estate.arada.pageobjectmodel.AradaRegisterDetailsPage;

import io.cucumber.java.en.When;

public class AradaRegisterDetailsStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(AradaRegisterDetailsStepDefinition.class);

	@When("^user enter resident details ApplyFor as \"([^\"]*)\" and Adult as \"([^\"]*)\" and Children as \"([^\"]*)\" and SrCitizen as \"([^\"]*)\" and NoOfDetermination as \"([^\"]*)\" and Name as \"([^\"]*)\" and ContactNo as \"([^\"]*)\" and Email as \"([^\"]*)\" and Nationality as \"([^\"]*)\" and Occupation as \"([^\"]*)\" and NoOfVechile as \"([^\"]*)\" and VechileNumber as \"([^\"]*)\" and Pet as \"([^\"]*)\"$")
	public void user_enter_resident_details_as_and_and_and_and_and_and_and_and_and_and(String ApplyFor, String Adult,
			String Children, String SrCitizen, String NoOfDetermination, String Name, String ContactNo, String Email,
			String Nationality, String Occupation, String NoOfVechile, String vechileNumbner, String Pet) {
		LOGGER.info("user enter resident details ApplyFor");
		AradaRegisterDetailsPage.selectApplyOnBehalf(ApplyFor);
		AradaRegisterDetailsPage.enterNumberOfPeopleResideInUnit(Adult, Children, SrCitizen, NoOfDetermination);
		AradaRegisterDetailsPage.primaryTenantContactDetails(Name, ContactNo, Email, Nationality, Occupation);
		AradaRegisterDetailsPage.enterNumberOfVechicle(NoOfVechile, vechileNumbner);
		AradaRegisterDetailsPage.selectPet(Pet);
		AradaRegisterDetailsPage.clickNext();
	}

	@When("^user enter owner resident details Adult as \"([^\"]*)\" and Children as \"([^\"]*)\" and SrCitizen as \"([^\"]*)\" and NoOfDetermination as \"([^\"]*)\" and Name as \"([^\"]*)\" and ContactNo as \"([^\"]*)\" and Email as \"([^\"]*)\" and Nationality as \"([^\"]*)\" and Occupation as \"([^\"]*)\" and NoOfVechile as \"([^\"]*)\" and VechileNumber as \"([^\"]*)\" and Pet as \"([^\"]*)\"$")
	public void user_enter_Owner_resident_details_as_and_and_and_and_and_and_and_and_and_and(String Adult,
			String Children, String SrCitizen, String NoOfDetermination, String Name, String ContactNo, String Email,
			String Nationality, String Occupation, String NoOfVechile, String vechileNumbner, String Pet) {
		LOGGER.info("user enter owner resident details Adult as");

		AradaRegisterDetailsPage.enterNumberOfPeopleResideInUnit(Adult, Children, SrCitizen, NoOfDetermination);
		AradaRegisterDetailsPage.primaryOwnerContactDetails(Name, ContactNo, Email, Nationality, Occupation);
		AradaRegisterDetailsPage.enterNumberOfVechicle(NoOfVechile, vechileNumbner);
		AradaRegisterDetailsPage.selectPet(Pet);
		AradaRegisterDetailsPage.clickNext();
	}

}
