package com.khanacademy.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.khanacademy.resources.FunctionalLibrary;

public class FifthGradeMathpage {

	public FifthGradeMathpage(){
		PageFactory.initElements(FunctionalLibrary.driver, this);
	}
	
	@FindBy(xpath = "//a[@data-test-id='unit-header']/span[text()='Shapes and angles']")
	private WebElement lnk_ShapesAndAngles;

	public WebElement getLnk_ShapesAndAngles() {
		return lnk_ShapesAndAngles;
	}

}
