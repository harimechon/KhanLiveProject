package com.khanacademy.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.khanacademy.resources.FunctionalLibrary;

public class CcEarlyMathAddSubBasics {

	public CcEarlyMathAddSubBasics() {
		PageFactory.initElements(FunctionalLibrary.driver, this);
	}

	@FindBy(xpath="(//a[@data-test-id='lesson-card-link'])[1]")
	private WebElement lnk_additionSubtration;
	
	@FindBy(xpath="//div[@id='ka-videoPageTabs-tabbedpanel-content']//span")
	private WebElement lbl_aboutDescription;

	public WebElement getLnk_additionSubtration() {
		return lnk_additionSubtration;
	}

	public WebElement getLbl_aboutDescription() {
		return lbl_aboutDescription;
	}
	
	
}
