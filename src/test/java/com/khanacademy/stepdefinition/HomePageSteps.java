package com.khanacademy.stepdefinition;

import com.khanacademy.objectrepository.HomePage;
import com.khanacademy.resources.FunctionalLibrary;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class HomePageSteps extends FunctionalLibrary {
	@Given("The user navigates to early math page")
	public void the_user_navigates_to_early_math_page() {
		HomePage home = new HomePage();
		click(home.getLnk_courses());
		click(home.getLnk_earlyMath());
	}

	@Given("The user navigates to math page")
	public void the_user_navigates_to_math_page() {
		HomePage home = new HomePage();
		click(home.getLnk_courses());
		click(home.getLnk_headerMath());

	}

	@Given("The user is in class{int} math course")
	public void the_user_is_in_class_math_course(Integer int1) {
		HomePage home = new HomePage();
		click(home.getLnk_courses());
		click(home.getLnk_Class5());
	}

	@Given("The user navigates to Arithmetic page")
	public void the_user_navigates_to_Arithmetic_page() {
		HomePage home = new HomePage();
		click(home.getLnk_courses());
		click(home.getLnk_arithmatic());
	}

	@When("The user navigates to class nine physics course")
	public void the_user_navigates_to_class_physics_course() {
		HomePage home = new HomePage();
		click(home.getLnk_courses());
		click(home.getLnk_class9Physics());
	}
}
