package coreClasses;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {
	String APPLICATION_URL;
	private WebDriver driver;
	Actions build;
	Alert alert;
	String testUrl;

	public static int Seconds = 15;

	public BasePageObject(WebDriver driver) {
		this.driver = driver;
		build = new Actions(driver);

	}

	public void click(By by) throws IOException {

		try {
			WebElement element = driver.findElement(by);
			getHighlightElement(element); //highligts 
			timeinterval(1);
			build.moveToElement(element).click().perform();

		} catch (NoSuchElementException e) {
			driver.findElement(by).click();
		} catch (Exception e) {
			// Assert.assertTrue(false, "Fail to click on link : " + by + " on page : " +
			// e.getMessage());
			// rootLogger.warn("Fail to click on link : " + by + " on page : " +
			// selenium.getWrappedDriver().getCurrentUrl());
		}
	}

	public void getHighlightElement(final WebElement element) {
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, 10);
			// Wait for search to complete
			wait.until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver webDriver) {
					return element != null;
				}
			});
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid red'", element);
		} catch (Exception e) {
			// logger.info("Fail to highlight the Element");
		}

	}

	public void timeinterval(int i) throws InterruptedException {

		Thread.sleep(1000 * i);

	}

	public void sendkeys(By by, String keys) {
		getHighlightElement(driver.findElement(by));
		driver.findElement(by).sendKeys(keys);
	}

	public void navigatetoURL() throws IOException {
		APPLICATION_URL = textingProperties.getInstance().getProperty("qa_DEV_URL").trim();
		driver.navigate().to(APPLICATION_URL);

	}

	@SuppressWarnings("deprecation")
	public void selectOptionFromDropDown(By by, String option) throws IOException {

		waitForParticularElement(by, Seconds);
		Select select_list = null;
		try {
			moveToElement(by);

			select_list = new Select(driver.findElement(by));

			select_list.selectByVisibleText(option);
		} catch (NoSuchElementException e) {
			// Assert.assertTrue(false,
			// "Fail to find drop down box to select option : " + by + " on page : " +
			// e.getMessage());
		} catch (Exception e) {
			// rootLogger.warn("Fail to select stetus : " + e.getMessage());
		}
	}

	public void waitForParticularElement(final By element, int waitForSeconds) throws IOException {
		int i = 1;
		do {
			try {
				driver.findElement(element).isDisplayed();

				break;
			} catch (Exception e) {

				i++;
				System.out.println("waiting for element : " + element.toString() + " :  Waiting Time [ " + i
						+ " ] out of " + waitForSeconds);
			}
		} while (i <= waitForSeconds);
	}

	public void moveToElement(By by) throws IOException {
		WebElement element;

		try {
			element = driver.findElement(by);
			getHighlightElement(driver.findElement(by));
			build.moveToElement(element).build().perform();
		} catch (NoSuchElementException e) {
			// rootLogger.warn("Fail to find Element: " + by + " on page : " +
			// detectPage());
		} catch (Exception e) {
			// rootLogger.warn("Fail to find Element: " + by + " on page : " +
			// detectPage());
		}
	}

	public boolean isDisplayed(By by) throws IOException {
		try {
			moveToElement(by);
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			// rootLogger.warn("Fail to isDisplayed element : " + by + " on page : " +
			// selenium.getWrappedDriver().getCurrentUrl());
			return false;
		} catch (Exception e) {
			// CaptureErrorScreen(selenium.getWrappedDriver().getCurrentUrl());
			System.out.println("Exception 2:" + e);
		}
		return false;
	}

}
