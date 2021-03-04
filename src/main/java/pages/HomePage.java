package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.ReadingCredentialFromExceel;

public class HomePage {

	WebDriver browserobject;
	WebDriverWait wait;

	By signInItem = By.xpath("//span[contains(text(),'Sign In')]");
	By signInBtn =By.xpath("//a[contains(text(),'Sign In')]");
	By createMyAccountBtn =By.xpath("//a[contains(text(),'Create My Account')]");
	
	public HomePage(WebDriver browserobject, WebDriverWait wait)
	{
		this.browserobject=browserobject;
		this.wait=wait;
		
		
	}
	
	
	public void navigateToHomePage() throws InterruptedException, IOException
	{
		String siteUrl = ReadingCredentialFromExceel.ReadingData(0,1);
		
		browserobject.get(siteUrl);
		
	}
	
	public void navigateToRegisterationPage() throws InterruptedException
	{
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(signInItem));
		WebElement signInMenu =browserobject.findElement(signInItem);  
		signInMenu.click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(createMyAccountBtn));
		WebElement createMyAccountBtnLink =browserobject.findElement(createMyAccountBtn);  
		createMyAccountBtnLink.click();
		
	}
	

	public void navigateToLoginPage() throws InterruptedException
	{
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(signInItem));
		WebElement signInMenu =browserobject.findElement(signInItem);  
		signInMenu.click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(signInBtn));
		WebElement signInLink =browserobject.findElement(signInBtn);  
		signInLink.click();
		
	}
	
	
}
