package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.page.ContactsPage;
import com.qa.hubspot.page.HomePage;
import com.qa.hubspot.page.LoginPage;
import com.qa.hubspot.util.Credentials;

public class ContactsPageTest 
{
	Properties prop;
	WebDriver driver;
	BasePage base;
	LoginPage login;
	HomePage home;
	ContactsPage contactsPage;
	Credentials cred;
	
	@BeforeMethod
	public void setUp() {
		base = new BasePage();
		prop = base.getProperties();
		driver = base.init(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		login = new LoginPage(driver);
		cred=new Credentials(prop.getProperty("username"), prop.getProperty("password"));
	
	}

	@Test
	public void createContactTest()
	{
			
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	


}
