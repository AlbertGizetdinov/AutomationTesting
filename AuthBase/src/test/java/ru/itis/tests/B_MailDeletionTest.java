package ru.itis.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.basic.AuthBase;

public class B_MailDeletionTest extends AuthBase {

    @Test
    public void draftDeletionTestCase() throws Exception {
        applicationManager.getNavigationHelper().openMail();
        applicationManager.getMailHelper().deleteAllMails();

        Assert.assertTrue(applicationManager.getMailHelper().isLastMailDeleted());

        applicationManager.getLoginHelper().logout();
    }
}
