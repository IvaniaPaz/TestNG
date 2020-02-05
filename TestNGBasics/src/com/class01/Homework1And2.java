package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

//TC 1: HRMS Application Login: 
//
//Open chrome browser
//Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
//Enter valid username and password
//Click on login button
//Then verify Syntax Logo is displayed
//Close the browser

public class Homework1And2 extends CommonMethods {

	@BeforeMethod
	public void openAndNavigate() {
		setUp("chrome", Constants.HRMS_URL);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	@Test
	public void login() {
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
	}

	@Test(enabled = true)
	public void LogoVal() {
		boolean Logo = driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		Assert.assertTrue(Logo, "Syntax Logo displayed");
//		if (Logo) {
//			System.out.println("Test pass");
//		} else {
//			System.out.println("Failed");
//		}
	}

//	public void Logo() {
//		boolean displayed=driver.findElement(By.xpath("//a[@href='https://syntaxtechs.com']/img")).isDisplayed();
//		if(displayed) {
//			System.out.println("Verified");
//		}else {
//			System.err.println("Failed");
//		}
//	}

//	TC 2: HRMS Application Negative Login: 
//
//	Open chrome browser
//	Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
//	Enter valid username
//	Leave password field empty
//	Verify error message with text “Password cannot be empty” is displayed.
	@Test
	public void valdiationOfMsg() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("btnLogin")).click();
		boolean errorMsg = driver.findElement(By.id("spanMessage")).isDisplayed();
		String actualError = driver.findElement(By.id("spanMessage")).getText();
		String expectedError = "Password cannot be empty";
		Assert.assertTrue(errorMsg, "error message is displayed");
		Assert.assertEquals(actualError, expectedError);

//		if (error.isDisplayed()) {
//			System.out.println("error is displayed");
//			if (error.getText().equals(expectedError)) {
//				System.out.println("Error msg is correct.Test passed");
//			} else {
//				System.out.println("Error msg is NOT there. Test Failed");
//			}
//		} else {
//			System.out.println("error is NOT displayed. Test Failed");
//		}
	}
}