package com.webapp.trevo.utility;

public interface Constants {

    interface WEB_CONFIG {
        String WEB_URL = "https://trevo.my/events/fundyourdrive";
        String NODE_URL = "http://localhost:4444/wd/hub";
        String WINDOW_START_STATE = "--start-maximized";
        String WEB_PAGE_STATE = "return document.readyState";
        String WEB_PAGE_STATUS = "complete";
        //String EXECUTION_MODE = "headless";
    }

    interface CHROME_CONFIG {
        String CERTIFICATE_ERROR = "--ignore-certificate-errors";
        String POP_UP_DISABLE = "--disable-popup-blocking";
        String WINDOW_SIZE = "--window-size=1920,1080";
        String SANDBOX_FLAG = "no-sandbox";
        String NOTIFICATION_DISABLE = "--disable-notifications";
    }

    interface FIREFOX_CONFIG {
        Boolean ACCEPT_FLAG = true;
        Boolean DECLINE_FLAG = false;
        String WINDOW_WIDTH = "--width=1920";
        String WINDOW_HEIGHT = "--height=1080";
        String NETWORK_PROXY = "network.proxy.type";
    }
}
