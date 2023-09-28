								/* select dropdown with select tag - static */
package learning;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;


public class selecttagdropdown {
	
 public static void main(String[] args)  	
 {    
	 System.setProperty("webdriver.chrome.driver", "C://browserdrivers//chromedriver.exe");												
	 WebDriver driver = new ChromeDriver();
	 driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	 driver.manage().window().maximize();
	 WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); 
	 
	 //select dropdown with select tag - static  
	 Select dropdown = new Select(staticdropdown);
	 dropdown.selectByIndex(1);
	 System.out.println(dropdown.getFirstSelectedOption().getText());
	 dropdown.selectByVisibleText("AED");
	 System.out.println(dropdown.getFirstSelectedOption().getText());
	 //driver.close();
	 
 }
 }
 
