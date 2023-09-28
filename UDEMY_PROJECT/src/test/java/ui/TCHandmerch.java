package ui;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.dockerjava.api.model.Driver;

public class TCHandmerch {

	public static void main(String[] args) throws InterruptedException {
		String emilid = "dhara.itaims@gmail.com";
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

		 System.setProperty("webdriver.chrome.driver", "C://browserdrivers//chromedriver.exe");
		 WebDriver driver = new ChromeDriver();

		 //WebDriver driver = new FirefoxDriver();

		//WebDriver driver = new EdgeDriver();

		driver.get("https://handmerch.in/");
		
//TC_1 : Verify the site navigate from the google		
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.navigate().to("https://handmerch.in");
		driver.navigate().back();
		driver.navigate().forward();

//TC_2 : Verify the title of application 	

		System.out.println(driver.getTitle());

//TC_3 : Verify the URL of application 	

		System.out.println(driver.getCurrentUrl());

		// (//i[@class="mx-1 bi bi-chevron-up"])[2]
		
//TC_4 : Verify the Click on forgot password link 
		
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.findElement(By.xpath("//button[text()=\" Login \"]")).click();
			driver.findElement(By.linkText("Forgot Password?")).click();
			driver.findElement(By.id("inputEmail4")).sendKeys(emilid);
			driver.findElement(By.xpath("//span[text()=' Reset Password ']")).click();
			System.out.println(driver.findElement(By.xpath("//p[text()='We have sent you a link to reset your password']")).getText());		
		
//TC_5 : Verify the login into the application 	
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//driver.findElement(By.xpath("//button[text()=\" Login \"]")).click();
		driver.findElement(By.xpath("//input[@id=\"inputEmail4\"]")).sendKeys(emilid);     //Using declared variable
		driver.findElement(By.xpath("//input[@id=\"pwd\"]")).sendKeys("Dhara@1234");
		// driver.findElement(By.id("pwd")).sendKeys("Dhara@1234");
		driver.findElement(By.xpath("//button[text()=\"Sign In\"]")).click();
		//Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,\"v-toast__item v-toast__item--success v-toast__item--bottom-right\")]")).getText(), "User successfully logged in.");
		// driver.findElement(By.xpath("\"//p[text()='User successfully logged
		// in.']\"")).getText();
		//System.out.println("User successfully logged in.");
		
//TC_11 : Verify the functionality of adding and managing items in the user's wishlist
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()=\"Home\"]")).click();
		System.out.println(driver.findElement(By.cssSelector("div.product-desc")).getText());
		driver.findElement(By.cssSelector("div.product-desc")).click();
//		driver.findElement(By.xpath("(//i[@class=\"bi bi-heart\"])[2]")).isSelected();
 
// TC_6 : Verify the by default currency
//
//		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
//		driver.findElement(By.xpath("//div[@class='product-prise']")).getText();
//		if (contains("$")) {
//			System.out.println("Currency sign $ is present on the product price.");
//		} else {
//			System.out.println("Currency sign $ is not present on the product price.");
//		}
		

//TC_7 : Verify the search product

		//driver.get("https://handmerch.in/");
		driver.findElement(By.xpath("//a[text()=\"Home\"]")).click();
		driver.findElement(By.xpath("(//input[@placeholder='Search....'])[1]")).sendKeys("chair");
		driver.findElement(By.xpath("(//i[@class=\"bi bi-search search-icon\"])[1]")).click();
		driver.findElement(By.xpath("//i[@class='float-end bi bi-chevron-down']")).click();
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		driver.findElement(By.className("product-name")).getText();
		WebElement productNameElement = driver.findElement(By.className("product-name"));
		String productName = productNameElement.getText();
		System.out.println(productName);

//TC_8 : Verify the product add into add cart	
		
		driver.findElement(By.xpath("((//div[text()='Bucklo Wrop Wooden Chair'])[1]//parent::div//..)[1]")).click();
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//      jsExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		driver.findElement(By.xpath("//button[text()=\"Add To Cart\"]")).click();
		System.out.println(driver.findElement(By.xpath("//span[@class=\"quantit-input\"]")).getText());
		
//TC_9 : Verify the added product displayed into cart 
		
		driver.findElement(By.xpath("//i[@class='bi bi-cart3 position-relative']")).click();
		WebElement searchProduct = driver.findElement(By.xpath("//h3[text()='Shopping Cart']//following::div//div//div//ul//li//span//div//div//div[text()=\"Bucklo Wrop Wooden Chair\"]"));
		System.out.println(searchProduct.getText());
		driver.findElement(By.xpath("//a[@id=\"DropdownMenuUSD\"]")).click();
		driver.findElement(By.xpath("//span[text()='INR']")).click();
		
//Tc_10 : Verify the add quantity from the shopping cart page
		//Using with while loop
		Thread.sleep(5000L);
		/*int i=1;
		while (i<5)
		driver.findElement(By.xpath("//i[@class=\"bi bi-plus-lg\"]/parent::button[@class=\"countbtn\"]")).click();
		i++;*/
		// Using with for loop 
		System.out.println(driver.findElement(By.className("quantit-input")).getText());
		for (int i=0;i<5;i++)
			driver.findElement(By.xpath("//i[@class=\"bi bi-plus-lg\"]/parent::button[@class=\"countbtn\"]")).click();
		Thread.sleep(3000L);
		System.out.println(driver.findElement(By.className("quantit-input")).getText());
		
//TC_9 : Verify the proceed to checkout	with pay with Debit/Credit/ATM cards with Stripe
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[text()='Proceed to Checkout']")).click();
		driver.findElement(By.id("stripe")).click();	
		driver.findElement(By.xpath("(//button[@type=\"button\"])[4]"));
        
//TC_10 : Verify the Logout functionality
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//i[@class=\"bi bi-person\"]")).click();
		driver.findElement(By.xpath("//p[text()=\"Logout\"]")).click();
		driver.findElement(By.xpath("//button[text()=\"Logout\"]")).click();


		
		
		
		

		 driver.close(); // Use for close current window
		// driver.quit(); // Use for close all open window 
	}
}
