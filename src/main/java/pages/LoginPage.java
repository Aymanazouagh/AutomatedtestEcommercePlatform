package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;

	// les localisateurs
	private final By login = By.linkText("Log in");
	private final By emailField = By.id("Email");
	private final By passwordField = By.id("Password");
	private final By loginButton = By.xpath("//button[@class='button-1 login-button']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void navigateToLoginPage(String email, String password) {
		driver.findElement(login).click();
		//explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
	}

	// Non Fonct=securite
	
	public void testSqlInjection(String email, String password) {
		//String password = "MrUnknown' or 'x'='x";
	// select password from login where password= "MrUnknown' or 'x'='x"
		driver.findElement(login).click();
		//explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
		}
		

}
