package com.amazon.testcases;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.pages.AddedToCartPage;
import com.amazon.pages.AmazonHomePage;
import com.amazon.pages.AmazonSignInPage;
import com.amazon.pages.ProceedCheckoutPage;

/**
 * 
 * @author Sumair
 * 
 *Test class to validate Amazon Search product and checkout flow
 */

public class ValidateAmazonCheckoutFlow {

	@Test
	public void Verify_Amazon_checkoutFlow()
	{
//Initialize the chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\drivers\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//launch the amazon url
		driver.get("https://www.amazon.com");
		
//Initialize AmazonHomePage class and its elements
		
		AmazonHomePage homePage = new AmazonHomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nav-logo-sprites']")));
		homePage.ClickonSigninButton();
		
//Initialize AmazonSignInPage class and its elements	
		AmazonSignInPage signin = new AmazonSignInPage(driver);
		signin.InputEmail("sumairabrar.qa@gmail.com");
		signin.ClickContinueBtn();
		signin.InputPassword("test1234567890");
		signin.ClickonSignin();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nav-logo-sprites']")));

//Input search box with "qa testing for beginners"
		homePage.InputSearchBox("qa testing for beginners");
		homePage.ClickSearchBtn();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='a-link-normal a-text-normal'])[1]")));

//Select the First search result		
		homePage.ClickonFirstResult();
		String Actual_price = homePage.getPriceVal();

//Assert the price value before Add to Cart
		Assert.assertEquals(Actual_price,"$47.49");
		homePage.ClickonAddtoCart();

//Initialize AddToCartPage and its elements
		AddedToCartPage addToCartPage = new AddedToCartPage(driver);
		String price_val = addToCartPage.getCartSubTotalVal();

//Assert the price value before proceed to checkout
		Assert.assertEquals(price_val,"$47.49");
		addToCartPage.ClickonProceedToCheckout();

//Initialize ProceedCheckoutPage and its elements				
		ProceedCheckoutPage proceed = new ProceedCheckoutPage(driver);
		proceed.ClickDeliverThisAddr();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-color-price']")));

//Assert the price value after proceed to checkout		
		String price_val_proceed = proceed.getProceedToChkout_price();
		Assert.assertEquals(price_val_proceed,"$47.49");
		
//Quit the webdriver
		driver.quit();
	}

}
