package ru.itis.basic;

import org.junit.Before;
import ru.itis.ApplicationManager;
import ru.itis.data.MailData;
import ru.itis.data.UserData;

public class TestBase {

    protected static final UserData user = new UserData("autotest777", "!Qetuo13579");
    protected static final MailData mail = new MailData("albert160616@gmail.com", "ToPiC", "TexT");

    protected ApplicationManager applicationManager;

    @Before
    public void setUp() {
        applicationManager = ApplicationManager.getInstance();
    }
}
