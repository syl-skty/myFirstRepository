package ʹ��servletʵ���ļ��ϵ�����;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * ʹ�������ʵ�ֶ�����������ļ�ʱ����Ե��ļ���������������
 * 
 * �Բ�ͬ����������ɲ�ͬ���ļ������ı��뷽ʽ
 * 
 * @author skty
 *
 */
public class FileNameEncoder {

	/**
	 * ʹ�ô˷�������һ�����ص��ļ������������ַ����б��룬�ѷ�ֹ�����������ļ�������
	 * 
	 * @param agentMessage
	 *            �����ͷ�ֶΣ����������������İ汾��Ϣ
	 * @param fileName
	 *            Ҫ�������ı�����ļ���
	 * @return �������ļ���
	 * @throws UnsupportedEncodingException
	 */
	public static String getEncodeFileName(String agentMessage, String fileName) throws UnsupportedEncodingException {
		// IE�����(��ʹ�õ�)���߰汾��IE�����ֱ��ʹ��URLEncoder����ܾͿ���
		// Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko

		// ΢��Edge�����
		// Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML,
		// like Gecko) Chrome/58.0.3029.110 Safari/537.36 Edge/16.16299

		// ��������
		// Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:59.0) Gecko/20100101
		// Firefox/59.0

		// QQ�����
		// Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like
		// Gecko) Chrome/63.0.3239.26 Safari/537.36 Core/1.63.4952.400
		// QQBrowser/10.0.866.400
		if (agentMessage.contains("MSIE"))// ������ص��������IE��������Ͱ汾��
		{
			fileName = URLEncoder.encode(fileName, "utf-8");
			fileName = fileName.replace("+", " ");
			return fileName;

		} else if (agentMessage.contains("Chrome"))// �ȸ������
		{
			fileName = URLEncoder.encode(fileName, "utf-8");
			return fileName;
		} else // ����������������߰汾��IE�������
		{
			fileName = URLEncoder.encode(fileName, "utf-8");
			StringBuilder builder = new StringBuilder().append("\"").append(fileName).append("\"");
			return builder.toString();
		}
	}
}
