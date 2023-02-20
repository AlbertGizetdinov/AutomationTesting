package ru.itis.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import ru.itis.ApplicationManager;
import ru.itis.basic.HelperBase;
import ru.itis.data.UserData;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Scanner;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void login(UserData userData) throws InterruptedException {
        driver.findElement(By.linkText("Sign in")).click();
        sleep(2);
        try {
            driver.findElement(By.id("login-username")).clear();
            driver.findElement(By.id("login-username")).sendKeys(userData.login());
            driver.findElement(By.id("login-signin")).click();
        } catch (NoSuchElementException exception) {
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
