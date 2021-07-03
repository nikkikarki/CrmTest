package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	//Page Factory - OR:
		@FindBy(name="email")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//input[@type='submit']")
		//@FindBy(xpath="(//div[contains(text(), 'Login')])[1]")
		WebElement loginBtn;
		
		@FindBy(xpath="//button[contains(text(),'Sign Up')]")
		//@FindBy(xpath="//a[.='Sign Up']")
		WebElement signUpBtn;
		
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		//Actions:
		public String validateLoginPageTitle(){ //this method will return title of page
			return driver.getTitle();
		}
		
		public HomePage login(String un, String pwd){
			username.sendKeys(un); //username defined in object Repository
			password.sendKeys(pwd);//passward defined in object Repository
			loginBtn.click();
			    	
			return new HomePage();//login page is landing page of home page 
		}
		
}
