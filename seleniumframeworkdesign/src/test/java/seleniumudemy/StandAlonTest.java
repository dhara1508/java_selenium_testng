package seleniumudemy;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumframeworkdesign.abstaract.Abstractcomponant;
import seleniumframeworkdesign.pageobject.LandingPage;
import seleniumframeworkdesign.pageobject.ProductCataloguePage;

public class StandAlonTest {
 
	public static void main(String[] args) throws InterruptedException {
		String productname = "IPHONE 13 PRO";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		LandingPage LandingPage = new LandingPage(driver);
		LandingPage.goTo();
		LandingPage.loginapplication("dhara.itaims@gmail.com", "Dhara@1234");
		
		ProductCataloguePage ProductCataloguePage = new ProductCataloguePage(driver);
		List<WebElement> products = ProductCataloguePage.getproductlist();
		
		ProductCataloguePage.addProductToCart(productname);
		
		ProductCataloguePage.goToCartPage();
		
		List<WebElement> cartproduct = driver.findElements(By.cssSelector(".cart h3"));
		
		boolean match = cartproduct.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions country = new Actions(driver);
		country.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
				
		driver.findElement(By.cssSelector(".ta-item:nth-child(3)")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String confirmMessage = driver.findElement(By.tagName("h1")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		
		driver.close();
        }
	}
