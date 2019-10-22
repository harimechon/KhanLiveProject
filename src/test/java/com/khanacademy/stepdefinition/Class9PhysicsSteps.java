package com.khanacademy.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.khanacademy.objectrepository.Class9Physics;
import com.khanacademy.resources.FunctionalLibrary;

import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

public class Class9PhysicsSteps extends FunctionalLibrary {

	@Then("The user should see the list of courses in class nine physics")
	public void the_user_should_see_the_list_of_courses_in_class_physics(DataTable courseSummary) {
		List<String> ExpectedcourseList = courseSummary.asList(String.class);
		List<String> ActualCourseList = new ArrayList<String>();

		Class9Physics physics = new Class9Physics();
		waitForElementClickable(physics.getCourseSummaryList().get(0));
		List<WebElement> ActualCourseListElements = physics.getCourseSummaryList();
		for (WebElement ele : ActualCourseListElements) {
			ActualCourseList.add(ele.getText());
		}

		Assert.assertEquals(ExpectedcourseList, ActualCourseList);
	}
}
