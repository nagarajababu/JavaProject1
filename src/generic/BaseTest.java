package generic;

import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.language.bm.Lang;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements IAutoConst

{
	public WebDriver driver;
	private String ITO;
	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}

	@BeforeMethod
	public void openApplication()
	{
		driver= new ChromeDriver();
		//driver.get("http://localhost/login.do");
		String  appURL= AutoUtil.getProperty(CONFIG_PATH,"appURL");
		driver.get(appURL);
		String sITO=AutoUtil.getProperty(CONFIG_PATH, ITO);
		long ITO=Long.parseLong(sITO);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeApplication(ITestResult r)
	{
		String testName = r.getName();
		int status = r.getStatus();
		if(status==2)
		{
			AutoUtil.getPhoto(driver, PHOTO_PATH, testName);
		}
		driver.close();
	}
}
