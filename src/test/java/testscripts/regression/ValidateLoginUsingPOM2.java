 package testscripts.regression;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotelPage;

public class ValidateLoginUsingPOM2 extends BaseTest{

	  @Test
	  public void validateLogin()
	  {
		  LoginPage loginPage=new LoginPage() ;
		  
		  loginPage.usernameTextbox("anvitha7228");
		  
		  loginPage.passwordTextbox("tubatu304");
		  
		  loginPage.loginButton();
		  
		  SearchHotelPage searchHotelPage=new SearchHotelPage();
		  
		  searchHotelPage.verifyTitle("Adactin.com - Search Hotel");
		  
		  searchHotelPage.helloUsernameText("anvitha7228");
	  }
}
