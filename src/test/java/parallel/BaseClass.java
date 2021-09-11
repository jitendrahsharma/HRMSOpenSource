package parallel;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;

public class BaseClass {
	public DriverFactory driverFactory;
	public WebDriver driver;
	private ConfigReader configReader;
	public LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	Properties prop;
	public HomePage homePage = new HomePage(DriverFactory.getDriver());
	
	public HomePage login() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		String userName = prop.getProperty("userName");
		String password = prop.getProperty("password");
		loginPage.doLogin(userName,password);
		return new HomePage(driver);
	}
}
