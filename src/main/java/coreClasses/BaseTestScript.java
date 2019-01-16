package coreClasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseTestScript {
	public static WebDriver driver;
	static String APPLICATION_URL;

	@Before
	public static void beoferTest() throws IOException {

		driver = setUp();
		// APPLICATION_URL =
		// textingProperties.getInstance().getProperty("qa_DEV_URL").trim();
		driver.navigate().to("https://test.textingpro.com/admin/adminlogin");
	}

	public static WebDriver setUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable -extensions");
		options.addArguments("--start-maximized");
		return new ChromeDriver(options);

	}

	// @BeforeMethod
	// protected void beforeMethod() throws InterruptedException, IOException {
	// driver.get(APPLICATION_URL);
	// APPLICATION_URL =
	// itTopTalentProperties.getInstance().getProperty("qa_DEV_URL").trim();
	// driver.navigate().to(APPLICATION_URL);
	// }

	@After
	public void tearDown() {
		driver.close();
		driver.quit();

	}

}
