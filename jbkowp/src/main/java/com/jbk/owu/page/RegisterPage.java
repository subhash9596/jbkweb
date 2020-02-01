package com.jbk.owu.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jbk.owp.base.TestBase;

public class RegisterPage extends TestBase  {
	
	public RegisterPage() {
		super();
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "/html/body/div/div[2]/a")
	private static WebElement link_RegisterMemberlink;

	@FindBy(xpath = "/html/body/div/div[1]/a/b")
	private static WebElement text_ExpRegisterMemberlink;
	
	@FindBy(xpath = "//*[@id='name']")
	private static WebElement PlaceholderName;

	@FindBy(xpath = "//*[@id='mobile']")
	private static WebElement PlaceholderMobile;

	@FindBy(xpath = "//*[@id='email']")
	private static WebElement PlaceholderEmail;

	@FindBy(xpath = "//*[@id='password']")
	private static WebElement PlaceholderPassword;
	
	@FindBy(xpath = "//*[@id='form']/div[5]/div/button")
	private static WebElement btn_signin;
	
	@FindBy(xpath = "/html/body/div/div[2]/a")
	private static WebElement link_alreadyMember;
	
	@FindBy(xpath = "//*[@id='name_error']")
	private static WebElement text_ErrormsgName;

	@FindBy(xpath = "//*[@id='mobile_error']")
	private static WebElement text_ErrormsgMobile;
	
	@FindBy(xpath = "//*[@id='email_error']")
	private static WebElement text_ErrormsgEmail;
	
	@FindBy(xpath = "//*[@id='password_error']")
	private static WebElement text_ErrormsgPwd;
	
	@FindBy(xpath = "/html/body/div/div[2]/a")
	private static WebElement click_AlreadyMembership;
	
	

	public static WebElement getLink_RegisterMemberlink() {
		return link_RegisterMemberlink;
	}

	public static WebElement getText_ExpRegisterMemberlink() {
		return text_ExpRegisterMemberlink;
	}

	public static WebElement getPlaceholderName() {
		return PlaceholderName;
	}

	public static WebElement getPlaceholderMobile() {
		return PlaceholderMobile;
	}

	public static WebElement getPlaceholderEmail() {
		return PlaceholderEmail;
	}

	public static WebElement getPlaceholderPassword() {
		return PlaceholderPassword;
	}

	public static WebElement getBtn_signin() {
		return btn_signin;
	}
	public static WebElement getLink_alreadyMember() {
		return link_alreadyMember;
	}
	public static WebElement getText_ErrormsgName() {
		return text_ErrormsgName;
	}

	public static WebElement getText_ErrormsgMobile() {
		return text_ErrormsgMobile;
	}

	public static WebElement getText_ErrormsgEmail() {
		return text_ErrormsgEmail;
	}

	public static WebElement getText_ErrormsgPwd() {
		return text_ErrormsgPwd;
	}
	public static WebElement getClick_AlreadyMembership() {
		return click_AlreadyMembership;
	}
	
	
}
