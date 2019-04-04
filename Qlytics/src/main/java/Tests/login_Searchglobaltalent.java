package Tests;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Qlytics.Pages.SignUpPage;
import QlyticsAutomation.Qlytics.AppLibrary;
import QlyticsAutomation.Qlytics.TestBase;

public class login_Searchglobaltalent extends TestBase {

	@BeforeClass
	public void setUp() throws IOException {
		appLibrary = new AppLibrary();
//		 logger = Logger.getLogger("RegistrationFunctinalityTest");
		System.out.println("RegistrationFunctinalityTestStarted");
		PropertyConfigurator.configure("Log4j.properties");
		Reporter.log(
				"<h1><Center><Font face=\"arial\" color=\"Orange\">Log Summary</font></Center><h1><table border=\"1\" bgcolor=\"lightgray\">");
	}

	
	@Parameters({"email","name"})
	@Test
	public void globalTalentSearch(String email,String name) throws Exception {
		
		
		String Password="Admin123!@#";
		driver = appLibrary.getDriverInstance();

		appLibrary.launchAppDirectURL("");
	
		new SignUpPage(driver).Login(email, Password);
		
		new SignUpPage(driver).searchGlobalTalent(name);
		
		
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
