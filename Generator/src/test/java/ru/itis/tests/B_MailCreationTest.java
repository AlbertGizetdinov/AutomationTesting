package ru.itis.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import ru.itis.basic.TestBase;
import ru.itis.data.MailData;
import ru.itis.generator.Generator;
import ru.itis.jaxb.Mails;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@RunWith(Theories.class)
public class B_MailCreationTest extends TestBase {

    @DataPoints
    public static List<MailData> mailsFromXmlFile() {
        try {
            JAXBContext context = JAXBContext.newInstance(Mails.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Mails mails = (Mails) unmarshaller.unmarshal(new File(Generator.DIRECTORY + "/mails.xml"));
            return mails.getMails();
        } catch (JAXBException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Test
    @Theory
    public void mailCreationTestCase(MailData mail) throws Exception {
        applicationManager.getNavigationHelper().openYahoo();
        applicationManager.getNavigationHelper().openMail();
        applicationManager.getMailHelper().createMail(mail);
        applicationManager.getHelperBase().sleep(2);

        MailData createdMail = applicationManager.getMailHelper().getLastMail();
        Assert.assertEquals(createdMail.email(), mail.email());
        System.out.println("Topic: " + createdMail.topic() + "\t" +
                           "Text: " + createdMail.text() + "\n");
    }
}
