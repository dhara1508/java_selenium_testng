package seleniumudemy;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Addtocartway1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.id("userEmail")).sendKeys("dhara.itaims@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Dhara@1234");
		driver.findElement(By.id("login")).click();
		
		By productLocator  = By.cssSelector("div.col-lg-4.col-md-6.col-sm-10.offset-md-0.offset-sm-1.mb-3.ng-star-inserted");
		List<WebElement> products = driver.findElements(productLocator);

		
		WebElement prod = products.stream()
                .filter(product -> {
                    WebElement productNameElement = product.findElement(By.cssSelector("h5 > b"));
                    String productName = productNameElement.getText();
                    return productName.toUpperCase().contains("ADIDAS ORIGINAL");
                })
                .findFirst()
                .orElse(null);
	 {
            
            // Find and click the button associated with the product
            WebElement addToCartButton = prod.findElement(By.cssSelector("button.w-10"));
            addToCartButton.click();
        }


	
	}

}
