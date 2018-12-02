package com.ibm.seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.tools.javac.util.Assert;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class RoundTrip {
	// Declaratoin of main method
	public static void main(String[] args) {

		// Setting path for Firefox driver
		
		 System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		 WebDriver driver= new FirefoxDriver();
		 
		driver.get("https://spicejet.com");

		// locating radio button Round Trip and clicking on it
		WebElement roundTripElt = driver
				.findElement(By.xpath("//table[@id='ctl00_mainContent_rbtnl_Trip']/tbody/tr/td[1]/following::input"));
		System.out.println(roundTripElt.getTagName());
		roundTripElt.click();

		// Locating and clicking on Departure web element
		WebElement inputElt = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		inputElt.click();

		// WebElement
		// fromElt=driver.findElement(By.xpath("//table[@id='citydropdown']/tbody/tr[2]/td[2]/ul/li[6]/following::a"));

		// Selecting the departure city field as Chennai
		WebElement fromElt = driver.findElement(By.xpath("//a[@value='MAA']"));
		fromElt.click();

		// Locating and clicking on To web element
		WebElement inputTo = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
		inputTo.click();

		// Selecting the destination city as Bangalore
		WebElement toElt = driver.findElement(By.xpath("//a[@value='BLR']"));
		toElt.click();

		// locating and selecting Deaprture date
		WebElement departDate = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[2]/td[4]/descendant::a"));
		departDate.click();

		
		WebElement calendarButton = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']"));
		calendarButton.click();

		WebElement returnDate2 = driver
				.findElement(By.xpath("//*[contains(@class,'ui-state-default') and text()='7']"));
		returnDate2.click();

		// Locating and clicking Passenger drop down
		WebElement ageLevel = driver.findElement(By.xpath("//div[text()='1 Adult']"));
		ageLevel.click();

		// To click on + button to increase the No.of adults
		WebElement plusElt = driver.findElement(By.xpath("//span[@id='hrefIncAdt']"));
		plusElt.click();

		// To click on Done button
		driver.findElement(By.id("btnclosepaxoption")).click();

		// Selecting currency drop down value as USD'
		WebElement currencyElt = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		Select selectCurrency = new Select(currencyElt);
		selectCurrency.selectByVisibleText("USD");

		// To click on Search button
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

		// Displaying selected journey location details
		String tripText = driver.findElement(By.className("trip-detrails-sector")).getText();
		System.out.println();
		System.out.println("Round Trip Location details: " + tripText);

		System.out.println();
		// Verifying that the results are displayed as per the search criteria
		String result = driver.findElement(By.className("flightfare")).getText();

		if (result.contains("USD"))
			System.out.println("Flight Search Results are displayed");

	}

}
