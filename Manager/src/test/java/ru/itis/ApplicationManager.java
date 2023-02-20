package ru.itis;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import ru.itis.basic.HelperBase;
import ru.itis.helpers.LoginHelper;
import ru.itis.helpers.MailHelper;
import ru.itis.helpers.NavigationHelper;

import java.time.Duration;

public class ApplicationManager {

    public static final String BASE_URL = "https://www.yahoo.com/";
    public static final Duration TIMEOUT = Duration.ofSeconds(3);

    private static final String DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String DRIVER_PATH = "C:\\Programming\\AutoTests\\chromedriver.exe";

    private final WebDriver driver;

    private final HelperBase helperBase;
    private final NavigationHelper navigationHelper;
    private final LoginHelper loginHelper;
    private final MailHelper mailHelper;

    public ApplicationManager() {
        System.setProperty(DRIVER_PROPERTY, DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(TIMEOUT);

        helperBase = new HelperBase(this);
        navigationHelper = new NavigationHelper(this, BASE_URL);
        loginHelper = new LoginHelper(this);
        mailHelper = new MailHelper(this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void stop() {
        driver.quit();
    }

    public void sendEscapeKey() {
        new Actions(driver).sendKeys(Keys.ESCAPE).perform();
    }

    public HelperBase getHelperBase() {
        return helperBase;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public MailHelper getMailHelper() {
        return mailHelper;
    }
}
