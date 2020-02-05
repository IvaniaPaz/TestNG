package com.class01;

import org.openqa.selenium.By;
import org.testng.annotations.*;

public class TitleLogoAndLoginVerification extends CommonMethods {

	@BeforeMethod(alwaysRun = true)
	public void openAndNavigate() {
		setUp("chrome", Constants.HRMS_URL);
	}

	@Test(groups = { "regression", "sprint1" })
	public void TitleValidation() {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Success!");
		} else {
			System.err.println("Not verified");
		}
	}

	@Test(groups = { "smoke", "login" })
	public void ValidLogin() {
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
}