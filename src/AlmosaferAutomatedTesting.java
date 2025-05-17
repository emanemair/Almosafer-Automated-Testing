import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
		
		WebElement SaudiArabiaButton = driver.findElement(By.id("mui-2")); 
		SaudiArabiaButton.click(); 
		
	}
	
	@Test (priority = 2 , enabled = false)
	public void CheckLanguage() {
		
		String ExpectedLang = "en"; 
		String ActualLang = driver.findElement(By.tagName("html")).getDomAttribute("lang"); 
		AssertJUnit.assertEquals(ActualLang, ExpectedLang);
		
	}

	@Test (priority = 3 , enabled = true)
	public void CheckCurrency() {
		
		String ExpectedCurrency = "SAR"; 
		String ActualCurrency = driver.findElement(By.xpath("//div[@data-testid='Header__CurrencySelector']")).getText();
		AssertJUnit.assertEquals(ActualCurrency, ExpectedCurrency);
	}
	
	@Test(priority = 4 , enabled = true)
	public void CheckContactNumber() {
		
		String ExpectedContactNumber = "+966554400000" ; 
		String ActualContactNumber  = driver.findElement(By.xpath("//div[@style='direction:ltr;order:1']")).getText(); 
		AssertJUnit.assertEquals(ActualContactNumber, ExpectedContactNumber); 
	}
	
	@Test(priority = 5 , enabled = true) 
	public void VerifyQitafLogoInFooter() {
		
		WebElement Footer = driver.findElement(By.tagName("footer")); 
		WebElement QitafLogo = Footer.findElement(By.xpath("//img[@alt='qitaf']")); 
		Boolean ActualQitafLogoResult = QitafLogo.isDisplayed(); 
		Boolean ExppectedQitafLogoResult = true; 
		
		Assert.assertEquals(ActualQitafLogoResult, ExppectedQitafLogoResult); 
	}
	
	
	@Test(priority = 6 , enabled = true) 
	public void HotelSearchTabIsNotSelectedByDefault() {
		
		String ExpectedHotelTabState = "false"; 
		String ActualHotelTabState = driver.findElement(By.id("tab-hotels")).getDomAttribute("aria-selected"); 
		Assert.assertEquals(ActualHotelTabState, ExpectedHotelTabState);
}
	
	@Test(priority = 7 , enabled = true)
	public void FlightDepatureDate() {
		
	}
}