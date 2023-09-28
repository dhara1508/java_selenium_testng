							 /* Dynamic dropdown (depends on previous dropdown selection) */	
package learning;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class dynamicdropdown {
	
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://browserdrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		//Thread.sleep(200L);
		driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_originStation1_CTNR\"]//a[@text=\"Goa (GOI)\"]")).click();
		Thread.sleep(200L);
		driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@text=\"Surat (STV)\"]")).click();
		
		//Select the current date from the calendar
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		driver.close();
	}

}
