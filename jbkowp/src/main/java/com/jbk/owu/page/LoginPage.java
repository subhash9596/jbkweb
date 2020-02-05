package com.jbk.owu.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.jbk.owp.base.TestBase;
import com.jbk.owu.util.Reports;
public class LoginPage extends TestBase  {
	
	public LoginPage() {
		super();
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "/html/body/div/div[1]/a/b ")
	private static WebElement text_title;

	@FindBy(xpath = "/html/body/div/div[2]/p")
	private static WebElement text_Loignsession;

	@FindBy(xpath = "//*[@id='email']")
	private static WebElement Email;

	@FindBy(xpath = "//*[@id='password']")
	private static WebElement Password;

	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	private static WebElement btn_signcolor;

	@FindBy(xpath = "//*[@id='form']/div[3]/div/button")
	private static WebElement butn_Signin;
    
	@FindBy(xpath = "//*[@id='email_error']")
	private static WebElement msg_erroremail;
	
	@FindBy(xpath = "//*[@id='password_error']")
	private static WebElement msg_errorpwd;


	public static WebElement getMsg_erroremail() {
		return msg_erroremail;
	}

	public static WebElement getMsg_errorpwd() {
		return msg_errorpwd;
	}

	public static WebElement getText_title() {
		return text_title;
	}

	public static WebElement getText_Loignsession() {
		return text_Loignsession;
	}

	public static WebElement getEmail() {
		return Email;
	}

	public static WebElement getPassword() {
		return Password;
	}

	public static WebElement getBtn_signcolor() {
		return btn_signcolor;
	}

	public static WebElement getButn_Signin() {
		return butn_Signin;
	}
	
	public DashboardPagee login(String username,String pwd)throws IOException
	{
		Email.clear();
		Email.sendKeys(username);
	    Password.clear();
	    Password.sendKeys(pwd);
	    butn_Signin.click();
		return new DashboardPagee();
		
	}
	public static  RegisterPage regpage(){
		driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
		return new  RegisterPage();
			
	}
}