package com.firstmaven01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstMavenClass {

	public static void main(String[] args) throws Exception {
		
		//Step1: Create WebDriverManager
		WebDriverManager.edgedriver().setup();
		
		//Step2: Create a driver
		
		WebDriver driver= new EdgeDriver();
		driver.get("https://www.google.com");
		//We use javaFaker to get some fake data, we can use it in our test case
		//Thread.sleep(6000);
		// \"asdasdsad\"  'asdasdsad'
		//driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();
		
		try {
			driver.findElement(By.xpath("//*[text()='I agree']")).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Faker faker = new Faker();
		driver.findElement(By.name("q")).sendKeys(faker.name().fullName()+ Keys.ENTER);
		
		
		

	}

}
