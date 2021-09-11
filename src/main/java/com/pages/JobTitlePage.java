package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.utils.WrapperFunctions;


public class JobTitlePage{
	private WebDriver driver; 
	private WrapperFunctions objWrapperFunctions = new WrapperFunctions();
	String jobTitle1;
	String randomPayGrade;
	
	By btnAdd = By.id("btnAdd");
	By hdrJobTitle = By.xpath("//div[@class='head']//h1");
	By txtJobTitle = By.id("jobTitle_jobTitle");
	By txtJobDescription = By.id("jobTitle_jobDescription");
	By txtJobSpec = By.id("jobTitle_jobSpec");
	By txtNote = By.id("jobTitle_note");
	By btnSave = By.id("btnSave");
	By txtPayGradeName = By.id("payGrade_name");
	By btnAddCurrency = By.id("btnAddCurrency");
	By txtCurrency = By.id("payGradeCurrency_currencyName");
	By txtMinSalary = By.id("payGradeCurrency_minSalary");
	By txtMaxSalary = By.id("payGradeCurrency_maxSalary");
	By btnSaveCurrency = By.id("btnSaveCurrency");
	By btnCancelPayGrade = By.id("btnCancel");
	
	public JobTitlePage(WebDriver driver){
		this.driver=driver;
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 02 July 2021
     * @description This Method used to click On Add Btn
     */
	public void clickOnAddBtn(){
		driver.findElement(btnAdd).click();
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 02 July 2021
     * @description This Method used to verify Job Title Page Header
     * @param header
     */
	public boolean verifyJobTitlePageHeader(String header){
		objWrapperFunctions.waitFor(2);
		String actualHeader = driver.findElement(hdrJobTitle).getText();
		return actualHeader.equals(header);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 02 July 2021
     * @description This Method used to set Job Title
     * @param  jobTitle
     */
	public void setJobTitle(String jobTitle){
		jobTitle1 = WrapperFunctions.randomestring();
		driver.findElement(txtJobTitle).sendKeys(jobTitle+jobTitle1);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 02 July 2021
     * @description This Method used to set Job Description
     * @param  jobDescription
     */
	public void setJobDescription(String jobDescription){
		driver.findElement(txtJobDescription).sendKeys(jobDescription);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 02 July 2021
     * @description This Method used to select Job Specification
     */
	public void selectJobSpecification(){
		WebElement uploadElement = driver.findElement(txtJobSpec);
		uploadElement.sendKeys("C:\\Users\\jitendra.sharma\\workspace\\BDDDemoFramework\\src\\test\\testData\\Automation Developer.PNG");
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 02 July 2021
     * @description This Method used to set Note
     * @param  note
     */
	public void setNote(String note){
		driver.findElement(txtNote).sendKeys(note);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 02 July 2021
     * @description This Method used to click On Save Btn
     */
	public void clickOnSaveBtn(){
		driver.findElement(btnSave).click();
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to verify Added job Title
     * @param userName
     */
	public boolean verifyAddedJobTitle(String title){
		By addedUser = By.xpath("//table[@id='resultTable']//td//a[text()='"+title+jobTitle1+"']");
		String actualUser = driver.findElement(addedUser).getText();
		return actualUser.equals(title+jobTitle1);		
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 06 July 2021
     * @description This Method used to set Pay Grade Name
     * @param  payGradeName
     */
	public void setPayGradeName(String payGradeName){
		randomPayGrade = WrapperFunctions.randomestring();
		driver.findElement(txtPayGradeName).sendKeys(payGradeName+randomPayGrade);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 06 July 2021
     * @description This Method used to verify Added PayGrade
     * @parampayGrade
     */
	public boolean verifyAddedPayGrade(String payGrade){
		String actualUser = driver.findElement(txtPayGradeName).getText();
		return actualUser.equals(payGrade+randomPayGrade);		
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 06 July 2021
     * @description This Method used to click On Add Currency Button
     */
	public void clickOnAddCurrencyButton(){
		driver.findElement(btnAddCurrency).click();
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 06 July 2021
     * @description This Method used to set Currency
     * @param  currency
     */
	public void setCurrency(String currency){
		WebElement currencySet = driver.findElement(txtCurrency);
		currencySet.sendKeys(currency);
		objWrapperFunctions.waitFor(2);
		currencySet.sendKeys(Keys.DOWN);
		currencySet.sendKeys(Keys.ENTER);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 06 July 2021
     * @description This Method used to set Min Salary
     * @param  minSalary
     */
	public void setMinSalary(String minSalary){
		driver.findElement(txtMinSalary).sendKeys(minSalary);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 06 July 2021
     * @description This Method used to set Max Salary
     * @param  maxSalary
     */
	public void setMaxSalary(String maxSalary){
		driver.findElement(txtMaxSalary).sendKeys(maxSalary);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 06 July 2021
     * @description This Method used to click On Save Add Currency Button
     */
	public void clickOnSaveAddCurrencyButton(){
		driver.findElement(btnSaveCurrency).click();
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 07 July 2021
     * @description This Method used to verify Added Pay Grade And Currency
     * @param  payGrade, currency
     */
	public boolean verifyAddedPayGradeAndCurrency(String payGrade, String currency){
		By lblPayGrade = By.xpath("//table[@id='resultTable']//tr//td//a[text()='"+payGrade+randomPayGrade+"']//parent::td/following-sibling::td");
		String acutualCurrency = driver.findElement(lblPayGrade).getText();
		return acutualCurrency.equals(currency);	
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 07 July 2021
     * @description This Method used to click On Cancel Button For PayGrade
     */
	public void clickOnCancelButtonForPayGrade(){
		driver.findElement(btnCancelPayGrade).click();
	}
}
