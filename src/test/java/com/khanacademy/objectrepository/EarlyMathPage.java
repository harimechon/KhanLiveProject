package com.khanacademy.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.khanacademy.resources.FunctionalLibrary;

public class EarlyMathPage {

	public EarlyMathPage(){
		PageFactory.initElements(FunctionalLibrary.driver, this);
	}
	
	@FindBy(xpath="//span[text()='Get started']//parent::a")
	private WebElement lnk_getStarted;
	
	@FindBy(xpath="//a[contains(@href,'early-math')]//span[text()='Start']")
	private WebElement lnk_start;
	
	@FindBy(xpath="//button[@data-test-id='test-start-exercise-button']")
	private WebElement lnk_startExcercise;
	
	@FindBy(xpath="(//span[text()='Addition and subtraction intro']//parent::a[contains(@href,'add-sub-basics')])[2]")
	private WebElement lnk_addSubIntro;
	
	@FindBy(xpath="//input[@aria-label='Your answer:']")
	private WebElement txt_yourAnswer;
	
	@FindBy(xpath="//button[@data-test-id='exercise-check-answer']")
	private WebElement btn_checkAnswer;
	
	@FindBy(xpath="//div[@data-test-id='exercise-feedback-popover-correct']")
	private WebElement alert_feedBack;
	
	@FindBy(xpath="//a[@data-test-id='unit-header']/span[text()='Addition and subtraction intro']")
	private WebElement lnk_addSubtract;
	

	public WebElement getLnk_getStarted() {
		return lnk_getStarted;
	}

	public WebElement getLnk_start() {
		return lnk_start;
	}

	public WebElement getLnk_startExcercise() {
		return lnk_startExcercise;
	}

	public WebElement getLnk_addSubIntro() {
		return lnk_addSubIntro;
	}

	public WebElement getTxt_yourAnswer() {
		return txt_yourAnswer;
	}

	public WebElement getBtn_checkAnswer() {
		return btn_checkAnswer;
	}

	public WebElement getAlert_feedBack() {
		return alert_feedBack;
	}
	
	
}
