package NavnathLohar.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test001 {
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
     //   String productName= "ZARA COAT 3";
		System.setProperty("Webdriver.Chrome.driver", "D:\\Selenium_jars\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("www.google.com");

}
}