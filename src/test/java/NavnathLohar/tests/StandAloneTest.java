package NavnathLohar.tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import NavnathLohar.PageObject.CartPage;
import NavnathLohar.PageObject.CheckOutPage;
import NavnathLohar.PageObject.ConfirmationPage;
import NavnathLohar.PageObject.LandingPage;
import NavnathLohar.PageObject.OrderPage;
import NavnathLohar.PageObject.ProductCatlogue;
import NavnathLohar.TestComponents.BaseTest;

public class StandAloneTest extends BaseTest {
	String productName = "ZARA COAT 3";
	
@Test(dataProvider="getData", groups="Purchase") 
public void StandAlone(HashMap<String, String>input) throws IOException, InterruptedException
{
	
	
		ProductCatlogue productCatlogue = landingPage.loginApplication(input.get("email"), input.get("password"));
        List<WebElement> products = productCatlogue.getProductList();
		productCatlogue.addProductToCart(input.get("productName"));
		CartPage cartPage = productCatlogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay("productName");
		Assert.assertTrue(match);
		
		CheckOutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));


	}

@Test(dependsOnMethods= {"StandAlone"})
public void OrderHistoryTest()
{
	ProductCatlogue productCatlogue = landingPage.loginApplication("navnathtlohar@gmail.com", "Navnath@1996");
	OrderPage ordersPage=productCatlogue.goToOrderPage();
	Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
}

@DataProvider
public Object [] [] getData() throws IOException
{

	
List<HashMap<String,String>> data= getJsonDataToMap(System.getProperty("user.dir")+"//src//test//"
		+ "java//NavnathLohar//data//StandAlone.json");
	
return new Object[] [] {{data.get(0)}, {data.get(1)}};
}

public String getScreenshot( String testCaseName) throws IOException
{
TakesScreenshot ts=(TakesScreenshot)driver;	
File source=ts.getScreenshotAs(OutputType.FILE);

File file=new File(System.getProperty("user.dir")+ "//reports"+ testCaseName+ ".png");
FileUtils.copyFile(source, file);
return System.getProperty("user.dir")+ "//reports"+ testCaseName+ ".png";
}


//
//HashMap<String, String> map=new HashMap <String, String>();
//map.put("email", "navnathtlohar@gmail.com");
//map.put("password","Navnath@1996");
//map.put("productName", "ZARA COAT 3");
//
//HashMap<String, String> map1=new HashMap <String, String>();
//map1.put("email", "shetty@gmail.com");
//map1.put("password","Shetty@123");
//map1.put("productName", "ADIDAS ORIGINAL");










}
