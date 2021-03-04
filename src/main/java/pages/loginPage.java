package pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.ReadingCredentialFromExceel;

public class loginPage {
	WebDriver browserobject;
	WebDriverWait wait;
	
	
	By userName = By.id("username");
	By password = By.id("password");
	By signInBtn = By.id("submitBtn");

	
	
	public loginPage(WebDriver browserobject, WebDriverWait wait)
	{
		this.browserobject=browserobject;
		this.wait=wait;
		
	}
	

	public void login() throws InterruptedException, IOException
	{
	
		String usrName = ReadingCredentialFromExceel.ReadingData(2, 2);
		String Passwd = ReadingCredentialFromExceel.ReadingData(2, 3);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
		WebElement userNamee =browserobject.findElement(userName);         
		userNamee.sendKeys(usrName); 
	

		wait.until(ExpectedConditions.visibilityOfElementLocated(password));
		WebElement userPassword =browserobject.findElement(password);        
		userPassword.sendKeys(Passwd); 
		

		browserobject.findElement(signInBtn).click();
		browserobject.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
        
	
		
}
}
