package com.khanacademy.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.khanacademy.resources.FunctionalLibrary;


public class HomePage {
	
	public HomePage(){
		PageFactory.initElements(FunctionalLibrary.driver, this);
	}

	@FindBy(xpath="//div[text()='Learners, start here']")
	private WebElement lnk_learners;
	
	@FindBy(xpath="//span[@data-test-id='learn-menu-button']")
	private WebElement lnk_courses;
	
	@FindBy(xpath="//a[@aria-label='Early math']")
	private WebElement lnk_earlyMath;
	
	@FindBy(xpath="//a[text()='Math' and @class='link_1uvuyao-o_O-headerLinkStyle_13yjtgr']")
	private WebElement lnk_headerMath;
	
	@FindBy(xpath="//a[@aria-label='Class 5']")
	private WebElement lnk_Class5;

	@FindBy(xpath="//span[text()='Arithmetic']")
	private WebElement lnk_arithmatic;
	
	@FindBy(xpath="//a[@aria-label='Physics class 9']")
	private WebElement lnk_class9Physics;
	

	public WebElement getLnk_class9Physics() {
		return lnk_class9Physics;
	}

	public WebElement getLnk_headerMath() {
		return lnk_headerMath;
	}

	public WebElement getLnk_learners() {
		return lnk_learners;
	}

	public WebElement getLnk_courses() {
		return lnk_courses;
	}

	public WebElement getLnk_earlyMath() {
		return lnk_earlyMath;
	}

	public WebElement getLnk_Class5() {
		return lnk_Class5;
	}
	public WebElement getLnk_arithmatic() {
		return lnk_arithmatic;
	}
	
	
}
