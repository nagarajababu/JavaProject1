package generic;

import org.junit.Assert;
import org.junit.Test;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Properties;
//
//public class Demo 
//{
//	public static void main(String[] args) throws Exception {
//		Properties p = new Properties();
//		p.load(new FileInputStream("./qsp.properties"));
//		String v = p.getProperty("temp");
//		System.out.println(v);
//	}
//}


public class Demo
{
	@Test
	public void testA()
	{
		Reporter.log("Qsp",true);
	}
	@Test
	public void testB()
	{
		Reporter.log("Jsp",true);
		Assert.fail();
	}
	@AfterMethod
	public void end(ITestResult r)
	{
		String name = r.getName();
		int status = r.getStatus();
		
		if(status==1)
		{
			Reporter.log("The Test:"+name+" is Pass",true);
		}
		else
		{
	Reporter.log("the test:"+name+" is failed ",true);
	}
	}
}