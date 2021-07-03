package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver; //global variable(can be anywhere in project)
	public static Properties prop;
	
	//reading property
	public TestBase(){ //constructor
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\Selenium\\crmTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		    //location of congig.properties file 
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization(){
		String browserName = prop.getProperty("browser"); //fetching browser name from config.properties
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		/*
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		*/
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); 
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//TestUtil is class so we have to import -> import com.crm.qa.util.TestUtil;
		driver.get(prop.getProperty("url")); //launch the url
		                                     //fetching url from config.properties
	}
}
