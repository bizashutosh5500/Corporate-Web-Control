package com.cwc.testCase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cwc.pageobjects.LoginPage;
import com.cwc.utilites.XLSUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002  extends BaseClass
{
    @Test (dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
    	LoginPage lp=new LoginPage(driver);
    	driver.manage().window().maximize();
		driver.get(baseURL);
    	lp.setUsername(user);
    	logger.info("Key no provided");
    	lp.setPasswoard(pwd);
    	logger.info("Password provided");
    	lp.clickLogin();
    	Thread.sleep(2000);
    	String errormsg=driver.findElement(By.xpath("//span[contains(.,'Invalid User / Password / Access Denied')]")).getText();
    	if(errormsg.equals("Invalid User / Password / Access Denied"))
    	{
    		Assert.assertTrue(false);
    		logger.warn("Login Failed");
    	}
    	else
    	{
    		Assert.assertTrue(true);
    		logger.info("Login Passed");
    		//driver.findElement(By.xpath("//span[contains(.,'LogOut')]")).click();
    		lp.clickLogout();
    		
    	}
		
	}
    
    @DataProvider (name="LoginData")
    public String[][] getData() throws IOException
    {
    	//String path=System.getProperty("user.dir")+"src/test/java/com/cwc/testdata/SeleniumTest.xlsx";
    	String path="F:/QSpider/com.cwc/src/test/java/com/cwc/testdata/SeleniumTest.xlsx";
    	int rownum=XLSUtils.getRowCount(path, "CWCTestData");
    	int colcount=XLSUtils.getCellCount(path, "CWCTestData", 1);
    	String logindata [][]= new String[rownum][colcount];
    	
    	for(int i=1;i<=rownum;i++)
    	{
    		for(int j=0;j<colcount;j++)
    		{
    			logindata[i-1][j]=XLSUtils.getCellData(path, "CWCTestData", i, j);
    		}
    	}
    	return logindata;
    	
    }
	
}
