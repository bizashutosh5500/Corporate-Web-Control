package com.cwc.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	
	}
	
	@FindBy (xpath="//input[@name='txtKeyNo']")
	WebElement txtKeyNo;
	
	@FindBy (xpath="//input[@name='txtPassword']")
	WebElement txtPassword;
	
	@FindBy (name="btnLogin")
	WebElement btnLogin;
	
	@FindBy (xpath="//span[contains(.,'LogOut')]")
	WebElement btnLogout;
	
	public void setUsername(String keyno)
	{
		txtKeyNo.sendKeys(keyno);
	}
	
	public void setPasswoard(String pass)
	{
		txtPassword.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}

	public void clickLogout()
	{
		btnLogout.click();
	}

}
