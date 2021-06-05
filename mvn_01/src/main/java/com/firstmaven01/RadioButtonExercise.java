package com.firstmaven01;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonExercise {
//	1. Create a class : RadioButton
//	2. Complete the following task.
//	1.Go to https://www.facebook.com/
//	3.Click on Create an Account button
//	4.Locate the elements of radio buttons
//	5.Then click on the radio buttons for your gender if they are not selected
	
	
	@Test
	public void radioButtonTest() throws Exception {
		WebDriverManager.edgedriver().setup();
		WebDriver driver= new EdgeDriver();
		driver.get("https://www.facebook.com/");
		try {
			driver.findElement(By.xpath("//*[text()='Alle akzeptieren']")).click();
		} catch (Exception e) {
			e.getMessage();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Neues Konto erstellen")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Ali");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(faker.name().lastName());
		//driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(faker.funnyName()+"@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("123456987");
		driver.findElement(By.xpath("//select/option[@value='15']")).click();
		driver.findElement(By.xpath("(//select/option[@value='12'])[2]")).click();
		driver.findElement(By.xpath("//select/option[@value='1988']")).click();
		//WebElement weiblichRadioButton =driver.findElement(By.id("u_2_2_Us")); 
		Thread.sleep(2000);
		WebElement männlichButton= driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
		männlichButton.click();
		Thread.sleep(2000);
		Assert.assertTrue(männlichButton.isSelected());
		
		
		
	}

}
