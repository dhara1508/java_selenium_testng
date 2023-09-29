package seleniumframeworkdesign.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumframeworkdesign.abstaract.Abstractcomponant;

public class ProductCataloguePage extends Abstractcomponant{

	WebDriver driver;
	
	public ProductCataloguePage(WebDriver driver)
	{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

	//List<WebElement> products= driver.findElements(By.cssSelector("div.col-lg-4.col-md-6.col-sm-10.offset-md-0.offset-sm-1.mb-3.ng-star-inserted"));
	@FindBy(css="div.col-lg-4.col-md-6.col-sm-10.offset-md-0.offset-sm-1.mb-3.ng-star-inserted")
	List<WebElement> products;
	By productBy = By.cssSelector("h5 > b");
	By addToCart = By.cssSelector("button.w-10");
	By tostMessage = By.cssSelector("div.toast-message");
	
	@FindBy(css=".ng-animating")
	WebElement spinner; 
	
	public List<WebElement> getproductlist() 
	{
		waitForElementToAppear(productBy);
		return products;
	}
	
	public WebElement getProductByName(String productname) 
	{
		WebElement prod = getproductlist().stream().filter(product->product.findElement(By.cssSelector("h5 > b"))
			.getText().equals(productname)).findFirst().orElse(null);
		return prod;
	} 
	public void addProductToCart(String productname) throws InterruptedException {
		WebElement prod = getProductByName(productname);
		prod.findElement(addToCart).click();
		waitForElementToAppear(tostMessage);
		waitForElementToDisappear(spinner);
	}
	
}
