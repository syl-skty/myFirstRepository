package 使用java发送邮件;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * 这是一个工具类，通过该工具类，可以实现发送邮件的功能
 * 
 * java中对邮件的支持是在javaee包中有相应的类，所以要使用这个邮件的功能就必须导入javaEE的library
 * 邮件功能的实现主要依赖的是javax.mail包下的jar包,所以严格意义上来讲就只要将javax.mail包导入
 * 
 * @author skty
 *
 */
public class MailUtil {
	/**
	 * 通过这个静态方法可以实现发送邮件的作用
	 * 
	 * @param configPath
	 *            邮件发送者的邮箱类型的配置文件的路径，里面需要配置邮箱发送的方式，邮件代发送者的地址等信息
	 * @param senderMail
	 *            发送者的邮箱地址
	 * @param receiverMail
	 *            接收者邮箱地址
	 * @param userName
	 *            发送者邮箱用户名
	 * @param password
	 *            发送者邮箱密码,如果使用qq邮箱的话就要在使用获取到的授权码，而不是使用邮箱密码
	 * @param mailSubject
	 *            邮件主题
	 * @param mailContent
	 *            发送者邮件内容，如果要在内容中添加超链接的话就必须使用html的格式来写
	 * @param contentType
	 *            发送者邮件内容的格式类型
	 * @throws AddressException
	 * @throws MessagingException
	 * @throws IOException
	 */
	public static void sendMail(String configPath, String senderMail, String receiverMail, String userName,
			String password, String mailSubject, Object mailContent, String contentType)
			throws AddressException, MessagingException, IOException {
		// ###########################创建邮箱配置对象（邮件的配置）####################################//
		/*
		 * // 创建一个属性列表用于存放我们邮箱信息属性与连接邮箱时的配置的属性列表
		 * 
		 * Properties properties = new Properties();
		 * 
		 * // 配置发送者邮箱的发送协议
		 * 
		 * properties.setProperty("mail.transport.protocol", "SMTP");
		 * 
		 * // 配置邮件发送者邮箱的类型服务器地址，有QQ邮箱，网易邮箱等
		 * 
		 * properties.setProperty("mail.host", "smtp.sohu.com");
		 * 
		 * // 配置邮件发送者发送邮件时是否要验证
		 * 
		 * properties.setProperty("mail.smtp.auth", "true");
		 */
		Properties properties = new Properties();
		properties.load(new FileInputStream(configPath));
		// ###########################创建session（发送邮件的连接）####################################//

		// 创建好了以上的邮箱属性设置属性列表后
		// 我们要使用这个对象来创建一个用于发送邮件的Session,
		// 由于这里的Session构造方法私有，所以我们使用其getInstance(属性列表对象)来创建
		Session mailSession = Session.getInstance(properties);

		// ###########################创建message对象（邮件内容）####################################//

		// 创建一个message对象，这里使用其子类MimeMessage来创建示例，并传入之前创建的session
		Message mailMessage = new MimeMessage(mailSession);
		// 为邮件设置发送者，这里使用的是邮件发送者的邮箱地址（*@qq.com）.
		mailMessage.setFrom(new InternetAddress(senderMail));
		// 为邮件设置发送方式和接收者，
		// RecipientType.TO表示以发送方式发送
		// 后面的参数表示接收者邮箱对应的网络邮箱地址
		mailMessage.setRecipient(RecipientType.TO, new InternetAddress(receiverMail));

		// 设置邮件的主题
		mailMessage.setSubject(mailSubject);

		// 设置邮件的内容，并设置邮件内容的格式类型，内容可以是字符串,格式类型可以指定为（"text/html;charset=utf-8"），这样就可以发送html内容
		mailMessage.setContent(mailContent, contentType);

		// 设置邮件的发送日期时间
		mailMessage.setSentDate(new Date());
		// ###########################发送邮件####################################//

		// 使用Transport类的静态方法发送邮件，第一个参数为邮件对象，后面为发送者用户名与密码
		// 使用这种方式，会自动使用我们设置的用户名与密码来创建一个邮箱认证器对象，用于邮箱验证
		Transport.send(mailMessage, userName, password);
	}
}
