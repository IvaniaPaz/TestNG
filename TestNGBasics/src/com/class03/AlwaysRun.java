package com.class03;

import org.testng.annotations.*;

public class AlwaysRun {
	
	@BeforeSuite(alwaysRun=true)
	public void beforeSuite() {
		System.out.println("I am before suite");
	}
	
	@BeforeTest(alwaysRun=true)
	public void beforeTest() {
		System.out.println("I am before test");
	}

	@BeforeClass(alwaysRun=true)
	public void beforeclass() {
		System.out.println("I am before method");
	}
	@BeforeMethod(alwaysRun=true)
	public void beforeMethod() {
		System.out.println("I am before method");
	}
	@AfterMethod(alwaysRun=true)
	public void afterMetho() {
		System.out.println("I am after method");
	}
	
	@Test
	public void testMethod() {
		System.out.println("I am test");
	}
	@Test
	public void testMethod1() {
		System.out.println("I am test1");
	}
	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		System.out.println("I am before suite");
	}
	
	@AfterTest(alwaysRun=true)
	public void afterTest() {
		System.out.println("I am before test");
	}

	@AfterClass(alwaysRun=true)
	public void afterclass() {
		System.out.println("I am before method");
	}











}
