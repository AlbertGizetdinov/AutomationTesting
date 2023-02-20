package ru.itis.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.WiniumDriver;
import ru.itis.ApplicationManager;

public class HelperBase {
    protected static final String  EDITOR_CLASSNAME = "151900928";

    protected ApplicationManager applicationManager;
    protected WiniumDriver driver;

    public HelperBase(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
    }

    public void clearAll() {
        driver.findElement(By.className(EDITOR_CLASSNAME)).clear();
    }
}
