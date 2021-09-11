package parallel;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	private static String title;
	private static String forgotLink;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("user in login page")
	public void user_in_login_page() {
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/");
	}

	@When("user gets title of the page")
	public void user_gets_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedLoginPageTitle) {
		Assert.assertTrue(title.equals(expectedLoginPageTitle));
	}

	@Then("forgot password link should be {string} displayed")
	public void forgot_password_link_should_be_displayed(String expectedforgetLing) {
		forgotLink = loginPage.verifyForgotPassworddLinkDisplayed();
		Assert.assertTrue(forgotLink.equals(expectedforgetLing));
	}

	@When("user enters user name {string}")
	public void user_enters_user_name(String userName) {
		loginPage.setUserName(userName);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.setPassword(password);
	}

	@When("user click on Log in button")
	public void user_click_on_log_in_button() {
		loginPage.clickOnLoginButton();
	}

	@Then("user is on Home Page {string}")
	public void user_is_on_home_page(String expectedLoginPageTitle) {
		title = loginPage.getLoginPageTitle();
		Assert.assertTrue(title.equals(expectedLoginPageTitle));
	}

}
