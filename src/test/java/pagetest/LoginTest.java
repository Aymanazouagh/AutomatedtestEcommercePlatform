package pagetest;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.CSVUtils;

class LoginTest extends BaseTest {

@Test(priority = 2, dataProvider = "csvData", dataProviderClass = CSVUtils.class)
	public void loginPageTest(String firstname, String lastname, String day, String month, String year, String email,
			String company, String password, String confirmPassword) {
		new LoginPage(driver).navigateToLoginPage(email, password);
		
		
		}
	
	//@Test
	public void sqlInjectionTest() {
		String password = "MrUnknown' or 'x'='x";
		String email= "aaa@gmail.com";
		new LoginPage(driver).testSqlInjection(email, password);
	}
}
