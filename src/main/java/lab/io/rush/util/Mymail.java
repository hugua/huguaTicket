package lab.io.rush.util;

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

/**
 * 邮件发送类，这里使用163邮箱的加密465端口进行发送，安全
 * @author chen
 *
 */
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
		  // 获取配置对象并转载信息
		  Properties props = new Properties();
		  props.setProperty("mail.smtp.host", "smtp.163.com");
		  props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		  props.setProperty("mail.smtp.socketFactory.fallback", "false");
		  props.setProperty("mail.smtp.port", "465");
		  props.setProperty("mail.smtp.socketFactory.port", "465");
		  props.put("mail.smtp.auth", "true");
		  //用户名密码
		  final String username = "18819423824@163.com";
		  final String password = "chen19940912";
		  //获取一个session对象
		  Session session = Session.getDefaultInstance(props, new Authenticator(){
		      protected PasswordAuthentication getPasswordAuthentication() {
		          return new PasswordAuthentication(username, password);
		      }});
		 
		  //创建一封邮件信息
		  Message msg = new MimeMessage(session);
		 
		  // 设置信息
		  msg.setFrom(new InternetAddress("18819423824@163.com"));
		  msg.setRecipients(Message.RecipientType.TO, 
		    InternetAddress.parse(milto,false));
		  msg.setSubject(subject);
		  msg.setText(message);
		  msg.setSentDate(new Date());
		  Transport.send(msg);
	}
}
