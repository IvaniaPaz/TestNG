package com.class01;

import org.testng.annotations.*;

public class DifferentAnnotations {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("AfterSuite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before test");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("After test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class");
	}
	@AfterClass
	public void AfterClass() {
		System.out.println("After class");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method");
	}
	@Test
	public void Test() {
		System.out.println("I am an actual test");
	}
	

}
