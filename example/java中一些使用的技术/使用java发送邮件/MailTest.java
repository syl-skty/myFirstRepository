package ʹ��java�����ʼ�;

import java.io.IOException;

import javax.mail.MessagingException;

public class MailTest {

	public static void main(String[] args) {
		String path = "java��һЩʹ�õļ���\\ʹ��java�����ʼ�\\mail.properties";
		String senderMail = "1017089562@qq.com";
		String userName = "1017089562";
		String password = "uhffdcxhsjnpbbcd";
		String reString = "2239120808@qq.com";
		String mailSubject = "���ʷ�ʴ�";
		String mailContent = "<html ><body>���ݣ������ҷ��ĵ�һ��Java�ʼ�" + "<a href='http://www.baidu.com'>�ٶ�һ��</a></body></html>";
		String contentType = "text/html;charset=utf-8";
		try {
			MailUtil.sendMail(path, senderMail, reString, userName, password, mailSubject, mailContent, contentType);
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�������");
	}

}
