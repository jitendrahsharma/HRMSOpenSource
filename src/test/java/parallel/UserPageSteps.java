package parallel;

import org.junit.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.UserPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private UserPage userPage = new UserPage(DriverFactory.getDriver());
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private String UserHomePage;
	
	@Given("user is on Home Page")
	public void user_is_on_home_page() throws InterruptedException {
		loginPage.login();
		homePage.homeScreenDisplayed();
	}

	@When("Go to Admin Menu >User Management > Users")
	public void go_to_admin_menu_user_management_users() {
		homePage.clickOnMenu("Admin", "User Management", "Users");
	}

	@When("system Users Screen should get Open with {string}")
	public void system_users_screen_should_get_open_with(String expectedUserHomePage) {
		UserHomePage = userPage.getUserHomePageHeader();
		Assert.assertTrue(UserHomePage.equals(expectedUserHomePage));
	}

	@When("click on Add button")
	public void click_on_add_button() {
		userPage.clickOnAddBtn();
	}

	@When("add user screen should get open {string}")
	public void add_user_screen_should_get_open(String expectedAddUser) {
		UserHomePage = userPage.getUserHomePageHeader();
		Assert.assertTrue(UserHomePage.equals(expectedAddUser));		
	}

	@When("select User Roll {string}")
	public void select_user_roll(String userRoll) {
		userPage.selectUserRole(userRoll);
	}

	@When("select employee name {string}")
	public void select_employee_name(String empName) {
		userPage.selectEmployeeName(empName);
	}

	@When("enter User Name {string}")
	public void enter_user_name(String usrName) {
		userPage.setUserName(usrName);
	}

	@When("select the status {string}")
	public void select_the_status(String uStatus) {
		userPage.selectStatus(uStatus);
	}

	@When("enter the password {string}")
	public void enter_the_password(String pwd) {
		userPage.setPassword(pwd);
	}
	
	@When("enter the confirm password {string}")
	public void enter_the_confirm_password(String ConfmPwd) {
		userPage.setConfirmPassword(ConfmPwd);
	}

	@When("click on save button")
	public void click_on_save_button() {
		userPage.clickOnSaveButton();
	}

	@When("go to system user secreen search user {string}")
		public void go_to_system_user_secreen_search_user(String userName){
	     userPage.getUserHomePageHeader();
	     userPage.setUserNameInSearchField(userName);		
	}
	
	@When("click on serach button")
	 public void click_on_serach_button(){
		userPage.clickOnSearchBtn();
	}
	
	@Then("verify the added user in the application {string}")
	public void verify_the_added_user_in_the_application(String addUser) {
		userPage.verifyAddedUser(addUser);
	}

}
