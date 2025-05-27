import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.time.Duration;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlmosaferAutomatedTesting extends TestData{

	
	
	@BeforeTest
	public void mySetup() {	
		Setup();
	}
	
	@Test(priority = 1 , enabled = true)
	public void SelectCountry() {
		
		WebElement SaudiArabiaButton = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary")); 
		SaudiArabiaButton.click(); 
		
	}
	
	@Test (priority = 2 , enabled = false)
	public void CheckLanguage() {
		
		String ActualLang = driver.findElement(By.tagName("html")).getDomAttribute("lang"); 
		AssertJUnit.assertEquals(ActualLang, ExpectedLang);
		
	}

	@Test (priority = 3 , enabled = false)
	public void CheckCurrency() {
		
		String ActualCurrency = driver.findElement(By.xpath("//div[@data-testid='Header__CurrencySelector']")).getText();
		AssertJUnit.assertEquals(ActualCurrency, ExpectedCurrency);
	}
	
	@Test(priority = 4 , enabled = false)
	public void CheckContactNumber() {
	
		String ActualContactNumber  = driver.findElement(By.xpath("//div[@style='direction:ltr;order:1']")).getText(); 
		AssertJUnit.assertEquals(ActualContactNumber, ExpectedContactNumber); 
	}
	
	@Test(priority = 5 , enabled = false) 
	public void VerifyQitafLogoInFooter() {
		
		WebElement Footer = driver.findElement(By.tagName("footer")); 
		WebElement QitafLogo = Footer.findElement(By.xpath("//img[@alt='qitaf']")); 
		Boolean ActualQitafLogoResult = QitafLogo.isDisplayed(); 
		
		Assert.assertEquals(ActualQitafLogoResult, ExppectedQitafLogoResult); 
	}
	
	
	@Test(priority = 6 , enabled = false) 
	public void HotelSearchTabIsNotSelectedByDefault() {
		
		String ActualHotelTabState = driver.findElement(By.id("tab-hotels")).getDomAttribute("aria-selected"); 
		Assert.assertEquals(ActualHotelTabState, ExpectedHotelTabState);
}
	
	@Test(priority = 7 , enabled = false)
	public void FlightDepatureDate() {
		
		List<WebElement>  Dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG")); 
		String ActualDepatureDay = Dates.get(0).getText(); 
	
		
		Assert.assertEquals(ExpectudeDay, ActualDepatureDay);
		
	}
	
	@Test(priority = 8 , enabled = false )
	public void FlightArrivalDate() {
		
		List<WebElement>  Dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG")); 
		String ActualArrivalDate = Dates.get(1).getText(); 
	
		Assert.assertEquals(ExpectedArrivalTime, ActualArrivalDate);
	}
	
	@Test(priority = 9 , enabled = true )
	public void RandomLanguage() {
			
		driver.get(SelectedWebsiteLang);
		String ActualLang = driver.getCurrentUrl().substring(driver.getCurrentUrl().length() - 2); 
		WebSiteLang = ActualLang; 
		Assert.assertEquals(ExpectedLanguage,ActualLang  );
		
	}
	
	
	@Test(priority = 10 , enabled = true)
	public void SwitchToHotelTab () throws InterruptedException {
		
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")); 
		
		HotelTab.click();
		if (driver.getCurrentUrl().contains("en")) {
			
		int RandomCity = rand.nextInt(LocationEn.length); 
		driver.findElement(By.xpath("//input[@data-testid='AutoCompleteInput']")).sendKeys(LocationEn[RandomCity]); 
		
		}else {
			
			int RandomCity = rand.nextInt(LocationAr.length);
			driver.findElement(By.xpath("//input[@data-testid='AutoCompleteInput']")).sendKeys(LocationAr[RandomCity]); 

		}
		
		Thread.sleep(2000); 
	
		driver.findElement(By.xpath("//li[@data-testid='AutoCompleteResultItem0']")).click(); 			
	
	}
	
	@Test(priority = 11 , enabled = true)
	public void SelectRoom() {
		
		WebElement RoomSelectionItem = driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi")); 
		Select Rooms = new Select(RoomSelectionItem); 
		
		List<WebElement> options = Rooms.getOptions(); 
		int numberOfOptions = options.size();
		int RandomRoom = rand.nextInt(numberOfOptions - 1 ); 
		
		Rooms.selectByIndex(RandomRoom); 
		
		driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']")).click();
		
		
	}
	
	@Test(priority = 12 , enabled = true)
	public void CheckTheFinalResultIsRetrived() {
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement ResultsElement = wait.until(ExpectedConditions.presenceOfElementLocated(
			    By.xpath("//span[@data-testid='srp_properties_found']")));
		
		String SearchResult = ResultsElement.getText();
		Boolean ActualResult = SearchResult.contains("مكان") || SearchResult.contains("stays"); 
		
		Assert.assertEquals(ExpectedResut, ActualResult);
		
	}
	

	

	
}