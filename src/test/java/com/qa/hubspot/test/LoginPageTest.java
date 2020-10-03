package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.page.LoginPage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.Credentials;

public class LoginPageTest {
	WebDriver driver;
	BasePage base;
	Properties prop;
	LoginPage login;
	Credentials cred;

	@BeforeMethod
	@Parameters(value={"browser"})
	public void setup(String browsername) {
		String browser;
		base = new BasePage();
		prop = base.getProperties();
		if(browsername.equals(null))
		{
		browser=prop.getProperty("browser");
		}
		else {
			browser=browsername;
		}
		
		
		driver = base.init(browser);
		driver.get(prop.getProperty("url"));
		login = new LoginPage(driver);
		cred=new Credentials(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyTitleTest() throws InterruptedException {
		Thread.sleep(6000);
		String title = login.pageTitle();
		System.out.println("Page Title is " +title);
		Assert.assertEquals(title, Constants.Login_Page_Title);
	}

	@Test(priority = 2)
	public void verifySignupTest() {

		Assert.assertTrue(login.getSignupLink());

	}

	@Test(priority = 3)
	public void verifyForgotPasswordTest() {
		Assert.assertTrue(login.forgotPassword());
	}

	@Test(priority = 4)
	public void verifyLoginTest() {
		login.login(cred);
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data= {{"Test@gmail.com","Test123"},
				{"Test2@gmail.com","Test345"},
				{"Test3@gmail.com","Test567"}
                };
		return data;
	}
	@Test(dataProvider = "getData",enabled = false)
	public void negativeLoginTest(String username,String pwd)
	{
		cred.setUsername(username);
		cred.setPassword(pwd);
		login.login(cred);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
