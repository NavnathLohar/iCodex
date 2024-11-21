package NavnathLohar.tests;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import NavnathLohar.PageObject.CartPage;
import NavnathLohar.PageObject.CheckOutPage;
import NavnathLohar.PageObject.ConfirmationPage;
import NavnathLohar.PageObject.LandingPage;
import NavnathLohar.PageObject.ProductCatlogue;
import NavnathLohar.TestComponents.BaseTest;

public class ErrorValidationTest extends BaseTest {

	
@Test (groups= {"ErrorHandling"})
public void ErrorValidation() throws IOException, InterruptedException
{
		String productName = "ZARA COAT 3";
	
		landingPage.loginApplication("navnalohar@gmail.com", "Navnath@1999");
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
		


	}

}
