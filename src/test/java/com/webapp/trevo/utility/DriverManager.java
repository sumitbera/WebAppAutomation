package com.webapp.trevo.utility;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager implements IInvokedMethodListener {

    private static ThreadLocal<RemoteWebDriver> remoteDriver = new ThreadLocal<>();
    public CapabilityFactory capabilityFactory = new CapabilityFactory();

    @Parameters(value = {"browser"})
    private void createInstance(String browser) throws MalformedURLException {
        remoteDriver.set(new RemoteWebDriver(new URL(Constants.WEB_CONFIG.NODE_URL), capabilityFactory.getCapabilities(browser)));
    }

    public static WebDriver getDriver() {
        return remoteDriver.get();
    }

    //To instantiate webdriver in the beginning of every run
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browser");
            try {
                createInstance(browserName);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    //To close browser after each run
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            RemoteWebDriver remoteDriver = (RemoteWebDriver) getDriver();
            if (remoteDriver != null) {
                remoteDriver.quit();
            }
        }
    }

    //To take screenshot if there is a failure
    @Attachment(value = "Page screenshot", type= "image/png")
    public static byte[] saveScreenshot() {
        return ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
