package com.khanacademy.stepdefinition;

import org.junit.Assert;

import com.khanacademy.objectrepository.EarlyMathPage;
import com.khanacademy.resources.FunctionalLibrary;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class EarlyMathSteps extends FunctionalLibrary {

	@Given("The user starts the addition subtraction challenge")
	public void the_user_starts_the_challenge() {
		EarlyMathPage earlymath = new EarlyMathPage();
		clickjs(earlymath.getLnk_addSubIntro());
		click(earlymath.getLnk_start());
		click(earlymath.getLnk_startExcercise());

	}

	@When("The user selects the correct answer for the question")
	public void the_user_selects_the_correct_answer_for_the_question(DataTable answers) {
		EarlyMathPage earlymath = new EarlyMathPage();
		waitForElementVisibility(earlymath.getTxt_yourAnswer());
		setText(earlymath.getTxt_yourAnswer(), "5");
		click(earlymath.getBtn_checkAnswer());
	}

	@Then("The user should see the message")
	public void the_user_should_see_the_message() {
		EarlyMathPage earlymath = new EarlyMathPage();
		Assert.assertTrue(earlymath.getAlert_feedBack().isDisplayed());
	}

	@When("The user navigates to addition subtration course")
	public void the_user_navigates_to_addition_subtration_course() {
		EarlyMathPage math = new EarlyMathPage();
		waitForElementClickable(math.getLnk_addSubIntro());
		clickjs(math.getLnk_addSubIntro());

	}

}
