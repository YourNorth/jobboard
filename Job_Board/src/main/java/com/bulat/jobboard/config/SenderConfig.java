package com.bulat.jobboard.config;

import lombok.AllArgsConstructor;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Configuration class for sending messages
 * @author Bulat Bilalov
 * @version 1.0
 */
@AllArgsConstructor
public class SenderConfig {
    /** Mail that will send messages to users */
    private final String email;

    /** The password that will be used to enter the mail */
    private final String password;

    /** Settings for writing */
    private final Properties properties;

    /**
     * Method of sending email to users
     * @param subject Data of the user who sent the message
     * @param text Text of the letter
     * @param toEmail Mail of the user who will receive the message
     */
    public void send(String subject, String text, String toEmail){
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(text);
            message.setContent(text, "text/html");

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
