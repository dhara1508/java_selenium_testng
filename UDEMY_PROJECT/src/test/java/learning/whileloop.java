										/* Increase count with while loop */
package learning;                                         
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class whileloop {

	public static void main(String args[]) throws InterruptedException {

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		// Using with while loop
		int i = 1;
		while (i < 5) {
			driver.findElement(By.id("hrefIncAdt")).click(); // 4 times
			i++;
		}

		//Using with for loop
		/*
		 	for(int i=1;i<5;i++) 
		 	{ driver.findElement(By.id("hrefIncAdt")).click(); }
		 */
		
		Thread.sleep(2000L);
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.close();
	}
}
