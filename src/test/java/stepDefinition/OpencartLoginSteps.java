package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.LoginPageFactory;

public class OpencartLoginSteps {
	WebDriver driver;
	LoginPageFactory pageObject1;

	@Before
	public void setup() {
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Given("I am on the Opencart login page")
	public void i_am_on_the_opencart_login_page() {
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		pageObject1 = new LoginPageFactory(driver);
	}

	@Given("I have entered a valid username and password")
	public void i_have_entered_a_valid_username_and_password() {
		pageObject1.enter_email_password("mailatp.pallavi@gmail.com", "pal@123");
	}

	@Given("I have entered invalid {string} and {string}")
	public void i_have_entered_invalid_and(String username, String password) throws InterruptedException {
		pageObject1.enter_email_password(username, password);
		Thread.sleep(5000);
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		pageObject1.click_login_button();
	}

	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() {
		// Assert.assertEquals(pageObject1.checkLoginPageSuccess(), true);
		pageObject1.checkLoginPageSuccess();

	}

	@Then("I should see error message indicating {string}")
	public void i_should_see_error_message_indicating(String error_message) {
		// Assert that an error message is displayed on the page matching the expected
		// error message
		Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);

	}

	@When("I click on the Forgotten Password link")
	public void i_click_on_the_forgotten_password_link() {
		pageObject1.click_forgot_password();

	}

	@Then("I should be redirected to the password reset page")
	public void i_should_be_redirected_to_the_password_reset_page() {
		Assert.assertTrue(pageObject1.getForgotPwdPageURL().contains("account/forgotten"));
	}

}
