package Qlytics.Pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import QlyticsAutomation.Qlytics.AppLibrary;

public class SignUpPage {

	WebDriver driver;

	public static String firstNameInput = "xpath://input[@id='firstName']";
	public static String lastNameInput = "xpath://input[@id='lastName']";
	public static String emailInput = "xpath://input[@id='email']";
	public static String passwordInput = "xpath://input[@id='password']";
	public static String cnfPasswordInput = "xpath://input[@id='confirmPassword']";
	public static String phoneNumberInput = "xpath://input[@id='phoneNumber']";
	public static String companyNameInput = "xpath://input[@id='companyName']";
	public static String jobTitleInput = "xpath://input[@id='jobTitle']";
	public static String registerButton = "xpath://button[@class='ant-btn ant-btn-primary']";

	public static String loginLink = "xpath://a[text()='Login']";
	// Login page
	public static String EmailAddressInput = "xpath://input[@placeholder='Email Address']";
	public static String LoginpasswordInput = "xpath://input[@placeholder='Password']";
	public static String LoginButton = "xpath://button[@class='ant-btn ant-btn-primary ant-btn-block']";

	public static String signUpLink = "xpath://a[text()='Sign up']";

	// Verification Message
	public static String VerificationMessage = "xpath://span[text()='Verification e-mail sent.']";

	// Logout
	public static String profileButton = "xpath://ul[@class='action-menu ml-10 ant-menu ant-menu-root ant-menu-dark ant-menu-horizontal ng-star-inserted']";

	public static String logoutButton = "xpath://*[contains(text(),'Logout')]";

	// forgot password
	public static String forgotLink = "xpath://a[text()='Forgot password']";

	/// Data marketplace
	public static String datamraketButton = "xpath://li[contains(text(),'Data Marketplace')]";

	public static String dataBaseList = "xpath://div[div[p[text()='Datasets']]]//*[contains(text(),'More')]";

	public static String selectDataSet = "xpath:(//div[div[p[text()='Datasets']]]//*[contains(text(),'More')])[Replace]";

	
	public static String DataSetView = "xpath://div[div[h4[text()='ABOUT THIS DATABASE']]]//button[span[contains(text(),'VIEW')]]";

	public static String verifyDatasetPage = "xpath://h5[contains(text(),'- Datasets')]";
	
	public static String DataSetViewButton = "xpath://div[h5[contains(text(),'- Datasets')]]//button";
	
	public static String DataSetSelectViewButton = "xpath:(//div[h5[contains(text(),'- Datasets')]]//button)[Replace]";
	
	public static String dataRecordsLabel = "xpath://div[contains(text(),'Dataset records')]";
	

    //TalentHub

	public static String talentHuBButton = "xpath://li[contains(text(),'Talent Hub')]";
	public static String SearchTextBox = "xpath://input[@placeholder='Machine learning...']";
	public static String SearchButton = "xpath://button[@class='btn btn-primary ant-btn ant-btn-primary']";

	public static String morebutton = "xpath://*[contains(text(),'More')]";

	/// Resource

	public static String projectButton = "xpath://li[contains(text(),'Projects')]";
	public static String resourceButton = "xpath://div[span[span[text()='Resources']]]";
	public static String computeText = "xpath://li[contains(text(),'Compute')]";
	public static String createInstanceButton = "xpath://button[@class='ant-btn ant-btn-primary ng-star-inserted']";

	public static String nameTextbox = "xpath://input[@placeholder='please enter a name']";
	public static String Typedropdown = "xpath://div[nz-form-item//label[contains(text(),'Type *')]]//input";
	public static String keypairAddButton = "xpath://button[@class='mt-40 ant-btn ant-btn-default ant-btn-circle ant-btn-icon-only']";
	public static String createleynameButton = "xpath://input[@placeholder='please enter key pair name']";
	public static String createButton = "xpath://div[@class='ant-drawer-body']//button";
	public static String keypairdropdown = "xpath://div[nz-form-item//label[contains(text(),'Key Pair *')]]//input";
	public static String qlytivsFunctionlaContainer = "xpath://div[nz-form-item//label[contains(text(),'Qlytics Functional Container *')]]//input";
	public static String qlyticscontainerList = "xpath://ul[@class='ant-select-dropdown-menu ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']//li";
	
	public static String qlyticscontainerListselect = "xpath:(//ul[@class='ant-select-dropdown-menu ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']//li)[Replace]";
	
	public static String createButton2 = "xpath://div[div[@class='ant-col-24']]//button";
	public static String ActionThreeDot = "xpath://button[@class='ant-dropdown-trigger ant-btn ant-btn-primary ant-btn-icon-only']";
	public static String stopButton = "xpath://li[contains(text(),'Stop')]";
	public static String typeSelect = "xpath://ul[@role='menu']//li[contains(text(),Replace)]";
	public static String keySelect = "xpath://ul[@class='ant-select-dropdown-menu ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']//li[contains(text(),Replace)]";
	

	public SignUpPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void registration(String firstName, String lastName, String email, String pass, String CnfPass,
			String PhoneNo, String CompanyName, String jobTitle) {
		AppLibrary.enterText(driver, firstNameInput, firstName);
		AppLibrary.enterText(driver, lastNameInput, lastName);
		AppLibrary.enterText(driver, emailInput, email);
		AppLibrary.enterText(driver, passwordInput, pass);
		AppLibrary.enterText(driver, cnfPasswordInput, CnfPass);
		AppLibrary.enterText(driver, phoneNumberInput, PhoneNo);
		AppLibrary.enterText(driver, companyNameInput, CompanyName);
		AppLibrary.enterText(driver, jobTitleInput, jobTitle);
		AppLibrary.clickElement(driver, registerButton);
	}

	public void Login(String emailaddess, String pass) {
		AppLibrary.sleep(2000);
		AppLibrary.enterText(driver, EmailAddressInput, emailaddess);
		AppLibrary.enterText(driver, LoginpasswordInput, pass);
		AppLibrary.clickElement(driver, LoginButton);
		AppLibrary.sleep(3000);
	}

	public void Logout() {

		AppLibrary.sleep(1000);
		AppLibrary.mouseHover(driver, profileButton);
//		AppLibrary.clickElement(driver, profileButton);
		AppLibrary.clickElement(driver, logoutButton);

	}

	public void dataMarketPlaceSearch() {
		AppLibrary.sleep(1000);
		
		AppLibrary.clickElement(driver, datamraketButton);
		
		AppLibrary.sleep(3000);

		List<WebElement> listings = AppLibrary.findElements(driver, dataBaseList);
		System.out.println(listings.size());
		int size = listings.size();
//
//		for (int i = 1; i < size; i++) {
			int randnMumber = ThreadLocalRandom.current().nextInt(1, size);
			AppLibrary.clickElement(driver, selectDataSet.replace("Replace",""+randnMumber+""));
			AppLibrary.sleep(1000);
			AppLibrary.clickElement(driver, DataSetView);
			AppLibrary.sleep(2000);
			AppLibrary.findElement(driver, verifyDatasetPage);
			
			List<WebElement> listings2 = AppLibrary.findElements(driver,DataSetViewButton );
			System.out.println(listings2.size());
			int size2 = listings2.size();
			
			int randnMumber2 = ThreadLocalRandom.current().nextInt(1, size2);
			AppLibrary.sleep(1000);
			AppLibrary.clickElement(driver, DataSetSelectViewButton.replace("Replace",""+randnMumber2+""));
			AppLibrary.sleep(1000);
			AppLibrary.findElement(driver, dataRecordsLabel );
			
			
//		}

	}

	public void searchGlobalTalent(String text) {

		AppLibrary.clickElement(driver, talentHuBButton);
		AppLibrary.clickElement(driver, morebutton);
		AppLibrary.enterText(driver, SearchTextBox, text);
		AppLibrary.clickElement(driver, SearchButton);

	}

	public void CreateInstance(String name,String type) {

		AppLibrary.clickElement(driver, projectButton);
		AppLibrary.sleep(1000);
		AppLibrary.clickElement(driver, resourceButton);
		AppLibrary.clickElement(driver, computeText);
		AppLibrary.sleep(2000);
		AppLibrary.clickElement(driver, createInstanceButton);

		AppLibrary.enterText(driver, nameTextbox, name);
		
		AppLibrary.enterText(driver, Typedropdown,type );
		AppLibrary.clickElement(driver, typeSelect.replace("Replace", type));

		AppLibrary.clickElement(driver, keypairAddButton);
		AppLibrary.enterText(driver, createleynameButton, name);
		AppLibrary.clickElement(driver, createButton);

		
		
		AppLibrary.enterText(driver, keypairdropdown,type );
		AppLibrary.clickElement(driver, keySelect.replace("Replace", name));
		

		AppLibrary.clickElement(driver, qlytivsFunctionlaContainer);
		List<WebElement> listings = AppLibrary.findElements(driver,qlyticscontainerList );
		System.out.println(listings.size());
		int size = listings.size();
		int randnMumber = ThreadLocalRandom.current().nextInt(1, size);
		AppLibrary.sleep(1000);
		AppLibrary.clickElement(driver, qlyticscontainerListselect.replace("Replace",""+randnMumber+""));
		

		
		
		
		AppLibrary.clickElement(driver, createButton2);
		AppLibrary.sleep(2000);
		AppLibrary.clickElement(driver, ActionThreeDot);
		AppLibrary.clickElement(driver, stopButton);

	}

}
