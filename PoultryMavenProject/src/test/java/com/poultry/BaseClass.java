package com.poultry;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

	public class BaseClass {
		public static WebDriver driver;

		@Before
		public void testBeforeClass() throws Exception {
			driver = openBrowser();
		}
		public static String BROWSER = System.getProperty("browser");
		public static String folder;
		public static WebDriver openBrowser() throws Exception {
			// TODO Auto-generated method stub
			if (BROWSER == null) {
				BROWSER = "chrome";
			}
			if (BROWSER.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
				Map<String, Object> prefs = new HashMap<String, Object>();
				ChromeOptions options = new ChromeOptions();
//				String userProfile ="C:\\Users\\Vinay server 3\\eclipse-workspace\\userdata";
				String userProfile ="C:\\Users\\Vinay server 3\\eclipse-workspace\\userdata\\userdata2";

				options.addArguments("--test-type");
				options.addArguments("start-maximized");
				options.addArguments("user-data-dir="+userProfile);
				driver = new ChromeDriver(options);
				String SITE_BASE_URL="https://web.whatsapp.com/";
				System.out.println("site name: " + SITE_BASE_URL);
				driver.get(SITE_BASE_URL);
				return driver;

			} else {
				throw new Exception();
			}
		}	
		
		@After
		public void tearDown() {
			System.out.println("Success!!!!!!!!");
			driver.quit();
		
		}
		
	}


	

	




