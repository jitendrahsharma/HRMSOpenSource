package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.utils.WrapperFunctions;

public class HomePage {
	private WebDriver driver;
	private WrapperFunctions objWrapperFunctions = new WrapperFunctions();
	
	By lblHomePage = By.xpath("//div[@id='branding']//img[@alt='OrangeHRM']");
	


	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	 /**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to click On Menu
     */
	public void clickOnMenu(String menu, String subMenu, String subMenuItem)
	{
		WebElement menu1 = driver.findElement(By.linkText(menu));
		Actions action=new Actions(driver);
		action.moveToElement(menu1).build().perform();
		menu1.click();
		if(subMenu != null){
			WebElement subMenu1 = driver.findElement(By.linkText(subMenu));
			action.moveToElement(subMenu1).build().perform();
			subMenu1.click();
		}
		if(subMenu != null && subMenuItem !=null){
			WebElement subMenuItems = driver.findElement(By.linkText(subMenuItem));
			subMenuItems.click();
		}
	}
	
	public boolean homeScreenDisplayed() throws InterruptedException{
		objWrapperFunctions.waitFor(2);
		return driver.findElement(lblHomePage).isDisplayed();
	 }
}
