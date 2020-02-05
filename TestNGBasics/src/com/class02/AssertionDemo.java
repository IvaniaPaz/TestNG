package com.class02;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.class01.CommonMethods;
import com.class01.Constants;

public class AssertionDemo extends CommonMethods {

	@BeforeMethod(alwaysRun=true)
	public void openAndNavigate() {
		setUp("chrome", Constants.HRMS_URL);
	}

	@Test(enabled = true)
	public void TitleValidation() {
		String expectedTitle = "Human Management Systems";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Titles are matched");

//		if (actualTitle.equals(expectedTitle)) {
//			System.out.println("Test passed");
//		} else {
//			System.err.println("Test failed");
//		}
	}

	@Test(groups="regression")
	public void LogoValidation() {
		boolean Logo = driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		Assert.assertTrue(Logo, "Syntax Logo is displayed");
//		//using if condition we cannot make test NG test fail -> no way that it'll fail 
//		if (Logo) {
//			System.out.println("Test passed");
//		} else {
//			System.err.println("Test failed");
//		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}