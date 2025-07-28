package org.iitwf.hc.mmp.am.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminHomePage {
	protected WebDriver driver;

	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getTitle().equals("home"))
				{
			throw new IllegalStateException("This is not Admin Home Page," +
					" current page is: " + driver.getCurrentUrl());
		}
	}
	public void navigateToModule(String moduleName) {
        System.out.println("Attempting to navigate to module: " + moduleName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            // Wait until the element with the given link text is clickable
            WebElement moduleLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(moduleName)));
            moduleLink.click();
            System.out.println("Successfully clicked on module: " + moduleName);
        } catch (Exception e) {
            System.err.println("Failed to click on module '" + moduleName + "'. Error: " + e.getMessage());
            System.err.println("Current URL: " + driver.getCurrentUrl());
            System.err.println("Current Title: " + driver.getTitle());
            throw new RuntimeException("Could not navigate to module: " + moduleName, e);
        }
    }

}
