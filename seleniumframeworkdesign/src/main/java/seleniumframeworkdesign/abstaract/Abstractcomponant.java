package seleniumframeworkdesign.abstaract;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstractcomponant {
	
	WebDriver driver;
	
	public Abstractcomponant(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink=\"/dashboard/cart\"]")
	WebElement gotocart;
	

	public void waitForElementToAppear(By findBy)
	{
	WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
	
	public void waitForElementToDisappear(WebElement elem) throws InterruptedException 
	{
		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(elem));
	}
	
	public void goToCartPage()
	{
	gotocart.click();
	}
}
