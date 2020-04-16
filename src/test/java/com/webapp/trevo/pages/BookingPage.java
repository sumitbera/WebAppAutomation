package com.webapp.trevo.pages;

import com.webapp.trevo.pageobjects.BookingScreen;
import com.webapp.trevo.utility.CommonTests;
import com.webapp.trevo.utility.Log;
import com.webapp.trevo.utility.PageLoaderHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class BookingPage extends CommonTests<BookingPage> {

    BookingScreen bookingScreen = new BookingScreen();

    public BookingPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, bookingScreen);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        PageLoaderHelper.isLoaded().isElementVisible(bookingScreen.BOOKING_APPOINTMENT_SECTION);
    }

    //Function for book appointment title verification
    public void verifyBookAppointmentTitle() {
        waitForVisibility(bookingScreen.BOOKING_APPOINTMENT_SECTION);
        Log.info("Booking Appointment section visible");
    }

    //Function for verifying booking form
    public void verifyBookAppointmentForm() {
        waitForVisibility(bookingScreen.NAME_LABEL);
        Log.info("Name label visible");
        waitForVisibility(bookingScreen.NAME_TEXT_FIELD);
        Log.info("Name text field visible");
        waitForVisibility(bookingScreen.PHONE_NO_LABEL);
        Log.info("Phone number label visible");
        waitForVisibility(bookingScreen.PHONE_NO_TEXT_FIELD);
        Log.info("Phone number field visible");
        waitForVisibility(bookingScreen.EMAIL_FIELD);
        Log.info("Email field visible");
        waitForVisibility(bookingScreen.CARS_INTERESTED_LABEL);
        Log.info("Cars interested label visible");
        waitForVisibility(bookingScreen.CARS_INTERESTED_FIELD);
        Log.info("Cars interested field visible");
        waitForVisibility(bookingScreen.APPOINTMENT_DATE_LABEL);
        Log.info("Appointment date label visible");
        waitForVisibility(bookingScreen.APPOINTMENT_DATE_FIELD);
        Log.info("Appointment date selection field visible");
    }

    //Entering username
    public void enterUserName(String userName) {
        enterData(bookingScreen.NAME_TEXT_FIELD, userName);
        Log.info("User name entered");
    }

    //Entering mobile number
    public void enterPhoneNumber(String phoneNumber) {
        enterData(bookingScreen.PHONE_NO_TEXT_FIELD, phoneNumber);
        Log.info("Phone number entered");
    }

    //Entering email id
    public void enterEmailId(String emailId) {
        enterData(bookingScreen.EMAIL_FIELD, emailId);
        Log.info("Email id entered");
    }

    //Entering interested car
    public void enterInterestedCar(String interestedCar) {
        enterData(bookingScreen.CARS_INTERESTED_FIELD, interestedCar);
        Log.info("Cars interested entered");

    }

    //Selecting appointment date 5 days ahead of today's date
    public void selectAppointmentDate() {
        String today = getCurrentDay();
        actionToClick(bookingScreen.APPOINTMENT_DATE_FIELD);
        List<WebElement> columns = bookingScreen.CALENDAR_DATES;
        for (WebElement cell : columns) {
            if (cell.getText().equalsIgnoreCase(today)) {
                cell.click();
            }
        }
        actionToClick(bookingScreen.CALENDAR_OK_BTN);
        Log.info("Calendar date selected");
    }

    private String getCurrentDay() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int todayDate = calendar.get(Calendar.DAY_OF_MONTH);
        todayDate = todayDate + 5;
        return Integer.toString(todayDate);
    }

    //Clicking Let's Drive Button
    public void clickLetsDriveBtn() {
        actionToClick(bookingScreen.LETS_DRIVE_BTN);
        Log.info("Let's drive button clicked");
    }
}
