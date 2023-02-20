package ru.itis.basic;

import org.junit.Before;
import ru.itis.ApplicationManager;

import java.net.MalformedURLException;

public class TestBase {

    protected ApplicationManager applicationManager;

    @Before
    public void setUp() throws MalformedURLException, InterruptedException {
        applicationManager = ApplicationManager.getInstance();
    }
}
