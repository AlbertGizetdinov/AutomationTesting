package ru.itis.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import ru.itis.ApplicationManager;
import ru.itis.basic.HelperBase;
import ru.itis.data.UserData;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void login(UserData userData) {
        driver.findElement(By.linkText("Sign in")).click();
        try {
            driver.findElement(By.id("login-username")).clear();
            driver.findElement(By.id("login-username")).sendKeys(userData.login());
            driver.findElement(By.id("login-signin")).click();
        } catch (NoSuchElementException ignore) {
            driver.findElement(By.name("username")).click();
        }
        driver.findElement(By.id("login-passwd")).clear();
        driver.findElement(By.id("login-passwd")).sendKeys(userData.password());
        driver.findElement(By.id("login-signin")).click();
    }

    public void logout() throws InterruptedException {
        applicationManager.getNavigationHelper().openYahoo();
        sleep(2);
        driver.findElement(By.id("ybarAccountProfile")).click();
        driver.findElement(By.xpath("//a[@id='profile-signout-link']/span[2]")).click();
        sleep(2);
    }

    public boolean isAuthorized() {
        try {
            driver.findElement(By.linkText("Sign in"));
            return false;
        } catch (NoSuchElementException exception) {
            return true;
        }
    }
}
