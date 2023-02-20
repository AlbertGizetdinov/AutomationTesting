package ru.itis.basic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import ru.itis.ApplicationManager;

public class HelperBase {
    protected ApplicationManager applicationManager;
    protected WebDriver driver;
    protected JavascriptExecutor js;

    public HelperBase(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
        this.js = applicationManager.getJs();
    }

    public void sleep(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }
}
