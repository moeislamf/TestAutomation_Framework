package coreClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTestScript {
	public static WebDriver driver;
	static String APPLICATION_URL;
	
	//builds a new report using the html template 
    static ExtentHtmlReporter htmlReporter;
    
    public  static ExtentReports extent;
    
    //helps to generate the logs in test report.
    public ExtentTest test;

    
    
    @BeforeSuite
    public void beforesuite() {
    	
    	 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
	        
	        //initialize ExtentReports and attach the HtmlReporter
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	         
	        //To add system or environment info by using the setSystemInfo method.
//	        extent.setSystemInfo("OS", OS);
//	        extent.setSystemInfo("Browser", browser);
	        
	        //configuration items to change the look and feel
	        //add content, manage tests etc
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setDocumentTitle("Extent Report Demo");
	        htmlReporter.config().setReportName("Test Report");
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	     
		
    }
    
    
	@BeforeTest
	public static void beoferTest() throws IOException {

		driver = setUp();
		
		
		driver.navigate().to("https://test.textingpro.com/index/index");
	}

	public static WebDriver setUp() {

		System.setProperty("webdriver.chrome.driver", "/Software/chromedriver");
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

	 @AfterMethod
	    public void getResult(ITestResult result) {
	        if(result.getStatus() == ITestResult.FAILURE) {
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
	            test.fail(result.getThrowable());
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS) {
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	        }
	        else {
	            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
	            test.skip(result.getThrowable());
	        }
	    }
	
	@AfterTest
	public void tearDown() {
	
		extent.flush();
	
	driver.close();
	
	driver.quit();

	}
	

}
