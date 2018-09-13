package ʹ��MD5�����ַ���;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * ʹ��MD5�����ַ����ķ�ʽ����Ҫʹ�õ���MessageDigest��Ĳ���
 * 
 * ��ԭʼ�ַ�ת��Ϊ���ܺ���ֽ����飬
 * 
 * ֮�󽫸��ֽ�����ת��Ϊ16���Ƶ��ַ�����
 * 
 * ��󽫼��ܵ��ַ���ǰ�油�㽫�䲹Ϊ��32λ���ַ�
 * 
 * @author skty
 *
 */
public class MD5Util {

	public static String getMD5String(String str) {

		String md5String = null;

		// ����һ���ֽ��������ڴ�ż���ʱ�������ֽ���
		byte[] secretBytes = null;

		try {
			// ��ȡmd5�����㷨����
			MessageDigest instance = MessageDigest.getInstance("md5");

			// ��Ҫ���ܵ��ַ����ֽ�Ϊ�ֽ����飬��ʹ��md5�㷨���ܻ�ȡһ���µ��ֽ�����
			secretBytes = instance.digest(str.getBytes());

			// ���õ��ļ��ܺ��ֽ���������һ��������������������ת��ΪString����
			// ���ֱ�ʾ���ţ�ǰ���1��ʾ������0��ʾ0��-1��ʾ����
			// ������ת��Ϊ��16���Ʊ�����ַ���
			md5String = new BigInteger(1, secretBytes).toString(16);

			// �������ɵļ��ܺ���ַ����п��ܲ���32��λ�ı�׼MD5�ַ�,��������ǰ����㱣֤��Ϊ32λ
			for (int i = 0; i < 32 - md5String.length(); i++) {
				md5String = "0" + md5String;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5String;
	}

	public static void main(String[] args) {
		System.out.println(MD5Util.getMD5String("123"));
	}
}
