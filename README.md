# Almosafer Automated Testing Suite

This project is an automated testing suite for [Almosafer](https://www.almosafer.com) using **Java**, **Selenium WebDriver**, and **TestNG**. It simulates and validates different functionalities on the Almosafer website including language settings, currency, contact details, hotel booking process, and more.

## 🔧 Technologies Used

- Java
- Selenium WebDriver
- TestNG
- ChromeDriver
- JUnit Assertions

## 📁 Project Structure

- `AlmosaferAutomatedTesting.java`: Main test class containing test cases.
- `TestData.java`: Contains test data such as expected values and utility methods (assumed to be present based on usage).
- `chromedriver`: WebDriver used for browser automation (ensure version compatibility).

## 🚀 Features Tested

| Test | Description |
|------|-------------|
| `SelectCountry` | Selects Saudi Arabia as the preferred country. |
| `CheckLanguage` | Verifies the website's language setting. |
| `CheckCurrency` | Validates the displayed currency. |
| `CheckContactNumber` | Confirms that the contact number is correctly shown. |
| `VerifyQitafLogoInFooter` | Checks for the presence of the Qitaf logo in the footer. |
| `HotelSearchTabIsNotSelectedByDefault` | Ensures the hotel tab is not selected on page load. |
| `FlightDepatureDate` | Validates the departure date from the flight search. |
| `FlightArrivalDate` | Validates the arrival date from the flight search. |
| `RandomLanguage` | Opens the site in a random language and verifies the URL. |
| `SwitchToHotelTab` | Switches to the hotel booking tab and selects a city. |
| `SelectRoom` | Randomly selects a room and proceeds with the search. |
| `CheckTheFinalResultIsRetrived` | Confirms that results are retrieved after the search. |

> **Note:** Some tests are disabled (`enabled = false`) and can be enabled as needed.

## ⚙️ Setup Instructions

1. **Install dependencies**:
   - Java JDK
   - Maven or similar Java build tool
   - Chrome browser and corresponding [ChromeDriver](https://chromedriver.chromium.org/downloads)

2. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/almosafer-automation.git
   cd almosafer-automation
