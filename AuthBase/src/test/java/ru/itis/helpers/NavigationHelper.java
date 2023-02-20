package ru.itis.helpers;

import ru.itis.ApplicationManager;
import ru.itis.basic.HelperBase;

public class NavigationHelper extends HelperBase {

    private final String baseUrl;
    private final String mailUrl;

    public NavigationHelper(ApplicationManager applicationManager, String baseUrl, String mailUrl) {
        super(applicationManager);
        this.baseUrl = baseUrl;
        this.mailUrl = mailUrl;
    }

    public void openYahoo() {
        driver.get(baseUrl);
    }

    public void openMail() {
        driver.get(mailUrl);
    }
}
