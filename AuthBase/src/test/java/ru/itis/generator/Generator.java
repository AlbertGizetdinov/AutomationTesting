package ru.itis.generator;

import ru.itis.data.MailData;
import ru.itis.data.UserData;
import ru.itis.data.jaxb.Mails;
import ru.itis.data.jaxb.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Generator {
    public static final String DIRECTORY = "src/test/resources/generator";

    public static void main(String[] args) {
        String type = args[0];
        int count = Integer.parseInt(args[1]);
        String filename = args[2];
        String format = args[3];
        if (Objects.equals(type, "mail")) generateForMails(count, filename, format);
        else if (Objects.equals(type, "user")) generateForUsers(count, filename, format);
        else throw new IllegalArgumentException("Unrecognized type of data: " + type);
    }

    private static void generateForMails(int count, String filename, String format) {
        List<MailData> mails = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            mails.add(new MailData(
                    "albert160616@gmail.com",
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString()
            ));
        }
        if (Objects.equals(format, "xml")) {
            try (FileWriter fileWriter = new FileWriter(DIRECTORY + "/" + filename + "." + format)) {
                writeMailsToXmlFile(mails, fileWriter);
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        } else {
            throw new IllegalArgumentException("Unrecognized format: " + format);
        }
    }

    private static void writeMailsToXmlFile(List<MailData> mailDataList, FileWriter fileWriter) {
        try {
            Mails mails = new Mails();
            mails.setMails(mailDataList);
            JAXBContext jaxbContext = JAXBContext.newInstance(Mails.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(mails, fileWriter);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    private static void generateForUsers(int count, String filename, String format) {
        List<UserData> users = new LinkedList<>();
        if (filename.equals("valid_users")) {
            users.add(new UserData(
                    "autotest777",
                    "!Qetuo13579"
            ));
        } else {
            users.add(new UserData(
                    "autotest777",
                    UUID.randomUUID().toString()
            ));
            for (int i = 1; i < count; i++) {
                users.add(new UserData(
                        UUID.randomUUID().toString(),
                        UUID.randomUUID().toString()
                ));
            }
        }
        if (Objects.equals(format, "xml")) {
            try (FileWriter fileWriter = new FileWriter(DIRECTORY + "/" + filename + "." + format)) {
                writeUsersToXmlFile(users, fileWriter);
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        } else {
            throw new IllegalArgumentException("Unrecognized format: " + format);
        }
    }

    private static void writeUsersToXmlFile(List<UserData> userDataList, FileWriter fileWriter) {
        try {
            Users users = new Users();
            users.setUsers(userDataList);
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(users, fileWriter);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
