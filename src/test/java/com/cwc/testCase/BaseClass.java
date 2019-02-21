package com.cwc.testCase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.cwc.utilites.ReadConfig;



public class BaseClass
{
	//public String baseURL="http://srv11.corpwebcontrol.com/CorpWebControl/Login.aspx";
	//public String KeyNo="C-9876543210";
	//public String password="bizsecure";
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationUrl();
	public String KeyNo=readconfig.getKeyNo();
	public String password=readconfig.getpassowrd();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void SetUp(String br)
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		logger=Logger.getLogger("Corp Web Control");
		PropertyConfigurator.configure("Log4j.properties");
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
			driver=new ChromeDriver();
				
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxpath());
			driver=new FirefoxDriver();
			
		}
		else if (br.equals("ie"))
		{
			System.setProperty("webdriver.MicrosoftWebdriver.driver", readconfig.getiepath());
			driver=new EdgeDriver();
			
		}
		
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
	
	public void capturescreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=	(TakesScreenshot) driver; 
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir") + "/Screenshots/" + tname +".png");
		FileUtils.copyFile(source, target);
		System.out.println("Scrrenshot Taken");
	}

}
