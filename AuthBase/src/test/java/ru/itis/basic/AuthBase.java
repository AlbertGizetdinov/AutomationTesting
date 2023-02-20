package ru.itis.basic;

import org.junit.Before;
import ru.itis.config.Settings;
import ru.itis.data.UserData;

public class AuthBase extends TestBase {
    protected static final UserData user = new UserData(Settings.getLogin(), Settings.getPassword());

    @Before
    public void signUp() throws InterruptedException {
        super.setUp();
        applicationManager.getNavigationHelper().openYahoo();
        applicationManager.getLoginHelper().login(user);
    }
}
