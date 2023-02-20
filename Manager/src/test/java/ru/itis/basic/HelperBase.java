package ru.itis.basic;

import org.openqa.selenium.WebDriver;
import ru.itis.ApplicationManager;

public class HelperBase {
    protected ApplicationManager applicationManager;
    protected WebDriver driver;

    public HelperBase(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
    }

    public void sleep(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }
}
