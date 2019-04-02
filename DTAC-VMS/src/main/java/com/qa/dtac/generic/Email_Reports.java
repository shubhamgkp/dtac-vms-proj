package com.qa.dtac.generic;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import com.qa.dtac.base.BaseTest;

public class Email_Reports extends BaseTest
{
	/*public static void execute( String Extent_report_File_Name) throws Exception{

	    final String username = "rj.jn9104@gmail.com";
	    final String password = "6565";

	    Properties props = new Properties();
	    props.put("mail.smtp.auth", true);
	    props.put("mail.smtp.starttls.enable", true);
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");

	    Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });

	    try {

	    	Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("rj.jn9104@gmail.com"));
	        message.setRecipients(Message.RecipientType.TO,    
	        InternetAddress.parse("rahuljain9104@gmail.com"));
	        
//	        message.setRecipients(Message.RecipientType.CC,
//        		InternetAddress.parse("swati.sharma@espire.com"));
	        
	       // message.setRecipients(Message.RecipientType.BCC,
	        		//InternetAddress.parse("anuj.pal@esteltelecom.com"));
	        
	        
	        message.setSubject("Test Automation Report");
	        message.setText("PFA");
	        //message.se
	       

	        MimeBodyPart messageBodyPart = new MimeBodyPart();

	        Multipart multipart = new MimeMultipart();

	        messageBodyPart = new MimeBodyPart();
	        messageBodyPart.setText("check the body");
	       
	       // String file = "D:\\Test\\Project\\extentreport.html";
	        String file = "C:\\Users\\Rahulj\\eclipse-workspace\\new\\dtacproject\\report\\extendReport.html";
	        String fileName = "ExtentReport.html";
	        DataSource source = new FileDataSource(file);
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        
	        
	        messageBodyPart.setFileName(fileName);
	     
	        multipart.addBodyPart(messageBodyPart);

	        message.setContent(multipart);

	        System.out.println("Sending");

	        Transport.send(message);

	        System.out.println("Done");

	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	  }*/
	}