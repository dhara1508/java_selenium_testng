package learning;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Proxyset {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://browserdrivers//chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		Proxy Proxy = new Proxy();						//Proxy setup 
		Proxy.setHttpProxy("myhttpproxy:3337");
		option.setCapability("Proxy", Proxy);
		
		//Set download directory
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		option.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://expired.badssl.com/");
		

	}

}


//https://chromedriver.chromium.org/capabilities       //ref link for capabilites method 
