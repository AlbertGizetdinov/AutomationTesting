package ru.itis.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.basic.TestBase;
import ru.itis.data.MailData;

public class MailCreationTest extends TestBase {

    @Test
    public void mailCreationTestCase() throws Exception {
        applicationManager.getNavigationHelper().openYahoo();
        applicationManager.getLoginHelper().login(user);
        applicationManager.getNavigationHelper().openMail();
        applicationManager.getMailHelper().createMail(mail);
        applicationManager.getHelperBase().sleep(2);

        MailData createdMail = applicationManager.getMailHelper().getLastMail();
        Assert.assertEquals(createdMail.email(), mail.email());
        System.out.println(createdMail.topic() + " " + createdMail.text());

        applicationManager.getLoginHelper().logout();
    }

}
