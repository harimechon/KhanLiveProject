package com.khanacademy.stepdefinition;

import com.khanacademy.objectrepository.FifthGradeMathpage;
import com.khanacademy.resources.FunctionalLibrary;

import cucumber.api.java.en.When;

public class FifthGradeMathSteps extends FunctionalLibrary {

	@When("The user navigates to shapes and angles")
	public void the_user_navigates_to_shapes_and_angles() {
		FifthGradeMathpage fifthgrade = new FifthGradeMathpage();

		click(fifthgrade.getLnk_ShapesAndAngles());

	}
}
