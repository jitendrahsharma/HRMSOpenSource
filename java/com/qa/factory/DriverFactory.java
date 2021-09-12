package com.qa.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	

	/**
     * @author Jitendra.Sharma
     * @since 01 July 2021
     * @description This Method is used to initial the driver
     * @param browser
     * @return this method will return tlDriver
     */
	public WebDriver init_driver(String browser) {

		System.out.println("Browser value is :" + browser);
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} 
		else if(browser.equals("headless")){
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			tlDriver.set(new ChromeDriver(chromeOptions));
		}
		else if (browser.equals("firefox")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new FirefoxDriver());
		} 
		else {
			System.out.println("Please pass the correct browser value: " + browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		return getDriver();
	}
	
	/**
     * @author Jitendra.Sharma
     * @since 01 July 2021
     * @description This Method is used to get the driver with ThreadLocal
     */
	public static synchronized WebDriver getDriver(){
		return tlDriver.get();
	}

}
