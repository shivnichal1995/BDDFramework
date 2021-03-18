package com.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.Select;

import com.test.utils.TestBase;

public class IbiboHomePage extends TestBase{
	
	
	By FromDropdown = By.xpath("//input[@id='gosuggest_inputSrc']");
	
	By DestinationDropdown = By.xpath("//input[@id='gosuggest_inputDest']");
	
	By DepartureCalender = By.xpath("//input[@id='departureCalendar']");
	
	By ReturnCalender = By.xpath("//input[@id='returnCalendar']");
	
	By NextArrow = By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']");
	
	By MonthYearLabel = By.xpath("//div[@role='heading']");
	
	By SearchButton = By.xpath("//button[contains(text(),'SEARCH')]");
	
	public IbiboHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public void verifySelectedReturnFromDestinationAndDepartureDate(String returnFrom, String returnDest, String returnDate, String returnMonth_Year)
	{
List<WebElement> labels = driver.findElements(By.xpath("//span[@class='fl mobdn ico18 padL10']"));
		
		String returnLabel = labels.get(1).getText();
		System.out.println(returnLabel);
		
		

		if (returnLabel.contains(returnFrom)) {
			System.out.println("source is correct");
		} else {
			System.out.println("source is incorrect");
		}

		if (returnLabel.contains(returnDest)) {
			System.out.println("destination is correct");
		} else {
			System.out.println("destination is incorrect");
		}

		if (returnLabel.contains(returnDate)) {
			System.out.println("date is correct");
		} else {
			System.out.println("date is incorrect");
		}

		if (returnLabel.contains(returnMonth_Year)) {
			System.out.println("month or year is correct");
		} else {
			System.out.println("month or year is incorrect");
		}	
	}
	
	public void selectReturenDate(String date,String month_year) throws InterruptedException
	{
		driver.findElement(ReturnCalender).click();
		Thread.sleep(2000);
		for (int i = 0; i < 20; i++) {
			WebElement ym = driver.findElement(By.xpath("//div[@role='heading']"));
			String str1 = ym.getText();
			if (str1.equals(month_year)) {

				driver.findElement(By.xpath("//div[@class='DayPicker-Day']//div[contains(text(),'"+date+"')]"))
						.click();
				Thread.sleep(2000);
				break;

			} else {
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}
		}
	}
	
	public void verifySelectedFromDestinationAndDepartureDate(String from, String dest, String date, String month_year)
	{

		String selectedDetails = driver.findElement(By.xpath("//span[@class='fl mobdn ico18 padL10']")).getText();

		if (selectedDetails.contains(from)) {
			System.out.println("source is correct");
		} else {
			System.out.println("source is incorrect");
		}

		if (selectedDetails.contains(dest)) {
			System.out.println("destination is correct");
		} else {
			System.out.println("destination is incorrect");
		}

		if (selectedDetails.contains(date)) {
			System.out.println("date is correct");
		} else {
			System.out.println("date is incorrect");
		}

		if (selectedDetails.contains(month_year)) {
			System.out.println("month or year is correct");
		} else {
			System.out.println("month or year is incorrect");
		}	
	}
	
	
	
	public void selectCheapPriceBookButton() throws InterruptedException
	{
		List<WebElement> BookButtons = driver.findElements(By.xpath("//input[@value='BOOK']"));
		//System.out.println(BookButtons.size());
		BookButtons.get(0).click();
		Thread.sleep(3000);
	}
	
	public void clickOnSearchButton()
	{
		driver.findElement(SearchButton).click();
	}
	
	public void selectAdultsChildrenInfantsAndTravelclass(int adults, int children, 
			int infants,String travelclass)
	{

		driver.findElement(By.xpath("//div[@id='pax_link_common']")).click();
		for (int i = 1; i < adults; i++) {
			driver.findElement(By.xpath("//button[@id='adultPaxPlus']")).click();
		}

		if (children != 0) {
			for (int i = 0; i < children; i++) {
				driver.findElement(By.xpath("//button[@id='childPaxPlus']")).click();
			}
		}

		if (infants != 0) {
			for (int i = 0; i < infants; i++) {
				driver.findElement(By.xpath("//button[@id='infantPaxPlus']")).click();
			}
		}
		Select trvlclas = new Select(driver.findElement(By.id("gi_class")));
		trvlclas.selectByVisibleText(travelclass);
	}
	
	
	public void selectDepartureDate(String date,String month_year) throws InterruptedException
	{
		driver.findElement(DepartureCalender).click();
		Thread.sleep(2000);
		for (int i = 0; i < 20; i++) {
			WebElement ym = driver.findElement(MonthYearLabel);
			String str1 = ym.getText();
			if (str1.equals(month_year)) {

				driver.findElement(By.xpath("//div[@class='DayPicker-Day']//div[contains(text(),'"+date+"')]"))
				.click();
				Thread.sleep(2000);
				break;

			} else {
				driver.findElement(NextArrow).click();
			}
		}
	}
	
	public void selectTrip(String typeOfTrip)
	{
		driver.findElement(By.xpath("//span[contains(text(),'" + typeOfTrip + "')]")).click();
	}
			
			
	public void enterFrom(String from) throws InterruptedException
	{
		
		
		driver.findElement(FromDropdown).click();
		driver.findElement(FromDropdown).sendKeys(from);
		Thread.sleep(2000);
		driver.findElement(FromDropdown).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		driver.findElement(FromDropdown).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		
		
		
	}
	
	public void enterDestination(String dest) throws InterruptedException
	{
		
		driver.findElement(DestinationDropdown).click();
		driver.findElement(DestinationDropdown).sendKeys(dest);
		Thread.sleep(2000);
		driver.findElement(DestinationDropdown).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		driver.findElement(DestinationDropdown).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	
	
			
			
	
	

}
