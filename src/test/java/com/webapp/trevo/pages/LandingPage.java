package com.webapp.trevo.pages;

import com.webapp.trevo.pageobjects.LandingScreen;
import com.webapp.trevo.utility.BaseTest;
import com.webapp.trevo.utility.CommonTests;
import com.webapp.trevo.utility.Log;
import com.webapp.trevo.utility.PageLoaderHelper;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends CommonTests<LandingPage> {

    LandingScreen landingScreen = new LandingScreen();

    public LandingPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, landingScreen);
    }


    @Override
    protected void load() {
        launchWebApp();
    }

    @Override
    protected void isLoaded() throws Error {
        PageLoaderHelper.isLoaded().isElementVisible(landingScreen.TREVO_LOGO);
        PageLoaderHelper.isLoaded().isElementVisible(landingScreen.LEARN_MORE_BTN);
        PageLoaderHelper.isLoaded().isElementClickable(landingScreen.LEARN_MORE_BTN);
    }

    //Launch web application with Trevo as URL
    public void launchWebApp() {
        BaseTest.setup();
        Log.info("Application Launched");
    }

    //Click on Lear more button
    public void clickLearnMoreBtn() {
        waitForPageLoadedState();
        waitForElementToBeClickable(landingScreen.LEARN_MORE_BTN);
        actionToClick(landingScreen.LEARN_MORE_BTN);
        Log.info("Learn more button clicked");
    }
}
