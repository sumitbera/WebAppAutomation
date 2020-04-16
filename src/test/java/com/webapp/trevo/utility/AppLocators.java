package com.webapp.trevo.utility;

public interface AppLocators {

    interface LandingScreen {
        String trevoLogo = "flex md:hidden h-8";
        String learnMore = "yellow-btn";
    }

    interface BookingScreen {
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
        String letsDriveBtn = "//button[contains(text(),\"LET'S DRIVE\")]";
    }
}
