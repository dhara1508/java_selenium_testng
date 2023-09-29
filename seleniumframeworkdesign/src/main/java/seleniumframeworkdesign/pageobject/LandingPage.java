package seleniumframeworkdesign.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumframeworkdesign.abstaract.Abstractcomponant;

public class LandingPage extends Abstractcomponant{

	WebDriver driver;
	public LandingPage(WebDriver driver) {
		// initalization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	 WebElement useremail = driver.findElement(By.id("userEmail")).sendKeys("dhara.itaims@gmail.com");
	// PageFactory
	@FindBy(id = "userEmail")
	WebElement useremail;

//	driver.findElement(By.id("userPassword")).sendKeys("Dhara@1234");
	@FindBy(id = "userPassword")
	WebElement userPassword;

//	driver.findElement(By.id("login")).click();
	@FindBy(id = "login")
	WebElement login;

	public void loginapplication(String mailid, String password) {
		useremail.sendKeys(mailid);
		userPassword.sendKeys(password);
		login.click(); 
		}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}
