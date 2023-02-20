package ru.itis.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import ru.itis.basic.TestBase;
import ru.itis.data.MailData;
import ru.itis.data.UserData;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorizationAndSendingMailTest extends TestBase {
    private static final UserData user = new UserData("", "");
    private static final MailData mail = new MailData("@gmail.com", "Это тема", "Это текст");

    @Test
    public void authorizationTestCase() throws Exception {
        applicationManager.getNavigationHelper().openYahoo();
        applicationManager.getLoginHelper().login(user);
        applicationManager.getHelperBase().sleep(5);
    }

    @Test
    public void mailSendingTestCase() throws Exception {
        applicationManager.getNavigationHelper().openYahoo();
        applicationManager.getLoginHelper().login(user);
        applicationManager.getNavigationHelper().openMail();
        applicationManager.getMailHelper().createMail(mail);
        applicationManager.getHelperBase().sleep(5);
    }
}