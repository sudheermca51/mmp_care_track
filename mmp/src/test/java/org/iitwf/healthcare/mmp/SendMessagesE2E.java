package org.iitwf.healthcare.mmp;

import java.time.Duration;
import java.util.HashMap;

import org.iitwf.hc.lib.FrameworkLibrary;
import org.iitwf.hc.mmp.pages.HomePage;
import org.iitwf.hc.mmp.pages.LoginPage;
import org.iitwf.hc.mmp.pages.MessagesAdminPage;
import org.iitwf.hc.mmp.pages.MessagesPage;
import org.iitwf.hc.mmp.pages.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendMessagesE2E extends FrameworkLibrary {
	
	@Test
	public void sendMessageToPatient() throws InterruptedException {
	 		
		//Patient login to send a message
		LoginPage lPage = new LoginPage(driver);
		HomePage hPage = lPage.loginValidUser(prop.getProperty("patient_username"), prop.getProperty("patient_password"));	 
		hPage.navigateToAModule("Profile");
		ProfilePage pPage = new ProfilePage(driver);
		String patientName = pPage.getPatientFName();
		hPage.navigateToAModule("Messages");
		MessagesPage sPage = new MessagesPage(driver);
		HashMap<String,String> expectedHMap =sPage.sendMessageToAdmin(patientName, "Your appointment is scheduled for next week.");
		String expected = "Messages Successfully sent.";
		String actual = sPage.getMessageStatus();
		Assert.assertTrue(actual.equals(expected));
		
		hPage.navigateToAModule("Logout");
		
		System.out.println("Patient account Logged out successfully");
				
				
		//Admin login to verify the message
		 launchApplication(prop.getProperty("admin_url"));
		 hPage = lPage.loginValidUser(prop.getProperty("admin_username"), prop.getProperty("admin_password"));	 
		 hPage.navigateToAModule("Messages");
		 MessagesAdminPage aPage = new MessagesAdminPage(driver);
		 HashMap<String,String> actualHMap = aPage.getMessageDetails(expectedHMap.get("subject"));
			
		 Thread.sleep(2000);
			
		WebElement element = driver.findElement(By.xpath("//span[normalize-space(text())='Logout']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf((element)));
		element.click();
			
		System.out.println("Admin account Logged out successfully");
			
		
		
	}
}
