package com.revature.charity.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailServiceUtil {
	 public static void sendMailUsingTLS(String host,
	            String username, String password, String from,
	            String to, String subject, String text) {
	         Properties properties = new Properties();
	         properties.put("mail.smtp.host", host);
	         properties.put("mail.smtp.auth", "true");
	         properties.put("mail.smtp.starttls.enable", "true");
	         properties.put("mail.smtp.port", "587");
	         properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	         sendMail(properties, username, password, from, to,
	            subject, text);
	      }
	      public static void sendMailUsingSSL(String host,
	            String username, String password, String from,
	            String to, String subject, String text) {
	         Properties properties = new Properties();
	         properties.put("mail.smtp.host", "smtp.gmail.com");
	         properties.put("mail.smtp.socketFactory.port", "465");
	         properties.put("mail.smtp.socketFactory.class",
	            "javax.net.ssl.SSLSocketFactory");
	         properties.put("mail.smtp.auth", "true");
	         properties.put("mail.smtp.port", "465");
	         sendMail(properties, username, password, from, to,
	            subject, text);
	      }
	      public static void sendMail(Properties properties,
	            final String username, final String password,
	            String fromEmailAddress, String toEmailAddress,
	            String subject, String messageText) {
	         Session session = Session.getInstance(properties,
	               new Authenticator() {
	            @Override
	            protected PasswordAuthentication
	                  getPasswordAuthentication() {
	               return new PasswordAuthentication(username,
	                  password);
	            }
	         });
	         try {
	            Message msg = new MimeMessage(session);
	            msg.setFrom(new InternetAddress(fromEmailAddress));
	            msg.setRecipients(Message.RecipientType.TO,
	            InternetAddress.parse(toEmailAddress));
	            msg.setContent(messageText, "text/html");
	            msg.setSubject(subject);
//	            msg.setText(messageText);
	            Transport.send(msg);
	         } catch (Exception ex) {
	            ex.printStackTrace();
	         }
	      }
	     
}
