package ru.itis.generator;

import ru.itis.data.MailData;
import ru.itis.jaxb.Mails;

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
    public static final String DIRECTORY = "generator";

    public static void main(String[] args) {
        String type = args[0];
        int count = Integer.parseInt(args[1]);
        String filename = args[2];
        String format = args[3];
        if (Objects.equals(type, "mail")) generateForGroups(count, filename, format);
        else throw new IllegalArgumentException("Unrecognized type of data: " + type);
    }

    private static void generateForGroups(int count, String filename, String format) {
        List<MailData> mails = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            mails.add(new MailData(
                    "albert160616@gmail.com",
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString()
            ));
        }
        if (Objects.equals(format, "xml")) {
            try (FileWriter fileWriter = new FileWriter(DIRECTORY + "\\" + filename + "." + format)) {
                writePostsToXmlFile(mails, fileWriter);
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        } else {
            throw new IllegalArgumentException("Unrecognized format: " + format);
        }
    }

    static void writePostsToXmlFile(List<MailData> mailDataList, FileWriter fileWriter) {
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
}
