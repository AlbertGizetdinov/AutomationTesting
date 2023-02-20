package ru.itis.basic;

import org.junit.Before;
import ru.itis.ApplicationManager;

public class TestBase {

    protected ApplicationManager applicationManager;

    @Before
    public void setUp() {
        applicationManager = ApplicationManager.getInstance();
    }
}
