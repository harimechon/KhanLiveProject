package com.khanacademy.stepdefinition;

import java.util.List;

import org.junit.Assert;

import com.khanacademy.objectrepository.CcEarlyMathAddSubBasics;
import com.khanacademy.resources.FunctionalLibrary;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class CcEearlyMathAddSubBasics extends FunctionalLibrary {

	@When("The user navigtes to intro to addition page")
	public void the_user_navigtes_to_intro_to_addition_page() {
		CcEarlyMathAddSubBasics earlyMath = new CcEarlyMathAddSubBasics();
		click(earlyMath.getLnk_additionSubtration());

	}

	@Then("The user should see the description in about section")
	public void the_user_should_see_the_description_in_about_section(DataTable description) {
		CcEarlyMathAddSubBasics earlyMath = new CcEarlyMathAddSubBasics();
		List<String> expectedValue = description.asList(String.class);
		Assert.assertEquals(expectedValue.get(0), getText(earlyMath.getLbl_aboutDescription()));
	}
}
