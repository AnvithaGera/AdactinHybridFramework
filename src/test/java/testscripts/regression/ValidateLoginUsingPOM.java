package testscripts.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotelPage;

public class ValidateLoginUsingPOM extends BaseTest{

	  @Test
	  public void validateLogin()
	  {
		  LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		  
		  loginPage.usernameTextbox("anvitha7228");
		  
		  loginPage.passwordTextbox("tubatu304");
		  
		  loginPage.loginButton();
		  
		  SearchHotelPage searchHotelPage= PageFactory.initElements(driver, SearchHotelPage.class);
		  
		  searchHotelPage.verifyTitle("Adactin.com - Search Hotel");
		  
		  searchHotelPage.helloUsernameText("anvitha7228");
	  }
}
