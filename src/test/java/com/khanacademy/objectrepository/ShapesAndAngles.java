package com.khanacademy.objectrepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.khanacademy.resources.FunctionalLibrary;

public class ShapesAndAngles {

	public ShapesAndAngles() {
		PageFactory.initElements(FunctionalLibrary.driver, this);
	}

	@FindBy(xpath = "//div[@data-test-id='lesson-card']//a[@href]/div[2]/div/span")
	private List<WebElement> list_videoLnk;

	@FindBy(xpath = "//div[@data-test-id='lesson-card']//a[@href]/span")
	private List<WebElement> list_practiceLnk;

	public List<WebElement> getList_videoLnk() {
		return list_videoLnk;
	}

	public List<WebElement> getList_practiceLnk() {
		return list_practiceLnk;
	}

}
