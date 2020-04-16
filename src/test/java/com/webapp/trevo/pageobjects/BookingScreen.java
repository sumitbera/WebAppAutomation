package com.webapp.trevo.pageobjects;

import com.webapp.trevo.utility.AppLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BookingScreen implements AppLocators.BookingScreen {

    //Page object for booking appointment section
    @FindBy(xpath = bookAppointmentTitle)
    public WebElement BOOKING_APPOINTMENT_SECTION;

    //Page object for name label
    @FindBy(xpath = nameLabel)
    @CacheLookup
    public WebElement NAME_LABEL;

    //Page object for name text field
    @FindBy(xpath = nameTextField)
    @CacheLookup
    public WebElement NAME_TEXT_FIELD;

    //Page object for phone number label
    @FindBy(xpath = phoneNoLabel)
    @CacheLookup
    public WebElement PHONE_NO_LABEL;

    //Page object for phone number field
    @FindBy(xpath = phoneNoTextField)
    @CacheLookup
    public WebElement PHONE_NO_TEXT_FIELD;

    //Page object for email label
    @FindBy(xpath = emailLabel)
    @CacheLookup
    public WebElement EMAIL_LABEL;

    //Page object for email field
    @FindBy(xpath = emailField)
    @CacheLookup
    public WebElement EMAIL_FIELD;

    //Page object for cars interested label
    @FindBy(xpath = carsInterestedLabel)
    @CacheLookup
    public WebElement CARS_INTERESTED_LABEL;

    //Page object for cars interested field
    @FindBy(xpath = carsInterestedField)
    @CacheLookup
    public WebElement CARS_INTERESTED_FIELD;

    //Page object for appointment date label
    @FindBy(xpath = desiredAppointmentDate)
    @CacheLookup
    public WebElement APPOINTMENT_DATE_LABEL;

    //Page object for appointment date label
    @FindBy(name = appointmentDateField)
    @CacheLookup
    public WebElement APPOINTMENT_DATE_FIELD;

    @FindBy(tagName = calendarDates)
    public List<WebElement> CALENDAR_DATES;

    //Page object for calendar ok button
    @FindBy(xpath = calendarOkBtn)
    @CacheLookup
    public WebElement CALENDAR_OK_BTN;

    //Page object for let's Drive button
    @FindBy(xpath = letsDriveBtn)
    @CacheLookup
    public WebElement LETS_DRIVE_BTN;
}
