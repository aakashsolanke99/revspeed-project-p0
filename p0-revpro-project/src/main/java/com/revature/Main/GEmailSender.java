package com.revature.Main;

import java.util.Properties;

import com.revature.dao.imple.BroadbandServicePlansDaoImple;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GEmailSender {
    public static final Logger logger= LoggerFactory.getLogger(BroadbandServicePlansDaoImple.class);

    public boolean sendEmail(String to, String from, String subject, String text) {
        boolean flag = false;

        //logic
        //smtp properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", "smtp.gmail.com");

        String username = "aakashsolanke99@gmail.com";
        String password = "phid tffj zain pxvs";
       //  "phid tffj zain pxvs" two steps varifications

        //session
//        Session session = Session.getInstance(properties, new Authenticator() {


        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }

        });

        try {

            Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
            flag = true;
        } catch (Exception e) {
            logger.error("Error in Email sending ");
            e.printStackTrace();
        }


        return flag;
    }

}

