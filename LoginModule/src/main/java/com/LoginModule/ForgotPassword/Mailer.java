package com.LoginModule.ForgotPassword;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {
	
	public static void sendEmail(String message, String subject, String to, String from) {
 
		//Variable for gmail...
		String host = "smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		
		//setting important informations to system properties..
		
		//setting host 
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		//Step 1 : to get session object.....
		
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("/*your mail id */", "/* 16 digit pass key */");
			}
		});

		
		session.setDebug(true);
		
		//Step 2 : compose the message [ text, multimedia]
		MimeMessage m = new MimeMessage(session);
		
		try {
			
			//from email
			m.setFrom(from);
			
			//adding recipient to message
			m.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding subject to message
			m.setSubject(subject);
			
			//adding text to message
			m.setText(message);
			
			
			//Step 3 : send the message using transport class
			Transport.send(m);
			
			System.out.println("Sent Success...............");
			
			
		} catch (MessagingException e) {

			throw new RuntimeException(e);
		}
		
	}
}
