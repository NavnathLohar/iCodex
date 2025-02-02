package NavnathLohar.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

import NavnathLohar.PageObject.LandingPage;
import net.bytebuddy.jar.asm.TypeReference;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;
	
	@BeforeMethod(alwaysRun=true)
	public WebDriver initialiazeDriver() throws IOException
	
	
	{
		
		//properties clss
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//NavnathLohar//resources//GlobalData.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
	      
			System.setProperty("Webdriver.Chrome.driver", "D:\\Selenium_jars\\chromedriver-win64\\chromedriver.exe");
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
	
	public List<HashMap<String,String>> getJsonDataToMap(String filePath) throws IOException
	{
		String jsonContent= FileUtils.readFileToString(new File(filePath),
				StandardCharsets.UTF_8);
	
	
	//String hashmap jackson databind
		
		ObjectMapper mapper=new ObjectMapper();
		
	List<HashMap<String, String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
	});
		return data;
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
