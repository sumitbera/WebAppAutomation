package com.webapp.trevo.utility;

public class BaseTest implements Constants{

    public static void setup() {
        System.out.println("Thread id = " + Thread.currentThread().getId());
        System.out.println("Hashcode of web driver instance = " + DriverManager.getDriver().hashCode());
        DriverManager.getDriver().get(WEB_CONFIG.WEB_URL);
    }
}
