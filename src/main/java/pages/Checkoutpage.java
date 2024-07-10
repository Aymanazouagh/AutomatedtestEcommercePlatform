package pages;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkoutpage {
	private WebDriver driver;
	private WebDriverWait wait;

	// les localisateurs

	private final By checkout = By.id("checkout");
	private final By agreeService = By.id("termsofservice");
	private final By exactCountry = By.xpath("//option[normalize-space()='United States']");
	private final By exactState = By.xpath("//option[normalize-space()='Alabama']");

	private final By cityName = By.id("BillingNewAddress_City");
	private final By addressOne = By.id("BillingNewAddress_Address1");
	private final By addressTwo = By.id("BillingNewAddress_Address2");
	private final By zipCode = By.id("BillingNewAddress_ZipPostalCode");
	private final By phoneNum = By.id("BillingNewAddress_PhoneNumber");
	private final By faxNumber = By.id("BillingNewAddress_FaxNumber");
	private final By continueButton = By.name("save");
	private final By shippingMethod = By.id("shippingoption_0");
	private final By shippingmethodbutton = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button");
	private final By paymentMethod = By.id("paymentmethod_0");
	private final By paymentmethodbutton = By.xpath("//button[@class='button-1 payment-method-next-step-button']");
	private final By confirmOrder = By.xpath("//*[@id=\"payment-info-buttons-container\"]/button");
	private final By confirmorderbutton = By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button");
	private final By confirmOrderAssertion = By.xpath("//div[@class='page-body checkout-data']//div[@class='section order-completed']//div[@class='title']/strong");

	public Checkoutpage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void checkoutPage(String city, String address_one, String address_Tow, String zip, String phone,
			String fax) {

		//Enter User informations
		driver.findElement(agreeService).click();
		driver.findElement(checkout).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("BillingNewAddress_FirstName")));
		driver.findElement(exactCountry).click();
		wait.until(ExpectedConditions.elementToBeClickable(exactState)).click();
		driver.findElement(cityName).sendKeys(city);
		driver.findElement(addressOne).sendKeys(address_one);
		driver.findElement(addressTwo).sendKeys(address_Tow);
		driver.findElement(zipCode).sendKeys(zip);
		driver.findElement(phoneNum).sendKeys(phone);
		driver.findElement(faxNumber).sendKeys(fax);
		driver.findElement(continueButton).click();

		//set Shipping Method
		wait.until(ExpectedConditions.elementToBeClickable(shippingMethod)).click();
		wait.until(ExpectedConditions.elementToBeClickable(shippingmethodbutton)).click();
		
		//set Payment Method
		wait.until(ExpectedConditions.elementToBeClickable(paymentMethod)).click();
		wait.until(ExpectedConditions.elementToBeClickable(paymentmethodbutton)).click();

		//set Confirm Order
		wait.until(ExpectedConditions.elementToBeClickable(confirmOrder)).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmorderbutton)).click();

		// Wait for the confirmation message to be present and visible
		WebElement confirmOrderMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderAssertion));
		
		// Compare the actual alert text with the expected value
		String expectedText = "Your order has been successfully processed!";
		assertEquals(confirmOrderMsg.getText(), expectedText, "Confirmation message mismatch");
		

	}

}
