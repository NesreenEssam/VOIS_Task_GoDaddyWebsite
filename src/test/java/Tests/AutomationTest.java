package Tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Utils.CaptureScreenShot;
import pages.HomePage;
import pages.RegisterationPage;
import pages.loginPage;



public class AutomationTest {
	
	WebDriver browserobject;
	WebDriverWait wait;
	RegisterationPage Registeration;
	loginPage loginObj;
	HomePage homePage;
	CaptureScreenShot ScreenShoot;
	
	
	String loginPage = "loginpage.png";
	String registerPage = "registerpage.png";



	@Test(priority=0)
	public void registerTest() throws IOException, InterruptedException, EncryptedDocumentException {
	    
		homePage.navigateToHomePage();
	    homePage.navigateToRegisterationPage();
	    Registeration.register();
	    ScreenShoot.ScreenShot(registerPage);
		
	}

	@Test(priority = 1)
	public void loginTest() throws IOException, InterruptedException, EncryptedDocumentException {
	    
		
		homePage.navigateToHomePage();
	    homePage.navigateToLoginPage();
	    loginObj.login();
	    ScreenShoot.ScreenShot(loginPage);
			

	}
	
	 @BeforeClass
	  public void beforeClass() 
	 {
		 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Driiver\\chromedriver.exe");

		 browserobject = new ChromeDriver();
		 browserobject.manage().window().maximize();
		 wait =new WebDriverWait(browserobject,10);
		 Registeration = new RegisterationPage(browserobject,wait);
		 loginObj = new loginPage(browserobject,wait);
		 homePage = new HomePage(browserobject,wait);
		 ScreenShoot =  new CaptureScreenShot(browserobject);
		  
	  }
	
	 @AfterClass
	  public void afterClass()
	 {
		 browserobject.close();
	 }
	 
}
