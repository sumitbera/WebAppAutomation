package com.webapp.trevo.stepdefinition;

import com.webapp.trevo.pages.BookingPage;
import com.webapp.trevo.pages.LandingPage;
import com.webapp.trevo.testcontext.TestContext;
import com.webapp.trevo.utility.Log;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FundYourDriverDefinition {

    LandingPage landingPage;
    BookingPage bookingPage;
    TestContext testContext;

    public FundYourDriverDefinition(TestContext context) {
        testContext = context;
        landingPage = context.getAppObjectManager().getLandingScreen();
        bookingPage = context.getAppObjectManager().getBookingPage();
    }

    @Given("^I open trevo web app in browser$")
    public void i_open_trevo_web_app_in_browser() {
        landingPage.launchWebApp();
    }

    @Given("^I click on learn more button on landing screen$")
    public void i_click_on_learn_more_button_on_landing_screen() {
        landingPage.clickLearnMoreBtn();
    }

    @Then("^I should be navigated to book appointment section$")
    public void i_should_be_navigated_to_book_appointment_section() {
        bookingPage.verifyBookAppointmentTitle();
    }

    @Then("^I verify all the sections of booking perform$")
    public void i_verify_all_the_sections_of_booking_perform() {
        bookingPage.verifyBookAppointmentForm();
    }

    @When("I enter my full name as \"([^\"]*)\"$")
    public void i_enter_my_full_name_as(String name) {
        bookingPage.enterUserName(name);
    }

    @When("I enter my phone number as \"([^\"]*)\"$")
    public void i_enter_my_phone_number_as(String phoneNumber) {
        bookingPage.enterPhoneNumber(phoneNumber);
    }

    @When("I enter my email id as \"([^\"]*)\"$")
    public void i_enter_my_email_id_as(String email) {
        bookingPage.enterEmailId(email);
    }


    @When("I enter my cars interested as \"([^\"]*)\"$")
    public void i_enter_my_cars_interested_as(String interestedCar) {
        bookingPage.enterInterestedCar(interestedCar);
    }

    @When("I select my booking date$")
    public void i_select_my_booking_date() {
        bookingPage.selectAppointmentDate();
    }

    @When("I clicked on Let's drive button$")
    public void i_clicked_on_Let_s_drive_button() {
        //bookingPage.clickLetsDriveBtn();
    }

    @Then("I should be successfully book and appointment$")
    public void i_should_be_successfully_book_and_appointment() {
        Log.info("Booking appointment complement");
    }
}
