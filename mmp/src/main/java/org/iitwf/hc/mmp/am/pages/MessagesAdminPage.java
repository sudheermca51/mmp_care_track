package org.iitwf.hc.mmp.am.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
		actualHMap.put("message", driver.findElement(By.xpath("//b[text()='"+subject+"']/parent::td/preceding-sibling::td/b")).getText());
		actualHMap.put("date", driver.findElement(By.xpath("//b[text()='"+subject+"']/parent::td/following-sibling::td/b")).getText());
		actualHMap.put("patientName", driver.findElement(By.xpath("//b[text()='"+subject+"']/ancestor::tr/following-sibling::tr[1]/td[2]")).getText());
		return actualHMap;
	}

}
