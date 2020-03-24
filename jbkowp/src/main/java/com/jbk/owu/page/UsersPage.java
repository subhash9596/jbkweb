package com.jbk.owu.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jbk.owp.base.TestBase;

public class UsersPage extends TestBase {
	

	public UsersPage() {
		super();
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath = "//table[@class='table table-hover']")
	private static WebElement User_Table;
	
	@FindBy(xpath = "//span[@class='label label-danger']")
	private static WebElement delete;

	
	public static WebElement getUser_Table() {
		return User_Table;
	}

	public static WebElement getDelete() {
		return delete;
	}
	
	
}
