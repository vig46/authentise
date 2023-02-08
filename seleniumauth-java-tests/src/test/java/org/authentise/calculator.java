package org.authentise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class calculator
{
	
	WebDriver driver = null;
	@BeforeTest
	public void launch_browser() throws InterruptedException
	{
		System.getProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.findElement(By.id("L2AGLb")).click();
	}
	
	@Test
	public void temperature() throws InterruptedException
	{
		driver.get("https://www.calculator.net/conversion-calculator.html");
		String title = driver.getTitle();
		System.out.println(title);
		WebElement Temp_link = driver.findElement(By.xpath("//a[normalize-space()='Temperature']"));
		Temp_link.click();
		
		WebElement from_Options = driver.findElement(By.xpath("//option[normalize-space()='Celsius']"));
		from_Options.click();
		
		WebElement fromField = driver.findElement(By.name("fromVal"));
		fromField.sendKeys("10");
		
		WebElement to_Options = driver.findElement(By.cssSelector("select[id='calTo'] option[value='3']"));
		to_Options.click();
		
		WebElement toField = driver.findElement(By.name("toVal"));
		String to_Value = toField.getAttribute("value");
		System.out.println(to_Value);
		Assert.assertEquals(to_Value, "50");
		
		Thread.sleep(3000);
	}
	
	@Test
	public void weight() throws InterruptedException
	{
		driver.get("https://www.calculator.net/conversion-calculator.html");
		
		WebElement Weight_link = driver.findElement(By.xpath("//a[normalize-space()='Weight']"));
		Weight_link.click();
		
		WebElement from_Options = driver.findElement(By.xpath("//option[normalize-space()='Kilogram']"));
		from_Options.click();
		
		WebElement fromField = driver.findElement(By.name("fromVal"));
		fromField.sendKeys("0.5");
		
		WebElement to_Options = driver.findElement(By.cssSelector("select[id='calTo'] option[value='2']"));
		Thread.sleep(3000);
		to_Options.click();
		
		WebElement toField = driver.findElement(By.name("toVal"));
		String to_Value = toField.getAttribute("value");
		System.out.println(to_Value);
		Assert.assertEquals(to_Value, "500");
		
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
}
