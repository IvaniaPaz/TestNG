package com.class01;

import org.testng.annotations.*;

public class TaskTest2 {
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	@Test
	public void TestOne() {
		System.out.println("Test 1");
	}
	@Test
	public void TestTwo() {
		System.out.println("Test 2");
	}
}
