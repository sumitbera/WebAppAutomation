package com.webapp.trevo.utility;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLoaderHelper {

    public static PageLoaderHelper isLoaded() {
        PageLoaderHelper loadHelper = new PageLoaderHelper();
        return loadHelper;
    }


    //To wait for element to be clickable
    public PageLoaderHelper isElementClickable (WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 120);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return this;
        }
        catch (WebDriverException e) {
            throw new Error("Element not clickable. Page failed to load successfully");
        }
    }

    //To wait for visibility of element
    public PageLoaderHelper isElementVisible (WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 120);
            wait.until(ExpectedConditions.visibilityOf(element));
            return this;
        }
        catch (WebDriverException e) {
            throw new Error("Element not visible. Page failed to load successfully");
        }
    }
}
