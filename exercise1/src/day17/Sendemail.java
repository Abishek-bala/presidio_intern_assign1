package day17;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;

public class Sendemail {
	public static void main(String[] args) {
		 String to = "2903abi@gmail.com";

	      // Sender's email ID needs to be mentioned
	      String from = "javaemailpack@gmail.com";
	      final String username = "javaemailpack@gmail.com";//change accordingly
	      final String password = "javaemailpack@123";//change accordingly

//	      // Assuming you are sending email through relay.jangosmtp.net
	      final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	      // Get a Properties object
	         Properties props = System.getProperties();
	         props.setProperty("mail.smtp.host", "smtp.gmail.com");
	         props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	         props.setProperty("mail.smtp.socketFactory.fallback", "false");
	         props.setProperty("mail.smtp.port", "465");
	         props.setProperty("mail.smtp.socketFactory.port", "465");
	         props.put("mail.smtp.auth", "true");
	         props.put("mail.debug", "true");
	         props.put("mail.store.protocol", "pop3");
	         props.put("mail.transport.protocol", "smtp");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
		   }
	         });
	        

	      try {
		   // Create a default MimeMessage object.
		   Message message = new MimeMessage(session);
		
		   // Set From: header field of the header.
		   message.setFrom(new InternetAddress(from));
		
		   // Set To: header field of the header.
		   message.setRecipients(Message.RecipientType.TO,
	               InternetAddress.parse(to));
		
		   // Set Subject: header field
		   message.setSubject("Testing Subject");
		
		   // Now set the actual message
		   message.setText("Hello, this is sample for to check send " +
			"email using JavaMailAPI ");

		   // Send message
		   Transport.send(message);

		   System.out.println("Sent message successfully....");

	      } catch (MessagingException e) {
	         throw new RuntimeException(e);
	      }
	      
//	      String host = "localhost";
//	      
//	      // Getting system properties
//	      Properties properties = System.getProperties();
//	  
//	      // Setting up mail server
//	      properties.setProperty("mail.smtp.host", host);
//	  
//	      // creating session object to get properties
//	      Session session = Session.getDefaultInstance(properties);
//	  
//	      try 
//	      {
//	         // MimeMessage object.
//	         MimeMessage message = new MimeMessage(session);
//	  
//	         // Set From Field: adding senders email to from field.
//	         message.setFrom(new InternetAddress(from));
//	  
//	         // Set To Field: adding recipient's email to from field.
//	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//	  
//	         // Set Subject: subject of the email
//	         message.setSubject("This is Suject");
//	  
//	         // set body of the email.
//	         message.setText("This is a test mail");
//	  
//	         // Send email.
//	         Transport.send(message);
//	         System.out.println("Mail successfully sent");
//	      }
//	      catch (MessagingException mex) 
//	      {
//	         mex.printStackTrace();
//	      }
	}
}
