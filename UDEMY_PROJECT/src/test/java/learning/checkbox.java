								/* Select Check box with assertion */
package learning;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class checkbox {
	
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// Select the checkbox
		//Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		Assert.assertFalse(false);
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		// Count the how many checkbox on page
		System.out.println(driver.findElements(By.cssSelector("input[type=\"checkbox\"]")).size());
		
//Radio button check with enabled disabled mode with if - else 
		
		System.out.println(driver.findElement(By.className("picker-second")).getAttribute("style"));
		//Thread.sleep(1000L);
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.className("picker-second")).getAttribute("style"));
		if (driver.findElement(By.className("picker-second")).getAttribute("style").contains("1"))
				{
					System.out.println("Is Enabled");
					Assert.assertTrue(true);					
				}
		else 	{
					System.out.println("Is Disabled");
					Assert.assertFalse(false);
				}		
		
		driver.close();
	}
	}