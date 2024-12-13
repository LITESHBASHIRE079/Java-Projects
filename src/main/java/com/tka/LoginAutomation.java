package com.tka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAutomation {
	WebDriver driver= null;
	
	@BeforeClass
	public void openloginpage() {
		driver = new ChromeDriver();
		driver.get("https://javabykiran.com/selenium/login.html");
	}
	
	
	@BeforeMethod
	public void clearTextBox() {
		driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
	}
	
	
	@AfterClass
	public void closedriver() {
		driver.quit();
	}
	
	
	
	@Test
	public void testheading1() {

		String txt = driver.findElement(By.xpath("/html/body/div/div/h1")).getText();
		Assert.assertEquals(txt, "Welcome Back");

	}
	
	@Test
	public void testlogininvalidError() {
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("aabb");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("1234");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();

		String txt = driver.findElement(By.xpath("//*[@id=\"error-message\"]")).getText();
		
		Assert.assertEquals(txt, "Invalid username or password");
	}
	
	@Test
	public void testtologinintosysytem() {
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("password123");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
		String txt = driver.getTitle();


		Assert.assertEquals(txt, "Admin Panel - Manage Categories");

	}
	
	

}
