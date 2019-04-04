package Tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Qlytics.Pages.MailinatorPage;
import Qlytics.Pages.SignUpPage;
import QlyticsAutomation.Qlytics.AppLibrary;
import QlyticsAutomation.Qlytics.TestBase;

public class RegistrationFunctionalityTest extends TestBase {

	@BeforeClass
	public void setUp() throws IOException {
		appLibrary = new AppLibrary();
//		 logger = Logger.getLogger("RegistrationFunctinalityTest");
		System.out.println("RegistrationFunctinalityTestStarted");
		PropertyConfigurator.configure("Log4j.properties");
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");
	}

	@Test
	public void testRegistrationFunctinalityWithCafe() throws Exception {
		String unique = AppLibrary.getFDate() + "_" + AppLibrary.randInt();
		String emailAddress = "neoTest_" + unique;
		System.out.println(emailAddress);

		String firstname = appLibrary.generateRandomString(10);
		String LastName = appLibrary.generateRandomString(10);
		
		String Password="Admin123!@#";

		driver = appLibrary.getDriverInstance();
	
		appLibrary.launchAppDirectURL("");
		AppLibrary.clickElement(driver, SignUpPage.signUpLink);

		new SignUpPage(driver).registration(firstname, LastName, emailAddress + "@mailinator.com", Password,
				Password, "8989700929", firstname + "Company", "Tester");

		AppLibrary.findElement(driver, SignUpPage.VerificationMessage);

		AppLibrary.clickElement(driver, SignUpPage.loginLink);

		new MailinatorPage(driver).getVerification(emailAddress);
		
		AppLibrary.sleep(2000);
		
		new SignUpPage(driver).Login(emailAddress + "@mailinator.com", Password);
		
		new SignUpPage(driver).Logout();
		
		
		

	}

	@Override
	@AfterMethod
	public void checkAlerts(ITestResult result) {
		System.out.println("im doing nothign");
	}

	@Override
	@AfterClass(alwaysRun = true)
	public void quitBrowser() {
		if (driver != null)
			driver.quit();
	}

}