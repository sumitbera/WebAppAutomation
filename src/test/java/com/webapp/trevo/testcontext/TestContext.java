package com.webapp.trevo.testcontext;

import com.webapp.trevo.objectmanager.AppObjectManager;
import com.webapp.trevo.utility.DriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestContext {

    private AppObjectManager appObjectManager;
    public TestContext() {
        appObjectManager = new AppObjectManager((RemoteWebDriver) DriverManager.getDriver());
    }
    public AppObjectManager getAppObjectManager() {
        return appObjectManager;
    }
}
