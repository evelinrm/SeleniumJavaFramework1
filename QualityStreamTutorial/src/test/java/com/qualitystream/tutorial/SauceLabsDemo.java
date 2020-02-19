package com.qualitystream.tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabsDemo {

	public static final String USERNAME = "eramos";
	public static final String ACCESS_KEY = "c0735e73-26fc-4836-a179-d51cc00ab065"; 
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com";
		
	public static void main(String[] args) throws Exception {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "latest");
		
		WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		
		//System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		System.out.println(driver.getTitle());
					
		System.out.println("Test completed");
		driver.quit();
				
		/*		
		driver.get("https://saucelabs.com/test/guinea-pig");
		System.out.println("title of page is: "+ driver.getTitle());
		*/
		
	}
}
