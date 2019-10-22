package com.khanacademy.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.khanacademy.resources.FunctionalLibrary;

public class ArithmaticPage {

	public ArithmaticPage() {
		PageFactory.initElements(FunctionalLibrary.driver, this);
	}

	@FindBy(xpath = "//a[@data-test-id='unit-header']/span[text()='Addition and subtraction']")
	private WebElement lnk_additionSubtraction;

	public WebElement getLnk_additionSubtraction() {
		return lnk_additionSubtraction;
	}

}
