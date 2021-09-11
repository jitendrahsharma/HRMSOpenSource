package com.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;

public class LoginPage {
	
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	 //1. By locators 
	
	By txtUserName = By.id("txtUsername");
	By txtPassword = By.id("txtPassword");
	By btnLogin = By.id("btnLogin");
	By inkForgetPwd = By.xpath("//div[@id='forgotPasswordLink']//a");
	
	//2. Constructor of the page class:
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	//3. Page actions: feature(behavior) of the page from of the method:
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to get Login Page Title
     */
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to verify Forgot Password Link Displayed
     */
	public String verifyForgotPassworddLinkDisplayed(){
		return driver.findElement(inkForgetPwd).getText();
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to set User Name
     */
	 public void setUserName(String userName){
		 driver.findElement(txtUserName).sendKeys(userName);
	 }
	 
	 /**
	     * @author Jitendra.Sharma
	     *  @since 01 July 2021
	     * @description This Method used to set Password
	     */
	 public void setPassword(String password){
		 driver.findElement(txtPassword).sendKeys(password);
	 }
	 
	 /**
	     * @author Jitendra.Sharma
	     *  @since 01 July 2021
	     * @description This Method used to click On Login Button
	     */
	 public void clickOnLoginButton(){
		 driver.findElement(btnLogin).click();
	 }
	 
	 public void doLogin(String un,String pwd){
		 DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/");
		 driver.findElement(txtUserName).sendKeys(un);
		 driver.findElement(txtPassword).sendKeys(pwd);
		 driver.findElement(btnLogin).click();
	 }
	 
	 public HomePage login() {
			configReader = new ConfigReader();
			prop = configReader.init_prop();
			String userName = prop.getProperty("userName");
			String password = prop.getProperty("password");
			doLogin(userName,password);
			return new HomePage(driver);
		}
}
