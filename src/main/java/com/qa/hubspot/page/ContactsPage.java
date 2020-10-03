package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementUtil;

public class ContactsPage extends BasePage{
	WebDriver driver;
	ElementUtil element;
	
	By createContact=By.xpath("//span[text()='Create contact']");
	By email = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");

	By createContactFormButton = By.xpath("(//button[@type='button']//span[text()='Create contact'])[position()=2]");

	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		element = new ElementUtil(driver);
		
	}
	
	public void clickonCreateContact()
	{
		element.doGetClick(createContact);
	}
	
	public void InsertForm(String emailid, String fName, String lName, String jTitle)
	{
	    element.doGetsendkeys(email, emailid); 
	    element.doGetsendkeys(firstName, fName);
	    element.doGetsendkeys(lastName, lName);
	    element.doGetsendkeys(jobTitle, jTitle);
	    element.doGetClick(createContactFormButton);
	    
		
	}


}
