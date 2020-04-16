package com.webapp.trevo.utility;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.CoreMatchers.is;

public abstract class CommonTests<T extends LoadableComponent<T>> extends LoadableComponent<T> {

    public RemoteWebDriver remoteDriver;

    public CommonTests(RemoteWebDriver remoteDriver) {
        this.remoteDriver = remoteDriver;
    }

    public CommonTests() {
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

    //To scroll to an element
    protected void javascriptToScroll (WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView();", element);
        }
        catch (StaleElementReferenceException e) {
            Log.info("Unable to scroll to element");
        }
    }

    //To click on an element using javascript
    protected void javascriptToClick (WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].click();", element);
        }
        catch (StaleElementReferenceException e) {
            Log.info("Unable to click on element");
        }
    }

    //To click on an element using javascript (for svg elements)
    protected void javascriptOnClick (WebElement element) {
        try {
            String onClickScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents'); evObj.initEvent('click', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject){ arguments[0].fireEvent('onclick');}";
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript(onClickScript, element);
        }
        catch (StaleElementReferenceException e) {
            Log.info("Unable to click on element");
        }
    }

    //To move to element
    protected void actionToMove (WebElement element) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(element).build().perform();
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

    //To get value attribute
    protected String getAttribute (WebElement element, String attributeType) {
        String value = null;
        try {
            String val = element.getAttribute(attributeType);
            value = val;
        }
        catch (StaleElementReferenceException e) {
            Log.info("Unable to get attribute");
        }
        return value;
    }

    //To clear data
    protected void clearAllData (WebElement element, String value) {
        for (int i = 0; i < value.length(); i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
        if(value.isEmpty()) {
            Log.info("Data cleared successfully");
        }
    }

    //To reset the set timeout from default to zero
    protected void resetTimeoutToZero() {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    //To reset the set timeout from zero to default
    protected void resetTimeoutToDefault() {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    //To switch into iframe
    protected void enterIFrame(WebElement element) {
        DriverManager.getDriver().switchTo().frame(element);
    }

    //To close alert popup
    protected void closeAlert() {
        WebDriver driver = DriverManager.getDriver();
        driver.switchTo().alert().accept();
    }

    //To wait for page to finish loading
    protected void waitForPageLoadedState() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wd) {
                return ((JavascriptExecutor) wd).executeScript(Constants.WEB_CONFIG.WEB_PAGE_STATE).toString().equals(Constants.WEB_CONFIG.WEB_PAGE_STATUS);
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 60);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    //To wait for element to be displayed
    protected boolean isDisplayed(WebElement e, long timeOutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeOutInSeconds);
            wait.until(ExpectedConditions.visibilityOf(e));
        } catch (TimeoutException | StaleElementReferenceException | NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    //To refresh page as well as clear cache
    public void refreshWithThreadSleep() throws InterruptedException {
        Thread.sleep(10000);
        DriverManager.getDriver().navigate().refresh();
        Log.info("Refreshing...");
        waitForPageLoadedState();
    }

    public void normalRefresh() {
        DriverManager.getDriver().navigate().refresh();
        Log.info("Refreshing...");
        waitForPageLoadedState();
    }

    public void awaitilityAppear(WebElement element) {
        resetTimeoutToZero();
        if(isDisplayed(element,1)) {
            resetTimeoutToDefault();
            Log.info("Data is loaded");
        } else {
            await("Data does not load within 20 seconds").atMost(20, TimeUnit.SECONDS).ignoreException(StaleElementReferenceException.class).until(element::isDisplayed);
            Log.info("Data displayed successfully");
        }
    }

    public void awaitilityAppearText(WebElement element, String text) {
        await("Data does not load within 20 seconds").atMost(20, TimeUnit.SECONDS).until(element::getText, is(text));
        Log.info("Data displayed successfully");
    }

    public void awaitilityDisappear(WebElement element) {
        resetTimeoutToZero();
        if(!isDisplayed(element,2)) {
            resetTimeoutToDefault();
            Log.info("Data is loaded");
        } else {
            await("Data does not load within 20 seconds").atMost(20, TimeUnit.SECONDS).ignoreException(StaleElementReferenceException.class).until(() -> !element.isDisplayed());
            Log.info("Data displayed successfully");
        }
    }
}
