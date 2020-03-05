package com.checkingLinks.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class CheckLinksTest {
	
	WebDriver driver;
	CheckLinkPage page;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		page = new CheckLinkPage(driver);
		driver.get("https://www.lcra.org/Pages/default.aspx");
	}

	@Test
	public void checkingLinks() {
	assertTrue(page.checkingPageLinks(), "There are broken links");	
	}

	@AfterClass
	public void afterClass() {
	//driver.close();
	}

}
