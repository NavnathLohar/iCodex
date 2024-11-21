package NavnathLohar.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import NavnathLohar.PageObject.LandingPage;

public class BaseTest01 {

	public WebDriver driver;
	public LandingPage landingPage;
	
	@BeforeMethod
	public WebDriver initialiazeDriver() throws IOException
	
	
	{
		
		//properties clss
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//NavnathLohar//resources//GlobalData.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
	      
			System.setProperty("Webdriver.Chrome.driver", "D:\\Selenium_jars\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
		} 
		else if(browserName.equalsIgnoreCase("firefox"))
				{
			//Firefox
				}
		else if(browserName.equalsIgnoreCase("edge"))
		{
	//edge
			System.setProperty("Webdriver.edge.driver", "edge.exe");
			 driver =new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	
	}
	
	
	//public LandingPage launchApplication() throws IOException
	//{
	//	 driver = initialiazeDriver();
		// landingPage = new LandingPage(driver);
		 //landingPage.goTo();
		 //return landingPage;
	//}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
		
	}
	
}
