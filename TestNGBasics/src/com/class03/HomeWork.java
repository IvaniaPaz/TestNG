package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HomeWork extends CommonMethods {

	@BeforeMethod(alwaysRun = true)
	public void openAndNavigate() {
		setUp("chrome", Constants.HRMS_URL);
	}

	@Test(dataProvider="getData", groups="regression")
	public void Login() throws InterruptedException {
		//login
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("Hum@nhrm123");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		
//		WebDriverWait wait=new WebDriverWait();
	}

	@AfterMethod(alwaysRun = true)
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}