package ru.itis;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.itis.basic.HelperBase;
import ru.itis.destructor.Destructor;
import ru.itis.helpers.LoginHelper;
import ru.itis.helpers.MailHelper;
import ru.itis.helpers.NavigationHelper;

import java.time.Duration;

public class ApplicationManager {

    public static final String BASE_URL = "https://www.yahoo.com/";
    public static final Duration TIMEOUT = Duration.ofSeconds(3);

    private static final Logger log = LoggerFactory.getLogger(ApplicationManager.class);
    private static final String DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String DRIVER_PATH = "C:\\Programming\\AutoTests\\chromedriver.exe";

    private final WebDriver driver;
    private final StringBuffer verificationErrors;
    private final JavascriptExecutor js;

    private final HelperBase helperBase;
    private final NavigationHelper navigationHelper;
    private final LoginHelper loginHelper;
    private final MailHelper mailHelper;

    private static final ThreadLocal<ApplicationManager> applicationManagerThreadLocal = new ThreadLocal<>();

    private ApplicationManager() {
        System.setProperty(DRIVER_PROPERTY, DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(TIMEOUT);
        js = (JavascriptExecutor) driver;
        verificationErrors = new StringBuffer();

        helperBase = new HelperBase(this);
        navigationHelper = new NavigationHelper(this, BASE_URL);
        loginHelper = new LoginHelper(this);
        mailHelper = new MailHelper(this);

        Thread destructorHook = Destructor.addManagerDestructor(this);
        log.info("Destructor-thread-hook is a " + destructorHook);
    }

    public static ApplicationManager getInstance() {
        if (applicationManagerThreadLocal.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            applicationManagerThreadLocal.set(newInstance);
        }
        return applicationManagerThreadLocal.get();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public JavascriptExecutor getJs() {
        return js;
    }

    public StringBuffer getVerificationErrors() {
        return verificationErrors;
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
