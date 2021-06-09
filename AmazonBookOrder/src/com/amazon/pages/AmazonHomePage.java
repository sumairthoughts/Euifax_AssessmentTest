package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Sumair
 * Amazon Home page elements captured in this page.
 *
 */

public class AmazonHomePage {
 WebDriver driver;
 
 	By sign_in_btn = By.xpath("//a[@id='nav-link-accountList']");
	By search_box = By.xpath("//input[@id='twotabsearchtextbox']");
	By search_btn = By.xpath("//input[@id='nav-search-submit-button']");
	By first_result_link = By.xpath("(//a[@class='a-link-normal a-text-normal'])[1]");
    By Price_value = By.xpath("//span[@id='newBuyBoxPrice']");
    By Add_to_Cart = By.xpath("//input[@id='add-to-cart-button']"); 
    
	public AmazonHomePage(WebDriver driver) {
		this.driver=driver;
		}
	
public void InputSearchBox(String query)
{
driver.findElement(search_box).sendKeys(query);

}
public void ClickSearchBtn()
{

driver.findElement(search_btn).click();
}
public void ClickonSigninButton()
{
driver.findElement(sign_in_btn).click();

}

public void ClickonFirstResult()
{
driver.findElement(first_result_link).click();
}

public String getPriceVal()
{
return driver.findElement(Price_value).getText();
}

public void ClickonAddtoCart()
{
driver.findElement(Add_to_Cart).click();
}

}
