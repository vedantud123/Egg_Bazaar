package com.poultry;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions
{
	static int maxWaitingTime =120;

	public static void waittill(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public static WebElement getWebElement(WebDriver driver, By by) {
		
		WebElement ele = driver.findElement(by);
		return ele;
	}
	
	
	public static void LoadUrl(WebDriver driver, String url) {
		driver.get(url);
		Actions.waittill(5000);
	}
	
	
	public static String getAttribute(WebDriver driver, By by, String attribute) {
		try {
			return getWebElement(driver, by).getAttribute(attribute);
		} catch (Exception e) {
			return "";
		}
	}
	
	public static int getSize(WebDriver driver,By by) {
		try {	
			return driver.findElements(by).size();
			} catch(Exception e) {
				return 0;
			}
		}
	public static String getText(WebDriver driver, By by) {
		try {
			return driver.findElement(by).getText().trim();
		} catch (Exception e) {
			return "";
		}
	}
	
	 public static void click(WebDriver driver,By by) {
		 getWebElement(driver, by).click();
	 }
	 public static void sendKeys(WebDriver driver, By by, String data) {
		 try {
		 getWebElement(driver,by).sendKeys(data);
		 }catch(Exception e) {
			 
		 }
	 }
	 public static void log(WebDriver driver, String message) {
			String pageURL = driver.getCurrentUrl();
			StackTraceElement caller = new Throwable().getStackTrace()[1];
			String callerInfo = caller.getClassName() + " " + caller.getMethodName() + " line " + caller.getLineNumber();
			Calendar cal = Calendar.getInstance();
			cal.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			System.out.print("--->" + sdf.format(cal.getTime()) + " ");
			System.out.print("--->" + pageURL);
			System.out.println(callerInfo + " | " + message);
		}
	 
	 public static void waitForVisible(WebDriver driver, By by) {
		 log(driver , "Waiting for Element to be visible"+by);
		 WebElement elm =getWebElement(driver,by);
		 WebElement wdw =(WebElement) new WebDriverWait (driver ,maxWaitingTime);
		 ((FluentWait<WebDriver>) wdw).until(ExpectedConditions.visibilityOf(elm));
	 }
	 
	 public static void new_tab(WebDriver driver,String url) {
		 ((JavascriptExecutor) driver).executeScript("window.open('', '_blank');");
	        // Switch to the child window
			for (String windowHandle : driver.getWindowHandles()) {
				driver.switchTo().window(windowHandle);
			}
			driver.get(url);
			Actions.waittill(2000);
			driver.close();
			driver.switchTo().window(driver.getWindowHandles().iterator().next());
	 }
	 

}




