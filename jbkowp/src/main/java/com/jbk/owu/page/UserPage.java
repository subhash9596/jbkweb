package com.jbk.owu.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage {
	
	@FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-sm pull-right']")
	private static WebElement btn_Adduser;
	
	@FindBy(xpath="//*[@id='username']")
	private static WebElement txt_Username;

	@FindBy(xpath="//*[@id='mobile']")
	private static WebElement txt_Mobile;
	
	@FindBy(xpath="//*[@id='email']")
	private static WebElement txt_Email;
	
	@FindBy(xpath="//*[@id='course']")
	private static WebElement txt_Course;
	
	@FindBy(xpath="//*[@id='Male']")
	private static WebElement btn_radios_Male;
	
	@FindBy(xpath="//*[@id='Female']")
	private static WebElement btn_radios_Female;
	
	@FindBy(xpath="/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select")
	private static WebElement dropdown_State;
	
	@FindBy(xpath="//*[@id='password']")
	private static WebElement txt_Password;
	
	@FindBy(xpath="//*[@id='submit']")
	private static WebElement btn_Submit;
	
	@FindBy(xpath="/html/body/div/div[1]/section[2]/div/div/div/form/div[2]/a/span")
	private static WebElement btn_Cancel;
	
	@FindBy(xpath="//section[1]/h1")
	private static WebElement title_AddUser;
	
	@FindBy(xpath="/a[@href='users.html']")
	private static WebElement link_User;
	
	public static WebElement getLink_User() {
		return link_User;
	}

	public static WebElement getBtn_Adduser() {
		return btn_Adduser;
	}

	public static WebElement getTxt_Username() {
		return txt_Username;
	}

	public static WebElement getTxt_Mobile() {
		return txt_Mobile;
	}

	public static WebElement getTxt_Email() {
		return txt_Email;
	}

	public static WebElement getTxt_Course() {
		return txt_Course;
	}

	public static WebElement getBtn_radios_Male() {
		return btn_radios_Male;
	}

	public static WebElement getBtn_radios_Female() {
		return btn_radios_Female;
	}

	public static WebElement getDropdown_State() {
		return dropdown_State;
	}

	public static WebElement getTxt_Password() {
		return txt_Password;
	}

	public static WebElement getBtn_Submit() {
		return btn_Submit;
	}

	public static WebElement getBtn_Cancel() {
		return btn_Cancel;
	}

	public static WebElement getTitle_AddUser() {
		return title_AddUser;
	}
	
	}


