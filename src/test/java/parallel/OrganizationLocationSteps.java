package parallel;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.OrganizationLocationPage;
import com.qa.factory.DriverFactory;
import com.qa.utils.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrganizationLocationSteps {
	
	private OrganizationLocationPage organizationLocationPage = new OrganizationLocationPage(DriverFactory.getDriver());
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("user is logged into OrangeHrms using valid credentials")
	public void user_is_logged_into_orange_hrms_using_valid_credentials() throws InterruptedException {
		loginPage.login();
		homePage.homeScreenDisplayed();
	}

	@When("Go to Menu bar > Admin > Organization > Locations")
	public void go_to_menu_bar_admin_organization_locations() {
		homePage.clickOnMenu("Admin", "Organization", "Locations");
	}

	@When("Locations screen should get open")
	public void locations_screen_should_get_open() {
		organizationLocationPage.verifyLocationsPageHeader("Locations");
	}

	@When("Click on Add button of Location")
	public void click_on_add_button_of_location() {
		organizationLocationPage.clickOnAddBtn();
	}

	@When("Add Location screen should get open")
	public void add_location_screen_should_get_open() {
		organizationLocationPage.verifyLocationsPageHeader("Add Location");
	}

	@When("add the location data from given sheetName {string} and rownumber {int}")
	public void add_the_location_data_from_given_sheet_name_and_rownumber(String sheetName, int rowNumber) throws InvalidFormatException, IOException{
	    ExcelReader reader= new ExcelReader();
	    List<Map<String,String>> testData =
	    		reader.getData(".//src//test//testData//Locations.xlsx", sheetName);
	    String name = testData.get(rowNumber).get("Name");
	    String country = testData.get(rowNumber).get("Country");
	    String state = testData.get(rowNumber).get("State");
	    String city = testData.get(rowNumber).get("City");
	    String address = testData.get(rowNumber).get("Address");
	    String zip = testData.get(rowNumber).get("Zip");
	    String phone = testData.get(rowNumber).get("Phone");
	    String fax = testData.get(rowNumber).get("Fax");
	    String note = testData.get(rowNumber).get("Note");
	    organizationLocationPage.fillLocationForm(name, country, state, city, address, zip, phone, fax, note);
	    
	}

	@When("Click on Save button of the location")
	public void click_on_save_button_of_the_location() {
		organizationLocationPage.clickOnSaveAddLocationButton();
	}

	@Then("Location  should get added in the organization")
	public void location_should_get_added_in_the_organization() {
		organizationLocationPage.verifyAddedLocation("New Healthcare HQ");
	}

}
