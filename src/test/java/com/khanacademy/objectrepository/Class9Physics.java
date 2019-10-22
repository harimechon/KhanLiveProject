package com.khanacademy.objectrepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.khanacademy.resources.FunctionalLibrary;

public class Class9Physics {

	public Class9Physics() {
		PageFactory.initElements(FunctionalLibrary.driver, this);
	}

	@FindBy(xpath = "//h2[text()='Course summary']//parent::li//following-sibling::li//span[1]")
	private List<WebElement> courseSummaryList;

	public List<WebElement> getCourseSummaryList() {
		return courseSummaryList;
	}

}
