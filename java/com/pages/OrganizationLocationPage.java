package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.qa.utils.WrapperFunctions;

public class OrganizationLocationPage {
	private WebDriver driver; 
	String randomName;
	private WrapperFunctions objWrapperFunctions = new WrapperFunctions();
	
	By btnAdd = By.id("btnAdd");
	By hdrLocations = By.xpath("//div[@class='head']//h1");
	By txtName = By.id("location_name");
	By lstCountry = By.id("location_country");
	By lstState = By.id("location_state");
	By txtCity = By.id("location_city");
	By txtAddress = By.id("location_address");
	By txtZipCode = By.id("location_zipCode");
	By txtPhone = By.id("location_phone");
	By txtFax = By.id("location_fax");
	By txtNotes = By.id("location_notes");
	By btnSave = By.id("btnSave");
	By tblLocations = By.id("resultTable");
	
	public OrganizationLocationPage(WebDriver driver){
		this.driver=driver;
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 14 July 2021
     * @description This Method used to click On Add Btn
     */
	public void clickOnAddBtn(){
		driver.findElement(btnAdd).click();
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 14 July 2021
     * @description This Method used to verify Locations Page Header
     * @param header
     */
	public boolean verifyLocationsPageHeader(String header){
		objWrapperFunctions.waitFor(2);
		String actualHeader = driver.findElement(hdrLocations).getText();
		return actualHeader.equals(header);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 14 July 2021
     * @description This Method used to fill Location Form
     * @param name, country, state, city, address, zip, phone, fax, note
     */
	public void fillLocationForm(String name, String country, String state, String city, String address, String zip, String phone, String fax, String note){
		randomName = WrapperFunctions.randomestring();
		driver.findElement(txtName).sendKeys(name+randomName);
		Select select =new Select(driver.findElement(lstCountry));
		select.selectByVisibleText(country);
		Select selectState =new Select(driver.findElement(lstState));
		selectState.selectByVisibleText(state);
		driver.findElement(txtCity).sendKeys(city);
		driver.findElement(txtAddress).sendKeys(address);
		driver.findElement(txtZipCode).sendKeys(zip);
		driver.findElement(txtPhone).sendKeys(phone);
		driver.findElement(txtFax).sendKeys(fax);
		driver.findElement(txtNotes).sendKeys(note);		
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 14 July 2021
     * @description This Method used to click On Save Add Location Button
     */
	public void clickOnSaveAddLocationButton(){
		driver.findElement(btnSave).click();
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 07 July 2021
     * @description This Method used to verify Added Location
     * @param  name
     */
	public boolean verifyAddedLocation(String name){
		By lblLocationName = By.xpath("//table[@id='resultTable']//td//a[text()='"+name+randomName+"']");
		return driver.findElement(lblLocationName).isDisplayed();
	}
}
