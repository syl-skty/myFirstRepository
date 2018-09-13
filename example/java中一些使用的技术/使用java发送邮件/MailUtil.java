package ʹ��java�����ʼ�;

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
 * ����һ�������࣬ͨ���ù����࣬����ʵ�ַ����ʼ��Ĺ���
 * 
 * java�ж��ʼ���֧������javaee��������Ӧ���࣬����Ҫʹ������ʼ��Ĺ��ܾͱ��뵼��javaEE��library
 * �ʼ����ܵ�ʵ����Ҫ��������javax.mail���µ�jar��,�����ϸ�������������ֻҪ��javax.mail������
 * 
 * @author skty
 *
 */
public class MailUtil {
	/**
	 * ͨ�������̬��������ʵ�ַ����ʼ�������
	 * 
	 * @param configPath
	 *            �ʼ������ߵ��������͵������ļ���·����������Ҫ�������䷢�͵ķ�ʽ���ʼ��������ߵĵ�ַ����Ϣ
	 * @param senderMail
	 *            �����ߵ������ַ
	 * @param receiverMail
	 *            �����������ַ
	 * @param userName
	 *            �����������û���
	 * @param password
	 *            ��������������,���ʹ��qq����Ļ���Ҫ��ʹ�û�ȡ������Ȩ�룬������ʹ����������
	 * @param mailSubject
	 *            �ʼ�����
	 * @param mailContent
	 *            �������ʼ����ݣ����Ҫ����������ӳ����ӵĻ��ͱ���ʹ��html�ĸ�ʽ��д
	 * @param contentType
	 *            �������ʼ����ݵĸ�ʽ����
	 * @throws AddressException
	 * @throws MessagingException
	 * @throws IOException
	 */
	public static void sendMail(String configPath, String senderMail, String receiverMail, String userName,
			String password, String mailSubject, Object mailContent, String contentType)
			throws AddressException, MessagingException, IOException {
		// ###########################�����������ö����ʼ������ã�####################################//
		/*
		 * // ����һ�������б����ڴ������������Ϣ��������������ʱ�����õ������б�
		 * 
		 * Properties properties = new Properties();
		 * 
		 * // ���÷���������ķ���Э��
		 * 
		 * properties.setProperty("mail.transport.protocol", "SMTP");
		 * 
		 * // �����ʼ���������������ͷ�������ַ����QQ���䣬���������
		 * 
		 * properties.setProperty("mail.host", "smtp.sohu.com");
		 * 
		 * // �����ʼ������߷����ʼ�ʱ�Ƿ�Ҫ��֤
		 * 
		 * properties.setProperty("mail.smtp.auth", "true");
		 */
		Properties properties = new Properties();
		properties.load(new FileInputStream(configPath));
		// ###########################����session�������ʼ������ӣ�####################################//

		// �����������ϵ������������������б��
		// ����Ҫʹ���������������һ�����ڷ����ʼ���Session,
		// ���������Session���췽��˽�У���������ʹ����getInstance(�����б����)������
		Session mailSession = Session.getInstance(properties);

		// ###########################����message�����ʼ����ݣ�####################################//

		// ����һ��message��������ʹ��������MimeMessage������ʾ����������֮ǰ������session
		Message mailMessage = new MimeMessage(mailSession);
		// Ϊ�ʼ����÷����ߣ�����ʹ�õ����ʼ������ߵ������ַ��*@qq.com��.
		mailMessage.setFrom(new InternetAddress(senderMail));
		// Ϊ�ʼ����÷��ͷ�ʽ�ͽ����ߣ�
		// RecipientType.TO��ʾ�Է��ͷ�ʽ����
		// ����Ĳ�����ʾ�����������Ӧ�����������ַ
		mailMessage.setRecipient(RecipientType.TO, new InternetAddress(receiverMail));

		// �����ʼ�������
		mailMessage.setSubject(mailSubject);

		// �����ʼ������ݣ��������ʼ����ݵĸ�ʽ���ͣ����ݿ������ַ���,��ʽ���Ϳ���ָ��Ϊ��"text/html;charset=utf-8"���������Ϳ��Է���html����
		mailMessage.setContent(mailContent, contentType);

		// �����ʼ��ķ�������ʱ��
		mailMessage.setSentDate(new Date());
		// ###########################�����ʼ�####################################//

		// ʹ��Transport��ľ�̬���������ʼ�����һ������Ϊ�ʼ����󣬺���Ϊ�������û���������
		// ʹ�����ַ�ʽ�����Զ�ʹ���������õ��û���������������һ��������֤����������������֤
		Transport.send(mailMessage, userName, password);
	}
}
