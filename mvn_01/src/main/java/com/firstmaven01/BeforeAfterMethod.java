package com.firstmaven01;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BeforeAfterMethod {
	WebDriver driver;
	

	 @Before
	 public void setUp() {
		WebDriverManager.edgedriver().setup();
	    driver= new EdgeDriver();
		driver.get("https://www.google.com");
		try {
			driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();
		} catch (Exception e) {
			e.getMessage();
		}
		driver.manage().window().maximize(); 
		}
		
	@Test
	public void titleTest() {
		
		String actualTitle= driver.getTitle();
		String expectedTitle= "Google";
		
		String result = actualTitle.equals(expectedTitle) ? "PASSES" : "FAILS";
		System.out.println(result);
	}
	
	@Test
	public void imageTest() {
		
		WebElement imgGoogle =driver.findElement(By.xpath("//img[@class='lnXdpd']"));
		Assert.assertTrue(imgGoogle.isDisplayed());
		
	}
	
	@Test
	public void gmailLinkTest() {
		
		WebElement gmailLink= driver.findElement(By.linkText("Gmail"));
		Assert.assertTrue(gmailLink.isDisplayed());
	}
	
	@After
	public void tearDown() {
		//Closing driver after all test steps it is called tearDown 
		driver.close();
	}
	
	

}
