package com.jbk.owu.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jbk.owp.base.TestBase;

public class CoursesOfferedPage extends TestBase {

	public CoursesOfferedPage() {
		super();
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//a[href='../pdf/selenium-testing-syllabus-jbk.pdf']")
	private static WebElement SeleniumMoreInfo;
	
	@FindBy(xpath="//a[href='../pdf/java-j2ee-syllabus-jbk.pdf']")
	private static WebElement JavaMoreInfo;
	
	@FindBy(xpath="href='../pdf/python-syllabus.pdf']")
	private static WebElement PaythonMoreInfo;
	
	@FindBy(xpath="//a[href='#'target='_blank']")
	private static WebElement HHPMoreInfo;

	public static WebElement getSeleniumMoreInfo() {
		return SeleniumMoreInfo;
	}

	public static WebElement getJavaMoreInfo() {
		return JavaMoreInfo;
	}

	public static WebElement getPaythonMoreInfo() {
		return PaythonMoreInfo;
	}

	public static WebElement getHHPMoreInfo() {
		return HHPMoreInfo;
	}
	
	
}
 