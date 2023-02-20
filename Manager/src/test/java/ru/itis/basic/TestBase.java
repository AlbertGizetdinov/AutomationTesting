package ru.itis.basic;

import org.junit.After;
import org.junit.Before;
import ru.itis.ApplicationManager;

public class TestBase {
    protected ApplicationManager applicationManager;

    @Before
    public void setUp() throws Exception {
        applicationManager = new ApplicationManager();
    }

    @After
    public void tearDown() throws Exception {
        applicationManager.stop();
    }
}
