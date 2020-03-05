package Requirements;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Test_alv {
	
	WebDriver driver;
	
	By SearchIcon = By.cssSelector(".search-op");
	By SearchTextbox = By.cssSelector("#SearchBoxGlobal > #searchform #s");
	By ResultsLocator = By.cssSelector("a[href='http://www.lcra.org/energy/WSCenergy']");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://34.218.230.162/");
	}

	@Test
	public void f() {
	}

	@AfterClass
	public void afterClass() {
	}

}
