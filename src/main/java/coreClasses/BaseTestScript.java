package coreClasses;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTestScript {
	public static WebDriver driver;
	static String APPLICATION_URL;

	 protected static ExtentReports extent;
	 protected ExtentTest logger;
	
	@BeforeTest
	public static void beoferTest() throws IOException {

		driver = setUp();
		
		  extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
		  //extent.addSystemInfo("Environment","Environment Name")
		  extent
		                .addSystemInfo("Host Name", "SoftwareTestingMaterial")
		                .addSystemInfo("Environment", "Automation Testing")
		                .addSystemInfo("User Name", "Rajkumar SM");
		                //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
		                //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
		                extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		 
		// APPLICATION_URL =
		// textingProperties.getInstance().getProperty("qa_DEV_URL").trim();
		driver.navigate().to("https://test.textingpro.com/index/index");
	}

	public static WebDriver setUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable -extensions");
		options.addArguments("--start-maximized");
		return new ChromeDriver(options);

	}
	

	@AfterMethod
	 public void getResult(ITestResult result){
	  if(result.getStatus() == ITestResult.FAILURE){
	   logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
	   logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
	  }else if(result.getStatus() == ITestResult.SKIP){
	   logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
	  }
	  // ending test
	  //endTest(logger) : It ends the current test and prepares to create HTML report
	  extent.endTest(logger);
	 }
	
	// @BeforeMethod
	// protected void beforeMethod() throws InterruptedException, IOException {
	// driver.get(APPLICATION_URL);
	// APPLICATION_URL =
	// itTopTalentProperties.getInstance().getProperty("qa_DEV_URL").trim();
	// driver.navigate().to(APPLICATION_URL);
	// }

	@AfterTest
	public void tearDown() {
	

		  // writing everything to document
		  //flush() - to write or update test information to your report. 
		                extent.flush();
		                //Call close() at the very end of your session to clear all resources. 
		                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
		                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
		                //Once this method is called, calling any Extent method will throw an error.
		                //close() - To close all the operation
		                extent.close();
		                driver.close();
		            	driver.quit();
		    }
		 
		
	
	
	}


