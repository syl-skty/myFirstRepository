package 使用java发送邮件;

import java.io.IOException;

import javax.mail.MessagingException;

public class MailTest {

	public static void main(String[] args) {
		String path = "java中一些使用的技术\\使用java发送邮件\\mail.properties";
		String senderMail = "1017089562@qq.com";
		String userName = "1017089562";
		String password = "uhffdcxhsjnpbbcd";
		String reString = "2239120808@qq.com";
		String mailSubject = "你好史仁聪";
		String mailContent = "<html ><body>内容：这是我发的第一封Java邮件" + "<a href='http://www.baidu.com'>百度一下</a></body></html>";
		String contentType = "text/html;charset=utf-8";
		try {
			MailUtil.sendMail(path, senderMail, reString, userName, password, mailSubject, mailContent, contentType);
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("发送完成");
	}

}
