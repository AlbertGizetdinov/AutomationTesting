package ru.itis.helpers;

import org.openqa.selenium.By;
import ru.itis.ApplicationManager;
import ru.itis.basic.HelperBase;
import ru.itis.data.MailData;

public class MailHelper extends HelperBase {

    public MailHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void createMail(MailData mailData) throws InterruptedException {
        driver.findElement(By.linkText("Написать")).click();
        driver.findElement(By.id("message-to-field")).click();
        driver.findElement(By.id("message-to-field")).clear();
        driver.findElement(By.id("message-to-field")).sendKeys(mailData.email());
        applicationManager.sendEscapeKey();
        sleep(2);
        driver.findElement(By.xpath("//div[@id='mail-app-component']/div/div/div/div/div[3]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='mail-app-component']/div/div/div/div/div[3]/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='mail-app-component']/div/div/div/div/div[3]/div/div/input")).sendKeys(mailData.theme());
        sleep(2);
        driver.findElement(By.xpath("//div[@id='editor-container']/div/div")).click();
        driver.findElement(By.xpath("//div[@id='editor-container']/div/div")).clear();
        driver.findElement(By.xpath("//div[@id='editor-container']/div/div")).sendKeys(mailData.text());
        sleep(2);
        driver.findElement(By.xpath("//div[@id='mail-app-component']/div/div/div/div[2]/div[2]/div/button/span")).click();
    }
}
