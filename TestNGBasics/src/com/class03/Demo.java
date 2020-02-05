package com.class03;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import com.utils.CommonMethods;
import com.utils.Constants;

public class Demo extends CommonMethods{

	@BeforeMethod
	public void openAndNavigate() {
		setUp("chrome",Constants.HRMS_URL);
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void TitleValidation() {
		String expectedTitle="Human Management System";
		String actualTitle=driver.getTitle();
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Success!");
		}else {
			System.err.println("Not verified");
		}
	}
	@Test
	public void LogoValidation() {
		boolean Logo=driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		if(Logo) {
			System.out.println("Test pass");
		}else {
			System.out.println("Failed");
		}
	}
	@Test
	public void ValidLogin() {
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
	}


}
