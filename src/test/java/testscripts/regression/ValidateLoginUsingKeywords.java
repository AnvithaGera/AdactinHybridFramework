package testscripts.regression;

import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;

public class ValidateLoginUsingKeywords extends BaseTest{
	
		@Test
		public void loginTest()
		{
			ApplicationKeywords app=new ApplicationKeywords();
			
			app.startBrowser();
			
			app.launchApp();
			
			app.type("username_textbox", "anvitha7228");
			
			app.type("password_textbox", "tubatu304");
			
			app.click("login_button");
			
			app.verifyTitle("Adactin.com - Search Hotel");
		}

}
