package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.qa.factory.DriverFactory;
import com.qa.utils.WrapperFunctions;

public class UserPage {
	private WebDriver driver; 
	private WrapperFunctions objWrapperFunctions = new WrapperFunctions();
	int name;
	
	
	
	By lstUserRoll = By.id("systemUser_userType");
	By txtEmployeeName = By.id("systemUser_employeeName_empName");
	By txtUserName = By.id("systemUser_userName");
	By lstStatus  = By.id("systemUser_status");
	By txtPassword = By.id("systemUser_password");
	By txtConfPassword = By.id("systemUser_confirmPassword");
	By btnSave = By.id("btnSave");
	By hdrSystemUser = By.xpath("//div[@class='head']//h1");
	By btnAdd = By.id("btnAdd");
	By txtSearchUser = By.id("searchSystemUser_userName");
	By btnSearch = By.id("searchBtn");
	
	
	public UserPage(WebDriver driver){
		this.driver=driver;
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to select User Role
     * @param  uRoll
     */
	public void selectUserRole(String uRoll){
		Select userRoll = new Select(driver.findElement(lstUserRoll));
		userRoll.selectByVisibleText(uRoll);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to select Employee Name
     * @param  empName
     */
	public void selectEmployeeName(String empName){
		WebElement empSearch = driver.findElement(txtEmployeeName);
		empSearch.sendKeys(empName);
		objWrapperFunctions.waitFor(2);
		empSearch.sendKeys(Keys.DOWN);
		empSearch.sendKeys(Keys.ENTER);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to set User Name
     * @param  empName
     */
	public void setUserName(String userName){
       name = objWrapperFunctions.generateRandomNumber(200);
		driver.findElement(txtUserName).sendKeys(userName+name);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to select User Role
     * @param  uStatus
     */
	public void selectStatus(String uStatus){
		Select status = new Select(driver.findElement(lstStatus));
		status.selectByVisibleText(uStatus);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to set Password
     * @param  password
     */
	public void setPassword(String password){
		driver.findElement(txtPassword).sendKeys(password);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to set Confirm Password
     * @param  confPassword
     */
	public void setConfirmPassword(String confPassword){
		driver.findElement(txtConfPassword).sendKeys(confPassword);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to click on Save Button
     */
	public void clickOnSaveButton(){
		objWrapperFunctions.waitFor(2);
		Actions action=new Actions(driver);
		WebElement element = driver.findElement(btnSave);
		action.moveToElement(element).doubleClick().build().perform();
	}
	
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to get User Home Page Header
     */
	public String getUserHomePageHeader(){
		objWrapperFunctions.waitFor(2);
		return driver.findElement(hdrSystemUser).getText();
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to click On Add Btn
     */
	public void clickOnAddBtn(){
		driver.findElement(btnAdd).click();
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to set User Name In Search Field
     * @param userName
     */
	public void setUserNameInSearchField(String userName){
		driver.findElement(txtSearchUser).sendKeys(userName+name);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to click On Search Btn
     */
	public void clickOnSearchBtn(){
		driver.findElement(btnSearch).click();
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to verify Added User
     * @param userName
     */
	public boolean verifyAddedUser(String userName){
		By addedUser = By.xpath("//table[@id='resultTable']//td//a[text()='"+userName+name+"']");
		String actualUser = driver.findElement(addedUser).getText();
		return actualUser.equals(userName+name);		
	}
}
