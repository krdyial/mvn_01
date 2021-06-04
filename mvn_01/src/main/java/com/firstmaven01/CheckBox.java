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

public class CheckBox {
	
//	1.Create a class : CheckBox
//

//	1.Go to https://the-internet.herokuapp.com/checkboxes
//
//	2.Locate the elements of checkboxes
//
//	3.Then click on checkbox1 if box is not selected
//
//	4.Then click on checkbox2 if box is not selected
//	

	WebDriver driver;
//	1.Go to https://the-internet.herokuapp.com/checkboxes
	@Before
	public void setUp() {
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	//3.Then click on checkbox1 if box is not selected
	@Test
	public void checkBox1() throws Exception {
		WebElement checkbox1= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
		checkbox1.click();
		Thread.sleep(5000);
		Assert.assertTrue(checkbox1.isSelected());
		
	}
	
	
//	4.Then click on checkbox2 if box is not selected
	
	@Test
	public void checkBox2() throws Exception {
		WebElement checkbox2= driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		checkbox2.click();
		Thread.sleep(5000);
		Assert.assertTrue(!checkbox2.isSelected());
	}
	
	@After
	public void tearDown() {
		driver.close();  //5.16.21
	
	}
}
