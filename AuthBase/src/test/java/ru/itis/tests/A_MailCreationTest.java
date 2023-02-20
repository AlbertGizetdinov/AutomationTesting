package ru.itis.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import ru.itis.basic.AuthBase;
import ru.itis.data.MailData;
import ru.itis.data.jaxb.Mails;
import ru.itis.generator.Generator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@RunWith(Theories.class)
public class A_MailCreationTest extends AuthBase {

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
        applicationManager.getNavigationHelper().openMail();
        applicationManager.getMailHelper().createMail(mail);
        applicationManager.getHelperBase().sleep(2);

        MailData createdMail = applicationManager.getMailHelper().getLastMail();
        Assert.assertEquals(createdMail.email(), mail.email());
        Assert.assertEquals(createdMail.topic(), mail.topic());
        Assert.assertEquals(createdMail.text(), mail.text());
        System.out.println("---------------------------------------------------------");
        System.out.println("E-mail: " + createdMail.email() + "\t" +
                           "Topic: " + createdMail.topic() + "\t" +
                           "Text: " + createdMail.text() + "\n");
    }
}
