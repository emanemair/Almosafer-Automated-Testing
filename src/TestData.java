import java.time.LocalDateTime;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestData {


	String URL = "https://www.almosafer.com/en";
	String WebSiteLang = ""; 
	WebDriver driver = new ChromeDriver(); 
	Random rand = new Random(); 
	String ExpectedLang = "en"; 
	String ExpectedCurrency = "SAR"; 
	String ExpectedContactNumber = "+966554400000" ; 
	Boolean ExppectedQitafLogoResult = true; 
	String ExpectedHotelTabState = "false"; 
	LocalDateTime today = LocalDateTime.now();
	int  tmwr = today.plusDays(1).getDayOfMonth();
	String ExpectudeDay = String.format("%02d", tmwr ); 
	String ExpectedArrivalTime = String.format("%02d", today.plusDays(2).getDayOfMonth()); 
	

	String[] WebsiteLangs  = {"https://www.almosafer.com/en" , "https://www.almosafer.com/ar"}; 
	
	int RandomLang = rand.nextInt(WebsiteLangs.length); 
	
	String SelectedWebsiteLang = WebsiteLangs[RandomLang]; 
	String ExpectedLanguage =  SelectedWebsiteLang.substring(SelectedWebsiteLang.length() - 2); 

	String[] LocationEn = {"Duabi" , "Jeddah" , "Riyadh"}; 
	String [] LocationAr = {"دبي", "جدة"} ;   
	
	Boolean ExpectedResut = true; 
	public void Setup() {
		

		driver.get(URL); 
		driver.manage().window().maximize();
		
	}
}
