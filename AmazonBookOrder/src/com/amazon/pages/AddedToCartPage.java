package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Sumair
 * Amazon Login page elements captured in this page.
 *
 */

public class AddedToCartPage {
 WebDriver driver;
 

	By Cart_SubTotal = By.xpath("(//b[text()='Cart subtotal'])[1]//parent::span/following-sibling::span");
 	By ProceedToChkout_btn = By.xpath("//a[@id='hlb-ptc-btn-native']");
              
	public AddedToCartPage(WebDriver driver) {
		this.driver=driver;
		}
	


public void ClickonProceedToCheckout()
{
driver.findElement(ProceedToChkout_btn).click();

}

public String getCartSubTotalVal()
{
return driver.findElement(Cart_SubTotal).getText();
}

}
