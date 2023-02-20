package ru.itis.helpers;

import org.openqa.selenium.By;
import ru.itis.ApplicationManager;
import ru.itis.basic.HelperBase;
import ru.itis.data.UserData;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void login(UserData userData) throws InterruptedException {
        driver.findElement(By.linkText("Sign in")).click();
        sleep(2);
        driver.findElement(By.id("login-username")).clear();
        driver.findElement(By.id("login-username")).sendKeys(userData.login());
        driver.findElement(By.id("login-signin")).click();
        sleep(2);
        driver.findElement(By.id("login-passwd")).clear();
        driver.findElement(By.id("login-passwd")).sendKeys(userData.password());
        driver.findElement(By.id("login-signin")).click();
    }
}
