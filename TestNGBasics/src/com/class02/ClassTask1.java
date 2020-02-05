package com.class02;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

public class ClassTask1 extends CommonMethods {

	@BeforeMethod
	public void open() {
		setUp("chrome", Constants.HRMS_URL);
	}

	@Test(priority = 1)
	public void login() throws InterruptedException {
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.name("Submit")).click();

		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();

		SoftAssert softA = new SoftAssert();
		
		boolean fullNameDisplay = driver.findElement(By.xpath("//label[@class='hasTopFieldHelp']")).isDisplayed();
		softA.assertTrue(fullNameDisplay);
		
		boolean employeeIdDisplay = driver.findElement(By.xpath("//label[@for='employeeId']")).isDisplayed();
		softA.assertTrue(employeeIdDisplay);
		
		boolean photoDisplay = driver.findElement(By.xpath("//label[@for='photofile']")).isDisplayed();
		softA.assertTrue(photoDisplay);
	
		softA.assertAll();
		
		String firstN="Jane";
		String lastN="Doe";

		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstN);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastN);
	
		String empID=driver.findElement(By.xpath("//input[@id='employeeId']")).getAttribute("value");

		driver.findElement(By.xpath("//input[@name='photofile']")).sendKeys("C:\\Users\\Ivania Paz\\Desktop\\cat.png");
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(4000);
		String empIDConfirm=driver.findElement(By.xpath("//input[@name='personal[txtEmployeeId]']")).getAttribute("value");
		softA.assertEquals(empIDConfirm, empID);
	    String EmpName=	driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		softA.assertEquals(EmpName, firstN+" "+lastN);
		
		softA.assertAll();
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}
}