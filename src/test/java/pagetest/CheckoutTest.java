package pagetest;
import org.testng.annotations.Test;

import pages.Checkoutpage;
import utils.DataInjectionIntern;
public class CheckoutTest extends BaseTest {

	
	@Test(priority=4 ,dataProvider="userData", dataProviderClass= DataInjectionIntern.class)
	// 
	public void checkoutTest(String city, String address_one, String address_Tow,
            String zip, String phone, String fax) {
		new Checkoutpage(driver).checkoutPage(city,address_one, address_Tow,
	           zip, phone,  fax);
	}
	
}
