package com.firstmaven01;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Homework01 {
	
	WebDriver driver;
	Faker faker;
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void test1() {
		driver.findElement(By.partialLinkText("Sign in")).click();
		faker=new Faker();
		driver.findElement(By.id("email_create")).sendKeys(faker.name().firstName()+"@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		String actualHead= driver.findElement(By.xpath("//*[text()='Create an account']")).getText();
		System.out.println(actualHead);
		String expectedHead= "CREATE AN ACCOUNT";
		Assert.assertTrue(actualHead.equals(expectedHead));
		
		Actions action = new Actions(driver);
		WebElement state= driver.findElement(By.id("id_state"));
		Select select= new Select(state);
		select.selectByValue("Florida");
		
	}

}
