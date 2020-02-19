package com.qualitystream.tutorial;



import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleSearchTest {

	private static WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cgbot.devbot.mx");
		
	}
	@Test
	public void GoogleLogin2() throws InterruptedException {
		System.out.println("1:" + driver.getTitle());
		Thread.sleep(5000);
		
		By googleLoginButton = By.xpath("//div[@id='log-in']/div/div/h4");
		driver.findElement(googleLoginButton).click(); 
		
		Thread.sleep(5000);
		/*
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> iter = windowIds.iterator();
		
		String mainWindow = iter.next();
		String childWindow = iter.next();
		
		driver.switchTo().window(childWindow);
		*/
		
		switchToWindow(2);		
		
		System.out.println("2:" + driver.getTitle());
		
		Thread.sleep(5000);		
		 
		By emailField = By.id("identifierId");
		driver.findElement(emailField).sendKeys("eramos2sc@gmail.com");
		
		By emailButton = By.id("identifierNext");
		driver.findElement(emailButton).click();
		
		Thread.sleep(5000);		
		
		switchToWindow(3);
		
		System.out.println("3:" + driver.getTitle());
		
	}

	// If I give index as 1 -> Main window
	// If I give index as 2 -> Child window
	
	public static void switchToWindow(int index) {
		String windowId = null;
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> iter = windowIds.iterator();
		
		for (int i = 1; i<=index; i++) {
			windowId = iter.next();
		}
	
		driver.switchTo().window(windowId);
		
	}

}
