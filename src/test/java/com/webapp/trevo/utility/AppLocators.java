package com.webapp.trevo.utility;

public interface AppLocators {

    interface LandingScreen {
        String trevoLogo = "flex md:hidden h-8";
        String learnMore = "yellow-btn";
    }

    interface BookingScreen {
        String bookAppointmentTitle = "/html[1]/body[1]/div[1]/main[1]/div[4]/div[1]/div[3]/section[1]/div[1]/div[1]/h4[1]";
        String nameLabel = "//label[contains(text(),'Name')]";
        String nameTextField = "//input[@placeholder='Your name']";
        String phoneNoLabel = "//label[contains(text(),'Phone number')]";
        String phoneNoTextField = "//input[@placeholder='Enter mobile number']";
        String emailLabel = "//label[contains(text(),'Email')]";
        String emailField = "//input[@placeholder='Your email']";
        String carsInterestedLabel = "//label[contains(text(),'Cars interested in')]";
        String carsInterestedField = "//input[@placeholder='Enter a car']";
        String desiredAppointmentDate = "//label[contains(text(),'Desired Appointment Date')]";
        String appointmentDateField = "date";
        String calendarDates = "span";
        String calendarOkBtn = "//div[@class='vdatetime-popup__actions__button vdatetime-popup__actions__button--confirm']";
        String letsDriveBtn = "//button[contains(text(),\"LET'S DRIVE\")]";
    }
}
