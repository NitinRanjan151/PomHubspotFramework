package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Credentials;
import com.qa.hubspot.util.ElementUtil;

public class LoginPage extends BasePage{

	WebDriver driver;
	ElementUtil element;

	// Locators:-
	By Email = By.id("username");
	By password = By.id("password");
	By Loginbtn = By.id("loginBtn");
	By SignupLinl = By.linkText("Sign up");
	By ForgotPasswordLink = By.linkText("Forgot my password");
	By GoogleSigninbtn = By.className("google-sign-in");
	By PrivacyPolicyLink = By.linkText("Privacy Policy");
	By FooterLink = By.className("copyright");

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		element=new ElementUtil(driver);
		
	}

	// Actions

	public String pageTitle() {
		return element.dpGetTitle();
	}

	public boolean getSignupLink() {
		return element.doGetElementDisplayed(SignupLinl);
	}

	public HomePage login(Credentials cred) {
		element.doGetsendkeys(Email, cred.getUsername());
		element.doGetsendkeys(password, cred.getPassword());
		element.doGetClick(Loginbtn);
		
		return new HomePage(driver);
	}

	public void googleSignin() {
		element.doGetClick(GoogleSigninbtn);
	}
	
	public boolean forgotPassword()
	{
		
		return element.doGetElementDisplayed(ForgotPasswordLink);
		
	}

}
