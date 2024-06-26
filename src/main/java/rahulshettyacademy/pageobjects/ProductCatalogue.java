package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	WebDriver driver;
	String productName="ZARA COAT 3";
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css="..ng-animating")
	WebElement spinner;
	
	
	By productsBy=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	


	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
		
	}
	
		
	public WebElement getProductByName(String productName)
		{
			WebElement prod=getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
			
//			System.out.println(prod.getText());
			return prod;
		}
	
	public void addProductToCart(String productName){
	
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
//		System.out.println(toastMessage);
//		waitForElementToDisappear(spinner);
	
	}
	
}

