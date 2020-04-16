package com.webapp.trevo.objectmanager;

import com.webapp.trevo.pages.BookingPage;
import com.webapp.trevo.pages.LandingPage;
import com.webapp.trevo.utility.DriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AppObjectManager {

    RemoteWebDriver remoteWebDriver;
    LandingPage landingPage;
    BookingPage bookingPage;

    public AppObjectManager(RemoteWebDriver remoteDriver) {
        this.remoteWebDriver = remoteDriver;
    }

    public LandingPage getLandingScreen() {
        return (landingPage == null) ? new LandingPage((RemoteWebDriver) DriverManager.getDriver()) : landingPage;
    }

    public BookingPage getBookingPage() {
        return (bookingPage == null) ? new BookingPage((RemoteWebDriver) DriverManager.getDriver()) : bookingPage;
    }
}
