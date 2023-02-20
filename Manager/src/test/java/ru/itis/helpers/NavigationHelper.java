package ru.itis.helpers;

import org.openqa.selenium.By;
import ru.itis.ApplicationManager;
import ru.itis.basic.HelperBase;

public class NavigationHelper extends HelperBase {

    private final String baseUrl;

    public NavigationHelper(ApplicationManager applicationManager, String baseUrl) {
        super(applicationManager);
        this.baseUrl = baseUrl;
    }

    public void openYahoo() {
        driver.get(baseUrl);
    }

    public void openMail() {
        driver.findElement(By.id("root_1")).click();
    }
}
