package com.webapp.trevo.pageobjects;

import com.webapp.trevo.utility.AppLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LandingScreen implements AppLocators.LandingScreen {

    //Page object for trevo logo
    @FindBy(className = trevoLogo)
    @CacheLookup
    public WebElement TREVO_LOGO;

    //Page object for learn more button
    @FindBy(className = learnMore)
    @CacheLookup
    public WebElement LEARN_MORE_BTN;

}
