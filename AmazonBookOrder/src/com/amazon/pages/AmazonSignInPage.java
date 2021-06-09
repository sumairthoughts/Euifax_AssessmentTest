package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Sumair
 * Amazon Login page elements captured in this page.
 *
 */

public class AmazonSignInPage {
 WebDriver driver;
 

	By Email_input = By.xpath("//input[@name='email']");
 	By continue_btn = By.xpath("//input[@id='continue']");
	By Password_input = By.xpath("//input[@name='password']");
	By Sign_In_btn = By.xpath("//input[@id='signInSubmit']");
              
	public AmazonSignInPage(WebDriver driver) {
		this.driver=driver;
		}
	
public void InputEmail(String eId)
{
driver.findElement(Email_input).sendKeys(eId);

}
public void ClickContinueBtn()
{

driver.findElement(continue_btn).click();
}

public void ClickonSignin()
{
driver.findElement(Sign_In_btn).click();

}

public void InputPassword(String Pwd)
{
driver.findElement(Password_input).sendKeys(Pwd);
}

}
