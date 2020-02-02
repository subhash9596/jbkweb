package com.jbk.owu.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jbk.owp.base.TestBase;

public class UsefulLinkPage extends TestBase {

	public UsefulLinkPage() {
		super();
		PageFactory.initElements(driver,this);
	}


	@FindBy(xpath="//a[@href='https://www.javabykiran.com/news']")
	private static WebElement Schedulelink;

	@FindBy(xpath="//a[@href='https://www.javabykiran.com/java-by-kiran-videos']")
	private static WebElement Video_Lactures;

	@FindBy(xpath="//a[@href='https://www.javabykiran.com/selenium-testing-interview-question-answer']")
	private static WebElement Selenium_Interview;

	@FindBy(xpath="//a[@href='https://www.javabykiran.com/core-java-interview-question-answer']")
	private static WebElement Java_Interview;

	@FindBy(xpath="//a[@href='https://www.javabykiran.com/courses']")
	private static WebElement Courses;

	@FindBy(xpath="//a[@href='https://www.javabykiran.com/placement']")
	private static WebElement Placement;

	public static WebElement getSchedulelink() {
		return Schedulelink;
	}

	public static WebElement getVideo_Lactures() {
		return Video_Lactures;
	}

	public static WebElement getSelenium_Interview() {
		return Selenium_Interview;
	}

	public static WebElement getJava_Interview() {
		return Java_Interview;
	}

	public static WebElement getCourses() {
		return Courses;
	}

	public static WebElement getPlacement() {
		return Placement;
	}



}
