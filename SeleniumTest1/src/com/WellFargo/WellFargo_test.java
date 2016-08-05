package com.WellFargo;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class WellFargo_test {

	public static void main(String[] args) throws InterruptedException 
	{
		String expectedpage = "Wells Fargo - Personal & Business Banking - Student, Auto & Home Loans - Investing & Insurance";
		String expectedheader = "About Wells Fargo";
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		//Step 1: Open the WebPage "http://www.WellsFargo.com" in firefox browser
		driver.get("https://www.wellsfargo.com/");
		
		//Step 2: verify you are on personal tab
		String actualpage= driver.getTitle();
		System.out.println("The expected page is "+"\""+  expectedpage +"\"");
		System.out.println("The actual page is "+"\""+actualpage+"\"");
		if(expectedpage.equals(actualpage))
		{
			System.out.println("Actual page matches with expected page. The user is on Personal tab");
		}else
		{
			System.out.println("This is not personal tab");
		}
		System.out.println("");
		
		//Step 3: There is  "About Wells Fargo". click on link and verify the page.
		WebElement Aboutlink = driver.findElement(By.xpath("//*[@id='headerTools']/nav/ul/li[2]/a"));
		Aboutlink.click();		
		System.out.println("The title of the page is "+"\""+driver.getTitle()+"\"");
		
		//Step 4: Confirm the heading
		String Actualheader = driver.findElement(By.xpath("//*[@id='shell']/div[1]/h1")).getText();
		System.out.println("The expected header text is " +"\""+ expectedheader+"\"");
		System.out.println("The actual header text is "+"\""+Actualheader+"\"");
		if(expectedheader.equals(Actualheader))
		{
			System.out.println("The expected header text matches with actual header text");
			
		}else
		{
			System.out.println("The header msg does not match");
		}
		System.out.println("");
		
		//Step 5: navigate back to the home page
		driver.navigate().back();
		
		//Step 6: check you are on the Personal tab
		String actualtab= driver.getTitle();
		System.out.println("The expected page after navigating back is " +"\""+ expectedpage+"\"");
		System.out.println("The actual page is "+"\""+actualtab+"\"");
		if(expectedpage.equals(actualtab))
		{
			System.out.println("Actual page after navigate back matches with expected page. The user is on Personal tab");
		}else
		{
			System.out.println("This is not personal tab");
		}
		System.out.println("");
		
		//Step 7: click on insurance tab - click Homeowners insurance link
		WebElement insurance = driver.findElement(By.xpath("//*[@id='insuranceTab']/a"));

		Actions action = new Actions(driver);
				action.moveToElement(insurance).build().perform();
		driver.findElement(By.xpath("//*[@id='insurance']/div[1]/div[2]/ul/li[1]/a")).click();
		
	
		
		
		
		

	}

}
