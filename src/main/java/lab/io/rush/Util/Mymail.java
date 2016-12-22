package lab.io.rush.Util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mymail {
	private String subject;
	private String message;
	private String milto;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMilto() {
		return milto;
	}
	public void setMilto(String milto) {
		this.milto = milto;
	}
	public Mymail(String subject, String message, String milto) {
		super();
		this.subject = subject;
		this.message = message;
		this.milto = milto;
	}
	public void send() throws MessagingException {
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		  // Get a Properties object
		  Properties props = new Properties();
		  props.setProperty("mail.smtp.host", "smtp.163.com");
		  props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		  props.setProperty("mail.smtp.socketFactory.fallback", "false");
		  props.setProperty("mail.smtp.port", "465");
		  props.setProperty("mail.smtp.socketFactory.port", "465");
		  props.put("mail.smtp.auth", "true");
		  final String username = "18819423824@163.com";
		  final String password = "chen19940912";
		  Session session = Session.getDefaultInstance(props, new Authenticator(){
		      protected PasswordAuthentication getPasswordAuthentication() {
		          return new PasswordAuthentication(username, password);
		      }});
		 
		       // -- Create a new message --
		  Message msg = new MimeMessage(session);
		 
		  // -- Set the FROM and TO fields --
		  msg.setFrom(new InternetAddress("18819423824@163.com"));
		  msg.setRecipients(Message.RecipientType.TO, 
		    InternetAddress.parse(milto,false));
		  msg.setSubject(subject);
		  msg.setText(message);
		  msg.setSentDate(new Date());
		  Transport.send(msg);
	}
}
