package ru.itis.basic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import ru.itis.data.MailData;
import ru.itis.data.UserData;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase {
    JavascriptExecutor js;
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Programming\\AutoTests\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    protected void openYahoo() {
        driver.get("https://www.yahoo.com/");
    }

    protected void login(UserData userData) throws InterruptedException {
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

    protected void sleep(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    protected void openMail() {
        driver.findElement(By.id("root_1")).click();
    }

    protected void createMail(MailData mailData) throws InterruptedException {
        driver.findElement(By.linkText("Написать")).click();
        driver.findElement(By.id("message-to-field")).click();
        driver.findElement(By.id("message-to-field")).clear();
        driver.findElement(By.id("message-to-field")).sendKeys(mailData.email());
        sendEscapeKey();
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

    protected void sendEscapeKey() {
        new Actions(driver).sendKeys(Keys.ESCAPE).perform();
    }
}
