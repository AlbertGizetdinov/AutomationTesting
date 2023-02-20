package ru.itis.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
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
        sleep(2);
        applicationManager.sendEscapeKey();
        driver.findElement(By.xpath("//div[@id='mail-app-component']/div/div/div/div/div[3]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='mail-app-component']/div/div/div/div/div[3]/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='mail-app-component']/div/div/div/div/div[3]/div/div/input")).sendKeys(mailData.topic());
        sleep(2);
        driver.findElement(By.xpath("//div[@id='editor-container']/div/div")).click();
        driver.findElement(By.xpath("//div[@id='editor-container']/div/div")).clear();
        driver.findElement(By.xpath("//div[@id='editor-container']/div/div")).sendKeys(mailData.text());
        sleep(2);
        driver.findElement(By.xpath("//div[@id='mail-app-component']/div/div/div/div[2]/div[2]/div/button/span")).click();
    }

    public MailData getLastMail() {
        driver.findElement(By.xpath("//div[@id='app']/div[2]/div/div/nav/div/div[3]/div/ul/li[5]/div/a/span/span")).click();
        driver.findElement(By.xpath("//div[@id='mail-app-component']/div/div/div/div[2]/div/div/div[3]/div/div/ul/li[3]/a/div/div[2]/div")).click();
        String email = driver.findElement(
                By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div[2]/ul/li/div/div[1]/header/div[2]/div[2]/span[2]/span/span")
                ).getText();
        String topic = driver.findElement(
                By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div[1]/header/div[2]/span/span")
                ).getText();
        String text = driver.findElement(
                By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div[2]/ul/li/div/div[2]/div[1]/div[2]/div/div/div/div/div/div")
                ).getText();
        return new MailData(email, topic, text);
    }

    public void createDraft(MailData mailData) throws InterruptedException {
        sleep(2);
        driver.findElement(By.linkText("Написать")).click();
        driver.findElement(By.id("message-to-field")).click();
        driver.findElement(By.id("message-to-field")).clear();
        driver.findElement(By.id("message-to-field")).sendKeys(mailData.email());
        sleep(2);
        applicationManager.sendEscapeKey();
        driver.findElement(By.xpath("//div[@id='mail-app-component']/div/div/div/div/div[3]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='mail-app-component']/div/div/div/div/div[3]/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='mail-app-component']/div/div/div/div/div[3]/div/div/input")).sendKeys(mailData.topic());
        sleep(2);
        driver.findElement(By.xpath("//div[@id='editor-container']/div/div")).click();
        driver.findElement(By.xpath("//div[@id='editor-container']/div/div")).clear();
        driver.findElement(By.xpath("//div[@id='editor-container']/div/div")).sendKeys(mailData.text());
        sleep(2);
        driver.findElement(By.xpath("//div[@id='app']/div[2]/div/div/nav/div/div[3]/div/ul/li[4]/div/a/span/span")).click();
        sleep(2);
    }

    public void deleteLastDraft() throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='mail-app-component']/div/div/div/div[2]/div/div/div[2]/div/div/ul/li[2]/a/div/div[2]/div")).click();
        sleep(2);
        driver.findElement(By.xpath("//div[@id='mail-app-component']/div/div/div/div[2]/div[2]/div/span[7]/button/span")).click();
        sleep(2);
        driver.findElement(By.xpath("//div[@id='modal-outer']/div/div/div/div[4]/button")).click();
        sleep(2);
    }

    public boolean isLastDraftDeleted() {
        try {
            driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div/div[2]/div/div[1]/ul/li[2]/a"));
            return false;
        }catch (NoSuchElementException exception) {
            return true;
        }
    }
}
