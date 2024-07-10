package pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	private WebDriver driver ;
    private  WebDriverWait wait ;
    // les localisateurs
    //private final By register = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
    private final By register = By.linkText("Register");
	private final By genderF= By.id("gender-female");
	private final By firstName= By.id("FirstName");
	private final By lastName= By.id("LastName");
	private final By birthDay= By.name("DateOfBirthDay");
	private final By birthMonth= By.name("DateOfBirthMonth");
	private final By birthYear= By.name("DateOfBirthYear");
	private final By emailField = By.id("Email");
	private final By companyName= By.id("Company");
	private final By passwordField= By.id("Password");
	private final By confirmPass= By.id("ConfirmPassword");
	private final By registerButton= By.id("register-button");
	private final By registrationMessage= By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]");
	private final By logoutFromRegistration= By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");
	
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	public void navigateToRegisterPage(String firstname, String lastname, int day, String month,
            int year, String email, String company, String password, String confirmPassword) {
		driver.findElement(register).click();
		wait.until(ExpectedConditions.urlContains("/register?returnUrl=%2F"));
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("gender-female")));
		driver.findElement(genderF).click();
		driver.findElement(firstName).sendKeys(firstname);
		driver.findElement(lastName).sendKeys(lastname);
		driver.findElement(birthDay).sendKeys(String.valueOf(day));
		driver.findElement(birthMonth).sendKeys(month);
		driver.findElement(birthYear).sendKeys(String.valueOf(year));
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(companyName).sendKeys(company);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(confirmPass).sendKeys(confirmPassword);
		driver.findElement(registerButton).click();
		
		// msg actual dans la site 
		WebElement registrationMsg = driver.findElement(registrationMessage);
        // Compare the actual alert text with the expected value
        String expectedText = "Your registration completed";
        assertEquals(registrationMsg.getText(), expectedText, "Confirmation message mismatch");
        
        
        driver.findElement(logoutFromRegistration).click();
	
		
		
		
		
	}
	
	

	
}
