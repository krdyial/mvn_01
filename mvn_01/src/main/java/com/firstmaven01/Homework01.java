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
		
		String actualTitle= driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[1]/label")).getText();
		System.out.println("Title:"+actualTitle);
		String expectedTitle= "Title";
		Assert.assertTrue(actualTitle.equals(expectedTitle));
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys(faker.name().firstName());
		driver.findElement(By.id("customer_lastname")).sendKeys(faker.name().lastName());
		driver.findElement(By.id("passwd")).sendKeys(faker.name().firstName()+faker.name().lastName());
		
		WebElement daysDrop= driver.findElement(By.id("days"));
		Select select= new Select(daysDrop);
		select.selectByValue("15");
		WebElement monthDrop= driver.findElement(By.id("months"));
		Select select1= new Select(monthDrop);
		select1.selectByIndex(6);
		WebElement yearDrop= driver.findElement(By.id("years"));
		Select select2= new Select(yearDrop);
		select2.selectByValue("1986");
		
		WebElement newsTeller= driver.findElement(By.id("newsletter"));
		newsTeller.click();
		Assert.assertTrue(newsTeller.isSelected());
		driver.findElement(By.id("address1")).sendKeys(faker.address().fullAddress());
		driver.findElement(By.id("city")).sendKeys(faker.address().cityName());
		WebElement stateDrop=  driver.findElement(By.id("id_state"));
		Select select3 = new Select(stateDrop);
		select3.selectByIndex(10);
		
		driver.findElement(By.id("postcode")).sendKeys("59604");
		
		WebElement countryDrop=  driver.findElement(By.id("id_country"));
		Select select4= new Select(countryDrop);
		select4.selectByVisibleText("United States");
		
		driver.findElement(By.id("phone_mobile")).sendKeys("0123654789");
		driver.findElement(By.id("alias")).sendKeys("My address");
		driver.findElement(By.id("submitAccount")).click();
		System.out.println("Verify of succesful Account creation"+driver.findElement(By.id("center_column")).getText());
		
		
		
		
		
		
		
		
		
		
	
		
		
	}

}
