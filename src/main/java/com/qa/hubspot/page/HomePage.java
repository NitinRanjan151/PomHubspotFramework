package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementUtil;

public class HomePage extends BasePage{
	
	WebDriver driver;
	ElementUtil util;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		util=new ElementUtil(driver);
	}

	By header=By.cssSelector("h1.private-header__heading");
	
	By importbtn=By.linkText("Start import");
	
	
	public void getHeaderDisplayed()
	{
		util.doGetElementDisplayed(header);
	}
	public String getPageTitle()
	{
		return util.dpGetTitle();
	}
	
	
	
	

}
	