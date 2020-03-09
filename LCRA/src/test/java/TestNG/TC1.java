package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC1 {

	static String driverPath = "IE driver path";
	private WebDriver driver;

	By logoLocator = By.cssSelector("div[class='lcra-logo white']");
	By sideNavLocator = By.cssSelector("nav[id='lcra-nav']");
	By searchLocator = By.cssSelector("div[id='firstSearch']");
	By scrollButton = By.cssSelector("div[class='go-down-btn']");
	By ourMissionLocator = By.cssSelector("div[id='ctl00_PlaceHolderMain_pubControl_CoverTitle_DisplayMode']");

	@BeforeClass
	@Parameters({ "URL", "BrowserType" })
	public void beforeClass(String url, String browserType) {

		if (browserType.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserType.equalsIgnoreCase("Internet Explorer")) {
			System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("Opening:" + browserType + "=)");
		
	}

	@Test
	public void homePage() {

		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.presenceOfElementLocated(logoLocator));

		driver.findElement(logoLocator).isDisplayed();
		System.out.println("Se muestra Logo");
		driver.findElement(sideNavLocator).isDisplayed();
		System.out.println("Se muestra Sidenav");
		driver.findElement(searchLocator).isDisplayed();
		System.out.println("Se muestra Search");
		driver.findElement(scrollButton).isDisplayed();
		System.out.println("Se muestra Scroll Button");
		driver.findElement(ourMissionLocator).isDisplayed();
		System.out.println("Se muestra Our Mission Msg");

	}

	@AfterClass
	public void afterClass() {
		// driver.close();
	}

}
