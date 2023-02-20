package ru.itis.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import ru.itis.basic.TestBase;
import ru.itis.data.UserData;
import ru.itis.data.jaxb.Users;
import ru.itis.generator.Generator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@RunWith(Theories.class)
public class D_ValidAuthorizationTest extends TestBase {

    @DataPoints
    public static List<UserData> usersFromXmlFile() {
        try {
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Users users = (Users) unmarshaller.unmarshal(new File(Generator.DIRECTORY + "/valid_users.xml"));
            return users.getUsers();
        } catch (JAXBException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Test
    @Theory
    public void validAuthorizationTestCase(UserData user) throws Exception {
        applicationManager.getNavigationHelper().openYahoo();
        applicationManager.getLoginHelper().login(user);

        Assert.assertTrue(applicationManager.getLoginHelper().isAuthorized());

        applicationManager.getLoginHelper().logout();
    }
}
