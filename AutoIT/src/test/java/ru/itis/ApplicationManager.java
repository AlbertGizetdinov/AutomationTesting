package ru.itis;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import ru.itis.basic.HelperBase;
import ru.itis.config.Settings;
import ru.itis.helpers.ReaderHelper;
import ru.itis.helpers.WriterHelper;
import ru.itis.utils.DestructorUtil;

import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationManager {
    private static final String NOTEPAD = Settings.getNotepad();
    private static final String LOCALHOST = Settings.getLocalhost();

    private final WiniumDriver driver;

    private final HelperBase helperBase;
    private final ReaderHelper readerHelper;
    private final WriterHelper writerHelper;

    private static final ThreadLocal<ApplicationManager> applicationManagerThreadLocal = new ThreadLocal<>();

    private ApplicationManager() throws MalformedURLException, InterruptedException {
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(NOTEPAD);
        driver = new WiniumDriver(new URL(LOCALHOST), options);
        Thread.sleep(5000);

        helperBase = new HelperBase(this);
        readerHelper = new ReaderHelper(this);
        writerHelper = new WriterHelper(this);

        DestructorUtil.addManagerDestructor(this);
    }

    public static ApplicationManager getInstance() throws MalformedURLException, InterruptedException {
        if (applicationManagerThreadLocal.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            applicationManagerThreadLocal.set(newInstance);
        }
        return applicationManagerThreadLocal.get();
    }

    public WiniumDriver getDriver() {
        return driver;
    }

    public HelperBase getHelperBase() {
        return helperBase;
    }

    public ReaderHelper getReaderHelper() {
        return readerHelper;
    }

    public WriterHelper getWriterHelper() {
        return writerHelper;
    }
}
