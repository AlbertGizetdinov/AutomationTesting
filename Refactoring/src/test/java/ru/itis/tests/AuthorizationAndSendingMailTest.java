package ru.itis.tests;

import ru.itis.basic.TestBase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import ru.itis.data.MailData;
import ru.itis.data.UserData;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorizationAndSendingMailTest extends TestBase {
    private static final UserData user = new UserData("autotest777", "!Qetuo13579");
    private static final MailData mail = new MailData("albert1606162@gmail.com", "Это тема", "Это текст");

    @Test
    public void authorizationTestCase() throws Exception {
        openYahoo();
        login(user);
        sleep(10);
    }

    @Test
    public void mailSendingTestCase() throws Exception {
        openYahoo();
        login(user);
        openMail();
        createMail(mail);
        sleep(10);
    }
}