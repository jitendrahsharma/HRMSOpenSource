package parallel;

import com.pages.HomePage;
import com.pages.JobTitlePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JobTitleSteps{
	
	private JobTitlePage jobTitlePage = new JobTitlePage(DriverFactory.getDriver());
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	
	@Given("user  is logged into OrangeHrms using valid credentials")
	public void user_is_logged_into_orange_hrms_using_valid_credentials() throws InterruptedException {
		loginPage.login();
		homePage.homeScreenDisplayed();
	}

	@When("Go to Menu bar > Admin > Job > Job Title")
	public void go_to_menu_bar_admin_job_job_title() {
		homePage.clickOnMenu("Admin", "Job", "Job Titles");
	}

	@When("Job Titles screen should get open")
	public void job_titles_screen_should_get_open() {
		jobTitlePage.verifyJobTitlePageHeader("Job Titles");
	}

	@When("Click on Add button")
	public void click_on_add_button() {
		jobTitlePage.clickOnAddBtn();
	}

	@When("Add Job Title screen should get open")
	public void add_job_title_screen_should_get_open() {
		jobTitlePage.verifyJobTitlePageHeader("Add Job Title");
	}

	@When("Enter the Job Title {string}")
	public void enter_the_job_title(String jobTitle) {
		jobTitlePage.setJobTitle(jobTitle);
	}

	@When("Enter the Job Description {string}")
	public void enter_the_job_description(String jobDescription) {
		jobTitlePage.setJobDescription(jobDescription);
	}

	@When("upload the Job Specification")
	public void upload_the_job_specification() {
		jobTitlePage.selectJobSpecification();
	}

	@When("Enter the Note {string}")
	public void enter_the_note(String note) {
		jobTitlePage.setNote(note);
	}

	@When("Click on Save button")
	public void click_on_save_button() {
		jobTitlePage.clickOnSaveBtn();
	}

	@Then("Job title should get added")
	public void job_title_should_get_added() {
		jobTitlePage.verifyAddedJobTitle("Automation Developer");
	}
	
	@When("Go to Menu bar > Admin > Job >  Pay Grades")
	public void go_to_menu_bar_admin_job_Pay_Grades() {
		homePage.clickOnMenu("Admin", "Job", "Pay Grades");
	}
	
	@When("Pay Grades screen should get open")
	public void pay_grades_screen_should_get_open() {
		jobTitlePage.verifyJobTitlePageHeader("Pay Grades");
	}

	@When("Click on Add button of Pay Grades")
	public void click_on_add_button_of_pay_grades() {
		jobTitlePage.clickOnAddBtn();
	}

	@When("Add Pay Grades screen should get open")
	public void add_pay_grades_screen_should_get_open() {
		jobTitlePage.verifyJobTitlePageHeader("Add Pay Grade");
	}

	@When("Enter the name {string}")
	public void enter_the_name(String name) {
		jobTitlePage.setPayGradeName(name);
	}
	
	@And("Click on Save button of Pay Grades")
	public void click_on_save_button_of_pay_grades(){
		jobTitlePage.clickOnSaveBtn();
	}

	@Then("Pay Grades Name should get added")
	public void pay_grades_name_should_get_added() {
		jobTitlePage.verifyAddedPayGrade("Grade 8");
	}

	@When("Click on Add button of Assigned Currencies")
	public void click_on_add_button_of_assigned_currencies() {
		jobTitlePage.clickOnAddCurrencyButton();
	}
	
	@And("Enter Currency {string}")
	public void enter_currency(String currency){
		jobTitlePage.setCurrency(currency);
	}
	
	@And("Enter Minimum Salary {string}")
	public void enter_minimum_salary(String minSalary){
		jobTitlePage.setMinSalary(minSalary);
	}
	
	@And("Enter Maximum Salary {string}")
	public void enter_maximum_salary(String maxSalary){
		jobTitlePage.setMaxSalary(maxSalary);
	}
	
	@And("Click on Save button of Add Currency")
	public void click_on_save_button_of_add_currency(){
		jobTitlePage.clickOnSaveAddCurrencyButton();
	}
	@And("Click on Cancel button for Edit Pay Grade")
	public void click_on_cancel_button_for_edit_pay_grade(){
		jobTitlePage.clickOnCancelButtonForPayGrade();
	}
	@Then("Pay Grade {string} and Currency {string} should get added")
	public void pay_grade_and_currency_should_get_added(String payGrade, String currency){
		jobTitlePage.verifyAddedPayGradeAndCurrency(payGrade,currency);
	}
}
