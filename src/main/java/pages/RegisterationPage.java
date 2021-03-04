package pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.ReadingCredentialFromExceel;

public class RegisterationPage {
	
	WebDriver browserobject;
	WebDriverWait wait;
	

	By email =By.id("email");
	By userName = By.id("username");
	By password = By.id("new-password");
	By agreeBtn = By.id("consent-accept-button");
	By createAccountBtn = By.id("submitBtn");
	
	
	
	public RegisterationPage(WebDriver browserobject, WebDriverWait wait)
	{
		this.browserobject=browserobject;
		this.wait=wait;
		
	}
	
	public void navigateTositeurl() throws IOException
	{
		String SiteUrl = ReadingCredentialFromExceel.ReadingData(0,1);
		 browserobject.navigate().to(SiteUrl);
		 
	}

	
	public void register() throws InterruptedException, IOException
	{
		
		String dateTime = new SimpleDateFormat("hhmmss").format(new Date());
		String userMail = ReadingCredentialFromExceel.ReadingData(2, 1);
		String uniqueUserName = ReadingCredentialFromExceel.ReadingData(2, 2) + dateTime;
		String Passwd = ReadingCredentialFromExceel.ReadingData(2, 3);
	


		wait.until(ExpectedConditions.visibilityOfElementLocated(email));
		WebElement userEmail =browserobject.findElement(email);      
		userEmail.sendKeys(userMail); 
	 
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
		WebElement usrName =browserobject.findElement(userName); 
		usrName.sendKeys(Keys.CONTROL + "a");
		usrName.sendKeys(Keys.DELETE);
		usrName.sendKeys(uniqueUserName);
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(password));
		WebElement userPassword =browserobject.findElement(password);   
		userPassword.sendKeys(Passwd); 
		

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(agreeBtn));
		browserobject.findElement(agreeBtn).click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn));
		browserobject.findElement(createAccountBtn).click();
		browserobject.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

}
