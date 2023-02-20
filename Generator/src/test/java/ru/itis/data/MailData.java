package ru.itis.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mail")
@XmlAccessorType(XmlAccessType.FIELD)
public class MailData {

    @XmlElement(name = "email", required = true)
    private String email;

    @XmlElement(name = "topic", required = true)
    private String topic;

    @XmlElement(name = "text", required = true)
    private String text;

    public MailData() {}

    public MailData(String email, String topic, String text) {
        this.email = email;
        this.topic = topic;
        this.text = text;
    }

    public String email() {
        return email;
    }

    public String topic() {
        return topic;
    }

    public String text() {
        return text;
    }
}