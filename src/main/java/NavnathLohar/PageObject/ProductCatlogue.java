package NavnathLohar.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NavnathLohar.AbstractComponents.AbstractComponent;

public class ProductCatlogue extends AbstractComponent {

	WebDriver driver;

	public ProductCatlogue(WebDriver driver) {
		// Initiliazation
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	// WebElement userEmail=driver.findElement(By.id("userEmail"));

	// >>>>>Page factory

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
		WebElement spinner;

	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		By productsBy = By.cssSelector(".mb-3");
		waitForElementToAppear(productsBy);
		return products;
	}

	public WebElement getProductName(String productName) {
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;
	}

	public void addProductToCart(String productName) {
		WebElement prod = getProductName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	}

}
