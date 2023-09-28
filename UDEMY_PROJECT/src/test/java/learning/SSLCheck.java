package learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;


public class SSLCheck {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
		//ChromeOptions option = new ChromeOptions();
		EdgeOptions option1 = new EdgeOptions();    //For Edgebrowser
		//FirefoxOptions option2 = new FirefoxOptions();  // Firefoxbrowser
		//option.setAcceptInsecureCerts(true);
		option1.setAcceptInsecureCerts(true);
		//option2.setAcceptInsecureCerts(true);
		
		//WebDriver driver = new ChromeDriver(option);
		WebDriver driver = new EdgeDriver(option1);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

	}

}
