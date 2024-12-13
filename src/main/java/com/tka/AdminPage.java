package com.tka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminPage {
	WebDriver driver=null;
	
	
	@BeforeClass
	public void loginToAdminPage() {
		driver = new ChromeDriver();
		driver.get("https://javabykiran.com/selenium/login.html");
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("password123");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
	}
	
	
	@AfterClass
	public void closedriver() {
		driver.quit();
	}
	
	

	@Test
	public void testcatagory() {
		
		String txt = driver.findElement(By.xpath("//*[@id=\"categories\"]/div[1]/h2")).getText();

		Assert.assertEquals(txt, "Categories");

	}

	@Test
	public void testHeadingAdminPage() {
		

		String txt = driver.findElement(By.xpath("/html/body/header/div/h1")).getText();

		Assert.assertEquals(txt, "Admin Panel");

	}

	@Test
	public void testaddcatagory() {
		

		driver.findElement(By.xpath("//*[@id=\"add-category\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"category-name\"]")).sendKeys("Java");
		driver.findElement(By.xpath("//*[@id=\"category-form\"]/div/button[1]")).click();

		String txt = driver.findElement(By.xpath("//*[@id=\"categories-table\"]/tbody/tr[3]/td[2]")).getText();

		Assert.assertEquals(txt, "Java");

	}


}
