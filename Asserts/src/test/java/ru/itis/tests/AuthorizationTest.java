package ru.itis.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.basic.TestBase;

public class AuthorizationTest extends TestBase {

    @Test
    public void authorizationTestCase() throws Exception {
        applicationManager.getNavigationHelper().openYahoo();
        applicationManager.getLoginHelper().login(user);

        Assert.assertTrue(applicationManager.getLoginHelper().isAuthorized());

        applicationManager.getLoginHelper().logout();
    }
}
