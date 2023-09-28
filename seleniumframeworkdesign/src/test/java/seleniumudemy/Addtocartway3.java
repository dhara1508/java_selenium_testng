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

public class Addtocartway3 {
 
	public static void main(String[] args) throws InterruptedException {
		String productname = "IPHONE 13 PRO";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.id("userEmail")).sendKeys("dhara.itaims@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Dhara@1234");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.col-lg-4.col-md-6.col-sm-10.offset-md-0.offset-sm-1.mb-3.ng-star-inserted")));
		List<WebElement> products= driver.findElements(By.cssSelector("div.col-lg-4.col-md-6.col-sm-10.offset-md-0.offset-sm-1.mb-3.ng-star-inserted"));
		
		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("h5 > b"))
				.getText().equals(productname)).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector("button.w-10")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.toast-message")));
		//Loading time 
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("[routerlink=\"/dashboard/cart\"]")).click();
		
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
