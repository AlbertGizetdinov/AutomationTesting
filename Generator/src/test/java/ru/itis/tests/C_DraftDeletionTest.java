package ru.itis.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.basic.TestBase;

public class C_DraftDeletionTest extends TestBase {

    @Test
    public void draftDeletionTestCase() throws Exception {
        applicationManager.getNavigationHelper().openYahoo();
        applicationManager.getNavigationHelper().openMail();
        applicationManager.getMailHelper().createDraft(mail);
        applicationManager.getMailHelper().deleteLastDraft();

        Assert.assertTrue(applicationManager.getMailHelper().isLastDraftDeleted());

        applicationManager.getLoginHelper().logout();
    }

}
