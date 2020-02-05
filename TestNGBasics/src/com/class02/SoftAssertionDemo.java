package com.class02;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.class01.CommonMethods;
import com.class01.Constants;

/*Open Application
 * Verify Logo is displayed
 * Enter valid credentials
 * Verify user successfully logged in
 */
public class SoftAssertionDemo extends CommonMethods {

	@BeforeMethod
	public void open() {
		setUp("chrome", Constants.HRMS_URL);
	}

	@Test
	public void logoAndLogin() {
		boolean logoDisplayed = driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		logoDisplayed=false;
// hard assert will fail and not execute->    Assert.assertTrue(logoDisplayed, "Logo is NOT displayed");
		
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertTrue(logoDisplayed, "Logo is NOT displayed");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.name("Submit")).click();
		boolean welcomeDisplay = driver.findElement(By.id("welcome")).isDisplayed();
//		Assert.assertTrue(welcomeDisplay);
		softAssert.assertTrue(welcomeDisplay, "Welcome element is NOT displayed");
		softAssert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
