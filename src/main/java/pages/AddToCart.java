package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {
	private WebDriver driver;
	private WebDriverWait wait;

	// les localisateurs
	
	//
	private final By addToCartButton= By.xpath("//*[@id=\"main\"]/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/div[3]/div[2]/button[1]");
	private final By confirmAddToCart = By.id("add-to-cart-button-4");
	private final By viewShoppingCart = By.linkText("Shopping cart");
	
	//private final By checkout = By.id("checkout");
	
	

	public AddToCart(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void addProductToCart() {
		driver.findElement(addToCartButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmAddToCart));
		driver.findElement(confirmAddToCart).click();
		wait.until(ExpectedConditions.elementToBeClickable(viewShoppingCart));
		driver.findElement(viewShoppingCart).click();
		
	}

}
