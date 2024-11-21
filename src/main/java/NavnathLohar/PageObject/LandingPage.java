package NavnathLohar.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NavnathLohar.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		// Initiliazation
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	// WebElement userEmail=driver.findElement(By.id("userEmail"));

	// >>>>>Page factory

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement submitbtn;
	
	@FindBy(css="[class=''flyInOut']")
	WebElement errorMessage;

	public ProductCatlogue loginApplication(String email, String password) {
		userEmail.sendKeys("navnathtlohar@gmail.com");
		userPassword.sendKeys("Navnath@1996");
		submitbtn.click();

		ProductCatlogue productCatlogue = new ProductCatlogue(driver);
		return productCatlogue;
	}
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		
	}
	

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}
