package ru.itis.data.jaxb;

import ru.itis.data.MailData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "mails")
@XmlAccessorType(XmlAccessType.FIELD)
public class Mails {

    @XmlElement(name = "mail")
    private List<MailData> mails;

    public List<MailData> getMails() {
        return mails;
    }

    public void setMails(List<MailData> mails) {
        this.mails = mails;
    }
}
