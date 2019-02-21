package com.cwc.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig
{
	Properties prop;
	public ReadConfig() 
	{
	File src=new File("./Configuration/config.properties");
	
	try {
		FileInputStream fis = new FileInputStream(src);
		prop=new Properties();
		prop.load(fis);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Exception is " + e.getMessage());

	}
	
		
	}
	
	public String getApplicationUrl()
	{
		String url=prop.getProperty("baseURL");
		return url;
	}
	
	public String getKeyNo()
	{
		String keyno=prop.getProperty("KeyNo");
		return keyno;
	}
	
	public String getpassowrd()
	{
		String pass=prop.getProperty("password");
		return pass;
	}
	
	public String getChromepath()
	{
		String chrompath=prop.getProperty("chromepath");
		return chrompath;
	}
	public String getiepath()
	{
		String iepath=prop.getProperty("iepath");
		return iepath;
	}
	public String getfirefoxpath()
	{
		String FFpath=prop.getProperty("firefoxpath");
		return FFpath;
	}
	
	

}
