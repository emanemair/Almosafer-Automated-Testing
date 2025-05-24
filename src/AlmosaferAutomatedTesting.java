import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlmosaferAutomatedTesting {

	
	String URL = "https://www.almosafer.com/en";
	
	WebDriver driver = new ChromeDriver(); 
	Random rand = new Random(); 
	
	@BeforeTest
	public void mySetup() {
		
		driver.get(URL); 
		driver.manage().window().maximize();
		
	}
	
	@Test(priority = 1 , enabled = true)
	public void SelectCountry() {
		
		WebElement SaudiArabiaButton = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary")); 
		SaudiArabiaButton.click(); 
		
	}
	
	@Test (priority = 2 , enabled = false)
	public void CheckLanguage() {
		
		String ExpectedLang = "en"; 
		String ActualLang = driver.findElement(By.tagName("html")).getDomAttribute("lang"); 
		AssertJUnit.assertEquals(ActualLang, ExpectedLang);
		
	}

	@Test (priority = 3 , enabled = false)
	public void CheckCurrency() {
		
		String ExpectedCurrency = "SAR"; 
		
		String ActualCurrency = driver.findElement(By.xpath("//div[@data-testid='Header__CurrencySelector']")).getText();
		AssertJUnit.assertEquals(ActualCurrency, ExpectedCurrency);
	}
	
	@Test(priority = 4 , enabled = false)
	public void CheckContactNumber() {
		
		String ExpectedContactNumber = "+966554400000" ; 
		String ActualContactNumber  = driver.findElement(By.xpath("//div[@style='direction:ltr;order:1']")).getText(); 
		AssertJUnit.assertEquals(ActualContactNumber, ExpectedContactNumber); 
	}
	
	@Test(priority = 5 , enabled = false) 
	public void VerifyQitafLogoInFooter() {
		
		WebElement Footer = driver.findElement(By.tagName("footer")); 
		WebElement QitafLogo = Footer.findElement(By.xpath("//img[@alt='qitaf']")); 
		Boolean ActualQitafLogoResult = QitafLogo.isDisplayed(); 
		Boolean ExppectedQitafLogoResult = true; 
		
		Assert.assertEquals(ActualQitafLogoResult, ExppectedQitafLogoResult); 
	}
	
	
	@Test(priority = 6 , enabled = false) 
	public void HotelSearchTabIsNotSelectedByDefault() {
		
		String ExpectedHotelTabState = "false"; 
		String ActualHotelTabState = driver.findElement(By.id("tab-hotels")).getDomAttribute("aria-selected"); 
		Assert.assertEquals(ActualHotelTabState, ExpectedHotelTabState);
}
	
	@Test(priority = 7 , enabled = true)
	public void FlightDepatureDate() {
		
		List<WebElement>  Dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG")); 
		String ActualDepatureDay = Dates.get(0).getText(); 
		LocalDateTime today = LocalDateTime.now();
		int  tmwr = today.plusDays(1).getDayOfMonth();
		String ExpectudeDay = String.format("%02d", tmwr ); 
		
		Assert.assertEquals(ExpectudeDay, ActualDepatureDay);
		
	}
	
	@Test(priority = 8 , enabled = true )
	public void FlightArrivalDate() {
		
		List<WebElement>  Dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG")); 
		String ActualArrivalDate = Dates.get(1).getText(); 
		
		LocalDateTime today = LocalDateTime.now(); 
		
		String ExpectedArrivalTime = String.format("%02d", today.plusDays(2).getDayOfMonth()); 
		
		Assert.assertEquals(ExpectedArrivalTime, ActualArrivalDate);
	}
}