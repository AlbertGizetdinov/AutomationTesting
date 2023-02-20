package ru.itis.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

    public void openMail() throws InterruptedException {
        driver.findElement(By.id("root_1")).click();
        sleep(2);
        try {
            driver.findElement(By.xpath("//div[@id='mail-app-component']/div[2]/div/div/span[2]/button/span")).click();
        } catch (NoSuchElementException ignore) {}
    }
}
