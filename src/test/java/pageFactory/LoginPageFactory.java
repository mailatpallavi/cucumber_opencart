package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

	private WebDriver driver;

	// Constructor
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators

	@FindBy(id = "input-email")
	WebElement txt_email;

	@FindBy(id = "input-password")
	WebElement txt_password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btn_login;

	@FindBy(xpath = "//h2[normalize-space()=\"My Account\"]")
	WebElement login_page_success;

	@FindBy(linkText = "Forgotten Password")
	WebElement link_forgot_pswd;

	@FindBy(linkText = "Logout")
	WebElement link_logout;

	// Methods/actions

	public void enter_email_password(String email, String Password) {
		txt_email.sendKeys(email);
		txt_password.sendKeys(Password);
	}

	public void click_login_button() {
		btn_login.click();
	}

//	public boolean checkLoginPageSuccess() {
//		boolean success_page_msg = login_page_success.isDisplayed();
//		return success_page_msg;
//	}

	public String checkLoginPageSuccess() {
		return login_page_success.getText();
	}

	public void click_forgot_password() {
		link_forgot_pswd.click();
	}

	public boolean checkForgotPwdLink() {
		return link_forgot_pswd.isDisplayed();

	}

	public String getForgotPwdPageURL() {
		String forgotPwdPageURL = driver.getCurrentUrl();
		return forgotPwdPageURL;

	}
}
