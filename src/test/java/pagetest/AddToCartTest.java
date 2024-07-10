package pagetest;
import org.testng.annotations.Test;

import pages.AddToCart;
import pages.LoginPage;
import utils.CSVUtils;
public class AddToCartTest extends BaseTest {
	@Test(priority = 3)
	public void addToCartTest() {
		
		new AddToCart(driver).addProductToCart();
	}	
	

}
