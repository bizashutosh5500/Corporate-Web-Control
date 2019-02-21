package com.cwc.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cwc.pageobjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void LoginTest() throws IOException
	{
		driver.manage().window().maximize();
		driver.get(baseURL);
		logger.info("URL is open");
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(KeyNo);
		logger.info("Enterd Key No");
		
		lp.setPasswoard(password);
		logger.info("Entered Password");
		lp.clickLogin();
		
		//String title=driver.getTitle();
		//System.out.println(title);
		if(driver.getTitle().equals("Corporate Login"))
		{
			Assert.assertTrue(true);
			logger.info("Login test Passed");
		}
		else
		{
			capturescreen(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("Login test Failed");
			
		}
		
		
	}
	

}
