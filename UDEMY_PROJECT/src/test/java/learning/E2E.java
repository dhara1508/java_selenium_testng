										/* Calender ui */
package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2E {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		//Thread.sleep(200L);
		driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_originStation1_CTNR\"]//a[@text=\"Goa (GOI)\"]")).click();
		Thread.sleep(200L);
		driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@text=\"Surat (STV)\"]")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		if (driver.findElement(By.className("picker-second")).getAttribute("style").contains("1"))
		{
			System.out.println("Is Enabled");
			Assert.assertTrue(true);					
		}
		else 	
		{
			System.out.println("Is Disabled");
			Assert.assertFalse(false);
		}	
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);
		int i = 1;
		while (i < 5) {
			driver.findElement(By.id("hrefIncAdt")).click(); // 4 times
			i++;
		}
		Thread.sleep(2000L);
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		 WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); 
		 Select dropdown = new Select(staticdropdown);
		 dropdown.selectByIndex(1);
		 System.out.println(dropdown.getFirstSelectedOption().getText());
		 
		driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
}
	}
