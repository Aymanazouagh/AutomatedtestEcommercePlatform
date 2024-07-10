package pagetest;
import org.testng.annotations.Test;

import pages.RegisterPage;
import utils.CSVUtils;
public class RegisterTest extends BaseTest{
	

    @Test(dataProvider = "csvData", dataProviderClass = CSVUtils.class)
    
    public void registerPageTest (String firstname, String lastname, String day, String month, String year,
			String email, String company, String password, String confirmPassword) {
    	int dayInt = Integer.parseInt(day);
		int yearInt = Integer.parseInt(year);
    	new RegisterPage(driver).navigateToRegisterPage(firstname, lastname, dayInt, month, yearInt, email, company, password, confirmPassword);
    }
    
    
   // @Test(priority = 2)
    
    
    public void invalidRegisterPageTest (String firstname, String lastname, String day, String month, String year,
			String email, String company, String password, String confirmPassword) {
    	int dayInt = Integer.parseInt(day);
		int yearInt = Integer.parseInt(year);
    	new RegisterPage(driver).navigateToRegisterPage(firstname, lastname, dayInt, month, yearInt, email, company, password, confirmPassword);
    }
}
