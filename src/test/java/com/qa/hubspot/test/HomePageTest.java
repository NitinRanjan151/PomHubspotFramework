package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.page.HomePage;
import com.qa.hubspot.page.LoginPage;
import com.qa.hubspot.util.Credentials;

public class HomePageTest {

	
	WebDriver driver;
	BasePage base;
	Properties prop;
	LoginPage login;
	Credentials cred;
	HomePage homepage;
	
	@BeforeTest
	public void setup() {
		base = new BasePage();

		prop = base.getProperties();
		driver = base.init(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		login = new LoginPage(driver);
		cred=new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		homepage=login.login(cred);
	}
	
	@Test
	public void verifyHomePageTitleTest()
	{
		String title= homepage.getPageTitle();
		Assert.assertEquals(title, title.contains("Account setup"));
		
	}

	
	
	
	
}
