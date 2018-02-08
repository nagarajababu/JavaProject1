package generic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AutoUtil
{
public static String getProperty(String path, String key)
{
	String v="";
	try
	{
	Properties p = 	new Properties();
	p.load(new FileInputStream(path));
	v=p.getProperty(key);	
	}
	catch (Exception e)
	{
		
	}
	return v;
}


public static void getPhoto(WebDriver driver, String folder, String testName)
{
	Date d = new Date();
	String s = d.toString();
	String dateTime = s.replaceAll(":", "_");
	String path = folder+testName+dateTime+".png";
	TakesScreenshot t =(TakesScreenshot)driver;
	File sreFile=t.getScreenshotAs(OutputType.FILE);
	File destFile= new File(path);
	try{
		FileUtils.copyFile(sreFile,destFile);
	}
	catch(Exception e)
	{
		
	}
}
}
