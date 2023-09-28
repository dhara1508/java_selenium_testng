		/*Product add to cart with Arraylist , implicitlyWait, Explicit wait */

package learning;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class addcartarraylist {
	public static void main(String[] args) throws InterruptedException {
		
		String[] vegnames = {"Cucumber", "Brocolli", "Beetroot"};
		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//addItem(driver,vegnames);
		addcartarraylist a = new addcartarraylist();
		a.addItem(driver, vegnames);
		driver.findElement(By.xpath("//img[@alt=\"Cart\"]")).click();
		driver.findElement(By.xpath("//button[text()=\"PROCEED TO CHECKOUT\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();	
		//Explicit wait 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("span.promoInfo")).getText(), "Code applied ..!");
		driver.close();
		}

	
	public static void addItem(WebDriver driver, String[] vegnames) throws InterruptedException {
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector(".product"));
		//Thread.sleep(5000L);
		for (int i = 0; i < products.size(); i++) {
			Thread.sleep(2000L);
			String[] name = products.get(i).getText().split("-");
			String formattedname = name[0].trim();
			List listItem = Arrays.asList(vegnames);

			if (listItem.contains(formattedname)) {
				j++;

				driver.findElements(By.xpath("//div[@class=\"product-action\"]//button")).get(i).click();
				if (j == vegnames.length) {
					break;
				}
			}
		}
	}
	
}
