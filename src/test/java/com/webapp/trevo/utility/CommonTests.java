package com.webapp.trevo.utility;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class CommonTests<T extends LoadableComponent<T>> extends LoadableComponent<T> {

    public RemoteWebDriver remoteDriver;

    public CommonTests(RemoteWebDriver remoteDriver) {
        this.remoteDriver = remoteDriver;
    }

    //To wait for element to be clickable
    protected void waitForElementToBeClickable (WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 60);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (StaleElementReferenceException e) {
            Log.info("Unable to click on element");
        }
    }

    //To wait for visibility of element
    protected void waitForVisibility (WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 60);
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (StaleElementReferenceException e) {
            Log.info("Unable to find element");
        }
    }

    //To click on element
    protected void actionToClick (WebElement element) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(element).click().build().perform();
        }
        catch (StaleElementReferenceException e) {
            Log.info("Unable to click on element");
        }
    }

    //To enter data
    protected void enterData (WebElement element, String data) {
        try {
            element.sendKeys(data);
        }
        catch (StaleElementReferenceException e) {
            Log.info("Unable to enter data");
        }
    }

    //To wait for page to finish loading
    protected void waitForPageLoadedState() {
        ExpectedCondition<Boolean> expectation = wd -> ((JavascriptExecutor) wd).executeScript(Constants.WEB_CONFIG.WEB_PAGE_STATE).toString().equals(Constants.WEB_CONFIG.WEB_PAGE_STATUS);
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 60);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}
