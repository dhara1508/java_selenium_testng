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

public class Addtocartway2 {

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

        for (WebElement product : products) {
            WebElement productNameElement = product.findElement(By.cssSelector("h5 > b"));
            String productName = productNameElement.getText();
            
            // Check if the product name contains "adidas original"
            if (productName.contains("ADIDAS ORIGINAL")) {
            	System.out.println("String -> : " + productName);
            
            	// Find and click the two buttons associated with the product
                List<WebElement> buttons = product.findElements(By.cssSelector("button"));
                if (buttons.size() >= 2) {
                    buttons.get(1).click(); // Click the second button
                    System.out.println("Clicked the buttons for " + productName);
                } 
            }
        }
	}
}
