package parallel;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/*import com.pages.HomePage;
import com.pages.LoginPage;*/
import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;
import io.cucumber.java.After;
/*import io.cucumber.java.AfterStep;*/
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	//private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Before(value="@skip_scenario",order=0)
	public void skip_scenario(Scenario scenario){
		System.out.println("SKIPPED SCENARIO IS : "+ scenario.getName());
		Assume.assumeTrue(false);
	}
	@Before(order = 1)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 2)
	public void lunchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
	}
	/*@Before(order = 2)
	public HomePage login(){
		String userName = prop.getProperty("userName");
		String password = prop.getProperty("password");
		loginPage.doLogin(userName,password);
		return new HomePage(driver);
	}*/

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order = 1)
	public void takeScreenShotsFailScenario(Scenario scenario) {
		if(scenario.isFailed()){
			String screenshotsName = scenario.getName().replaceAll(" ","_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotsName);
		}
	}

	/*@AfterStep
	public void addScreenshot(Scenario scenario){
	      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	      scenario.attach(screenshot, "image/png", "image"); 
		
	}*/

}
