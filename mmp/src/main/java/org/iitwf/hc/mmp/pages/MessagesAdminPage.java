package org.iitwf.hc.mmp.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MessagesAdminPage {
	protected WebDriver driver;
	/**
	 * Constructor for MessagesPage
	 * @param driver WebDriver instance to interact with the browser
	 */

	public MessagesAdminPage(WebDriver driver){
		this.driver = driver;
		if (!driver.getTitle().equals("Messages")) {
			throw new IllegalStateException("This is not Messages Page," +
					" current page is: " + driver.getCurrentUrl());
		}
	}
	public HashMap<String, String> getMessageDetails(String subject) {
		HashMap<String, String> actualHMap = new HashMap<String, String>();
		// Logic to retrieve message details goes here
		System.out.println("Retrieving message details for subject: " + subject);
		actualHMap.put("subject", subject);
		actualHMap.put("message", driver.findElement(By.xpath("//b[text()='"+subject+"']/ancestor::tr/following-sibling::tr[1]/td[2]")).getText());
		actualHMap.put("patientName", driver.findElement(By.xpath("//b[text()='"+subject+"']/parent::td/preceding-sibling::td/b")).getText());
		
		WebElement element = driver.findElement(By.xpath("//b[text()='"+subject+"']/parent::td/following-sibling::td/b"));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		actualHMap.put("date",  element.getText());
		
		
		
		return actualHMap;
	}

}