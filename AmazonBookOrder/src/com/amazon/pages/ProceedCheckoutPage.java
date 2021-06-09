package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Sumair
 * Amazon Proceed to checkout page elements captured in this page.
 *
 */

public class ProceedCheckoutPage {
 WebDriver driver;
 

	By Deliver_this_addr = By.xpath("//a[contains(text(),'Deliver')]");
 	By ProceedToChkout_price = By.xpath("//span[@class='a-color-price']");
              
	public ProceedCheckoutPage(WebDriver driver) {
		this.driver=driver;
		}
	

public void ClickDeliverThisAddr()
{
driver.findElement(Deliver_this_addr).click();

}

public String getProceedToChkout_price()
{
return driver.findElement(ProceedToChkout_price).getText();
}

}
